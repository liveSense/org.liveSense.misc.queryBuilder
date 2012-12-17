package org.liveSense.misc.queryBuilder;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.liveSense.core.BaseAnnotationHelper;
import org.liveSense.misc.queryBuilder.beans.Value;
import org.liveSense.misc.queryBuilder.domains.Criteria;
import org.liveSense.misc.queryBuilder.domains.Operand;
import org.liveSense.misc.queryBuilder.domains.Operator;
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;


public class OperatorAndCriteriaProcessor {
	enum Position {FIRST, LAST, MIDDLE};
	private static Pattern pattern = Pattern.compile("(\\$[\\w||\\']+\\$)", Pattern.COMMENTS);

	@SuppressWarnings("rawtypes")
	private static String processOperatorParams(Class<?> clazz, Object params, Position pos, ToSQLStringEvent toSQLString) throws QueryBuilderException {
	    String clause = "";
	    if (params instanceof Operator) {
			clause += processOperator(clazz, (Operator)params, toSQLString);
		} else if (params instanceof Criteria) {
			clause += processCriteria(clazz, (Criteria)params, toSQLString);
		} else {
			throw new QueryBuilderException("Parameter data is incompatible. (Operator or Criteria required)");
		}
		return clause;
	}
	
	public static String processCriteria(Criteria criteria) throws QueryBuilderException {
		return processCriteria(null, criteria);
	}
	
	public static String processCriteria(Criteria criteria, ToSQLStringEvent toSQLString) throws QueryBuilderException {
		return processCriteria(null, criteria, toSQLString);
	}
		
	public static String processCriteria(Class<?> clazz, Criteria criteria) throws QueryBuilderException {
		return processCriteria(clazz, criteria, null);
	}
	
	public static String processCriteria(Class<?> clazz, Criteria criteria, ToSQLStringEvent toSQLString) throws QueryBuilderException {
		//criteria.setDriverClass(jdbcDriver);
		
		Matcher matcher = pattern.matcher(criteria.getQueryTemplate());		
		String ret = criteria.getQueryTemplate();
		while (matcher.find()) {
			if (matcher.groupCount() != 1) throw new QueryBuilderException("Syntax error in criteria");
			String variableName = matcher.group(1).replaceAll("\\$", "");
			try {
				String originalVariableName = variableName;
				variableName = variableName.replaceAll("'", "");
				
				if (variableName.equalsIgnoreCase("field")) {
					String fieldName = OperandProcessor.getOperandSource(criteria.getOperand(), clazz);
					
					if (clazz != null) {
						Object[] annotations = BaseAnnotationHelper.findFieldAnnotationByAnnotationClass(clazz, fieldName, Column.class);
						if (annotations != null && annotations.length > 0) {
							fieldName = ((Column)annotations[0]).name();
						}
					}
				    ret = ret.replaceAll("\\$"+variableName+"\\$", fieldName);
				} 
				else {
					Object o = BeanUtilsBean.getInstance().getPropertyUtils().getNestedProperty(criteria, variableName);
					if (o instanceof Value) o = ((Value) o).getValueAsObject();
					ret = ret.replaceAll("\\$"+originalVariableName+"\\$", getAsValue(clazz, o, toSQLString));					
				}
			}
			catch (Exception e) {
				throw new QueryBuilderException(e);
			}
		}
		return ret;
	}
	
	public static String processOperator(Operator operator) throws QueryBuilderException {
		return processOperator(null, operator);
	}
	
	public static String processOperator(Operator operator, ToSQLStringEvent toSQLString) throws QueryBuilderException {
		return processOperator(null, operator, toSQLString);
	}
	
	public static String processOperator(Class<?> clazz, Operator operator) throws QueryBuilderException { 
		return processOperator(clazz, operator, null); 
	}
		
	public static String processOperator(Class<?> clazz, Operator operator, ToSQLStringEvent toSQLString) throws QueryBuilderException {
		String ret = "";
		if (operator.getParams() == null) return "";
		if (operator.getParams().size() == 0) return "";

		if (operator.getParams().size() > 1) {
			ret = operator.getParamPreOperation();
			if (((List<?>) operator.getParams()).size() == 0) {
				ret = "";
			} else if (((List<?>)operator.getParams()).size() == 1) {
				ret = operator.getParamPreOperation()+
					operator.getFirstParamPreOperation()+
					processOperatorParams(clazz, ((List<?>)operator.getParams()).get(0), Position.MIDDLE, toSQLString)+
					operator.getLastParamPostOperation()+
					operator.getParamPostOperation();
			} else {
				for (int i=0; i<((List<?>)operator.getParams()).size(); i++) {
					if (i == 0) {
						ret = operator.getParamPreOperation()+
						operator.getFirstParamPreOperation()+
						processOperatorParams(clazz, ((List<?>)operator.getParams()).get(i), Position.FIRST, toSQLString)+
						operator.getFirstParamPostOperation();
					} else if (i == ((List<?>)operator.getParams()).size()-1) {
						ret += operator.getLastParamPostOperation()+
						processOperatorParams(clazz, ((List<?>)operator.getParams()).get(i), Position.LAST, toSQLString)+
						operator.getLastParamPostOperation()+
						operator.getParamPostOperation();
					} else {
						ret += operator.getMiddleParamPreOperation()+
						processOperatorParams(clazz, ((List<?>)operator.getParams()).get(i), Position.MIDDLE, toSQLString)+
						operator.getMiddleParamPostOperation();		
					}
				}		
			}
		} else {
			ret = operator.getParamPreOperation() + 
					operator.getFirstParamPreOperation()+
					processOperatorParams(clazz, operator.getParams().get(0), Position.MIDDLE, toSQLString)+
					operator.getLastParamPostOperation()+
					operator.getParamPostOperation();

		}
		return ret;
	}
	
	@SuppressWarnings({ "rawtypes" })
	private static String getAsValue(Class clazz, final Object o, ToSQLStringEvent toSQLString) throws QueryBuilderException {
		try {
			if (o instanceof Operand) {
				if (!((Operand)o).isLiteral()) {
					return OperandProcessor.getOperandSource(((Operand)o), clazz, toSQLString);
				}
			} else if (o instanceof Value) {
				return new ObjectToSQLLiteral(ValueProcessor.processValue((Value)o), toSQLString).getLiteral();
			}
			return new ObjectToSQLLiteral(o, toSQLString).getLiteral();
		}
		catch (Exception e) {
			throw new QueryBuilderException(e);
		}
	}	
}

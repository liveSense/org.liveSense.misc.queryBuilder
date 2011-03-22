package org.liveSense.misc.queryBuilder;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Id;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.liveSense.core.BaseAnnotationHelper;
import org.liveSense.misc.queryBuilder.criterias.Criteria;
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operators.Operator;


public class OperatorAndCriteriaProcessor {

	enum Position {FIRST, LAST, MIDDLE};
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	private static Pattern pattern = Pattern.compile("(\\$[\\w||\\']+\\$)", Pattern.COMMENTS);

	@SuppressWarnings("rawtypes")
	private static String processOperatorParams(Class<?> clazz, Object params, Position pos) throws QueryBuilderException {
	    String clause = "";
	    if (params instanceof Operator) {
			clause += processOperator(clazz, (Operator)params);
		} else if (params instanceof Criteria) {
			clause += processCriteria(clazz, (Criteria)params);
		} else {
			throw new QueryBuilderException("Parameter data is incompatible. (Operator or Criteria required)");
		}
		return clause;
	}

	public static String processCriteria(Criteria<?> criteria) throws QueryBuilderException {
		return processCriteria(null, criteria);
	}

	public static String processCriteria(Class<?> clazz, Criteria<?> criteria) throws QueryBuilderException {
		Matcher matcher = pattern.matcher(criteria.getQueryTemplate());
		String ret = criteria.getQueryTemplate();
		while (matcher.find()) {
			if (matcher.groupCount() != 1) throw new QueryBuilderException("Syntax error in criteria");
			String variableName = matcher.group(1).replaceAll("\\$", "");
			try {
				boolean stringEscape = true;
				String originalVariableName = variableName;
				if (variableName.startsWith("'")) stringEscape = false;
				variableName = variableName.replaceAll("'", "");

				Object o = BeanUtilsBean.getInstance().getPropertyUtils().getNestedProperty(criteria, variableName);
				if (variableName.equalsIgnoreCase("field")) {
					String fieldName = criteria.getField();
					if (clazz != null) {
						Object[] annotations = BaseAnnotationHelper.findFieldAnnotationByAnnotationClass(clazz, fieldName, Column.class);
						if (annotations != null && annotations.length > 0) {
							fieldName = ((Column)annotations[0]).name();
						}
					}
				    ret = ret.replaceAll("\\$"+variableName+"\\$", fieldName);
				} else {
					ret = ret.replaceAll("\\$"+originalVariableName+"\\$", getAsValue(o, stringEscape));					
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
	
	public static String processOperator(Class<?> clazz, Operator operator) throws QueryBuilderException {
		String ret = "";
		if (operator.getParams() == null) return "";
		

		if (operator.getParams() instanceof List<?>) {
			ret = operator.getParamPreOperation();
			if (((List<?>) operator.getParams()).size() == 0) {
				ret = "";
			} else if (((List<?>)operator.getParams()).size() == 1) {
				ret = operator.getParamPreOperation()+
					operator.getFirstParamPreOperation()+
					processOperatorParams(clazz, ((List<?>)operator.getParams()).get(0), Position.MIDDLE)+
					operator.getLastParamPostOperation()+
					operator.getParamPostOperation();
			} else {
				for (int i=0; i<((List<?>)operator.getParams()).size(); i++) {
					if (i == 0) {
						ret = operator.getParamPreOperation()+
						operator.getFirstParamPreOperation()+
						processOperatorParams(clazz, ((List<?>)operator.getParams()).get(i), Position.FIRST)+
						operator.getFirstParamPostOperation();
					} else if (i == ((List<?>)operator.getParams()).size()-1) {
						ret += operator.getLastParamPostOperation()+
						processOperatorParams(clazz, ((List<?>)operator.getParams()).get(i), Position.LAST)+
						operator.getLastParamPostOperation()+
						operator.getParamPostOperation();
					} else {
						ret += operator.getMiddleParamPreOperation()+
						processOperatorParams(clazz, ((List<?>)operator.getParams()).get(i), Position.MIDDLE)+
						operator.getMiddleParamPostOperation();		
					}
				}		
			}
		} else if (operator.getParams() instanceof Object[]) {
			if (((Object[]) operator.getParams()).length == 0) { 
				ret = "";
			} else if (((Object[])operator.getParams()).length == 1) {
				ret = operator.getParamPreOperation()+
				operator.getFirstParamPreOperation()+
				processOperatorParams(clazz, ((Object[])operator.getParams())[0], Position.MIDDLE)+
				operator.getLastParamPostOperation()+
				operator.getParamPostOperation();
			} else {
				for (int i=0; i<((Object[])operator.getParams()).length; i++) {
					if (i == 0) {
						ret = operator.getParamPreOperation()+
						operator.getFirstParamPreOperation()+
						processOperatorParams(clazz, ((Object[])operator.getParams())[i], Position.FIRST)+
						operator.getFirstParamPostOperation();
					} else if (i == ((Object[])operator.getParams()).length-1) {
						ret += operator.getLastParamPostOperation()+
						processOperatorParams(clazz, ((Object[])operator.getParams())[i], Position.LAST)+
						operator.getLastParamPostOperation()+
						operator.getParamPostOperation();
					} else {
						ret += operator.getMiddleParamPreOperation()+
						processOperatorParams(clazz, ((Object[])operator.getParams())[i], Position.MIDDLE)+
						operator.getMiddleParamPostOperation();		
					}
				}
			}
		} else if (operator.getParams() instanceof Object) {
			ret = operator.getParamPreOperation() + 
			operator.getFirstParamPreOperation()+
			processOperatorParams(clazz, operator.getParams(), Position.MIDDLE)+
			operator.getLastParamPostOperation()+
			operator.getParamPostOperation();
		} 
		return ret;
	}

	@SuppressWarnings({ "rawtypes" })
	public static String getAsValue(final Object o, boolean stringEscape) throws QueryBuilderException {
		String apostrphe = "";
		if (stringEscape) apostrphe = "'";
		if (o == null) return "";
		if (o instanceof String) return apostrphe+(String)o+apostrphe;
		else if (o instanceof Integer) return ((Integer)o).toString();
		else if (o instanceof Long) return ((Long)o).toString();
		else if (o instanceof Date) return apostrphe+sdf.format((Date)o)+apostrphe;
		else if (o instanceof Object[]) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < ((Object[])o).length; i++) {
				Object o2 = ((Object[])o)[i];
				if (i!=0) sb.append(",");
				sb.append(getAsValue(o2, stringEscape));
			}
			return sb.toString();
		}
		else if (o instanceof List) {
			boolean first = true;
			StringBuffer sb = new StringBuffer();
			for (Object o2 : (List)o) {
				if (first) first = false; else sb.append(",");
				sb.append(getAsValue(o2, stringEscape));
			}
			return sb.toString();
		}
		else {
			Field fld = BaseAnnotationHelper.findFieldByAnnotationClass(o.getClass(), Id.class);
			if (fld != null)
				try {
					return getAsValue(BeanUtilsBean.getInstance().getPropertyUtils().getNestedProperty(o, fld.getName()),stringEscape);
				}
				catch (Exception e) {
					throw new QueryBuilderException(e);
				}

			else
				return o.toString();
		}
	}	
}

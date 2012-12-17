package org.liveSense.misc.queryBuilder;

import javax.persistence.Column;

import org.liveSense.core.BaseAnnotationHelper;
import org.liveSense.misc.queryBuilder.domains.Operand;

public class OperandProcessor {


	public static Object getOperandValue(Operand operand) {
		return ValueProcessor.processValue(operand.getSource());
	}
	
	@SuppressWarnings("rawtypes")
	public static String getOperandSource(Operand operand, Class clazz) throws Exception {
		return getOperandSource(operand, clazz, null);
	}
	
	@SuppressWarnings("rawtypes")
	public static String getOperandSource(Operand operand, Class clazz, ToSQLStringEvent toSQLString) throws Exception {
		String source;		
		if (operand.isLiteral()) {
			source = new ObjectToSQLLiteral(getOperandValue(operand), toSQLString).getLiteral();
		}
		else {
			String fieldName = (String) getOperandValue(operand);
			if (clazz != null) {
				Object[] annotations = BaseAnnotationHelper.findFieldAnnotationByAnnotationClass(clazz, fieldName, Column.class);
				if (annotations != null && annotations.length > 0) {
					fieldName = ((Column)annotations[0]).name(); 
				} 
			}
			source = fieldName;
		}
		
		String qualifier = operand.getQualifier();
		String function = operand.getFunction();
		
		if (!((qualifier == null) || (qualifier.equals("")))) {
			source = qualifier + "." + source;
		} 
		
		if (!((function == null) || (function.equals("")))) {
			source = function + "(" + source + ")";
		}
		return source;
	}	

}

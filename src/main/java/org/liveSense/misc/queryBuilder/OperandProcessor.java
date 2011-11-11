package org.liveSense.misc.queryBuilder;

import javax.persistence.Column;

import org.liveSense.core.BaseAnnotationHelper;
import org.liveSense.misc.queryBuilder.jdbcDriver.JdbcDrivers;
import org.liveSense.misc.queryBuilder.operands.OperandSource;


public class OperandProcessor {
	
	
	@SuppressWarnings("rawtypes")
	public static String getOperandSource(OperandSource operand, Class clazz, JdbcDrivers jdbcDriver) throws Exception {
		String source;		
		if (operand.isLiteral()) {
			source = new ObjectToSQLLiteral(operand.getSource()).getLiteral(jdbcDriver);
		}
		else {
			String fieldName = operand.getSource().toString();
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

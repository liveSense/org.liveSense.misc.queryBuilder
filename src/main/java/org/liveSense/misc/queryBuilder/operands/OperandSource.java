package org.liveSense.misc.queryBuilder.operands;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;

import org.liveSense.core.BaseAnnotationHelper;


public class OperandSource {	
	private String qualifier;
	private Object source;
	private boolean literal = true;
	private String jdbcDriverClass;
	
	
	public OperandSource(Object source){
		this("", source);		
	}
	
	public OperandSource(String qualifier, Object source){
		this(qualifier, source, true);		
	}
	
	public OperandSource(String qualifier, Object source, boolean literal){
		this.qualifier = qualifier;
		this.source = source;
		this.literal = literal;
	}	

	
	public String getQualifier() {	
		return qualifier;
	}
	
	public Object getSource() {	
		return source;
	}
		
	public boolean isLiteral() {
		return literal;
	}
			
	public String getJdbcDriverClass() {
		return jdbcDriverClass;
	}

	public void setJdbcDriverClass(
		String jdbcDriverClass) {	
		this.jdbcDriverClass = jdbcDriverClass;
	}

	
	@SuppressWarnings("rawtypes")
	private String getSrc(Class clazz) {
		if (literal) {
			if (source instanceof String) {
				return "'" + source.toString().replace("'", "''") + "'";
			} else 
			if (source instanceof Date) {
				return "'" + new SimpleDateFormat("yyyy.MM.dd").format((Date)source) + "'";
			} 
			else return source.toString();
		}
		else {
			String fieldName = source.toString();
			if (clazz != null) {
				Object[] annotations = BaseAnnotationHelper.findFieldAnnotationByAnnotationClass(clazz, fieldName, Column.class);
				if (annotations != null && annotations.length > 0) {
					fieldName = ((Column)annotations[0]).name(); 
				} 
			}
			return fieldName;
		}			
	}
	
	public String getSourceDefinition(){
		return getSourceDefinition(null); 
	}
		
	@SuppressWarnings("rawtypes")
	public String getSourceDefinition(Class clazz){
		if ((qualifier == null) || (qualifier.equals(""))) {
			return getSrc(clazz);
		} 
		else {
			return qualifier + "." + getSrc(clazz);
		} 
	}	
	
	
	
}
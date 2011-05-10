package org.liveSense.misc.queryBuilder.criterias;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;


public abstract class Criteria<K> {
	private OperandSource operand;
	private String jdbcDriverClass;

	
	public Criteria(String field){
		this("", field);		
	}
	
	public Criteria(String alias, String field){		
		operand = new OperandSource(alias, field, false);		
	}
	
	public Criteria(OperandSource operand){
		this.operand = operand;		
	}	

	
	public OperandSource getOperand() {
		return operand;
	}	
	
	public String getDriverClass() {
	
		return jdbcDriverClass;
	}
	
	public void setDriverClass(
		String driverClass) {
	
		this.jdbcDriverClass = driverClass;
	}
	
	public abstract String getQueryTemplate() throws QueryBuilderException;
		

}

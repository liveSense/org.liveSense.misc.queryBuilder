package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;


public abstract class Criteria<K> implements Serializable {

	
	//consts
	private static final long serialVersionUID = -5374353872807395900L;
	
	
	//fields
	private OperandSource<K> operand;
	private String jdbcDriverClass;

	
	//constructors
	public Criteria() {
		
	}
		
	public Criteria(String field){
		this("", field);		
	}
	
	@SuppressWarnings("unchecked")
	public Criteria(String alias, String field){		
		operand = (OperandSource<K>) new OperandSource<String>(alias, field, false);		
	}
	
	public Criteria(OperandSource<K> operand){
		this.operand = operand;		
	}	

	
	//getters and setters
	public OperandSource<K> getOperand() {
		return operand;
	}	
	
	public String getDriverClass() {
	
		return jdbcDriverClass;
	}
	
	public void setDriverClass(
		String driverClass) {
	
		this.jdbcDriverClass = driverClass;
	}
	
	//methods
	public abstract String getQueryTemplate() throws QueryBuilderException;
		

}

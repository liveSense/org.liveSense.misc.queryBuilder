package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.jdbcDriver.JdbcDrivers;
import org.liveSense.misc.queryBuilder.operands.OperandSource;


public abstract class Criteria<K> implements Serializable {
	private OperandSource operand;
	private JdbcDrivers jdbcDriver;

	public Criteria() {
		
	}
	
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
	
	public JdbcDrivers getDriverClass() {
	
		return jdbcDriver;
	}
	
	public void setDriverClass(
		JdbcDrivers driver) {
	
		this.jdbcDriver = driver;
	}
	
	public abstract String getQueryTemplate() throws QueryBuilderException;
		

}

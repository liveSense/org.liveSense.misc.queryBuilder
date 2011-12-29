package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.beans.Value;
import org.liveSense.misc.queryBuilder.domains.Operand;
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;

public class BetweenCriteria extends AbstractCriteria implements Serializable {	
	private Value value1;
	private Value value2;

	public BetweenCriteria() {
		super();
	}
	
	public BetweenCriteria(String fieldName, Value value1, Value value2) {
		this("", fieldName, value1, value2);
	}
	
	public BetweenCriteria(String alias, String fieldName, Value value1, Value value2) {		
		super(alias, fieldName);		
		this.value1 = value1;
		this.value2 = value2;				
	}
	
	public BetweenCriteria(Operand operand, Value value1, Value value2){
		super(operand);
		this.value1 = value1;
		this.value2 = value2;		
	}	

	public BetweenCriteria(String fieldName, Object value1, Object value2) {
		this("", fieldName, new Value(value1), new Value(value2));
	}
	
	public BetweenCriteria(String alias, String fieldName, Object value1, Object value2) {		
		this(alias, fieldName, new Value(value1), new Value(value2));
	}
	
	public BetweenCriteria(Operand operand, Object value1, Object value2){
		this(operand, new Value(value1), new Value(value2));
	}	

	public Value getValue1() {
		return value1;
	}

	public void setValue1(
		Value value1) {
		this.value1 = value1;
	}
	
	public Value getValue2() {
		return value2;
	}
	
	public void setValue2(
		Value value2) {
		this.value2 = value2;
	}

	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$ BETWEEN $value1$ AND $value2$";
	}

}

package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;

public class BetweenCriteria<K> extends Criteria<K> implements Serializable {	

	
	//consts	
	private static final long serialVersionUID = 7162173479356129628L;
	
	
	//fields
	private K value1;
	private K value2;

	
	//constructors
	public BetweenCriteria() {
		super();
	}
	
	public BetweenCriteria(String fieldName, K value1, K value2) {
		this("", fieldName, value1, value2);
	}
	
	public BetweenCriteria(String alias, String fieldName, K value1, K value2) {		
		super(alias, fieldName);		
		this.value1 = value1;
		this.value2 = value2;				
	}
	
	public BetweenCriteria(OperandSource<K> operand, K value1, K value2){
		super(operand);
		this.value1 = value1;
		this.value2 = value2;		
	}	
	
	
	//getters and setters
	public K getValue1() {
		return value1;
	}

	public void setValue1(
		K value1) {
		this.value1 = value1;
	}
	
	public K getValue2() {
		return value2;
	}
	
	public void setValue2(
		K value2) {
		this.value2 = value2;
	}

	
	//methods
	@Override
	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$ BETWEEN $value1$ AND $value2$";
	}

}

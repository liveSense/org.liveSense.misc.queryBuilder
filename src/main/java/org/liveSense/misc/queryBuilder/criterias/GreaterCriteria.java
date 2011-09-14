package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;

public class GreaterCriteria<K> extends Criteria<K> implements Serializable {
	
	
	//consts
	private static final long serialVersionUID = 427039913461433516L;
	
	
	//fields
	private K value;

	
	//constructors
	public GreaterCriteria() {
		super();
	}
	
	public GreaterCriteria(String fieldName, K value) {
		this("",fieldName,value);
	}
	
	public GreaterCriteria(String alias, String fieldName, K value) {
		super(alias, fieldName);
		this.value = value;		
	}
	
	public GreaterCriteria(OperandSource<K> operand, K value){
		super(operand);
		this.value = value;			
	}		

	
	//getters and setters
	public K getValue() {
		return value;
	}
	
	public void setValue(K value) {
		this.value = value;
	}

	
	//methods
	@Override
	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$>$value$";
	}

}

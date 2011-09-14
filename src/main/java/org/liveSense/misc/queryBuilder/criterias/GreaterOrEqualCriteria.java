package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;

public class GreaterOrEqualCriteria<K> extends Criteria<K> implements Serializable {
	
	
	//consts
	private static final long serialVersionUID = -3300740876974711458L;
	
	
	//fields
	private K value;

	
	//constructors
	public GreaterOrEqualCriteria() {
		super();
	}
	
	public GreaterOrEqualCriteria(String fieldName, K value) {
		this("", fieldName, value);
	}	

	public GreaterOrEqualCriteria(String alias, String fieldName, K value) {		
		super(alias, fieldName);
		this.value = value;
	}
	
	public GreaterOrEqualCriteria(OperandSource<K> operand, K value){
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
		return "$field$>=$value$";
	}

}

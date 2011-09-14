package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;

public class GreaterOrEqualCriteria<K> extends Criteria<K> implements Serializable {	
	private K value;

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
	
	public GreaterOrEqualCriteria(OperandSource operand, K value){
		super(operand);
		this.value = value;		
	}	

	
	public K getValue() {
		return value;
	}
	
	public void setValue(K value) {
		this.value = value;
	}

	
	@Override
	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$>=$value$";
	}

}

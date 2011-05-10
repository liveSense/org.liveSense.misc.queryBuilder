package org.liveSense.misc.queryBuilder.criterias;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;

public class LikeCriteria<K> extends Criteria<K> {	
	private K value;

	
	public LikeCriteria(String fieldName, K value) throws QueryBuilderException {
		this("", fieldName, value);
	}
	
	public LikeCriteria(String alias, String fieldName, K value) throws QueryBuilderException {
		super(alias, fieldName);		
		this.value = value;
		
		if (!(value instanceof String)) {
			throw new QueryBuilderException("Only string values allowed in LIKE criteria");
		}		
	}
	
	public LikeCriteria(OperandSource operand, K value) throws QueryBuilderException{
		super(operand);
		this.value = value;
		
		if (!(value instanceof String)) {
			throw new QueryBuilderException("Only string values allowed in LIKE criteria");
		}		
	}	

	
	public K getValue() {
		return value;
	}

	public void setValue(K value) {
		this.value = value;
	}

	
	@Override
	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$ LIKE '$'value'$'";
	}

	
}

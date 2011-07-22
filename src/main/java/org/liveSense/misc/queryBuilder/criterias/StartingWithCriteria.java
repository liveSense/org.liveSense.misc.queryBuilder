package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;

public class StartingWithCriteria<K> extends Criteria<K> implements Serializable {	
	private K value;

	public StartingWithCriteria() {
		super();
	}
	
	public StartingWithCriteria(String fieldName, K value) throws QueryBuilderException {
		this("", fieldName, value);
	}
	
	public StartingWithCriteria(String alias, String fieldName, K value) throws QueryBuilderException {
		super(alias, fieldName);		
		this.value = value;
		
		if (!(value instanceof String)) {
			throw new QueryBuilderException("Only string values allowed in STARTING WITH criteria");
		}		
	}
	
	public StartingWithCriteria(OperandSource operand, K value) throws QueryBuilderException {
		super(operand);
		this.value = value;
		
		if (!(value instanceof String)) {
			throw new QueryBuilderException("Only string values allowed in STARTING WITH criteria");
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
		return "$field$ STARTING WITH $value$";
	}

	
}

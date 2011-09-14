package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;

public class LikeCriteria<K> extends Criteria<K> implements Serializable {
	
	
	//consts
	private static final long serialVersionUID = 5292924355401481200L;
	
	
	//fields
	private K value;

	
	//constructors
	public LikeCriteria() {
		super();
	}
	
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
	
	public LikeCriteria(OperandSource<K> operand, K value) throws QueryBuilderException{
		super(operand);
		this.value = value;
		
		if (!(value instanceof String)) {
			throw new QueryBuilderException("Only string values allowed in LIKE criteria");
		}		
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
		return "$field$ LIKE $value$";
	}

	
}

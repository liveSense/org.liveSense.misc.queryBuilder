package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;

public class IsNotNullCriteria<K> extends Criteria<K> implements Serializable {
	
	public IsNotNullCriteria() {
		super();
	}

	public IsNotNullCriteria(String fieldName) {
		this("",fieldName);
	}	

	public IsNotNullCriteria(String alias,String fieldName) {
		super(alias, fieldName);
	}
	
	public IsNotNullCriteria(OperandSource operand){
		super(operand);		
	}	
	
	
	@Override
	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$ IS NOT NULL";
	}
	
	
}

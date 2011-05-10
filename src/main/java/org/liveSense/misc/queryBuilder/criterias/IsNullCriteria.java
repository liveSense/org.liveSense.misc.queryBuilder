package org.liveSense.misc.queryBuilder.criterias;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;

public class IsNullCriteria<K> extends Criteria<K> {
	

	public IsNullCriteria(String fieldName) {
		this("",fieldName);
	}	

	public IsNullCriteria(String alias,String fieldName) {
		super(alias, fieldName);
	}
	
	public IsNullCriteria(OperandSource operand){
		super(operand);		
	}	

	
	@Override
	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$ IS NULL";
	}
	
	
}

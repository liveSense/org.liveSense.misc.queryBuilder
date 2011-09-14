package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;

public class IsNullCriteria<K> extends Criteria<K> implements Serializable {

	
	//consts	
	private static final long serialVersionUID = -1849325802286210319L;

	
	//constructors
	public IsNullCriteria() {
		super();
	}

	public IsNullCriteria(String fieldName) {
		this("",fieldName);
	}	

	public IsNullCriteria(String alias,String fieldName) {
		super(alias, fieldName);
	}
	
	public IsNullCriteria(OperandSource<K> operand){
		super(operand);		
	}	

	
	//methods
	@Override
	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$ IS NULL";
	}
	
	
}

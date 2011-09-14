package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;

public class IsNotNullCriteria<K> extends Criteria<K> implements Serializable {
	
	
	//consts
	private static final long serialVersionUID = 5197630609416320661L;


	//constructors
	public IsNotNullCriteria() {
		super();
	}

	public IsNotNullCriteria(String fieldName) {
		this("",fieldName);
	}	

	public IsNotNullCriteria(String alias,String fieldName) {
		super(alias, fieldName);
	}
	
	public IsNotNullCriteria(OperandSource<K> operand){
		super(operand);		
	}	
	
	
	//methods
	@Override
	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$ IS NOT NULL";
	}
	
	
}

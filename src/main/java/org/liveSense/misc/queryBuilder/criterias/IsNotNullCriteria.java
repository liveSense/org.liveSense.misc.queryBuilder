package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.domains.Operand;
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;

public class IsNotNullCriteria extends AbstractCriteria implements Serializable {
	
	public IsNotNullCriteria() {
		super();
	}

	public IsNotNullCriteria(String fieldName) {
		this("",fieldName);
	}	

	public IsNotNullCriteria(String alias,String fieldName) {
		super(alias, fieldName);
	}
	
	public IsNotNullCriteria(Operand operand){
		super(operand);		
	}	
	
	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$ IS NOT NULL";
	}
	
}

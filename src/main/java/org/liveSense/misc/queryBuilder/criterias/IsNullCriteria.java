package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.domains.Operand;
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;

public class IsNullCriteria extends AbstractCriteria implements Serializable {

	public IsNullCriteria() {
		super();
	}

	public IsNullCriteria(String fieldName) {
		this("",fieldName);
	}	

	public IsNullCriteria(String alias,String fieldName) {
		super(alias, fieldName);
	}
	
	public IsNullCriteria(Operand operand){
		super(operand);		
	}	

	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$ IS NULL";
	}
	
}

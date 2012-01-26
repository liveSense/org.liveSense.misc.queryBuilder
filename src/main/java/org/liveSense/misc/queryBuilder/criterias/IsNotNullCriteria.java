package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.domains.Criteria;
import org.liveSense.misc.queryBuilder.operands.AbstractOperand;

public class IsNotNullCriteria extends AbstractCriteria implements Serializable, Criteria {
	private static final long serialVersionUID = -1918626129018546873L;

	public IsNotNullCriteria() {
		super();
	}

	public IsNotNullCriteria(String fieldName) {
		this("",fieldName);
	}	

	public IsNotNullCriteria(String alias,String fieldName) {
		super(alias, fieldName);
	}
	
	public IsNotNullCriteria(AbstractOperand operand){
		super(operand);		
	}	
	
	public String getQueryTemplate() {
		return "$field$ IS NOT NULL";
	}
	
}

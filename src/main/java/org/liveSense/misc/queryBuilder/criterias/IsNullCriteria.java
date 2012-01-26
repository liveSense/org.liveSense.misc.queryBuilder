package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.domains.Criteria;
import org.liveSense.misc.queryBuilder.operands.AbstractOperand;

public class IsNullCriteria extends AbstractCriteria implements Serializable, Criteria {
	private static final long serialVersionUID = -3296926930056382446L;

	public IsNullCriteria() {
		super();
	}

	public IsNullCriteria(String fieldName) {
		this("",fieldName);
	}	

	public IsNullCriteria(String alias,String fieldName) {
		super(alias, fieldName);
	}
	
	public IsNullCriteria(AbstractOperand operand){
		super(operand);		
	}	

	public String getQueryTemplate() {
		return "$field$ IS NULL";
	}
	
}

package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.beans.Value;
import org.liveSense.misc.queryBuilder.domains.Criteria;
import org.liveSense.misc.queryBuilder.operands.AbstractOperand;
import org.liveSense.misc.queryBuilder.operands.DefaultOperand;


public class AbstractCriteria implements Serializable, Criteria {
	private static final long serialVersionUID = -1512428439424809724L;
	protected AbstractOperand operand;

	public AbstractCriteria() {
		
	}
	
	public AbstractCriteria(String field){
		this("", field);		
	}
	
	public AbstractCriteria(String alias, String field){		
		operand = new DefaultOperand(alias, new Value(field), false);		
	}
	
	public AbstractCriteria(AbstractOperand operand){
		this.operand = operand;		
	}	

	
	public AbstractOperand getOperand() {
		return operand;
	}

	public String getQueryTemplate() {
		return null;
	}

	public void setOperand(AbstractOperand operand) {
		this.operand = operand;
	}	
}

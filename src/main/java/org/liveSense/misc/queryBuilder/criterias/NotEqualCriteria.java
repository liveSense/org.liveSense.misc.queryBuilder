package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.beans.Value;
import org.liveSense.misc.queryBuilder.domains.Criteria;
import org.liveSense.misc.queryBuilder.operands.AbstractOperand;

public class NotEqualCriteria extends AbstractCriteria implements Serializable, Criteria {
	private static final long serialVersionUID = -6660403099747151970L;
	private Value value;
	
	public NotEqualCriteria() {
		super();
	}

	public NotEqualCriteria(String fieldName, Value value) {
		this("",fieldName,value);
	}	

	public NotEqualCriteria(String alias,String fieldName, Value value) {
		super(alias, fieldName);
		this.value = value;
	}
	
	public NotEqualCriteria(AbstractOperand operand, Value value) {
		super(operand);
		this.value = value;		
	}		

	public NotEqualCriteria(String fieldName, Object value) {
		this("",fieldName, new Value(value));
	}	

	public NotEqualCriteria(String alias,String fieldName, Object value) {
		super(alias, fieldName);
		this.value = new Value(value);
	}
	
	public NotEqualCriteria(AbstractOperand operand, Object value) {
		super(operand);
		this.value = new Value(value);		
	}		

	
	public Value getValue() {
		return value;
	}
	
	public void setValue(
		Value value) {
		this.value = value;
	}

	public String getQueryTemplate() {
		return "$field$<>$value$";
	}
	
}

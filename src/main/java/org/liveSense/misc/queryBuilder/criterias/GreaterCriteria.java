package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.beans.Value;
import org.liveSense.misc.queryBuilder.domains.Criteria;
import org.liveSense.misc.queryBuilder.operands.AbstractOperand;

public class GreaterCriteria extends AbstractCriteria implements Serializable, Criteria {	
	private static final long serialVersionUID = 7240233409626805485L;
	private Value value;

	public GreaterCriteria() {
		super();
	}
	
	public GreaterCriteria(String fieldName, Value value) {
		this("",fieldName,value);
	}
	
	public GreaterCriteria(String alias, String fieldName, Value value) {
		super(alias, fieldName);
		this.value = value;		
	}
	
	public GreaterCriteria(AbstractOperand operand, Value value){
		super(operand);
		this.value = value;			
	}		

	public GreaterCriteria(String fieldName, Object value) {
		this("",fieldName, new Value(value));
	}
	
	public GreaterCriteria(String alias, String fieldName, Object value) {
		this(alias, fieldName, new Value(value));
	}
	
	public GreaterCriteria(AbstractOperand operand, Object value){
		this(operand, new Value(value));
	}		

	
	public Value getValue() {
		return value;
	}
	
	public void setValue(Value value) {
		this.value = value;
	}

	public String getQueryTemplate() {
		return "$field$>$value$";
	}

}

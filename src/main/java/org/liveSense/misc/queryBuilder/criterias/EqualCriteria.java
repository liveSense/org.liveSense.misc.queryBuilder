package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.beans.Value;
import org.liveSense.misc.queryBuilder.domains.Criteria;
import org.liveSense.misc.queryBuilder.operands.AbstractOperand;

public class EqualCriteria extends AbstractCriteria implements Serializable, Criteria {
	private static final long serialVersionUID = 8860514890160256749L;
	private Value value;

	public EqualCriteria() {
		super();
	}

	public EqualCriteria(String fieldName, Value value) {
		this("", fieldName, value);
	}	

	public EqualCriteria(String alias,String fieldName, Value value) {
		super(alias, fieldName);
		this.value = value;
	}
	
	public EqualCriteria(AbstractOperand operand, Value value){
		super(operand);
		this.value = value;		
	}	

	public EqualCriteria(String fieldName, Object value) {
		this("", fieldName, new Value(value));
	}	

	public EqualCriteria(String alias,String fieldName, Object value) {
		this(alias, fieldName, new Value(value));
	}
	
	public EqualCriteria(AbstractOperand operand, Object value){
		this(operand, new Value(value));
	}	
	
	public Value getValue() {
		return value;
	}
	
	public void setValue(
		Value value) {
		this.value = value;
	}

	public String getQueryTemplate()  {
		return "$field$=$value$";
	}
	
}

package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.beans.Value;
import org.liveSense.misc.queryBuilder.domains.Criteria;
import org.liveSense.misc.queryBuilder.operands.AbstractOperand;

public class LessOrEqualCriteria extends AbstractCriteria implements Serializable, Criteria {
	private static final long serialVersionUID = -7351790208739679712L;
	private Value value;

	public LessOrEqualCriteria() {
		super();
	}
	
	public LessOrEqualCriteria(String fieldName, Value value) {
		this("", fieldName, value);
	}

	public LessOrEqualCriteria(String alias, String fieldName, Value value) {
		super(alias, fieldName);
		this.value = value;
	}

	public LessOrEqualCriteria(AbstractOperand operand, Value value){
		super(operand);
		this.value = value;			
	}	

	public LessOrEqualCriteria(String fieldName, Object value) {
		this("", fieldName, new Value(value));
	}

	public LessOrEqualCriteria(String alias, String fieldName, Object value) {
		super(alias, fieldName);
		this.value = new Value(value);
	}

	public LessOrEqualCriteria(AbstractOperand operand, Object value){
		super(operand);
		this.value = new Value(value);			
	}	

	
	public Value getValue() {
		return value;
	}
	
	public void setValue(Value value) {
		this.value = value;
	}

	public String getQueryTemplate() {
		return "$field$<=$value$";
	}

}

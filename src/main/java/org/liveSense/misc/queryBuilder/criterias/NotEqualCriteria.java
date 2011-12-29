package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.beans.Value;
import org.liveSense.misc.queryBuilder.domains.Operand;
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;

public class NotEqualCriteria extends AbstractCriteria implements Serializable {
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
	
	public NotEqualCriteria(Operand operand, Value value) {
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
	
	public NotEqualCriteria(Operand operand, Object value) {
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

	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$<>$value$";
	}
	
}

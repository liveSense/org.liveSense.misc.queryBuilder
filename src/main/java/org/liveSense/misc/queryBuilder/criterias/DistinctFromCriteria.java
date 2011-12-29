package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.beans.Value;
import org.liveSense.misc.queryBuilder.domains.Operand;
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;

public class DistinctFromCriteria extends AbstractCriteria implements Serializable {
	private Value value;
	
	public DistinctFromCriteria() {
		super();
	}

	public DistinctFromCriteria(String fieldName, Value value) {
		this("",fieldName,value);
	}	

	public DistinctFromCriteria(String alias,String fieldName, Value value) {
		super(alias, fieldName);
		this.value = value;
	}
	
	public DistinctFromCriteria(Operand operand, Value value){
		super(operand);
		this.value = value;		
	}

	
	public DistinctFromCriteria(String fieldName, Object value) {
		this("",fieldName, new Value(value));
	}	

	public DistinctFromCriteria(String alias,String fieldName, Object value) {
		this(alias, fieldName, new Value(value));
	}
	
	public DistinctFromCriteria(Operand operand, Object value){
		this(operand, new Value(value));
	}
	
	public Value getValue() {
		return value;
	}
	
	public void setValue(
		Value value) {
		this.value = value;
	}

	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$ IS DISTINCT FROM $value$";
	}
	
}

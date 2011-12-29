package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.beans.Value;
import org.liveSense.misc.queryBuilder.domains.Operand;
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;

public class GreaterCriteria extends AbstractCriteria implements Serializable {	
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
	
	public GreaterCriteria(Operand operand, Value value){
		super(operand);
		this.value = value;			
	}		

	public GreaterCriteria(String fieldName, Object value) {
		this("",fieldName, new Value(value));
	}
	
	public GreaterCriteria(String alias, String fieldName, Object value) {
		this(alias, fieldName, new Value(value));
	}
	
	public GreaterCriteria(Operand operand, Object value){
		this(operand, new Value(value));
	}		

	
	public Value getValue() {
		return value;
	}
	
	public void setValue(Value value) {
		this.value = value;
	}

	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$>$value$";
	}

}

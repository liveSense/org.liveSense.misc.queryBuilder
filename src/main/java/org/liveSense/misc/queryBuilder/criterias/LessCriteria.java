package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.beans.Value;
import org.liveSense.misc.queryBuilder.domains.Operand;
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;

public class LessCriteria extends AbstractCriteria implements Serializable {	
	private static final long serialVersionUID = -1736289212413096101L;

	private Value value;

	public LessCriteria() {
		super();
	}
	
	public LessCriteria(String fieldName, Value value) {
		this("", fieldName, value);
	}
		
	public LessCriteria(String alias, String fieldName, Value value) {
		super(alias, fieldName);
		this.value = value;		
	}
	
	public LessCriteria(Operand operand, Value value){
		super(operand);
		this.value = value;			
	}	

	public LessCriteria(String fieldName, Object value) {
		this("", fieldName, new Value(value));
	}
		
	public LessCriteria(String alias, String fieldName, Object value) {
		super(alias, fieldName);
		this.value = new Value(value);		
	}
	
	public LessCriteria(Operand operand, Object value){
		super(operand);
		this.value = new Value(value);			
	}	

	public Value getValue() {
		return value;
	}
	
	public void setValue(Value value) {
		this.value = value;
	}

	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$<$value$";
	}

}

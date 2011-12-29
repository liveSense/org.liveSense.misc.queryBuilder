package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.beans.Value;
import org.liveSense.misc.queryBuilder.beans.ValueDomain.ValueTypes;
import org.liveSense.misc.queryBuilder.domains.Operand;
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;

public class LikeCriteria extends AbstractCriteria implements Serializable {	
	private Value value;

	public LikeCriteria() {
		super();
	}
	
	public LikeCriteria(String fieldName, Value value) throws QueryBuilderException {
		this("", fieldName, value);
	}
	
	public LikeCriteria(String alias, String fieldName, Value value) throws QueryBuilderException {
		super(alias, fieldName);		
		this.value = value;
		
		if (value.getType() != ValueTypes.String) {
			throw new QueryBuilderException("Only string values allowed in LIKE criteria");
		}		
	}
	
	public LikeCriteria(Operand operand, Value value) throws QueryBuilderException{
		super(operand);
		this.value = value;
		
		if (value.getType() != ValueTypes.String) {
			throw new QueryBuilderException("Only string values allowed in LIKE criteria");
		}		
	}	

	public LikeCriteria(String fieldName, String value) throws QueryBuilderException {
		this("", fieldName, value);
	}

	public LikeCriteria(String alias, String fieldName, String value) throws QueryBuilderException {
		super(alias, fieldName);		
		this.value = new Value(value);
	}
	
	public LikeCriteria(Operand operand, String value) throws QueryBuilderException{
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
		return "$field$ LIKE $value$";
	}

	
}

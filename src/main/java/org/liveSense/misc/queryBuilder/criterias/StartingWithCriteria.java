package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.beans.Value;
import org.liveSense.misc.queryBuilder.beans.ValueDomain.ValueTypes;
import org.liveSense.misc.queryBuilder.domains.Criteria;
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.AbstractOperand;

public class StartingWithCriteria extends AbstractCriteria implements Serializable, Criteria {	
	private static final long serialVersionUID = 2452803606417345529L;
	private Value value;

	public StartingWithCriteria() {
		super();
	}
	
	public StartingWithCriteria(String fieldName, Value value) throws QueryBuilderException {
		this("", fieldName, value);
	}
	
	public StartingWithCriteria(String alias, String fieldName, Value value) throws QueryBuilderException {
		super(alias, fieldName);		
		this.value = value;
		
		if (value.getType() != ValueTypes.String) {
			throw new QueryBuilderException("Only string values allowed in STARTING WITH criteria");
		}		
	}
	
	public StartingWithCriteria(AbstractOperand operand, Value value) throws QueryBuilderException {
		super(operand);
		this.value = value;
		
		if (value.getType() != ValueTypes.String) {
			throw new QueryBuilderException("Only string values allowed in STARTING WITH criteria");
		}
	}		

	public StartingWithCriteria(String fieldName, String value) throws QueryBuilderException {
		this("", fieldName, value);
	}
	
	public StartingWithCriteria(String alias, String fieldName, String value) throws QueryBuilderException {
		super(alias, fieldName);		
		this.value = new Value(value);
	}
	
	public StartingWithCriteria(AbstractOperand operand, String value) throws QueryBuilderException {
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
		return "$field$ STARTING WITH $value$";
	}

	
}

package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;

public class GreaterCriteria<K> extends Criteria<K> implements Serializable {	
	private K value;

	public GreaterCriteria() {
		super();
	}
	
	public GreaterCriteria(String fieldName, K value) {
		this("",fieldName,value);
	}
	
	public GreaterCriteria(String alias, String fieldName, K value) {
		super(alias, fieldName);
		this.value = value;		
	}
	
	public GreaterCriteria(OperandSource operand, K value){
		super(operand);
		this.value = value;			
	}		

	
	public K getValue() {
		return value;
	}
	
	public void setValue(K value) {
		this.value = value;
	}

	
	@Override
	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$>$value$";
	}

}

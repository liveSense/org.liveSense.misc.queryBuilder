package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;

public class NotEqualCriteria<K> extends Criteria<K> implements Serializable {
	
	
	//consts
	private static final long serialVersionUID = -5572839823016023449L;
	
	
	//fields
	private K value;
	
	
	//constructors
	public NotEqualCriteria() {
		super();
	}

	public NotEqualCriteria(String fieldName, K value) {
		this("",fieldName,value);
	}	

	public NotEqualCriteria(String alias,String fieldName, K value) {
		super(alias, fieldName);
		this.value = value;
	}
	
	public NotEqualCriteria(OperandSource<K> operand, K value) {
		super(operand);
		this.value = value;		
	}		

	
	//getters and setters
	public K getValue() {
		return value;
	}
	
	public void setValue(
		K value) {
		this.value = value;
	}

	
	//methods
	@Override
	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$<>$value$";
	}
	
	
}

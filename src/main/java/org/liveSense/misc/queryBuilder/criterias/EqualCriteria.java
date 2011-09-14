package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;

public class EqualCriteria<K> extends Criteria<K> implements Serializable {
	
	
	//consts
	private static final long serialVersionUID = -5761103957522310945L;
	
	
	//fields
	private K value;

	
	//constructors
	public EqualCriteria() {
		super();
	}

	public EqualCriteria(String fieldName, K value) {
		this("", fieldName, value);
	}	

	public EqualCriteria(String alias,String fieldName, K value) {
		super(alias, fieldName);
		this.value = value;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EqualCriteria(OperandSource operand, K value){
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
		return "$field$=$value$";
	}
	
	
}

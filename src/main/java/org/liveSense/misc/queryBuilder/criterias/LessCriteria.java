package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;

public class LessCriteria<K> extends Criteria<K> implements Serializable {
	
	
	//consts
	private static final long serialVersionUID = -1714760390390115098L;
	
	
	//fields
	private K value;

	
	//constructors
	public LessCriteria() {
		super();
	}
	
	public LessCriteria(String fieldName, K value) {
		this("", fieldName, value);
	}
		
	public LessCriteria(String alias, String fieldName, K value) {
		super(alias, fieldName);
		this.value = value;		
	}
	
	public LessCriteria(OperandSource<K> operand, K value){
		super(operand);
		this.value = value;			
	}	
	
	//getters and setters
	public K getValue() {
		return value;
	}
	
	public void setValue(K value) {
		this.value = value;
	}

	
	//methods
	@Override
	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$<$value$";
	}

}

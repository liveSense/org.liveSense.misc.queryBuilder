package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;

public class LessOrEqualCriteria<K> extends Criteria<K> implements Serializable {
	private K value;

	public LessOrEqualCriteria() {
		super();
	}
	
	public LessOrEqualCriteria(String fieldName, K value) {
		this("", fieldName, value);
	}

	public LessOrEqualCriteria(String alias, String fieldName, K value) {
		super(alias, fieldName);
		this.value = value;
	}

	public LessOrEqualCriteria(OperandSource operand, K value){
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
		return "$field$<=$value$";
	}

}

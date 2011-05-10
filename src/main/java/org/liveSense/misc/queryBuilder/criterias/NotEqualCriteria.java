package org.liveSense.misc.queryBuilder.criterias;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;

public class NotEqualCriteria<K> extends Criteria<K> {
	private K value;
	

	public NotEqualCriteria(String fieldName, K value) {
		this("",fieldName,value);
	}	

	public NotEqualCriteria(String alias,String fieldName, K value) {
		super(alias, fieldName);
		this.value = value;
	}
	
	public NotEqualCriteria(OperandSource operand, K value) {
		super(operand);
		this.value = value;		
	}		

	
	public K getValue() {
		return value;
	}
	
	public void setValue(
		K value) {
		this.value = value;
	}

	
	@Override
	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$<>$value$";
	}
	
	
}

package org.liveSense.misc.queryBuilder.criterias;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;

public class BetweenCriteria<K> extends Criteria<K> {
	
	K value1;
	K value2;

	public BetweenCriteria(K value1, K value2) {
		this(null, value1, value2);
	}

	public BetweenCriteria(String fieldName, K value1, K value2) {
		setField(fieldName);
		this.value1 = value1;
		this.value2 = value2;
	}
	
	public K getValue1() {
		return value1;
	}

	public void setValue1(
		K value1) {
		this.value1 = value1;
	}
	
	public K getValue2() {
		return value2;
	}
	
	public void setValue2(
		K value2) {
		this.value2 = value2;
	}

	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$ BETWEEN $value1$ AND $value2$";
	}

}

package org.liveSense.misc.queryBuilder.criterias;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;

public class EqualCriteria<K> extends Criteria<K> {

	K value;

	public EqualCriteria(K value) {
		this(null, value);
	}

	public EqualCriteria(String fieldName, K value) {
		setField(fieldName);
		this.value = value;
	}

	@Override
	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$=$value$";
	}

	
	public K getValue() {
		return value;
	}
	
	public void setValue(
		K value) {
		this.value = value;
	}
	
}

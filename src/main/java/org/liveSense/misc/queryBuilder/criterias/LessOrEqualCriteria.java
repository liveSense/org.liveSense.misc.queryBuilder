package org.liveSense.misc.queryBuilder.criterias;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;

public class LessOrEqualCriteria<K> extends Criteria<K> {
	
	K value;

	public LessOrEqualCriteria(K value) {
		this(null, value);
	}

	public LessOrEqualCriteria(String fieldName, K value) {
		this.value = value;
		setField(fieldName);
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

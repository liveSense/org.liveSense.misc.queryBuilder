package org.liveSense.misc.queryBuilder.criterias;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;

public class LikeCriteria<K> extends Criteria<K> {
	
	K value;

	public LikeCriteria(K value) throws QueryBuilderException {
		this(null, value);
	}

	public LikeCriteria(String fieldName, K value) throws QueryBuilderException {
		if (!(value instanceof String)) {
			throw new QueryBuilderException("Only string values allowed in LIKE criteria");
		}
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
		return "$field$ LIKE '$'value'$%'";
	}

	
}

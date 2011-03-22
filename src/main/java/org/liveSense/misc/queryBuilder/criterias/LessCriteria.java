package org.liveSense.misc.queryBuilder.criterias;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;

public class LessCriteria<K> extends Criteria<K> {
	
	K value;

	public LessCriteria(K value) {
		this(null, value);
	}

	public LessCriteria(String fieldName, K value) {
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
		return "$field$<$value$";
	}

}

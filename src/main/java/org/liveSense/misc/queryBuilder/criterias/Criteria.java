package org.liveSense.misc.queryBuilder.criterias;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;


public abstract class Criteria<K> {
	String field;
	
	public abstract String getQueryTemplate() throws QueryBuilderException;

	public String getField() {
		return field;
	}

	public void setField(
		String refereceFieldName) {
		this.field = refereceFieldName;
	}

}

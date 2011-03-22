package org.liveSense.misc.queryBuilder.criterias;

import java.util.ArrayList;
import java.util.List;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;

public class InCriteria<K> extends Criteria<K> {

	List<K> values;
	
	public InCriteria(List<K> values) {
		this(null, values);
	}
	
	public InCriteria(String fieldName, List<K> values) {
		this.values = values;
		setField(fieldName);
	}

	public InCriteria(K[] values) {
		this(null, values);
	}

	public InCriteria(String fieldName, K[] values) {
		this.values = new ArrayList<K>();
		for (int i=0; i<values.length; i++) {
			this.values.add(values[i]);
		}
		setField(fieldName);
	}
	

	
	public List<K> getValues() {
		return values;
	}

	
	public void setValues(List<K> values) {
		this.values = values;
	}

	@Override
	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$ IN ($values$)";
	}

}

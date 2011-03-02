package org.liveSense.misc.queryBuilder.criterias;

import java.util.ArrayList;
import java.util.List;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.models.Reference;

public class InCriteria<K> extends Criteria<K> {

	List<K> values;
	
	public InCriteria(Reference reference, String customReferenceFieldName, List<K> values) {
		this.reference = reference;
		this.values = values;
		this.customReferenceFieldName = customReferenceFieldName; 
	}

	public InCriteria(final String reference, String customReferenceFieldName, List<K> values) {
		this(new Reference() {

			public String reference() {
				return reference;
			}

			public String foreignKey() {
				return null;
			}
		}, customReferenceFieldName, values);
	}

	public InCriteria(Reference reference, String customReferenceFieldName, K[] values) {
		this(reference, customReferenceFieldName, (List<K>)null);
		this.values = new ArrayList<K>();
		for (int i=0; i<values.length; i++) {
			this.values.add(values[i]);
		}
	}

	public InCriteria(String reference, String customReferenceFieldName, K[] values) {
		this(reference, customReferenceFieldName, (List<K>)null);
		this.values = new ArrayList<K>();
		for (int i=0; i<values.length; i++) {
			this.values.add(values[i]);
		}
	}

	public InCriteria(Reference reference, List<K> values) {
		this(reference, null, values);
	}
	
	public InCriteria(Reference reference, K[] values) {
		this(reference, null, values);
	}

	public InCriteria(String reference, List<K> values) {
		this(reference, null, values);
	}
	
	public InCriteria(String reference, K[] values) {
		this(reference, (String)null, values);
	}


	@Override
	public String process() throws QueryBuilderException {
		if (values != null && values.size()>0) {
			String ret = reference.reference()+" IN (";
			int idx = 0;
			for (Object o : values) {
				if (idx != 0) ret+=",";
				ret += this.getAsValue(o);
				idx ++;
			}
			return ret+")";
		} else {
			return "";
		}
	}

}

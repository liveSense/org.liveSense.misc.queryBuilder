package org.liveSense.misc.queryBuilder.criterias;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.models.Reference;

public class EqualCriteria<K> extends Criteria<K> {
	
	K value;

	public EqualCriteria(K value) {
		this.value = value;
	}

	
	public EqualCriteria(Reference reference, String customReferenceFieldName, K value) {
		this.customReferenceFieldName = customReferenceFieldName;
		this.reference = reference;
		this.value = value;
	}

	public EqualCriteria(final String reference, String customReferenceFieldName, K value) {
		this(new Reference() {

			public String reference() {
				return reference;
			}

			public String foreignKey() {
				return null;
			}
		}, customReferenceFieldName, value);
	}

	public EqualCriteria(Reference reference, K value) {
		this(reference, null, value);
	}

	public EqualCriteria(final String reference, K value) {
		this(reference, null , value);
	}

	@Override
	public String process() throws QueryBuilderException {
		return reference.reference()+"="+getAsValue(value);
	}

}

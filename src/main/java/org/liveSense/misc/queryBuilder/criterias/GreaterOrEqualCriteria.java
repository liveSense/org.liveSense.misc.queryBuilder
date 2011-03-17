package org.liveSense.misc.queryBuilder.criterias;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.models.Reference;

public class GreaterOrEqualCriteria<K> extends Criteria<K> {
	
	K value;

	public GreaterOrEqualCriteria(K value) {
		this.value = value;
	}

	
	public GreaterOrEqualCriteria(Reference reference, String customReferenceFieldName, K value) {
		this.customReferenceFieldName = customReferenceFieldName;
		this.reference = reference;
		this.value = value;
	}

	public GreaterOrEqualCriteria(final String reference, String customReferenceFieldName, K value) {
		this(new Reference() {

			public String reference() {
				return reference;
			}

			public String foreignKey() {
				return null;
			}
		}, customReferenceFieldName, value);
	}

	public GreaterOrEqualCriteria(Reference reference, K value) {
		this(reference, null, value);
	}

	public GreaterOrEqualCriteria(final String reference, K value) {
		this(reference, null , value);
	}

	@Override
	public String process() throws QueryBuilderException {
		return reference.reference()+">="+getAsValue(value);
	}

}

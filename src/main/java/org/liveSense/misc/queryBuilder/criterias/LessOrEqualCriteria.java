package org.liveSense.misc.queryBuilder.criterias;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.models.Reference;

public class LessOrEqualCriteria<K> extends Criteria<K> {
	
	K value;

	public LessOrEqualCriteria(K value) {
		this.value = value;
	}

	
	public LessOrEqualCriteria(Reference reference, String customReferenceFieldName, K value) {
		this.customReferenceFieldName = customReferenceFieldName;
		this.reference = reference;
		this.value = value;
	}

	public LessOrEqualCriteria(final String reference, String customReferenceFieldName, K value) {
		this(new Reference() {

			public String reference() {
				return reference;
			}

			public String foreignKey() {
				return null;
			}
		}, customReferenceFieldName, value);
	}

	public LessOrEqualCriteria(Reference reference, K value) {
		this(reference, null, value);
	}

	public LessOrEqualCriteria(final String reference, K value) {
		this(reference, null , value);
	}

	@Override
	public String process() throws QueryBuilderException {
		return reference.reference()+"<="+getAsValue(value);
	}

}

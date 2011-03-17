package org.liveSense.misc.queryBuilder.criterias;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.models.Reference;

public class GreaterCriteria<K> extends Criteria<K> {
	
	K value;

	public GreaterCriteria(K value) {
		this.value = value;
	}

	
	public GreaterCriteria(Reference reference, String customReferenceFieldName, K value) {
		this.customReferenceFieldName = customReferenceFieldName;
		this.reference = reference;
		this.value = value;
	}

	public GreaterCriteria(final String reference, String customReferenceFieldName, K value) {
		this(new Reference() {

			public String reference() {
				return reference;
			}

			public String foreignKey() {
				return null;
			}
		}, customReferenceFieldName, value);
	}

	public GreaterCriteria(Reference reference, K value) {
		this(reference, null, value);
	}

	public GreaterCriteria(final String reference, K value) {
		this(reference, null , value);
	}

	@Override
	public String process() throws QueryBuilderException {
		return reference.reference()+">"+getAsValue(value);
	}

}

package org.liveSense.misc.queryBuilder.criterias;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.models.Reference;

public class LessCriteria<K> extends Criteria<K> {
	
	K value;

	public LessCriteria(K value) {
		this.value = value;
	}

	
	public LessCriteria(Reference reference, String customReferenceFieldName, K value) {
		this.customReferenceFieldName = customReferenceFieldName;
		this.reference = reference;
		this.value = value;
	}

	public LessCriteria(final String reference, String customReferenceFieldName, K value) {
		this(new Reference() {

			public String reference() {
				return reference;
			}

			public String foreignKey() {
				return null;
			}
		}, customReferenceFieldName, value);
	}

	public LessCriteria(Reference reference, K value) {
		this(reference, null, value);
	}

	public LessCriteria(final String reference, K value) {
		this(reference, null , value);
	}

	@Override
	public String process() throws QueryBuilderException {
		return reference.reference()+"<"+getAsValue(value);
	}

}

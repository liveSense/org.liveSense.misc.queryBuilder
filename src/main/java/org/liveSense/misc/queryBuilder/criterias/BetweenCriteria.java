package org.liveSense.misc.queryBuilder.criterias;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.models.Reference;

public class BetweenCriteria<K> extends Criteria<K> {
	
	K value1;
	K value2;

	public BetweenCriteria(Reference reference, K value1, K value2) {
		this(reference, null, value1, value2);
	}

	public BetweenCriteria(String reference, K value1, K value2) {
		this(reference, null, value1, value2);
	}

	public BetweenCriteria(final String reference, String customReferenceFieldName, K value1, K value2) {
		this(new Reference() {

			public String reference() {
				return reference;
			}

			public String foreignKey() {
				return null;
			}
		}, customReferenceFieldName, value1, value2);
	}

	public BetweenCriteria(Reference reference, String customReferenceFieldName, K value1, K value2) {
		this.reference = reference;
		this.value1 = value1;
		this.value2 = value2;
		this.customReferenceFieldName = customReferenceFieldName;
	}

	@Override
	public String process() throws QueryBuilderException {
		return reference.reference()+" BETWEEN "+this.getAsValue(value1)+" AND "+this.getAsValue(value2);
	}

}

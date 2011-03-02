package org.liveSense.misc.queryBuilder.criterias;

import java.util.Date;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.models.QueryModel;
import org.liveSense.misc.queryBuilder.models.Reference;

public class LikeCriteria<K> extends Criteria<K> {

	
	K value;

	public LikeCriteria(K value) {
		this.value = value;
	}

	
	public LikeCriteria(Reference reference, String customReferenceFieldName, K value) {
		this.customReferenceFieldName = customReferenceFieldName;
		this.reference = reference;
		this.value = value;
	}

	public LikeCriteria(final String reference, String customReferenceFieldName, K value) {
		this(new Reference() {

			public String reference() {
				return reference;
			}

			public String foreignKey() {
				return null;
			}
		}, customReferenceFieldName, value);
	}

	public LikeCriteria(Reference reference, K value) {
		this(reference, null, value);
	}

	public LikeCriteria(final String reference, K value) {
		this(reference, null , value);
	}
	
	@Override
	public String getAsValue(Object o) throws QueryBuilderException {
		if (o == null) return "";
		if (o instanceof String) return "'"+(String)o+"%'";
		else if (o instanceof Integer) throw new QueryBuilderException("Integer value is not allowed");
		else if (o instanceof Long)  throw new QueryBuilderException("Long value is not allowed");
		else if (o instanceof Date)  throw new QueryBuilderException("Date value is not allowed");
		else if (o instanceof QueryModel) {
			@SuppressWarnings("unchecked")
			QueryModel<K> am = (QueryModel<K>)o;
			if (getCustomReferenceFieldName() == null)  
				return this.getAsValue(am.getPrimaryKeyField()+"%");
			else
				return this.getAsValue(am.getField(this.getCustomReferenceFieldName())+"%");
		}
		else o.toString();
		return "";
	}


	@Override
	public String process() throws QueryBuilderException {
		return reference.reference()+" LIKE "+getAsValue(value);
	}

	
}

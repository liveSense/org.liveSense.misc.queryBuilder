package org.liveSense.misc.queryBuilder.criterias;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.models.QueryModel;
import org.liveSense.misc.queryBuilder.models.Reference;

public abstract class Criteria<K> {
	Reference reference;
	String customReferenceFieldName;
	
	
	public Reference getReference() {
		return reference;
	}

	public void setReference(final Reference reference) {
		this.reference = reference;
	}

	
	public String getCustomReferenceFieldName() {
		return customReferenceFieldName;
	}

	public void setCustomReferenceFieldName(final String keyFieldName) {
		this.customReferenceFieldName = keyFieldName;
	}

	private static Map<String, String> months = new HashMap<String, String>();
	{
		months.put("Jan", "01");
		months.put("Feb", "02");
		months.put("Mar", "03");
		months.put("Apr", "04");
		months.put("May", "05");
		months.put("Jun", "06");
		months.put("Jul", "07");
		months.put("Aug", "08");
		months.put("Sep", "09");
		months.put("Oct", "10");
		months.put("Nov", "11");
		months.put("Dec", "12");
	}
	public static String formatDate(final Date date) {
		String ret = "";
		if (date == null) return "";
		final String[] d = date.toString().split(" ");
		if (d.length != 6) return "";
		ret = d[5]+"."+months.get(d[1])+"."+d[2];
		return ret;
	}

	public String getAsValue(final Object o) throws QueryBuilderException {
		if (o == null) return "";
		if (o instanceof String) return "'"+(String)o+"'";
		else if (o instanceof Integer) return ((Integer)o).toString();
		else if (o instanceof Long) return ((Long)o).toString();
		else if (o instanceof Date) return "'"+formatDate((Date)o)+"'";
		else if (o instanceof QueryModel) {
			@SuppressWarnings("unchecked")
			final
			QueryModel<K> am = (QueryModel<K>)o;
			if (getCustomReferenceFieldName() == null)  
				return getAsValue(am.getPrimaryKeyField());
			else
				return getAsValue(am.getField(this.getCustomReferenceFieldName()));
		}
		else o.toString();
		return "";
	}
	
	public abstract String process() throws QueryBuilderException;
}

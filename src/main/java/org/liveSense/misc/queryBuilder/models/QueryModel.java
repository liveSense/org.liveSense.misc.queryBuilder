package org.liveSense.misc.queryBuilder.models;


public interface QueryModel<K>  {

	/*
	@SuppressWarnings("rawtypes")
	public static <E extends Enum<E> & Reference> E from(E[] values,
			String reference) {
		for (E e : values)
			if (e.reference() == reference)
				return e;

		throw new IllegalArgumentException("Illegal reference: " + reference);
	}
   */

	/**
	 * Returns the primary unique key field name
	 * 
	 * @return
	 */
	public K getPrimaryKeyField();
	
	/**
	 * Returs the fild with the given name
	 * 
	 * @param fieldName
	 * @return
	 */
	public Object getField(String fieldName);

}

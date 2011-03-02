package org.liveSense.misc.queryBuilder.models;

public interface QueryModel<K>  {

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

package org.liveSense.misc.queryBuilder;


public interface ToSQLStringEvent {


	public boolean toSQLString(
		Object obj,
		StringBuilder sb)
		throws Exception;

}

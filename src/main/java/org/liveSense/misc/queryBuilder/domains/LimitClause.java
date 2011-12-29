package org.liveSense.misc.queryBuilder.domains;

public interface LimitClause {

	public Integer getLimit();
	
	public void setLimit(Integer limit);
	
	public Integer getOffset();
	
	public void setOffset(Integer offset);
	
}

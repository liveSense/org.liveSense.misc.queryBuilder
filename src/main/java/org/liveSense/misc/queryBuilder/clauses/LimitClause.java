package org.liveSense.misc.queryBuilder.clauses;

public class LimitClause {
	Integer limit;
	Integer offset;
	
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
	public LimitClause(Integer limit, Integer offset) {
		this.limit = limit;
		this.offset = offset;
	}
	

}

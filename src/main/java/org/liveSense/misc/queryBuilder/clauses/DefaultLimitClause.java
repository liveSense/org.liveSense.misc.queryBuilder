package org.liveSense.misc.queryBuilder.clauses;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.domains.LimitClause;

public class DefaultLimitClause implements Serializable, LimitClause {
	private static final long serialVersionUID = 6632319600472528501L;

	Integer limit;
	Integer offset;
	
	public DefaultLimitClause() {
	}
	
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
	
	public DefaultLimitClause(Integer limit, Integer offset) {
		this.limit = limit;
		this.offset = offset;
	}
	

}

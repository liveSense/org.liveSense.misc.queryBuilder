package org.liveSense.misc.queryBuilder.clauses;

import java.io.Serializable;

public class LimitClause implements Serializable {
	
	
	//consts
	private static final long serialVersionUID = -4380904853559629125L;
	
	
	//fields
	private Integer limit;
	private Integer offset;
	
	
	//constructors
	public LimitClause() {
	}
	
	
	//getters and setters
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

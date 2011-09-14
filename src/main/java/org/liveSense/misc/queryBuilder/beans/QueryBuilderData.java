package org.liveSense.misc.queryBuilder.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.liveSense.misc.queryBuilder.clauses.LimitClause;
import org.liveSense.misc.queryBuilder.clauses.OrderByClause;


public class QueryBuilderData<T> implements Serializable{
	
	
	//consts
	private static final long serialVersionUID = -1250034376010372533L;
	
	
	//fields
	private T where;
	private LimitClause limit = new LimitClause(-1, -1);
	private List<OrderByClause> orderBy;	
	private Map<String, Object> parameters;
	
	
	//getters and setters
	public T getWhere() {
		return where;
	}
	
	public void setWhere(T where) {
		this.where = where;
	}
	
	public LimitClause getLimit() {
		return limit;
	}

	public void setLimit(LimitClause limit) {
		this.limit = limit;
	}

	public List<OrderByClause> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(List<OrderByClause> orderBy) {
		this.orderBy = orderBy;
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}
	
	public void setParameters(
		Map<String, Object> parameters) {
		this.parameters = parameters;
	}


}

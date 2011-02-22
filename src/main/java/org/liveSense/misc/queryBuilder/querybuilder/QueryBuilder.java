package org.liveSense.misc.queryBuilder.querybuilder;

import java.util.List;

import org.liveSense.misc.queryBuilder.exception.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operators.AndOperator;
import org.liveSense.misc.queryBuilder.operators.Operator;

public abstract class QueryBuilder {
	
	private Object params;
	private LimitClause limit = new LimitClause(-1, -1);
	private List<OrderByClause> orderBy;
		
	public Object getParams() {
		return params;
	}
	
	public void setParams(Object params) {
		this.params = params;
	}

	public String buildParameters() throws QueryBuilderException {
		return buildParameters(params);
	}
	
	public String buildParameters(Object params) throws QueryBuilderException {
		if (params == null) return "";
		if (!(params instanceof Operator)) {
			params = new AndOperator(params);
		}
		return ((Operator)params).process(this);
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

	public abstract String getQuery();
	
	
}

package org.liveSense.misc.queryBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.liveSense.misc.queryBuilder.clauses.LimitClause;
import org.liveSense.misc.queryBuilder.clauses.OrderByClause;
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operators.AndOperator;
import org.liveSense.misc.queryBuilder.operators.Operator;

public abstract class QueryBuilder {
	
	@SuppressWarnings("rawtypes")
	private Class clazz;
	private Object where;
	private LimitClause limit = new LimitClause(-1, -1);
	private List<OrderByClause> orderBy;	
	private Map<String, Object> parameters; 
	
	@SuppressWarnings("rawtypes")
	public Class getClazz() {
		return clazz;
	}
	
	@SuppressWarnings("rawtypes")
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	
	public Object getWhere() {
		return where;
	}
	
	public void setWhere(Object where) {
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


	public String buildWhere() throws QueryBuilderException {
		return buildWhere(where);
	}
	
	public String buildWhere(Object where) throws QueryBuilderException {
		return buildWhere(null, where);
	}

	@SuppressWarnings("rawtypes")
	public String buildWhere(Class<?> clazz, Object where) throws QueryBuilderException {
		if (where == null) return "";
		if (!(where instanceof Operator)) {
			where = new AndOperator(where);
		}
		Class localClass = clazz;
		if (localClass == null)
			localClass = this.clazz;
		return OperatorAndCriteriaProcessor.processOperator(localClass, (Operator)where);
	}


	public void setOrderBy(OrderByClause[] orderBy) {
		this.orderBy = Arrays.asList(orderBy);
	}
	
	public void setOrderBy(OrderByClause orderBy) {
		setOrderBy(new OrderByClause[] {orderBy});
	}
	
	
	public abstract String getQuery();
	
	public String getQuery(String tableAlias){
		return getQuery() + " " + tableAlias;
	}
	
	
}

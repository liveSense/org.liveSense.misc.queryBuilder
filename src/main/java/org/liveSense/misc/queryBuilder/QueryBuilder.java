package org.liveSense.misc.queryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.liveSense.misc.queryBuilder.clauses.DefaultLimitClause;
import org.liveSense.misc.queryBuilder.domains.Criteria;
import org.liveSense.misc.queryBuilder.domains.LimitClause;
import org.liveSense.misc.queryBuilder.domains.Operator;
import org.liveSense.misc.queryBuilder.domains.OrderByClause;
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operators.AndOperator;

public abstract class QueryBuilder {

	
	//fields
	@SuppressWarnings("rawtypes")
	private Class clazz;	
	private String tableAlias;
	private Operator where;
	private LimitClause limit = new DefaultLimitClause(-1, -1);
	private List<OrderByClause> orderBy;	
	private Map<String, Object> parameters;

	
	//getters and setters
	@SuppressWarnings("rawtypes")
	public Class getClazz() {
		return clazz;
	}
	
	@SuppressWarnings("rawtypes")
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	
	public String getTableAlias() {
		return tableAlias;
	}
	
	public void setTableAlias(
		String tableAlias) {
		this.tableAlias = tableAlias;
	}
	
	public Operator getWhere() {
		return where;
	}
	
	public void setWhere(Operator where) {
		this.where = where;
	}

	public void setWhere(Criteria where) {
		this.where = new AndOperator(where);
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

	
	//alternate getters and setters
	public void setOrderBy(OrderByClause[] orderBy) {
		this.orderBy = new ArrayList<OrderByClause>();
		for (int i = 0; i < orderBy.length; i++) {
			this.orderBy.add(orderBy[i]);
		}
	}
	
	public void setOrderBy(OrderByClause orderBy) {
		setOrderBy(new OrderByClause[] {orderBy});
	}

	//methods
	public String buildWhere() throws QueryBuilderException {
		return buildWhere(getWhere());
	}
	
	public String buildWhere(Operator where) throws QueryBuilderException {
		return buildWhere(null, where);
	}

	public String buildWhere(Criteria where) throws QueryBuilderException {
		return buildWhere(null, where);
	}
	
	@SuppressWarnings("rawtypes")
	public String buildWhere(Class<?> clazz, Operator where) throws QueryBuilderException {
		if (where == null) return "";
		if (!(where instanceof Operator)) {
			where = new AndOperator(where);
		}
		Class localClass = clazz;
		if (localClass == null)
			localClass = this.clazz;
		return OperatorAndCriteriaProcessor.processOperator(localClass, (Operator)where);
	}	

	@SuppressWarnings("rawtypes")
	public String buildWhere(Class<?> clazz, Criteria where) throws QueryBuilderException {
		if (where == null) return "";
		Operator cond = new AndOperator(where);
		return buildWhere(clazz, cond);
	}	

	
	public abstract String getQuery();
	
	public String getQuery(String tableAlias){
		
		String localTableAlias = tableAlias;
		if (localTableAlias == null)
			localTableAlias = this.tableAlias;
		if (localTableAlias == null)
			localTableAlias = "";
		return getQuery() + " " + localTableAlias;
	}
	
	
}

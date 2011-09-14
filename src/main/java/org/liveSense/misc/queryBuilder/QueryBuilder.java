package org.liveSense.misc.queryBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.liveSense.misc.queryBuilder.beans.QueryBuilderData;
import org.liveSense.misc.queryBuilder.clauses.LimitClause;
import org.liveSense.misc.queryBuilder.clauses.OrderByClause;
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operators.AndOperator;
import org.liveSense.misc.queryBuilder.operators.Operator;

public abstract class QueryBuilder {

	
	//fields
	@SuppressWarnings("rawtypes")
	private Class clazz;	
	private String tableAlias;
	@SuppressWarnings("rawtypes")
	private QueryBuilderData data = new QueryBuilderData();
	
	
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
	
	@SuppressWarnings("rawtypes")
	public QueryBuilderData getData() {
		return data;		
	}	
	
	@SuppressWarnings("rawtypes")
	public void setData(
		QueryBuilderData data) {	
		this.data = data;
	}
	
	//alternate getters and setters (backward compatibility)
	public Object getWhere() {
		return data.getWhere();
	}
	
	@SuppressWarnings("unchecked")
	public void setWhere(Object where) {
		data.setWhere(where);
	}
	
	public LimitClause getLimit() {
		return data.getLimit();
	}

	public void setLimit(LimitClause limit) {
		data.setLimit(limit);
	}

	@SuppressWarnings("unchecked")
	public List<OrderByClause> getOrderBy() {
		return data.getOrderBy();
	}

	@SuppressWarnings("unchecked")
	public void setOrderBy(List<OrderByClause> orderBy) {
		data.setOrderBy(orderBy);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getParameters() {
		return data.getParameters();
	}
	
	@SuppressWarnings("unchecked")
	public void setParameters(
		Map<String, Object> parameters) {
		data.setParameters(parameters);
	}

	@SuppressWarnings("unchecked")
	public void setOrderBy(OrderByClause[] orderBy) {
		data.setOrderBy(Arrays.asList(orderBy));
	}
	
	public void setOrderBy(OrderByClause orderBy) {
		setOrderBy(new OrderByClause[] {orderBy});
	}	

	//methods
	public String buildWhere() throws QueryBuilderException {
		return buildWhere(data.getWhere());
	}
	
	public String buildWhere(Object where) throws QueryBuilderException {
		return buildWhere(null, where);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
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

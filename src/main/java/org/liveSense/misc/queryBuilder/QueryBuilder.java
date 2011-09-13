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
	
	public QueryBuilderData getData() {
		return data;		
	}	
	
	public void setData(
		QueryBuilderData data) {	
		this.data = data;
	}
	
	//alternate getters and setters (backward compatibility)
	public Object getWhere() {
		return data.getWhere();
	}
	
	public void setWhere(Object where) {
		data.setWhere(where);
	}
	
	public LimitClause getLimit() {
		return data.getLimit();
	}

	public void setLimit(LimitClause limit) {
		data.setLimit(limit);
	}

	public List<OrderByClause> getOrderBy() {
		return data.getOrderBy();
	}

	public void setOrderBy(List<OrderByClause> orderBy) {
		data.setOrderBy(orderBy);
	}

	public Map<String, Object> getParameters() {
		return data.getParameters();
	}
	
	public void setParameters(
		Map<String, Object> parameters) {
		data.setParameters(parameters);
	}
	
	public String getTableAlias() {
		return data.getTableAlias();
	}
	
	public void setTableAlias(
		String tableAlias) {
		data.setTableAlias(tableAlias);
	}

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
	
	public abstract String getQuery();
	
	public String getQuery(String tableAlias){
		
		String localTableAlias = tableAlias;
		if (localTableAlias == null)
			localTableAlias = data.getTableAlias();
		if (localTableAlias == null)
			localTableAlias = "";
		return getQuery() + " " + localTableAlias;
	}
	
	
}

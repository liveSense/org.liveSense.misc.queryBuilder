package org.liveSense.misc.queryBuilder.querybuilder;

import java.util.List;

public class SimpleSQLQueryBuilder extends QueryBuilder {

	String statement;
	
	public SimpleSQLQueryBuilder(String statement) {
		this(statement, null, null, null);
	}

	public SimpleSQLQueryBuilder(String statement, Object parameters) {
		this(statement, parameters, null, null);
	}

	public SimpleSQLQueryBuilder(String statement, LimitClause limit) {
		this(statement, null, limit, null);
	}

	public SimpleSQLQueryBuilder(String statement, Object parameters, LimitClause limit) {
		this(statement, parameters, limit, null);
	}

	public SimpleSQLQueryBuilder(String statement, Object parameters, LimitClause limit, List<OrderByClause> orderBy) {
		this.statement = statement;
		setLimit(limit);
		setOrderBy(orderBy);
		setParams(parameters);
	}

	@Override
	public String getQuery() {
		return this.statement;
	}
	
}

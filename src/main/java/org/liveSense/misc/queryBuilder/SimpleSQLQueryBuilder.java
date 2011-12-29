package org.liveSense.misc.queryBuilder;

import java.util.List;

import org.liveSense.misc.queryBuilder.clauses.DefaultLimitClause;
import org.liveSense.misc.queryBuilder.clauses.DefaultOrderByClause;
import org.liveSense.misc.queryBuilder.domains.LimitClause;
import org.liveSense.misc.queryBuilder.domains.Operator;
import org.liveSense.misc.queryBuilder.domains.OrderByClause;

public class SimpleSQLQueryBuilder extends QueryBuilder {

	String statement;
	
	public SimpleSQLQueryBuilder(String statement) {
		this(statement, null, null, null);
	}

	public SimpleSQLQueryBuilder(String statement, Operator parameters) {
		this(statement, parameters, null, null);
	}

	public SimpleSQLQueryBuilder(String statement, LimitClause limit) {
		this(statement, null, limit, null);
	}

	public SimpleSQLQueryBuilder(String statement, Operator parameters, LimitClause limit) {
		this(statement, parameters, limit, null);
	}

	public SimpleSQLQueryBuilder(String statement, Operator parameters, LimitClause limit, List<OrderByClause> orderBy) {
		this.statement = statement;
		setLimit(limit);
		setOrderBy(orderBy);
		setWhere(parameters);
	}

	@Override
	public String getQuery() {
		return this.statement;
	}
	
}

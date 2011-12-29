package org.liveSense.misc.queryBuilder.domains;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;

public interface Criteria {
	
	public Operand getOperand();

	public String getQueryTemplate() throws QueryBuilderException;

}

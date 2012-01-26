package org.liveSense.misc.queryBuilder.domains;

import org.liveSense.misc.queryBuilder.operands.AbstractOperand;

public interface Criteria {
	
	public Operand getOperand();

	public String getQueryTemplate();

	public void setOperand(AbstractOperand operand);

}

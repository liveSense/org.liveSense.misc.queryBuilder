package org.liveSense.misc.queryBuilder.domains;

import org.liveSense.misc.queryBuilder.beans.Value;

public interface Operand  {		

	public String getQualifier();
	
	public boolean isLiteral();
	
	public String getFunction();
	
	public void setSource(Value source);

	public Value getSource();

	
}
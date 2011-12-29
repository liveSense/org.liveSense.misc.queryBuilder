package org.liveSense.misc.queryBuilder.domains;

import java.io.Serializable;

public interface OrderByClause {
	
	public String getFieldName();
	
	public void setFieldName(String fieldName);
	
	public Boolean getSortDesc();
	
	public void setSortDesc(Boolean sortDesc);
	
}

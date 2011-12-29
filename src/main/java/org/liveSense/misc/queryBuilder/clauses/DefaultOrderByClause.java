package org.liveSense.misc.queryBuilder.clauses;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.domains.OrderByClause;

public class DefaultOrderByClause implements Serializable, OrderByClause {
	
	private static final long serialVersionUID = -5242500703504684397L;

	String fieldName;
	Boolean sortDesc;
	
	public DefaultOrderByClause() {
		
	}
	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Boolean getSortDesc() {
		return sortDesc;
	}
	public void setSortDesc(Boolean sortDesc) {
		this.sortDesc = sortDesc;
	}
	
	public DefaultOrderByClause(String fieldName, Boolean sortDesc) {
		this.fieldName = fieldName;
		this.sortDesc = sortDesc;
	}
	

}

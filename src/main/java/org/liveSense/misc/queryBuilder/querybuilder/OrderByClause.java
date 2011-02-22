package org.liveSense.misc.queryBuilder.querybuilder;

public class OrderByClause {
	
	String fieldName;
	Boolean sortDesc;
	
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
	
	public OrderByClause(String fieldName, Boolean sortDesc) {
		this.fieldName = fieldName;
		this.sortDesc = sortDesc;
	}
	

}

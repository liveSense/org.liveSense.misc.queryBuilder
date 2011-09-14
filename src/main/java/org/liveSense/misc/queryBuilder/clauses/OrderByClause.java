package org.liveSense.misc.queryBuilder.clauses;

import java.io.Serializable;

public class OrderByClause implements Serializable {
	
	
	//consts
	private static final long serialVersionUID = 7113488053788586852L;
	
	
	//fields
	private String fieldName;
	private Boolean sortDesc;
	
	
	//constructors
	public OrderByClause() {
		
	}
	
	
	//getters and setters
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

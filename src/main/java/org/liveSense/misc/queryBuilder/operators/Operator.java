package org.liveSense.misc.queryBuilder.operators;

import java.io.Serializable;


public abstract class Operator<T> implements Serializable {

	//consts
	private static final long serialVersionUID = -2732125099200342642L;
	
	
	//fields
	private T params;

	
	//methods
	public abstract String getParamPreOperation();
	public abstract String getParamPostOperation();
	public abstract String getFirstParamPreOperation();
	public abstract String getMiddleParamPreOperation();
	public abstract String getLastParamPreOperation();
	public abstract String getFirstParamPostOperation();
	public abstract String getMiddleParamPostOperation();
	public abstract String getLastParamPostOperation();
	
	
	//getters and setters
	public void setParams(T params) {
		this.params = params;
	}
	
	public T getParams() {
		return this.params;
	}

}

package org.liveSense.misc.queryBuilder.operators;


public abstract class Operator {

	
	Object params;

	public abstract String getParamPreOperation();
	public abstract String getParamPostOperation();
	public abstract String getFirstParamPreOperation();
	public abstract String getMiddleParamPreOperation();
	public abstract String getLastParamPreOperation();
	public abstract String getFirstParamPostOperation();
	public abstract String getMiddleParamPostOperation();
	public abstract String getLastParamPostOperation();
	
	public void setParams(Object params) {
		this.params = params;
	}
	
	public Object getParams() {
		return this.params;
	}

}

package org.liveSense.misc.queryBuilder.operators;


public class NotOperator extends Operator {

	
	public NotOperator(Object params) {
		super();
		setParams(params);
	}

	@Override
	public String getParamPreOperation() {
		return "(";
	}

	@Override
	public String getParamPostOperation() {
		return ")";
	}

	@Override
	public String getFirstParamPreOperation() {
		return "NOT ";
	}

	@Override
	public String getMiddleParamPreOperation() {
		return "";
	}

	@Override
	public String getLastParamPreOperation() {
		return "";
	}

	@Override
	public String getFirstParamPostOperation() {
		return "";
	}

	@Override
	public String getMiddleParamPostOperation() {
		return "";
	}

	@Override
	public String getLastParamPostOperation() {
		return "";
	}
	

}

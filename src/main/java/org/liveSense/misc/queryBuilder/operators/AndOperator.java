package org.liveSense.misc.queryBuilder.operators;


public class AndOperator extends Operator {

	
	public AndOperator(Object params) {
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
		return "";
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
		return " AND ";
	}

	@Override
	public String getMiddleParamPostOperation() {
		return " AND ";
	}

	@Override
	public String getLastParamPostOperation() {
		return "";
	}
	

}

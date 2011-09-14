package org.liveSense.misc.queryBuilder.operators;

import java.io.Serializable;


public class OrOperator extends Operator implements Serializable {

	public OrOperator() {
		super();
	}
	
	public OrOperator(Object params) {
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
		return " OR ";
	}

	@Override
	public String getMiddleParamPostOperation() {
		return " OR ";
	}

	@Override
	public String getLastParamPostOperation() {
		return "";
	}
	

}

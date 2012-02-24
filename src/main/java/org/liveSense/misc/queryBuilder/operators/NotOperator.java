package org.liveSense.misc.queryBuilder.operators;

import java.io.Serializable;


public class NotOperator extends AbstractOperator implements Serializable {

	private static final long serialVersionUID = 1583783660683119788L;

	public NotOperator() {
		super();
	}
	
	public NotOperator(Object params) {
		super();
		addParamsObject(params);
	}

	public String getParamPreOperation() {
		return "(";
	}

	public String getParamPostOperation() {
		return ")";
	}

	public String getFirstParamPreOperation() {
		return "NOT ";
	}

	public String getMiddleParamPreOperation() {
		return "";
	}

	public String getLastParamPreOperation() {
		return "";
	}

	public String getFirstParamPostOperation() {
		return "";
	}

	public String getMiddleParamPostOperation() {
		return "";
	}

	public String getLastParamPostOperation() {
		return "";
	}

}

package org.liveSense.misc.queryBuilder.operators;

import java.io.Serializable;


public class OrOperator extends AbstractOperator implements Serializable {

	private static final long serialVersionUID = -5401575277269366543L;

	public OrOperator() {
		super();
	}
	
	public OrOperator(Object params) {
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
		return "";
	}

	public String getMiddleParamPreOperation() {
		return "";
	}

	public String getLastParamPreOperation() {
		return "";
	}

	public String getFirstParamPostOperation() {
		return " OR ";
	}

	public String getMiddleParamPostOperation() {
		return " OR ";
	}

	public String getLastParamPostOperation() {
		return "";
	}
	

}

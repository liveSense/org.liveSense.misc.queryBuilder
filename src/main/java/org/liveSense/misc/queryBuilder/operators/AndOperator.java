package org.liveSense.misc.queryBuilder.operators;

import java.io.Serializable;

public class AndOperator extends AbstractOperator implements Serializable {

	private static final long serialVersionUID = -6429259979979372988L;

	public AndOperator() {
		super();
	}
	
	public AndOperator(Object params) {
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
		return " AND ";
	}

	public String getMiddleParamPostOperation() {
		return " AND ";
	}

	public String getLastParamPostOperation() {
		return "";
	}
}

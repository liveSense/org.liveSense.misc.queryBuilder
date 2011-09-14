package org.liveSense.misc.queryBuilder.operators;

import java.io.Serializable;


public class OrOperator<T> extends Operator<T> implements Serializable {

	
	//consts
	private static final long serialVersionUID = -5401575277269366543L;

	
	//constructors
	public OrOperator() {
		super();
	}
	
	public OrOperator(T params) {
		super();
		setParams(params);
	}

	
	//methods
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

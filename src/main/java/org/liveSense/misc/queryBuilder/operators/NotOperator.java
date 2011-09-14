package org.liveSense.misc.queryBuilder.operators;

import java.io.Serializable;


public class NotOperator<T> extends Operator<T> implements Serializable {

	
	//consts
	private static final long serialVersionUID = 1583783660683119788L;

	
	//constructors
	public NotOperator() {
		super();
	}
	
	public NotOperator(T params) {
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

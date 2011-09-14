package org.liveSense.misc.queryBuilder.operators;

import java.io.Serializable;


public class AndOperator<T> extends Operator<T> implements Serializable {

	
	//consts
	private static final long serialVersionUID = -6429259979979372988L;

	
	//constructors
	public AndOperator() {
		super();
	}
	
	public AndOperator(T params) {
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

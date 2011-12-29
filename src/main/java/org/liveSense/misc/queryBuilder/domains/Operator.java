package org.liveSense.misc.queryBuilder.domains;

import java.util.List;



public interface Operator {
	
	public String getParamPreOperation();
	public String getParamPostOperation();
	public String getFirstParamPreOperation();
	public String getMiddleParamPreOperation();
	public String getLastParamPreOperation();
	public String getFirstParamPostOperation();
	public String getMiddleParamPostOperation();
	public String getLastParamPostOperation();
	@SuppressWarnings("rawtypes")
	public Operator addCriteria(Criteria criteria);
	public Operator addOperator(Operator operator);
	@SuppressWarnings("rawtypes")
	public Operator addCriterias(Criteria[] criteria);
	public Operator addOperators(Operator[] operator);
	@SuppressWarnings("rawtypes")
	public Operator addParams(List criteria);
	@SuppressWarnings("rawtypes")
	public List getParams();
	
}

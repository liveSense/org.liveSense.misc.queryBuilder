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
	public Operator addCriteria(Criteria criteria);
	public Operator addOperator(Operator operator);
	public Operator addCriterias(Criteria[] criteria);
	public Operator addOperators(Operator[] operator);
	public Operator addCriterias(List<Criteria> criteria);
	public Operator addOperators(List<Operator> operator);
	public Operator addParams(List<?> params);
	public Operator setCriteria(Criteria criteria);
	public Operator setOperator(Operator operator);
	public Operator setCriterias(Criteria[] criteria);
	public Operator setOperators(Operator[] operator);
	public Operator setCriterias(List<Criteria> criteria);
	public Operator setOperators(List<Operator> operator);
	public Operator setParams(List<?> params);

	public List getParams();
	
}

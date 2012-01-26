package org.liveSense.misc.queryBuilder.domains;

import java.util.List;

import org.liveSense.misc.queryBuilder.criterias.AbstractCriteria;
import org.liveSense.misc.queryBuilder.operators.AndOperator;
import org.liveSense.misc.queryBuilder.operators.NotOperator;
import org.liveSense.misc.queryBuilder.operators.OrOperator;



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
	public void setCriteria(AbstractCriteria criteria);
	public void setOperator(AndOperator operator);
	public void setOperator(OrOperator operator);
	public void setOperator(NotOperator operator);
	public Operator setOperator(Operator operator);
	public Operator setCriterias(Criteria[] criteria);
	public Operator setOperators(Operator[] operator);
	public Operator setCriterias(List<Criteria> criteria);
	public Operator setOperators(List<Operator> operator);
	public Operator setParams(List<?> params);

	public List getParams();
	
}

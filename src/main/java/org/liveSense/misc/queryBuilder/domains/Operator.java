package org.liveSense.misc.queryBuilder.domains;

import java.util.List;

import org.liveSense.misc.queryBuilder.criterias.AbstractCriteria;
import org.liveSense.misc.queryBuilder.operators.AbstractOperator;
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
	public AbstractOperator addCriteria(AbstractCriteria criteria);
	public AbstractOperator addOperator(AbstractOperator operator);
	public AbstractOperator addCriterias(AbstractCriteria[] criteria);
	public AbstractOperator addOperators(AbstractOperator[] operator);
	public AbstractOperator addCriterias(List<AbstractCriteria> criteria);
	public AbstractOperator addOperators(List<AbstractOperator> operator);
	public AbstractOperator addParams(List<?> params);
	public void setCriteria(AbstractCriteria criteria);
	public void setAndOperator(AndOperator operator);
	public void setOrOperator(OrOperator operator);
	public void setNotOperator(NotOperator operator);
	public void setOperator(AbstractOperator operator);
	public AbstractOperator setCriterias(AbstractCriteria[] criteria);
	public AbstractOperator setOperators(AbstractOperator[] operator);
	public void setCriterias(List<AbstractCriteria> criteria);
	public void setOperators(List<AbstractOperator> operator);
	public AbstractOperator setParams(List<?> params);

	public List getParams();
	
}

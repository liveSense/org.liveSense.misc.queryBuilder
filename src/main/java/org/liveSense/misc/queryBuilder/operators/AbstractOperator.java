package org.liveSense.misc.queryBuilder.operators;

import java.util.ArrayList;
import java.util.List;

import org.liveSense.misc.queryBuilder.criterias.AbstractCriteria;
import org.liveSense.misc.queryBuilder.criterias.BetweenCriteria;
import org.liveSense.misc.queryBuilder.criterias.DistinctFromCriteria;
import org.liveSense.misc.queryBuilder.criterias.EqualCriteria;
import org.liveSense.misc.queryBuilder.criterias.GreaterCriteria;
import org.liveSense.misc.queryBuilder.criterias.GreaterOrEqualCriteria;
import org.liveSense.misc.queryBuilder.criterias.InCriteria;
import org.liveSense.misc.queryBuilder.criterias.IsNotNullCriteria;
import org.liveSense.misc.queryBuilder.criterias.IsNullCriteria;
import org.liveSense.misc.queryBuilder.criterias.LessCriteria;
import org.liveSense.misc.queryBuilder.criterias.LessOrEqualCriteria;
import org.liveSense.misc.queryBuilder.criterias.LikeCriteria;
import org.liveSense.misc.queryBuilder.criterias.NotEqualCriteria;
import org.liveSense.misc.queryBuilder.criterias.StartingWithCriteria;
import org.liveSense.misc.queryBuilder.domains.Criteria;
import org.liveSense.misc.queryBuilder.domains.Operator;

public class AbstractOperator implements Operator {

	@SuppressWarnings("rawtypes")
	List params = new ArrayList();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addParamsObject(Object params) {
		if (params == null) return;
		if (params instanceof List) {
			for (Object  o: (List)params) {
				addParamsObject(o);
			}
		} else if (params instanceof Object[]) {
			for (int i = 0; i < ((Object[])params).length; i++) {
				addParamsObject(((Object[])params)[i]);
			}
		} else {
			this.params.add(params);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List getParams() {
		return params;
	}

	public AbstractOperator addCriteria(AbstractCriteria criteria) {
		addParamsObject(criteria);
		return this;
	}

	public AbstractOperator addOperator(AbstractOperator operators) {
		addParamsObject(operators);
		return this;
	}

	public AbstractOperator addOperator(AndOperator operators) {
		addParamsObject(operators);
		return this;
	}
	
	public AbstractOperator addOperator(NotOperator operators) {
		addParamsObject(operators);
		return this;
	}

	public AbstractOperator addOperator(OrOperator operators) {
		addParamsObject(operators);
		return this;
	}

	public AbstractOperator addCriterias(AbstractCriteria[] criteria) {
		addParamsObject(criteria);
		return this;
	}

	public AbstractOperator addOperators(AbstractOperator[] operators) {
		addParamsObject(operators);
		return this;
	}

	public AbstractOperator addCriterias(List<AbstractCriteria> criterias) {
		addParamsObject(params);
		return this;
	}

	public AbstractOperator addOperators(List<AbstractOperator> operators) {
		addParamsObject(params);
		return this;
	}

	public AbstractOperator addParams(List<?> params) {
		addParamsObject(params);
		return this;
	}
	
	@SuppressWarnings("rawtypes")
	public void setCriteria(AbstractCriteria criteria) {
		addParamsObject(criteria);
	}

	public void setBetweenCriteria(BetweenCriteria criteria) {
		addParamsObject(criteria);
	}

	public void setDistinctFromCriteria(DistinctFromCriteria criteria) {
		addParamsObject(criteria);
	}

	public void setEqualCriteria(EqualCriteria criteria) {
		addParamsObject(criteria);
	}

	public void setGreaterCriteria(GreaterCriteria criteria) {
		addParamsObject(criteria);
	}

	public void setGreaterOrEqualCriteria(GreaterOrEqualCriteria criteria) {
		addParamsObject(criteria);
	}

	public void setInCriteria(InCriteria criteria) {
		addParamsObject(criteria);
	}

	public void setIsNotNullCriteria(IsNotNullCriteria criteria) {
		addParamsObject(criteria);
	}

	public void setIsNullCriteria(IsNullCriteria criteria) {
		addParamsObject(criteria);
	}

	public void setLessCriteria(LessCriteria criteria) {
		addParamsObject(criteria);
	}

	public void setLessOrEqualCriteria(LessOrEqualCriteria criteria) {
		addParamsObject(criteria);
	}

	public void setLikeCriteria(LikeCriteria criteria) {
		addParamsObject(criteria);
	}

	public void setNotEqualCriteria(NotEqualCriteria criteria) {
		addParamsObject(criteria);
	}

	public void setStartingWithCriteria(StartingWithCriteria criteria) {
		addParamsObject(criteria);
	}

	@SuppressWarnings("rawtypes")
	public AbstractOperator setOperator(Operator operators) {
		addParamsObject(operators);
		return this;
	}

	@SuppressWarnings("rawtypes")
	public void setAndOperator(AndOperator operators) {
		addParamsObject(operators);
	}

	@SuppressWarnings("rawtypes")
	public void setOperator(AbstractOperator operators) {
		addParamsObject(operators);
	}

	@SuppressWarnings("rawtypes")
	public void setOrOperator(OrOperator operators) {
		addParamsObject(operators);
	}

	@SuppressWarnings("rawtypes")
	public void setNotOperator(NotOperator operators) {
		addParamsObject(operators);
	}

	@SuppressWarnings("rawtypes")
	public AbstractOperator setCriterias(AbstractCriteria[] criteria) {
		addParamsObject(criteria);
		return this;
	}
	
	@SuppressWarnings("rawtypes")
	public AbstractOperator setOperators(AbstractOperator[] operators) {
		addParamsObject(operators);
		return this;
	}

	@SuppressWarnings("rawtypes")
	public void setCriterias(List<AbstractCriteria> criterias) {
		//params = new ArrayList();
		addParamsObject(params);
	}

	@SuppressWarnings("rawtypes")
	public void setOperators(List<AbstractOperator> operators) {
		//params = new ArrayList();
		addParamsObject(params);
	}

	public AbstractOperator setParams(List<?> params) {
		addParamsObject(params);
		return this;
	}

	public String getParamPreOperation() {
		return null;
	}

	public String getParamPostOperation() {
		return null;
	}

	public String getFirstParamPreOperation() {
		return null;
	}

	public String getMiddleParamPreOperation() {
		return null;
	}

	public String getLastParamPreOperation() {
		return null;
	}

	public String getFirstParamPostOperation() {
		return null;
	}

	public String getMiddleParamPostOperation() {
		return null;
	}

	public String getLastParamPostOperation() {
		return null;
	}

	
	// Dummy getters. Theese needed for GWT, to able to
	// create setters - there is no setter without getters
	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public AbstractCriteria getCriteria() {
		return null;
	}

	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public BetweenCriteria getBetweenCriteria() {
		return null;
	}

	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public DistinctFromCriteria getDistinctFromCriteria() {
		return null;
	}

	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public EqualCriteria getEqualCriteria() {
		return null;
	}

	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public GreaterCriteria getGreaterCriteria() {
		return null;
	}

	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public GreaterOrEqualCriteria getGreaterOrEqualCriteria() {
		return null;
	}

	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public InCriteria getInCriteria() {
		return null;
	}

	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated

	public IsNotNullCriteria getIsNotNullCriteria() {
		return null;
	}

	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public IsNullCriteria getIsNullCriteria() {
		return null;
	}

	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public LessCriteria getLessCriteria() {
		return null;
	}

	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public LessOrEqualCriteria getLessOrEqualCriteria() {
		return null;
	}

	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public LikeCriteria getLikeCriteria() {
		return null;
	}

	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public NotEqualCriteria getNotEqualCriteria() {
		return null;
	}

	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public StartingWithCriteria getStartingWithCriteria() {
		return null;
	}

	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public List<AbstractCriteria> getCriterias() {
		for (Object param : params) {
			if (param instanceof Criteria) {
				
			}
		}
		return null;
	}
	
	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public AbstractOperator getOperator() {
		return null;	
	}
	
	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public AndOperator getAndOperator() {
		return null;	
	}
	
	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public OrOperator getOrOperator() {
		return null;	
	}

	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public NotOperator getNotOperator() {
		return null;	
	}

	/**
	 * Use getParams();
	 * @return
	 */
	@Deprecated
	public List<AbstractOperator> getOperators() {
		return null;
	}

}

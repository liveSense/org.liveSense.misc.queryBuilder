package org.liveSense.misc.queryBuilder.operators;

import java.util.ArrayList;
import java.util.List;

import org.liveSense.misc.queryBuilder.criterias.AbstractCriteria;
import org.liveSense.misc.queryBuilder.domains.Criteria;
import org.liveSense.misc.queryBuilder.domains.Operator;

public class AbstractOperator implements Operator {

	@SuppressWarnings("rawtypes")
	List params = new ArrayList();
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addParamsObject(Object params) {
		if (params == null) return;
		if (params instanceof List) {
			this.params.addAll((List)params);
		} else if (params instanceof Object[]) {
			for (int i = 0; i < ((Object[])params).length; i++) {
				this.params.add(((Object[])params)[i]);
			}			
		} else {
			this.params.add(params);
		}
	}

	public void setParams(Object params) {
		this.params.clear();
		addParamsObject(params);
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
		params = new ArrayList();
		addParamsObject(criteria);
	}

	@SuppressWarnings("rawtypes")
	public AbstractOperator setOperator(Operator operators) {
		params = new ArrayList();
		addParamsObject(operators);
		return this;
	}

	@SuppressWarnings("rawtypes")
	public void setOperator(AndOperator operators) {
		params = new ArrayList();
		addParamsObject(operators);
	}

	@SuppressWarnings("rawtypes")
	public void setOperator(AbstractOperator operators) {
		params = new ArrayList();
		addParamsObject(operators);
	}

	@SuppressWarnings("rawtypes")
	public void setOperator(OrOperator operators) {
		params = new ArrayList();
		addParamsObject(operators);
	}

	@SuppressWarnings("rawtypes")
	public void setOperator(NotOperator operators) {
		params = new ArrayList();
		addParamsObject(operators);
	}

	@SuppressWarnings("rawtypes")
	public AbstractOperator setCriterias(AbstractCriteria[] criteria) {
		params = new ArrayList();
		addParamsObject(criteria);
		return this;
	}
	
	@SuppressWarnings("rawtypes")
	public AbstractOperator setOperators(AbstractOperator[] operators) {
		params = new ArrayList();
		addParamsObject(operators);
		return this;
	}

	@SuppressWarnings("rawtypes")
	public void setCriterias(List<AbstractCriteria> criterias) {
		params = new ArrayList();
		addParamsObject(params);
	}

	@SuppressWarnings("rawtypes")
	public void setOperators(List<AbstractOperator> operators) {
		params = new ArrayList();
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

}

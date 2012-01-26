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

	public Operator addCriteria(Criteria criteria) {
		addParamsObject(criteria);
		return this;
	}

	public Operator addOperator(Operator operators) {
		addParamsObject(operators);
		return this;
	}

	public Operator addOperator(AndOperator operators) {
		addParamsObject(operators);
		return this;
	}
	
	public Operator addOperator(NotOperator operators) {
		addParamsObject(operators);
		return this;
	}

	public Operator addOperator(OrOperator operators) {
		addParamsObject(operators);
		return this;
	}

	public Operator addCriterias(Criteria[] criteria) {
		addParamsObject(criteria);
		return this;
	}

	public Operator addOperators(Operator[] operators) {
		addParamsObject(operators);
		return this;
	}

	public Operator addCriterias(List<Criteria> criterias) {
		addParamsObject(params);
		return this;
	}

	public Operator addOperators(List<Operator> operators) {
		addParamsObject(params);
		return this;
	}

	public Operator addParams(List<?> params) {
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
	public Operator setCriterias(Criteria[] criteria) {
		params = new ArrayList();
		addParamsObject(criteria);
		return this;
	}
	
	@SuppressWarnings("rawtypes")
	public Operator setOperators(Operator[] operators) {
		params = new ArrayList();
		addParamsObject(operators);
		return this;
	}

	@SuppressWarnings("rawtypes")
	public Operator setCriterias(List<Criteria> criterias) {
		params = new ArrayList();
		addParamsObject(params);
		return this;
	}

	@SuppressWarnings("rawtypes")
	public Operator setOperators(List<Operator> operators) {
		params = new ArrayList();
		addParamsObject(params);
		return this;
	}

	public Operator setParams(List<?> params) {
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

package org.liveSense.misc.queryBuilder.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.liveSense.misc.queryBuilder.domains.Criteria;
import org.liveSense.misc.queryBuilder.domains.Operator;

public abstract class AbstractOperator implements Operator {

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
	public Operator setCriteria(Criteria criteria) {
		params = new ArrayList();
		addParamsObject(criteria);
		return this;
	}

	@SuppressWarnings("rawtypes")
	public Operator setOperator(Operator operators) {
		params = new ArrayList();
		addParamsObject(operators);
		return this;
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

}

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
	public void addParams(Object params) {
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
		addParams(params);
	}

	@SuppressWarnings("rawtypes")
	public List getParams() {
		return params;
	}

	@SuppressWarnings({ "rawtypes" })
	public Operator addCriteria(Criteria criteria) {
		addParams(criteria);
		return this;
	}

	public Operator addOperator(Operator operators) {
		addParams(operators);
		return this;
	}

	@SuppressWarnings({ "rawtypes" })
	public Operator addCriterias(Criteria[] criteria) {
		addParams(criteria);
		return this;
	}

	public Operator addOperators(Operator[] operators) {
		addParams(operators);
		return this;
	}

	@SuppressWarnings({ "rawtypes" })
	public Operator addParams(List params) {
		addParams(params);
		return this;
	}

	
}

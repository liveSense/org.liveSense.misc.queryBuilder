package org.liveSense.misc.queryBuilder.operators;

import java.util.List;

import org.liveSense.misc.queryBuilder.criterias.Criteria;
import org.liveSense.misc.queryBuilder.exception.QueryBuilderException;
import org.liveSense.misc.queryBuilder.querybuilder.QueryBuilder;


public abstract class Operator {

	enum Position {FIRST, LAST, MIDDLE};
	
	Object params;

	public abstract String getParamPreOperation();
	public abstract String getParamPostOperation();
	public abstract String getFirstParamPreOperation();
	public abstract String getMiddleParamPreOperation();
	public abstract String getLastParamPreOperation();
	public abstract String getFirstParamPostOperation();
	public abstract String getMiddleParamPostOperation();
	public abstract String getLastParamPostOperation();
	

	@SuppressWarnings("rawtypes")
	private String processCriteria(QueryBuilder builder, Object params, Position pos) throws QueryBuilderException {
	    String clause = "";
	    if (params instanceof Operator) {
			clause += ((Operator)params).process(builder);
		} else if (params instanceof Criteria) {
			clause += ((Criteria)params).process();
		} else {
			throw new QueryBuilderException("Parameter data is incompatible. (Operator or Criteria required)");
		}
		return clause;
	}

	
	public String process(QueryBuilder builder) throws QueryBuilderException {
		String ret = "";
		if (params == null) return "";
		

		if (params instanceof List<?>) {
			ret = getParamPreOperation();
			if (((List<?>) params).size() == 0) {
				ret = "";
			} else if (((List<?>)params).size() == 1) {
				ret = getParamPreOperation()+getFirstParamPreOperation()+processCriteria(builder, ((List<?>)params).get(0), Position.MIDDLE)+getLastParamPostOperation()+getParamPostOperation();
			} else {
				for (int i=0; i<((List<?>)params).size(); i++) {
					if (i == 0) {
						ret = getParamPreOperation()+getFirstParamPreOperation()+processCriteria(builder, ((List<?>)params).get(i), Position.FIRST)+getFirstParamPostOperation();
					} else if (i == ((List<?>)params).size()-1) {
						ret += getLastParamPostOperation()+processCriteria(builder, ((List<?>)params).get(i), Position.LAST)+getLastParamPostOperation()+getParamPostOperation();
					} else {
						ret += getMiddleParamPreOperation()+processCriteria(builder, ((List<?>)params).get(i), Position.MIDDLE)+getMiddleParamPostOperation();		
					}
				}		
			}
		} else if (params instanceof Object[]) {
			if (((Object[]) params).length == 0) { 
				ret = "";
			} else if (((Object[])params).length == 1) {
				ret = getParamPreOperation()+getFirstParamPreOperation()+processCriteria(builder, ((Object[])params)[0], Position.MIDDLE)+getLastParamPostOperation()+getParamPostOperation();
			} else {
				for (int i=0; i<((Object[])params).length; i++) {
					if (i == 0) {
						ret = getParamPreOperation()+getFirstParamPreOperation()+processCriteria(builder, ((Object[])params)[i], Position.FIRST)+getFirstParamPostOperation();
					} else if (i == ((Object[])params).length-1) {
						ret += getLastParamPostOperation()+processCriteria(builder, ((Object[])params)[i], Position.LAST)+getLastParamPostOperation()+getParamPostOperation();
					} else {
						ret += getMiddleParamPreOperation()+processCriteria(builder, ((Object[])params)[i], Position.MIDDLE)+getMiddleParamPostOperation();		
					}
				}
			}
		} else if (params instanceof Object) {
			ret = getParamPreOperation() + getFirstParamPreOperation()+processCriteria(builder, params, Position.MIDDLE)+getLastParamPostOperation()+getParamPostOperation();
		} 
		return ret;
	}
    

}

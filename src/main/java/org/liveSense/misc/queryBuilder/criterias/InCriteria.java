package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.liveSense.misc.queryBuilder.beans.Value;
import org.liveSense.misc.queryBuilder.domains.Criteria;
import org.liveSense.misc.queryBuilder.domains.Operand;

public class InCriteria extends AbstractCriteria implements Serializable, Criteria {
	private static final long serialVersionUID = 1442158199666534479L;

	private List<Value> values;
	
	public InCriteria() {
		super();
	}
	
	public InCriteria(String fieldName, List<?> values) {
		this(null, "", fieldName, values);
	}

	public InCriteria(String alias, String fieldName, List<?> values) {
		this(null, alias, fieldName, values);
	}

	public InCriteria(Operand operand, String alias, String fieldName, List<?> values) {
		super(alias, fieldName);
		this.values = new ArrayList<Value>();
		if (values != null) {
			for (Object o : values) {
				if (!(o instanceof Value)) {
					this.values.add(new Value(o));
				} else {
					this.values.add((Value)o);
				}
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public InCriteria(Operand operand, String alias, String fieldName, Value[] values) {
		this(operand, "", fieldName, (List)null);
		this.values = new ArrayList<Value>();
		for (int i = 0; i < values.length; i++) {
			this.values.add(values[i]);
		}
	}

	@SuppressWarnings("rawtypes")
	public InCriteria(Operand operand, String alias, String fieldName, Object[] values) {
		this(operand, alias, fieldName, (List)null);
		this.values = new ArrayList<Value>();
		for (int i = 0; i < values.length; i++) {
			if (values[i] instanceof Value) {
				this.values.add((Value)values[i]);
			} else {
				this.values.add(new Value(values[i]));
			}
		}
	}

	public InCriteria(String fieldName, Value[] values) {
		this(null, "", fieldName, values);
	}

	public InCriteria(String alias, String fieldName, Value[] values) {
		this(null, alias, fieldName, values);
	}
	
	public InCriteria(Operand operand, List<?> values){
		this(operand, "", null, values);
	}
	
	public InCriteria(Operand operand, Value[] values){
		this(operand, "", null, values);
	}	

//
	public InCriteria(String fieldName, Object[] values) {
		this("", fieldName, values);
	}
	
	public InCriteria(String alias, String fieldName, Object[] values) {
		this(null, alias, fieldName, values);
	}
	
	public InCriteria(Operand operand, Object[] values){
		this(operand, "", null, values);		
	}	

	
	public List<Value> getValues() {
		return values;
	}

	public void setValues(List<Value> values) {
		this.values = values;
	}

	public String getQueryTemplate() {
		return "$field$ IN ($values$)";
	}

}

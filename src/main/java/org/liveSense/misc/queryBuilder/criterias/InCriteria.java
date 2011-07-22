package org.liveSense.misc.queryBuilder.criterias;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operands.OperandSource;

public class InCriteria<K> extends Criteria<K> implements Serializable {
	private List<K> values;
	
	public InCriteria() {
		super();
	}
	
	public InCriteria(String fieldName, List<K> values) {
		this("", fieldName, values);
	}
	
	public InCriteria(String alias, String fieldName, List<K> values) {
		super(alias, fieldName);
		this.values = values;
	}
	
	public InCriteria(String fieldName, K[] values) {
		this("", fieldName, Arrays.asList(values));
	}
	
	public InCriteria(String alias, String fieldName, K[] values) {
		this(alias, fieldName, Arrays.asList(values));
	}
	
	public InCriteria(OperandSource operand, List<K> values){
		super(operand);
		this.values = values;		
	}
	
	public InCriteria(OperandSource operand, K[]values){
		this(operand, Arrays.asList(values));		
	}	
	

	public List<K> getValues() {
		return values;
	}

	
	public void setValues(List<K> values) {
		this.values = values;
	}

	
	@Override
	public String getQueryTemplate() throws QueryBuilderException {
		return "$field$ IN ($values$)";
	}

}

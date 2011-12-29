package org.liveSense.misc.queryBuilder.operands;

import org.liveSense.misc.queryBuilder.beans.Value;

public class DefaultOperand extends AbstractOperand {
	public DefaultOperand() {
		
	}
	
	public DefaultOperand(Value source){
		this("", source);		
	}
	
	public DefaultOperand(String qualifier, Value source){
		this(qualifier, source, true);		
	}
	
	public DefaultOperand(String qualifier, Value source, boolean literal){
		this(qualifier, source, literal, "");
	}
	
	public DefaultOperand(String qualifier, Value source, boolean literal, String function){
		this.qualifier = qualifier;
		this.source = source;
		this.literal = literal;
		this.function = function;
	}	

	public DefaultOperand(Object source){
		this("", new Value(source));		
	}
	
	public DefaultOperand(String qualifier, Object source){
		this(qualifier, new Value(source), true);		
	}
	
	public DefaultOperand(String qualifier, Object source, boolean literal){
		this(qualifier, new Value(source), literal, "");
	}
	
	public DefaultOperand(String qualifier, Object source, boolean literal, String function){
		this(qualifier, new Value(source), literal, function);
	}	
	
	
	

}

package org.liveSense.misc.queryBuilder.operands;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.beans.Value;


public class UpperOperand
	extends AbstractOperand implements Serializable {

	public UpperOperand() {
		super();
	}
	
	public UpperOperand(Value source){
		this("", source);		
	}
	
	public UpperOperand(String qualifier, Value source){
		this(qualifier, source, true);		
	}
	
	public UpperOperand(String qualifier, Value source, boolean literal){
		this(qualifier, source, literal, "UPPER");
	}
	
	private UpperOperand(String qualifier, Value source, boolean literal, String function){
		super(qualifier, source, literal, function);
	}	

	public UpperOperand(Object source){
		this("", new Value(source));		
	}
	
	public UpperOperand(String qualifier, Object source){
		this(qualifier, new Value(source), true);		
	}
	
	public UpperOperand(String qualifier, Object source, boolean literal){
		this(qualifier, new Value(source), literal, "UPPER");
	}
	
	private UpperOperand(String qualifier, Object source, boolean literal, String function){
		this(qualifier, new Value(source), literal, "UPPER");
	}	

	
}

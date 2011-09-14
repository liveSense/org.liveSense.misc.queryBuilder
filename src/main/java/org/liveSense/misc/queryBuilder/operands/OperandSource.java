package org.liveSense.misc.queryBuilder.operands;

import java.io.Serializable;


public class OperandSource implements Serializable {		
	private String qualifier;
	private Object source;
	private boolean literal = true;
	private String function;
	
	public OperandSource() {
		
	}
	
	public OperandSource(Object source){
		this("", source);		
	}
	
	public OperandSource(String qualifier, Object source){
		this(qualifier, source, true);		
	}
	
	public OperandSource(String qualifier, Object source, boolean literal){
		this(qualifier, source, literal, "");
	}
	
	public OperandSource(String qualifier, Object source, boolean literal, String function){
		this.qualifier = qualifier;
		this.source = source;
		this.literal = literal;
		this.function = function;
	}	

	
	public String getQualifier() {	
		return qualifier;
	}
	
	public Object getSource() {	
		return source;
	}
		
	public boolean isLiteral() {
		return literal;
	}

	public String getFunction() {
		return function;
	}

	
	
	
	
	
}
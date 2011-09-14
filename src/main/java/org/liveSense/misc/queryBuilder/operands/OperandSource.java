package org.liveSense.misc.queryBuilder.operands;

import java.io.Serializable;


public class OperandSource<T> implements Serializable {
	
	
	//consts
	private static final long serialVersionUID = -3177822162121106408L;
	
	
	//fields
	private String qualifier;
	private T source;
	private boolean literal = true;
	private String function;
	
	
	//constructors
	public OperandSource() {
		
	}
	
	public OperandSource(T source){
		this("", source);		
	}
	
	public OperandSource(String qualifier, T source){
		this(qualifier, source, true);		
	}
	
	public OperandSource(String qualifier, T source, boolean literal){
		this(qualifier, source, literal, "");
	}
	
	protected OperandSource(String qualifier, T source, boolean literal, String function){
		this.qualifier = qualifier;
		this.source = source;
		this.literal = literal;
		this.function = function;
	}	

	
	//getters and setters
	public String getQualifier() {	
		return qualifier;
	}
	
	public T getSource() {	
		return source;
	}
		
	public boolean isLiteral() {
		return literal;
	}

	public String getFunction() {
		return function;
	}

	
	
	
	
	
}
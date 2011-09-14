package org.liveSense.misc.queryBuilder.operands;

import java.io.Serializable;


public class UpperOperand<T>
	extends OperandSource<T> implements Serializable {

	
	//consts
	private static final long serialVersionUID = 2476134233104762643L;
	

	//constructors
	public UpperOperand() {
		super();
	}
	
	public UpperOperand(T source){
		this("", source);		
	}
	
	public UpperOperand(String qualifier, T source){
		this(qualifier, source, true);		
	}
	
	public UpperOperand(String qualifier, T source, boolean literal){
		super(qualifier, source, literal, "UPPER");
	}
}

package org.liveSense.misc.queryBuilder.operands;

import java.io.Serializable;


public class UpperOperand
	extends OperandSource implements Serializable {

	public UpperOperand() {
		super();
	}
	
	public UpperOperand(Object source){
		this("", source);		
	}
	
	public UpperOperand(String qualifier, Object source){
		this(qualifier, source, true);		
	}
	
	public UpperOperand(String qualifier, Object source, boolean literal){
		this(qualifier, source, literal, "UPPER");
	}
	
	private UpperOperand(String qualifier, Object source, boolean literal, String function){
		super(qualifier, source, literal, function);
	}	

}

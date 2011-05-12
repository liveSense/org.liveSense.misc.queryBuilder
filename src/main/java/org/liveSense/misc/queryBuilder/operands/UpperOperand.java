package org.liveSense.misc.queryBuilder.operands;

import java.lang.reflect.InvocationTargetException;

public class UpperOperand extends OperandSource{

	
	public UpperOperand(String source) {
		super(source);		
	}
	
	public UpperOperand(String qualifier, String source){
		super(qualifier, source);		
	}	
	
	public UpperOperand(String qualifier, String source, boolean asIs){
		super(qualifier, source, asIs);		
	}	
	
	@SuppressWarnings("rawtypes")
	@Override
	public String getSourceDefinition(Class clazz) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		return "UPPER(" + super.getSourceDefinition(clazz)+ ")";		
	}	

}

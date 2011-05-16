package org.liveSense.misc.queryBuilder.operands;

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
	public String getSourceDefinition(Class clazz) throws Exception {
		return "UPPER(" + super.getSourceDefinition(clazz)+ ")";		
	}	

}

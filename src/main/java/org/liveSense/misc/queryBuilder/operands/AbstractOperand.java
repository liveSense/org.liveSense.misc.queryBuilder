package org.liveSense.misc.queryBuilder.operands;

import java.io.Serializable;

import org.liveSense.misc.queryBuilder.beans.Value;
import org.liveSense.misc.queryBuilder.domains.Operand;


public class AbstractOperand implements Operand, Serializable {		
	private static final long serialVersionUID = 8670026103430577990L;
	protected String qualifier;
	protected Value source;
	protected boolean literal = true;
	protected String function;
	
	public AbstractOperand() {
		
	}
	
	public AbstractOperand(Value source){
		this("", source);		
	}
	
	public AbstractOperand(String qualifier, Value source){
		this(qualifier, source, true);		
	}
	
	public AbstractOperand(String qualifier, Value source, boolean literal){
		this(qualifier, source, literal, "");
	}
	
	public AbstractOperand(String qualifier, Value source, boolean literal, String function){
		this.qualifier = qualifier;
		this.source = source;
		this.literal = literal;
		this.function = function;
	}	

	
	public String getQualifier() {	
		return qualifier;
	}
	
	public Value getSource() {	
		return source;
	}
		
	public boolean isLiteral() {
		return literal;
	}

	public String getFunction() {
		return function;
	}

	public void setSource(Object source) {
		this.source = new Value(source);
	}
	
	public void setSource(Value source) {
		this.source = source;
	}

	/**
	 * @param qualifier the qualifier to set
	 */
	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}

	/**
	 * @param literal the literal to set
	 */
	public void setLiteral(boolean literal) {
		this.literal = literal;
	}

	/**
	 * @param function the function to set
	 */
	public void setFunction(String function) {
		this.function = function;
	}
}
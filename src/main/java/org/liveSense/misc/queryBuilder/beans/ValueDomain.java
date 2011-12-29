package org.liveSense.misc.queryBuilder.beans;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public interface ValueDomain  {		

	public enum ValueTypes{Unknown, None, String, Boolean, Integer, Long, Double, Float, Date, Enum, BigInteger, BigDecimal};
	
	public void setValue(String source);

	public void setValue(Boolean source);

	public void setValue(Integer source);

	public void setValue(Long source);

	public void setValue(Double source);

	public void setValue(Float source);

	public void setValue(Date source);

	public void setValue(Enum<?> source);

	public void setValue(BigInteger source);

	public void setValue(BigDecimal source);

	public ValueTypes getType();
	
	public String getValueAsString();

	public Boolean getValueAsBoolean();
	
	public Integer getValueAsInteger();
	
	public Long getValueAsLong();
	
	public Double getValueAsDouble();
	
	public Float getValueAsFloat();
	
	public Date getValueAsDate();
	
	public Enum getValueAsEnum();
	
	public BigInteger getValueAsBigInteger();
	
	public BigDecimal getValueAsBigDecimal();


	
}
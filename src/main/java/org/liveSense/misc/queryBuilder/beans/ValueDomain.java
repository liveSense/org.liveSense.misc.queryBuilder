package org.liveSense.misc.queryBuilder.beans;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface ValueDomain  {		

	public enum ValueTypes{Unknown, None, String, Boolean, Integer, Long, Double, Float, Date, BigInteger, BigDecimal, List};
	
	public void setValue(String source);

	public void setValue(Boolean source);

	public void setValue(Integer source);

	public void setValue(Long source);

	public void setValue(Double source);

	public void setValue(Float source);

	public void setValue(Date source);

	public void setValue(BigInteger source);

	public void setValue(BigDecimal source);

	public void setValue(Object source);

	public void setValue(@SuppressWarnings("rawtypes") List source);

	public void setValueAsString(String source);

	public void setValueAsBoolean(Boolean source);

	public void setValueAsInteger(Integer source);

	public void setValueAsLong(Long source);

	public void setValueAsDouble(Double source);

	public void setValueAsFloat(Float source);

	public void setValueAsDate(Date source);

	public void setValueAsBigInteger(BigInteger source);

	public void setValueAsBigDecimal(BigDecimal source);

	public void setValueAsObject(Object source);

	public void setValueAsList(@SuppressWarnings("rawtypes") List<Value> source);

	public ValueTypes getType();
	
	public String getValueAsString();

	public Boolean getValueAsBoolean();
	
	public Integer getValueAsInteger();
	
	public Long getValueAsLong();
	
	public Double getValueAsDouble();
	
	public Float getValueAsFloat();
	
	public Date getValueAsDate();
	
	public BigInteger getValueAsBigInteger();
	
	public BigDecimal getValueAsBigDecimal();

	public List<Value> getValueAsList();

	public Object getValue();
	
}
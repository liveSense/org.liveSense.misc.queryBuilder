package org.liveSense.misc.queryBuilder.beans;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;


public class Value implements ValueDomain {

	Object value;

	private void setObjectValue(Object value) {
		this.value = value;
	}

	public Value(Object value) {
		setObjectValue(value);
	}

	public Value(String value) {
		setObjectValue(value);
	}

	public Value(Boolean value) {
		setObjectValue(value);
	}

	public Value(Integer value) {
		setObjectValue(value);
	}

	public Value(Long value) {
		setObjectValue(value);
	}

	public Value(Double value) {
		setObjectValue(value);
	}

	public Value(Float value) {
		setObjectValue(value);
	}

	public Value(Date value) {
		setObjectValue(value);
	}

	public Value(Enum<?> value) {
		setObjectValue(value);
	}

	public Value(BigInteger value) {
		setObjectValue(value);
	}

	public Value(BigDecimal value) {
		setObjectValue(value);
	}
	
	public void setValue(String value) {
		setObjectValue(value);
	}

	public void setValue(Boolean value) {
		setObjectValue(value);
	}

	public void setValue(Integer value) {
		setObjectValue(value);
	}

	public void setValue(Long value) {
		setObjectValue(value);
	}

	public void setValue(Double value) {
		setObjectValue(value);
	}

	public void setValue(Float value) {
		setObjectValue(value);
	}

	public void setValue(Date value) {
		setObjectValue(value);
	}

	public void setValue(Enum<?> value) {
		setObjectValue(value);
	}

	public void setValue(BigInteger value) {
		setObjectValue(value);
	}

	public void setValue(BigDecimal value) {
		setObjectValue(value);
	}

	public String getValueAsString() {
		if (getType() == ValueTypes.String) return (String)value; else return null;
	}

	public Boolean getValueAsBoolean() {
		if (getType() == ValueTypes.Boolean) return (Boolean)value; else return null;
	}

	public Integer getValueAsInteger() {
		if (getType() == ValueTypes.Integer) return (Integer)value; else return null;
	}

	public Long getValueAsLong() {
		if (getType() == ValueTypes.Long) return (Long)value; else return null;
	}

	public Double getValueAsDouble() {
		if (getType() == ValueTypes.Double) return (Double)value; else return null;
	}

	public Float getValueAsFloat() {
		if (getType() == ValueTypes.Float) return (Float)value; else return null;
	}

	public Date getValueAsDate() {
		if (getType() == ValueTypes.Date) return (Date)value; else return null;
	}

	public Enum getValueAsEnum() {
		if (getType() == ValueTypes.Enum) return (Enum)value; else return null;
	}

	public BigInteger getValueAsBigInteger() {
		if (getType() == ValueTypes.BigInteger) return (BigInteger)value; else return null;
	}

	public BigDecimal getValueAsBigDecimal() {
		if (getType() == ValueTypes.BigDecimal) return (BigDecimal)value; else return null;
	}

	public Object getValueAsObject() {
		return value;
	}

	public ValueTypes getType() {
		if (value == null) {
			return ValueTypes.None;
		} else {
			if (value instanceof Date) {
				return ValueTypes.Date;
			} else if (value instanceof BigDecimal) {
				return ValueTypes.BigDecimal;
			} else if (value instanceof BigInteger) {
				return ValueTypes.BigInteger;
			} else if (value instanceof Boolean) {
				return ValueTypes.Boolean;
			} else if (value instanceof Double) {
				return ValueTypes.Double;
			} else if (value instanceof Enum) {
				return ValueTypes.Enum;
			} else if (value instanceof Float) {
				return ValueTypes.Float;
			} else if (value instanceof Integer) {
				return ValueTypes.Integer;
			} else if (value instanceof Long) {
				return ValueTypes.Long;
			} else if (value instanceof String) {
				return ValueTypes.String;
			} else {
				return ValueTypes.Unknown;			
			}
		}
	}

}

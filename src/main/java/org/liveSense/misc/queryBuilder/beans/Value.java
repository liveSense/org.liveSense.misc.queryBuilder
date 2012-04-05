package org.liveSense.misc.queryBuilder.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class Value implements ValueDomain, Serializable {
	private static final long serialVersionUID = -3184057249131641791L;

	Class type;
	Object value;
	
	public Value() {
	}

	private void setObjectValue(Object value) {
		if (value != null) { 
			type = value.getClass();
			this.value = value;
		}
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

	public void setValue(Object value) {
		setObjectValue(value);
	}

	public void setValue(BigInteger value) {
		setObjectValue(value);
	}

	public void setValue(BigDecimal value) {
		setObjectValue(value);
	}

	public void setValueAsString(String value) {
		setObjectValue(value);
	}

	public void setValueAsBoolean(Boolean value) {
		setObjectValue(value);
	}

	public void setValueAsInteger(Integer value) {
		setObjectValue(value);
	}

	public void setValueAsLong(Long value) {
		setObjectValue(value);
	}

	public void setValueAsDouble(Double value) {
		setObjectValue(value);
	}

	public void setValueAsFloat(Float value) {
		setObjectValue(value);
	}

	public void setValueAsDate(Date value) {
		setObjectValue(value);
	}

	public void setValueAsBigInteger(BigInteger value) {
		setObjectValue(value);
	}

	public void setValueAsBigDecimal(BigDecimal value) {
		setObjectValue(value);
	}

	public void setValue(List value) {
		setObjectValue(value);
	}

	public void setValueAsObject(Object value) {
		setObjectValue(value);
	}

	public void setValueAsList(List<Value> value) {
		setObjectValue(value);
	}

	public Object getValue() {
		return getValueAsObject(); 
	}

	public String getValueAsString() {
		if (getType() == ValueTypes.String) return (String)getValueAsObject(); else return null;
	}

	public Boolean getValueAsBoolean() {
		if (getType() == ValueTypes.Boolean) return (Boolean)getValueAsObject(); else return null;
	}

	public Integer getValueAsInteger() {
		if (getType() == ValueTypes.Integer) return (Integer)getValueAsObject(); else return null;
	}

	public Long getValueAsLong() {
		if (getType() == ValueTypes.Long) return (Long)getValueAsObject(); else return null;
	}

	public Double getValueAsDouble() {
		if (getType() == ValueTypes.Double) return (Double)getValueAsObject(); else return null;
	}

	public Float getValueAsFloat() {
		if (getType() == ValueTypes.Float) return (Float)getValueAsObject(); else return null;
	}

	public Date getValueAsDate() {
		if (getType() == ValueTypes.Date) return (Date)getValueAsObject(); else return null;
	}

	public BigInteger getValueAsBigInteger() {
		if (getType() == ValueTypes.BigInteger) return (BigInteger)getValueAsObject(); else return null;
	}

	public BigDecimal getValueAsBigDecimal() {
		if (getType() == ValueTypes.BigDecimal) return (BigDecimal)getValueAsObject(); else return null;
	}

	public List<Value> getValueAsList() {
		if (getType() == ValueTypes.List) return (List<Value>)getValueAsObject(); else return null;
	}

	public Object getValueAsObject() {
		return value;
	}

	public void setType(ValueTypes type) {
	}
	
	public ValueTypes getType() {
		if (value == null) {
			return ValueTypes.None;
		} else {
			if (value instanceof Value)
				value = ((Value) value).getValueAsObject();
			
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
			} else if (value instanceof Float) {
				return ValueTypes.Float;
			} else if (value instanceof Integer) {
				return ValueTypes.Integer;
			} else if (value instanceof Long) {
				return ValueTypes.Long;
			} else if (value instanceof String) {
				return ValueTypes.String;
			} else if (value instanceof List) {
				return ValueTypes.List;
			} else {
				return ValueTypes.Unknown;			
			}
		}
	}
}

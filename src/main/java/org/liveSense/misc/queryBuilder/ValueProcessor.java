package org.liveSense.misc.queryBuilder;

import org.liveSense.misc.queryBuilder.beans.Value;
import org.liveSense.misc.queryBuilder.beans.ValueDomain;
import org.liveSense.misc.queryBuilder.beans.ValueDomain.ValueTypes;

public class ValueProcessor {

	public static Object processValue(ValueDomain value) {
		if (value.getType() == ValueTypes.Integer) return value.getValueAsInteger();
		else if (value.getType() == ValueTypes.Long) return value.getValueAsLong();
		else if (value.getType() == ValueTypes.String) return value.getValueAsString();
		else if (value.getType() == ValueTypes.Boolean) return value.getValueAsBoolean();
		else if (value.getType() == ValueTypes.Date) return value.getValueAsDate();
		else if (value.getType() == ValueTypes.Double) return value.getValueAsDouble();
		else if (value.getType() == ValueTypes.BigDecimal) return value.getValueAsBigDecimal();
		else if (value.getType() == ValueTypes.BigInteger) return value.getValueAsBigInteger();
		else if (value.getType() == ValueTypes.Float) return value.getValueAsFloat();
		else return ((Value)value).getValueAsObject();
	}

}

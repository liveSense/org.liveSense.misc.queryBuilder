package org.liveSense.misc.queryBuilder;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.Id;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.liveSense.core.BaseAnnotationHelper;
import org.liveSense.misc.queryBuilder.beans.Value;
import org.liveSense.misc.queryBuilder.domains.Operand;
import org.liveSense.misc.queryBuilder.jdbcDriver.JdbcDrivers;


public class ObjectToSQLLiteral {

	
	private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy.MM.dd");
	private static final DecimalFormat decimalFormatter = new DecimalFormat("#.###############");
	
	
	static {
		DecimalFormatSymbols dfs = decimalFormatter.getDecimalFormatSymbols();			
		dfs.setDecimalSeparator('.');
		decimalFormatter.setDecimalFormatSymbols(dfs);		
	}	

	
	private Object obj;
	private ToSQLStringEvent toSQLSqlStringEvent = null;
	
	
	public ObjectToSQLLiteral(Object obj) {
		this.obj = obj;
	}
	
	public ObjectToSQLLiteral(Object obj, ToSQLStringEvent toSQLSqlStringEvent) {
		this.obj = obj;
		this.toSQLSqlStringEvent = toSQLSqlStringEvent;
	}
	
	
	@SuppressWarnings("rawtypes")
	public String getLiteral() throws Exception {
		String s = "'";
		
		if (toSQLSqlStringEvent != null) {
			StringBuilder sb = new StringBuilder();
			if  (toSQLSqlStringEvent.toSQLString(this.obj, sb)) {
				return sb.toString();
			}
		}
		
		if (obj == null) 
			return "NULL";		
		else if (obj instanceof Value)
			return new ObjectToSQLLiteral(ValueProcessor.processValue((Value)obj)).getLiteral();
		else if (obj instanceof String) 
			return s + ((String)obj).replace("'", "''") + s;
		else if (obj instanceof Number) 
			return decimalFormatter.format((Number)obj);
		else if (obj instanceof java.sql.Date) 
			return s + dateFormatter.format((java.sql.Date)obj) + s;
		else if (obj instanceof java.util.Date) 
			return s + dateFormatter.format((java.util.Date)obj) + s;
		else if (obj instanceof Operand) {
			if (((Operand)obj).isLiteral()) {
				return OperandProcessor.getOperandSource( ((Operand)obj), null);
			}
		} 
		else if (obj instanceof Object[]) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < ((Object[])obj).length; i++) {
				Object obj2 = ((Object[])obj)[i];
				if (i!=0) sb.append(",");
				sb.append(new ObjectToSQLLiteral(obj2).getLiteral());
			}
			return sb.toString();
		}
		else if (obj instanceof List) {
			boolean first = true;
			StringBuffer sb = new StringBuffer();
			for (Object obj2 : (List)obj) {
				if (first) first = false; else sb.append(",");
				sb.append(new ObjectToSQLLiteral(obj2).getLiteral());
			}
			return sb.toString();
		}
		else {		
			Field fld = BaseAnnotationHelper.findFieldByAnnotationClass(obj.getClass(), Id.class);
			if (fld != null)
				return new ObjectToSQLLiteral(BeanUtilsBean.getInstance().getPropertyUtils().getNestedProperty(obj, fld.getName())).getLiteral();
			else
				return obj.toString();
		}
		
		return null;
	}	
}

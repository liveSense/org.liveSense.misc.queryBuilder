package org.liveSense.misc.queryBuilder;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.liveSense.misc.queryBuilder.operands.OperandSource;
import org.liveSense.misc.queryBuilder.operands.UpperOperand;

import static org.junit.Assert.assertTrue;


public class ObjectToSQLLiteralTest {
	
	
	public class Obj {
		private String fld;
		public String getFld() {return fld;}
		public void setFld(String fld) {this.fld = fld;}
	}
	

	@Test
	public void NullLiteral() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		assertTrue(new ObjectToSQLLiteral(null).getLiteral().equals("NULL"));		
	}
	
	@Test
	public void StringLiteral() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		assertTrue(new ObjectToSQLLiteral("Homer").getLiteral().equals("'Homer'"));		
		assertTrue(new ObjectToSQLLiteral("D'oh!").getLiteral().equals("'D''oh!'"));
	}
	
	@Test
	public void IntegerLiteral() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		assertTrue(new ObjectToSQLLiteral(10).getLiteral().equals("10"));		
		assertTrue(new ObjectToSQLLiteral(-10).getLiteral().equals("-10"));
	}	
	
	@Test
	public void RealLiteral() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {		
		assertTrue(new ObjectToSQLLiteral(0.00001).getLiteral().equals("0.00001"));
		assertTrue(new ObjectToSQLLiteral(-0.00001).getLiteral().equals("-0.00001"));
		assertTrue(new ObjectToSQLLiteral(1000000000.01).getLiteral().equals("1000000000.01"));
		assertTrue(new ObjectToSQLLiteral(-1000000000.01).getLiteral().equals("-1000000000.01"));
	}
	
	@Test
	public void DateLiteral() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, ParseException {
		assertTrue(new ObjectToSQLLiteral(new SimpleDateFormat("yyyy/MM/dd").parse("2011/05/12")).getLiteral().equals("'2011.05.12'"));		
		assertTrue(new ObjectToSQLLiteral(java.sql.Date.valueOf("2011-05-12")).getLiteral().equals("'2011.05.12'"));		
	}
	
	@Test
	public void OperandSourceLiteral() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, ParseException {
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", "Homer", true)).getLiteral().equals("'Homer'"));
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", "Homer", false)).getLiteral() == null);
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", "D'oh!", true)).getLiteral().equals("'D''oh!'"));
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", "D'oh!", false)).getLiteral() == null);
		
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", 10, true)).getLiteral().equals("10"));
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", -10, true)).getLiteral().equals("-10"));
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", 10, false)).getLiteral() == null);
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", -10, false)).getLiteral() == null);
		
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", 0.00001, true)).getLiteral().equals("0.00001"));
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", -0.00001, true)).getLiteral().equals("-0.00001"));
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", 0.00001, false)).getLiteral() == null);
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", -0.00001, false)).getLiteral() == null);
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", 1000000000.01, true)).getLiteral().equals("1000000000.01"));
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", -1000000000.01, true)).getLiteral().equals("-1000000000.01"));
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", 1000000000.01, false)).getLiteral() == null);
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", -1000000000.01, false)).getLiteral() == null);
		
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", new SimpleDateFormat("yyyy/MM/dd").parse("2011/05/12"), true)).getLiteral().equals("'2011.05.12'"));
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", new SimpleDateFormat("yyyy/MM/dd").parse("2011/05/12"), false)).getLiteral() == null);		
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", java.sql.Date.valueOf("2011-05-12"), true)).getLiteral().equals("'2011.05.12'"));
		assertTrue(new ObjectToSQLLiteral(new OperandSource("", java.sql.Date.valueOf("2011-05-12"), false)).getLiteral() == null);
	}
	
	@Test
	public void OperandSourceFeatureLiteral() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, ParseException {
		assertTrue(new ObjectToSQLLiteral(new UpperOperand("", "Homer", true)).getLiteral().equals("UPPER('Homer')"));		
	}
	
	@Test
	public void ListLiteral() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		List<String> list = new ArrayList<String>();
		list.add("Homer");
		list.add("D'oh!");
		
		assertTrue(new ObjectToSQLLiteral(list).getLiteral().equals("'Homer','D''oh!'"));				
	}
	
	@Test
	public void ArrayLiteral() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		String[] list = new String[2];
		list[0] = "Homer";
		list[1] = "D'oh!";
		
		assertTrue(new ObjectToSQLLiteral(list).getLiteral().equals("'Homer','D''oh!'"));				
	}
	
	@Test
	public void BeanLiteral() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		TestBean bean = new TestBean();
		bean.setId(10);
		
		assertTrue(new ObjectToSQLLiteral(bean).getLiteral().equals("10"));				
	}
	
	@Test
	public void ObjectLiteral() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Obj o = new Obj();
		o.setFld("xxx");
		
		assertTrue(new ObjectToSQLLiteral(o).getLiteral().equals(o.toString()));				
	}
	
	
	

}

package org.liveSense.misc.queryBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.liveSense.misc.queryBuilder.domains.Operand;
import org.liveSense.misc.queryBuilder.operands.DefaultOperand;
import org.liveSense.misc.queryBuilder.operands.UpperOperand;

import static org.junit.Assert.assertTrue;


public class ObjectToSQLLiteralTest {
	
	
	public class Obj {
		private String fld;
		public String getFld() {return fld;}
		public void setFld(String fld) {this.fld = fld;}
	}
	

	@Test
	public void NullLiteral() throws Exception {
		assertTrue(new ObjectToSQLLiteral(null).getLiteral().equals("NULL"));		
	}
	
	@Test
	public void StringLiteral() throws Exception {
		assertTrue(new ObjectToSQLLiteral("Homer").getLiteral().equals("'Homer'"));		
		assertTrue(new ObjectToSQLLiteral("D'oh!").getLiteral().equals("'D''oh!'"));
	}
	
	@Test
	public void IntegerLiteral() throws Exception {
		assertTrue(new ObjectToSQLLiteral(10).getLiteral().equals("10"));		
		assertTrue(new ObjectToSQLLiteral(-10).getLiteral().equals("-10"));
	}	
	
	@Test
	public void RealLiteral() throws Exception {		
		assertTrue(new ObjectToSQLLiteral(0.00001).getLiteral().equals("0.00001"));
		assertTrue(new ObjectToSQLLiteral(-0.00001).getLiteral().equals("-0.00001"));
		assertTrue(new ObjectToSQLLiteral(1000000000.01).getLiteral().equals("1000000000.01"));
		assertTrue(new ObjectToSQLLiteral(-1000000000.01).getLiteral().equals("-1000000000.01"));
	}
	
	@Test
	public void DateLiteral() throws Exception, ParseException {
		assertTrue(new ObjectToSQLLiteral(new SimpleDateFormat("yyyy/MM/dd").parse("2011/05/12")).getLiteral().equals("'2011.05.12'"));		
		assertTrue(new ObjectToSQLLiteral(java.sql.Date.valueOf("2011-05-12")).getLiteral().equals("'2011.05.12'"));		
	}
	
	@Test
	public void BooleanLiteral() throws Exception, ParseException {
		assertTrue(new ObjectToSQLLiteral(true).getLiteral().equals("true"));				
	}
	
	@Test
	public void OperandSourceLiteral() throws Exception, ParseException {
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", "Homer", true)).getLiteral().equals("'Homer'"));
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", "Homer", false)).getLiteral() == null);
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", "D'oh!", true)).getLiteral().equals("'D''oh!'"));
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", "D'oh!", false)).getLiteral() == null);
		
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", 10, true)).getLiteral().equals("10"));
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", -10, true)).getLiteral().equals("-10"));
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", 10, false)).getLiteral() == null);
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", -10, false)).getLiteral() == null);
		
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", 0.00001, true)).getLiteral().equals("0.00001"));
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", -0.00001, true)).getLiteral().equals("-0.00001"));
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", 0.00001, false)).getLiteral() == null);
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", -0.00001, false)).getLiteral() == null);
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", 1000000000.01, true)).getLiteral().equals("1000000000.01"));
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", -1000000000.01, true)).getLiteral().equals("-1000000000.01"));
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", 1000000000.01, false)).getLiteral() == null);
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", -1000000000.01, false)).getLiteral() == null);
		
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", new SimpleDateFormat("yyyy/MM/dd").parse("2011/05/12"), true)).getLiteral().equals("'2011.05.12'"));
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", new SimpleDateFormat("yyyy/MM/dd").parse("2011/05/12"), false)).getLiteral() == null);		
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", java.sql.Date.valueOf("2011-05-12"), true)).getLiteral().equals("'2011.05.12'"));
		assertTrue(new ObjectToSQLLiteral(new DefaultOperand("", java.sql.Date.valueOf("2011-05-12"), false)).getLiteral() == null);
	}
	
	@Test
	public void OperandSourceFeatureLiteral() throws Exception, ParseException {
		assertTrue(new ObjectToSQLLiteral(new UpperOperand("", (Object)"Homer", true)).getLiteral().equals("UPPER('Homer')"));		
	}
	
	@Test
	public void ListLiteral() throws Exception {
		List<String> list = new ArrayList<String>();
		list.add("Homer");
		list.add("D'oh!");
		
		assertTrue(new ObjectToSQLLiteral(list).getLiteral().equals("'Homer','D''oh!'"));				
	}
	
	@Test
	public void ArrayLiteral() throws Exception {
		String[] list = new String[2];
		list[0] = "Homer";
		list[1] = "D'oh!";
		
		assertTrue(new ObjectToSQLLiteral(list).getLiteral().equals("'Homer','D''oh!'"));				
	}
	
	@Test
	public void BeanLiteral() throws Exception {
		TestBean bean = new TestBean();
		bean.setId(10);
		
		assertTrue(new ObjectToSQLLiteral(bean).getLiteral().equals("10"));				
	}
	
	@Test
	public void ObjectLiteral() throws Exception {
		Obj o = new Obj();
		o.setFld("xxx");
		
		assertTrue(new ObjectToSQLLiteral(o).getLiteral().equals(o.toString()));				
	}
	
	@Test
	public void toSQLString() throws Exception, ParseException {
		assertTrue(new ObjectToSQLLiteral(true, new ToSQLStringEvent() {
			
			@Override
			public boolean toSQLString(
				Object obj,
				StringBuilder sb)
				throws Exception {
			
				sb.append("1");
				return true;
			}
		}).getLiteral().equals("1"));
		
		assertTrue(new ObjectToSQLLiteral(true, new ToSQLStringEvent() {
			
			@Override
			public boolean toSQLString(
				Object obj,
				StringBuilder sb)
				throws Exception {
			
				return false;
			}
		}).getLiteral().equals("true"));	
	}	
	

}

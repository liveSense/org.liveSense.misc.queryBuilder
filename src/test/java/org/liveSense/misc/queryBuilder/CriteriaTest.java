package org.liveSense.misc.queryBuilder;


import static junit.framework.Assert.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.liveSense.misc.queryBuilder.beans.Value;
import org.liveSense.misc.queryBuilder.criterias.BetweenCriteria;
import org.liveSense.misc.queryBuilder.criterias.DistinctFromCriteria;
import org.liveSense.misc.queryBuilder.criterias.EqualCriteria;
import org.liveSense.misc.queryBuilder.criterias.GreaterCriteria;
import org.liveSense.misc.queryBuilder.criterias.GreaterOrEqualCriteria;
import org.liveSense.misc.queryBuilder.criterias.InCriteria;
import org.liveSense.misc.queryBuilder.criterias.IsNotNullCriteria;
import org.liveSense.misc.queryBuilder.criterias.IsNullCriteria;
import org.liveSense.misc.queryBuilder.criterias.LessCriteria;
import org.liveSense.misc.queryBuilder.criterias.LessOrEqualCriteria;
import org.liveSense.misc.queryBuilder.criterias.LikeCriteria;
import org.liveSense.misc.queryBuilder.criterias.NotEqualCriteria;
import org.liveSense.misc.queryBuilder.criterias.StartingWithCriteria;
import org.liveSense.misc.queryBuilder.domains.Operand;
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.jdbcDriver.JdbcDrivers;
import org.liveSense.misc.queryBuilder.operands.DefaultOperand;
import org.liveSense.misc.queryBuilder.operands.UpperOperand;

public class CriteriaTest {

	private ArrayList intValue1List;
	private ArrayList intValueMultiList;
	private Integer[] intValue1Array;
	private Integer[] intValueMultiArray;
	private ArrayList longValue1List;
	private ArrayList longValueMultiList;
	private Long[] longValue1Array;
	private Long[] longValueMultiArray;
	private ArrayList stringValue1List;
	private ArrayList stringValueMultiList;
	private String[] stringValue1Array;
	private String[] stringValueMultiArray;
	private ArrayList dateValue1List;
	private ArrayList dateValueMultiList;
	private Date[] dateValue1Array;
	private Date[] dateValueMultiArray;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		intValue1List = new ArrayList();
		intValue1List.add(1);
		intValueMultiList = new ArrayList();
		intValueMultiList.add(1);
		intValueMultiList.add(2);
		intValueMultiList.add(3);

		intValue1Array = new Integer[]{1};
		intValueMultiArray = new Integer[]{1,2,3};

		longValue1List = new ArrayList();
		longValue1List.add(new Long(1));
		longValueMultiList = new ArrayList();
		longValueMultiList.add(new Long(1));
		longValueMultiList.add(new Long(2));
		longValueMultiList.add(new Long(3));

		longValue1Array = new Long[]{new Long(1)};
		longValueMultiArray = new Long[]{new Long(1), new Long(2), new Long(3)};

	
		stringValue1List = new ArrayList();
		stringValue1List.add("str1");
		stringValueMultiList = new ArrayList();
		stringValueMultiList.add("str1");
		stringValueMultiList.add("str2");
		stringValueMultiList.add("str3");
		stringValueMultiList.add("don't");
		stringValue1Array = new String[]{"str1"};
		stringValueMultiArray = new String[]{"str1", "str2", "str3", "don't"};

		dateValue1List = new ArrayList();
		dateValue1List.add(df.parse("2001.12.31"));
		dateValueMultiList = new ArrayList();
		dateValueMultiList.add(df.parse("2001.12.31"));
		dateValueMultiList.add(df.parse("2002.12.31"));
		dateValueMultiList.add(df.parse("2003.12.31"));
		dateValue1Array = new Date[]{df.parse("2001.12.31")};
		dateValueMultiArray = new Date[]{df.parse("2001.12.31"), df.parse("2002.12.31"), df.parse("2003.12.31")};
	
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void EqualsCriteriaTest() {
		try {
			assertEquals("Equals Integer", "integer=1", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("integer", 1)));
			assertEquals("Equals Long", "long=1", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("long", new Long(1))));
			assertEquals("Equals String", "string='str'", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("string", "str")));
			assertEquals("Equals Date", "date='2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("date", df.parse("2000.12.31"))));
			assertEquals("Equals String", "string='don''t'", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("string", "don't")));
			
			assertEquals("Equals Integer", "a.integer=1", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("a", "integer", 1)));
			assertEquals("Equals Long", "a.long=1", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("a", "long", new Long(1))));
			assertEquals("Equals String", "a.string='str'", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("a", "string", "str")));
			assertEquals("Equals Date", "a.date='2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("a", "date", df.parse("2000.12.31"))));			
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}

	}

	@Test
	public void BetweenCriteriaTest() {
		try {
			assertEquals("Between Integer", "integer BETWEEN 1 AND 2", OperatorAndCriteriaProcessor.processCriteria(new BetweenCriteria("integer", 1, 2)));
			assertEquals("Between Long", "long BETWEEN 1 AND 2", OperatorAndCriteriaProcessor.processCriteria(new BetweenCriteria("long", new Long(1), new Long(2))));
			assertEquals("Between String", "string BETWEEN 'str1' AND 'str2'", OperatorAndCriteriaProcessor.processCriteria(new BetweenCriteria("string", "str1", "str2")));
			assertEquals("Between Date", "date BETWEEN '2000.01.01' AND '2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new BetweenCriteria("date", df.parse("2000.01.01"), df.parse("2000.12.31"))));
			assertEquals("Between String", "string BETWEEN 'don''t' AND 'doesn''t'", OperatorAndCriteriaProcessor.processCriteria(new BetweenCriteria("string", "don't", "doesn't")));
			
			assertEquals("Between Integer", "a.integer BETWEEN 1 AND 2", OperatorAndCriteriaProcessor.processCriteria(new BetweenCriteria("a", "integer", 1, 2)));
			assertEquals("Between Long", "a.long BETWEEN 1 AND 2", OperatorAndCriteriaProcessor.processCriteria(new BetweenCriteria("a", "long", new Long(1), new Long(2))));
			assertEquals("Between String", "a.string BETWEEN 'str1' AND 'str2'", OperatorAndCriteriaProcessor.processCriteria(new BetweenCriteria("a", "string", "str1", "str2")));
			assertEquals("Between Date", "a.date BETWEEN '2000.01.01' AND '2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new BetweenCriteria("a", "date", df.parse("2000.01.01"), df.parse("2000.12.31"))));			
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}

	}

	@Test
	public void LikeCriteriaTest() {
		try {
			assertEquals("Like String", "string LIKE '%str_1'", OperatorAndCriteriaProcessor.processCriteria(new LikeCriteria("string", "%str_1")));
			assertEquals("Like String", "string LIKE '%don''t_1'", OperatorAndCriteriaProcessor.processCriteria(new LikeCriteria("string", "%don't_1")));
			
			assertEquals("Like String", "a.string LIKE '%str_1'", OperatorAndCriteriaProcessor.processCriteria(new LikeCriteria("a", "string", "%str_1")));
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}

	@Test (expected = QueryBuilderException.class)
	public void LikeCriteriaTest_Integer() throws QueryBuilderException {
			assertEquals("Like Integer", "integer LIKE 1", OperatorAndCriteriaProcessor.processCriteria(new LikeCriteria("integer", new Value(1))));
	}

	@Test (expected = QueryBuilderException.class)
	public void LikeCriteriaTest_Long() throws QueryBuilderException {
			assertEquals("Like Long", "integer LIKE 1", OperatorAndCriteriaProcessor.processCriteria(new LikeCriteria("long", new Value(new Long(1)))));
	}

	@Test (expected = QueryBuilderException.class)
	public void LikeCriteriaTest_Date() throws QueryBuilderException {
		try {
			assertEquals("Like Date", "date LIKE '2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new LikeCriteria("date", new Value(df.parse("2000.12.31")))));
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		}
	}

	@Test
	public void InCriteriaTest() {
			try {
				assertEquals("In Integer 1 value (List)", "integer IN (1)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("integer", intValue1List)));
				assertEquals("In Integer 1 value (List)", "integer IN (1)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("integer", intValue1Array)));
				assertEquals("In Integer multi value (List)", "integer IN (1,2,3)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("integer", intValueMultiList)));
				assertEquals("In Integer multi value (List)", "integer IN (1,2,3)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("integer", intValueMultiArray)));

				assertEquals("In Long 1 value (List)", "long IN (1)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("long", longValue1List)));
				assertEquals("In Long 1 value (List)", "long IN (1)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("long", longValue1Array)));
				assertEquals("In Long multi value (List)", "long IN (1,2,3)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("long", longValueMultiList)));
				assertEquals("In Long multi value (List)", "long IN (1,2,3)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("long", longValueMultiArray)));

				assertEquals("In String 1 value (List)", "string IN ('str1')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("string", stringValue1List)));
				assertEquals("In String 1 value (List)", "string IN ('str1')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("string", stringValue1Array)));
				assertEquals("In String multi value (List)", "string IN ('str1','str2','str3','don''t')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("string", stringValueMultiList)));
				assertEquals("In String multi value (List)", "string IN ('str1','str2','str3','don''t')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("string", stringValueMultiArray)));

				assertEquals("In Date 1 value (List)", "date IN ('2001.12.31')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("date", dateValue1List)));
				assertEquals("In Date 1 value (List)", "date IN ('2001.12.31')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("date", dateValue1Array)));
				assertEquals("In Date multi value (List)", "date IN ('2001.12.31','2002.12.31','2003.12.31')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("date", dateValueMultiList)));
				assertEquals("In Date multi value (List)", "date IN ('2001.12.31','2002.12.31','2003.12.31')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("date", dateValueMultiArray)));
				
				
				assertEquals("In Integer 1 value (List)", "a.integer IN (1)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("a", "integer", intValue1List)));
				assertEquals("In Integer 1 value (List)", "a.integer IN (1)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("a", "integer", intValue1Array)));
				assertEquals("In Integer multi value (List)", "a.integer IN (1,2,3)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("a", "integer", intValueMultiList)));
				assertEquals("In Integer multi value (List)", "a.integer IN (1,2,3)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("a", "integer", intValueMultiArray)));

				assertEquals("In Long 1 value (List)", "a.long IN (1)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("a", "long", longValue1List)));
				assertEquals("In Long 1 value (List)", "a.long IN (1)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("a", "long", longValue1Array)));
				assertEquals("In Long multi value (List)", "a.long IN (1,2,3)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("a", "long", longValueMultiList)));
				assertEquals("In Long multi value (List)", "a.long IN (1,2,3)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("a", "long", longValueMultiArray)));

				assertEquals("In String 1 value (List)", "a.string IN ('str1')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("a", "string", stringValue1List)));
				assertEquals("In String 1 value (List)", "a.string IN ('str1')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("a", "string", stringValue1Array)));
				assertEquals("In String multi value (List)", "a.string IN ('str1','str2','str3','don''t')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("a", "string", stringValueMultiList)));
				assertEquals("In String multi value (List)", "a.string IN ('str1','str2','str3','don''t')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("a", "string", stringValueMultiArray)));

				assertEquals("In Date 1 value (List)", "a.date IN ('2001.12.31')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("a", "date", dateValue1List)));
				assertEquals("In Date 1 value (List)", "a.date IN ('2001.12.31')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("a", "date", dateValue1Array)));
				assertEquals("In Date multi value (List)", "a.date IN ('2001.12.31','2002.12.31','2003.12.31')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("a", "date", dateValueMultiList)));
				assertEquals("In Date multi value (List)", "a.date IN ('2001.12.31','2002.12.31','2003.12.31')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria("a", "date", dateValueMultiArray)));
				

			} catch (QueryBuilderException e) {
				fail("QueryBuilderException"+e.getMessage());
			}
	}

	
	@Test
	public void LessCriteriaTest() {
		try {
			assertEquals("Less Integer", "integer<1", OperatorAndCriteriaProcessor.processCriteria(new LessCriteria("integer", 1)));
			assertEquals("Less Long", "long<1", OperatorAndCriteriaProcessor.processCriteria(new LessCriteria("long", new Long(1))));
			assertEquals("Less String", "string<'str'", OperatorAndCriteriaProcessor.processCriteria(new LessCriteria("string", "str")));			
			assertEquals("Less Date", "date<'2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new LessCriteria("date", df.parse("2000.12.31"))));
			assertEquals("Less String", "string<'don''t'", OperatorAndCriteriaProcessor.processCriteria(new LessCriteria("string", "don't")));
			
			assertEquals("Less Integer", "a.integer<1", OperatorAndCriteriaProcessor.processCriteria(new LessCriteria("a", "integer", 1)));
			assertEquals("Less Long", "a.long<1", OperatorAndCriteriaProcessor.processCriteria(new LessCriteria("a", "long", new Long(1))));
			assertEquals("Less String", "a.string<'str'", OperatorAndCriteriaProcessor.processCriteria(new LessCriteria("a", "string", "str")));
			assertEquals("Less Date", "a.date<'2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new LessCriteria("a", "date", df.parse("2000.12.31"))));			
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}

	@Test
	public void LessOrEqualCriteriaTest() {
		try {
			assertEquals("LessOrEquals Integer", "integer<=1", OperatorAndCriteriaProcessor.processCriteria(new LessOrEqualCriteria("integer", 1)));
			assertEquals("LessOrEquals Long", "long<=1", OperatorAndCriteriaProcessor.processCriteria(new LessOrEqualCriteria("long", new Long(1))));
			assertEquals("LessOrEquals String", "string<='str'", OperatorAndCriteriaProcessor.processCriteria(new LessOrEqualCriteria("string", "str")));
			assertEquals("LessOrEquals Date", "date<='2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new LessOrEqualCriteria("date", df.parse("2000.12.31"))));
			assertEquals("LessOrEquals String", "string<='don''t'", OperatorAndCriteriaProcessor.processCriteria(new LessOrEqualCriteria("string", "don't")));
			
			assertEquals("LessOrEquals Integer", "a.integer<=1", OperatorAndCriteriaProcessor.processCriteria(new LessOrEqualCriteria("a", "integer", 1)));
			assertEquals("LessOrEquals Long", "a.long<=1", OperatorAndCriteriaProcessor.processCriteria(new LessOrEqualCriteria("a", "long", new Long(1))));
			assertEquals("LessOrEquals String", "a.string<='str'", OperatorAndCriteriaProcessor.processCriteria(new LessOrEqualCriteria("a", "string", "str")));
			assertEquals("LessOrEquals Date", "a.date<='2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new LessOrEqualCriteria("a", "date", df.parse("2000.12.31"))));			
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}

	@Test
	public void GreaterCriteriaTest() {
		try {
			assertEquals("Greater Integer", "integer>1", OperatorAndCriteriaProcessor.processCriteria(new GreaterCriteria("integer", 1)));
			assertEquals("Greater Long", "long>1", OperatorAndCriteriaProcessor.processCriteria(new GreaterCriteria("long", new Long(1))));
			assertEquals("Greater String", "string>'str'", OperatorAndCriteriaProcessor.processCriteria(new GreaterCriteria("string", "str")));
			assertEquals("Greater Date", "date>'2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new GreaterCriteria("date", df.parse("2000.12.31"))));
			assertEquals("Greater String", "string>'don''t'", OperatorAndCriteriaProcessor.processCriteria(new GreaterCriteria("string", "don't")));
			
			assertEquals("Greater Integer", "a.integer>1", OperatorAndCriteriaProcessor.processCriteria(new GreaterCriteria("a", "integer", 1)));
			assertEquals("Greater Long", "a.long>1", OperatorAndCriteriaProcessor.processCriteria(new GreaterCriteria("a", "long", new Long(1))));
			assertEquals("Greater String", "a.string>'str'", OperatorAndCriteriaProcessor.processCriteria(new GreaterCriteria("a", "string", "str")));
			assertEquals("Greater Date", "a.date>'2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new GreaterCriteria("a", "date", df.parse("2000.12.31"))));
			
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}

	@Test
	public void GreaterOrEqualCriteriaTest() {
		try {
			assertEquals("GreaterOrEquals Integer", "integer>=1", OperatorAndCriteriaProcessor.processCriteria(new GreaterOrEqualCriteria("integer", 1)));
			assertEquals("GreaterOrEquals Long", "long>=1", OperatorAndCriteriaProcessor.processCriteria(new GreaterOrEqualCriteria("long", new Long(1))));
			assertEquals("GreaterOrEquals String", "string>='str'", OperatorAndCriteriaProcessor.processCriteria(new GreaterOrEqualCriteria("string", "str")));
			assertEquals("GreaterOrEquals Date", "date>='2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new GreaterOrEqualCriteria("date", df.parse("2000.12.31"))));
			assertEquals("GreaterOrEquals String", "string>='don''t'", OperatorAndCriteriaProcessor.processCriteria(new GreaterOrEqualCriteria("string", "don't")));
			
			assertEquals("GreaterOrEquals Integer", "a.integer>=1", OperatorAndCriteriaProcessor.processCriteria(new GreaterOrEqualCriteria("a", "integer", 1)));
			assertEquals("GreaterOrEquals Long", "a.long>=1", OperatorAndCriteriaProcessor.processCriteria(new GreaterOrEqualCriteria("a", "long", new Long(1))));
			assertEquals("GreaterOrEquals String", "a.string>='str'", OperatorAndCriteriaProcessor.processCriteria(new GreaterOrEqualCriteria("a", "string", "str")));
			assertEquals("GreaterOrEquals Date", "a.date>='2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new GreaterOrEqualCriteria("a", "date", df.parse("2000.12.31"))));
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}

	@Test
	public void BeanCriteriaTest() {
		try {
			assertEquals("Equals cutomerId", "ID_CUSTOMER=1", OperatorAndCriteriaProcessor.processCriteria(TestBean.class, new EqualCriteria("customerId",1)));
			
			assertEquals("Equals cutomerId", "a.ID_CUSTOMER=1", OperatorAndCriteriaProcessor.processCriteria(TestBean.class, new EqualCriteria("a", "customerId",1)));
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}

	@Test
	public void BeanIdCriteriaTest() {
		ArrayList<TestBean> beans = new ArrayList<TestBean>();
		TestBean bean1 = new TestBean();
		bean1.setId(1);
		TestBean bean2 = new TestBean();
		bean2.setId(2);
		beans.add(bean1);
		beans.add(bean2);
		try {
			assertEquals("Equals cutomerId", "ID_CUSTOMER IN (1,2)", OperatorAndCriteriaProcessor.processCriteria(TestBean.class, new InCriteria("customerId", beans)));
			
			assertEquals("Equals cutomerId", "a.ID_CUSTOMER IN (1,2)", OperatorAndCriteriaProcessor.processCriteria(TestBean.class, new InCriteria("a", "customerId", beans)));
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}
	
	@Test
	public void IsNullCriteriaTest() {
		try {
			assertEquals("Null Integer", "integer IS NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNullCriteria("integer")));
			assertEquals("Null Long", "long IS NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNullCriteria("long")));
			assertEquals("Null String", "string IS NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNullCriteria("string")));
			assertEquals("Null Date", "date IS NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNullCriteria("date")));
			
			assertEquals("Null Integer", "a.integer IS NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNullCriteria("a", "integer")));
			assertEquals("Null Long", "a.long IS NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNullCriteria("a", "long")));
			assertEquals("Null String", "a.string IS NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNullCriteria("a", "string")));
			assertEquals("Null Date", "a.date IS NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNullCriteria("a", "date")));			
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}
	
	@Test
	public void IsNotNullCriteriaTest() {
		try {
			assertEquals("Not Null Integer", "integer IS NOT NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNotNullCriteria("integer")));
			assertEquals("Not Null Long", "long IS NOT NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNotNullCriteria("long")));
			assertEquals("Not Null String", "string IS NOT NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNotNullCriteria("string")));
			assertEquals("Not Null Date", "date IS NOT NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNotNullCriteria("date")));
			
			assertEquals("Not Null Integer", "a.integer IS NOT NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNotNullCriteria("a", "integer")));
			assertEquals("Not Null Long", "a.long IS NOT NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNotNullCriteria("a", "long")));
			assertEquals("Not Null String", "a.string IS NOT NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNotNullCriteria("a", "string")));
			assertEquals("Not Null Date", "a.date IS NOT NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNotNullCriteria("a", "date")));			
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}
	
	@Test
	public void DistinctFromCriteriaTest() {
		try {
			assertEquals("Distinct from Integer", "integer IS DISTINCT FROM 1", OperatorAndCriteriaProcessor.processCriteria(new DistinctFromCriteria("integer", 1)));
			assertEquals("Distinct from Long", "long IS DISTINCT FROM 1", OperatorAndCriteriaProcessor.processCriteria(new DistinctFromCriteria("long", new Long(1))));
			assertEquals("Distinct from String", "string IS DISTINCT FROM 'str'", OperatorAndCriteriaProcessor.processCriteria(new DistinctFromCriteria("string", "str")));
			assertEquals("Distinct from Date", "date IS DISTINCT FROM '2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new DistinctFromCriteria("date", df.parse("2000.12.31"))));
			assertEquals("Distinct from String", "string IS DISTINCT FROM 'don''t'", OperatorAndCriteriaProcessor.processCriteria(new DistinctFromCriteria("string", "don't")));
			
			assertEquals("Distinct from Integer", "a.integer IS DISTINCT FROM 1", OperatorAndCriteriaProcessor.processCriteria(new DistinctFromCriteria("a", "integer", 1)));
			assertEquals("Distinct from Long", "a.long IS DISTINCT FROM 1", OperatorAndCriteriaProcessor.processCriteria(new DistinctFromCriteria("a", "long", new Long(1))));
			assertEquals("Distinct from String", "a.string IS DISTINCT FROM 'str'", OperatorAndCriteriaProcessor.processCriteria(new DistinctFromCriteria("a", "string", "str")));
			assertEquals("Distinct from Date", "a.date IS DISTINCT FROM '2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new DistinctFromCriteria("a", "date", df.parse("2000.12.31"))));			
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}
	
	@Test
	public void StartingWithCriteriaTest() {
		try {
			assertEquals("Starting with String", "string STARTING WITH 'str1'", OperatorAndCriteriaProcessor.processCriteria(new StartingWithCriteria("string", "str1")));
			assertEquals("Starting with String", "string STARTING WITH 'don''t'", OperatorAndCriteriaProcessor.processCriteria(new StartingWithCriteria("string", "don't")));
			
			assertEquals("Starting with String", "a.string STARTING WITH 'str1'", OperatorAndCriteriaProcessor.processCriteria(new StartingWithCriteria("a", "string", "str1")));
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}

	
	@Test (expected = QueryBuilderException.class)
	public void StartingWithCriteriaTest_Integer() throws QueryBuilderException {
			assertEquals("Starting with Integer", "integer STARTING WITH 1", OperatorAndCriteriaProcessor.processCriteria(new StartingWithCriteria("integer", new Value(1))));
	}

	@Test (expected = QueryBuilderException.class)
	public void StartingWithCriteriaTest_Long() throws QueryBuilderException {
			assertEquals("Starting with Long", "integer STARTING WITH 1", OperatorAndCriteriaProcessor.processCriteria(new StartingWithCriteria("long", new Value(new Long(1)))));
	}

	@Test (expected = QueryBuilderException.class)
	public void StartingWithCriteriaTest_Date() throws QueryBuilderException {
		try {
			assertEquals("Starting with Date", "date STARTING WITH '2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new StartingWithCriteria("date", new Value(df.parse("2000.12.31")))));
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		}
	}	

	@Test
	public void NotEqualsCriteriaTest() {
		try {
			assertEquals("Not equals Integer", "integer<>1", OperatorAndCriteriaProcessor.processCriteria(new NotEqualCriteria("integer", 1)));
			assertEquals("Not equals Long", "long<>1", OperatorAndCriteriaProcessor.processCriteria(new NotEqualCriteria("long", new Long(1))));
			assertEquals("Not equals String", "string<>'str'", OperatorAndCriteriaProcessor.processCriteria(new NotEqualCriteria("string", "str")));
			assertEquals("Not equals Date", "date<>'2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new NotEqualCriteria("date", df.parse("2000.12.31"))));
			assertEquals("Not equals String", "string<>'don''t'", OperatorAndCriteriaProcessor.processCriteria(new NotEqualCriteria("string", "don't")));
			
			assertEquals("Not equals Integer", "a.integer<>1", OperatorAndCriteriaProcessor.processCriteria(new NotEqualCriteria("a", "integer", 1)));
			assertEquals("Not equals Long", "a.long<>1", OperatorAndCriteriaProcessor.processCriteria(new NotEqualCriteria("a", "long", new Long(1))));
			assertEquals("Not equals String", "a.string<>'str'", OperatorAndCriteriaProcessor.processCriteria(new NotEqualCriteria("a", "string", "str")));
			assertEquals("Not equals Date", "a.date<>'2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new NotEqualCriteria("a", "date", df.parse("2000.12.31"))));			
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}
	
	@Test
	public void FeatureTest() {		
		try {
			assertEquals("equals", "integer=1", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("integer", new DefaultOperand(1))));
			assertEquals("equals", "a.dbfield1=b.dbfield2", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("a", "dbfield1", new DefaultOperand("b", "dbfield2", false))));			
			assertEquals("equals", "a.dbfield1=UPPER(b.dbfield2)", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("a", "dbfield1", new UpperOperand("b", (Object)"dbfield2", false))));			
			assertEquals("equals", "b.ID_CUSTOMER=1", OperatorAndCriteriaProcessor.processCriteria(TestBean.class,new EqualCriteria("b", "customerId", new DefaultOperand(1))));
			assertEquals("equals", "b.CODE=UPPER('Homer')", OperatorAndCriteriaProcessor.processCriteria(TestBean.class,new EqualCriteria("b", "code", new UpperOperand("Homer"))));
			assertEquals("equals", "UPPER(b.CODE)=UPPER('Homer')", OperatorAndCriteriaProcessor.processCriteria(TestBean.class,new EqualCriteria(new UpperOperand("b", (Object)"code", false), new UpperOperand("Homer"))));
			
			assertEquals("equals", "b.CODE=UPPER('D''oh!')", OperatorAndCriteriaProcessor.processCriteria(TestBean.class,new EqualCriteria("b", "code", new UpperOperand("D'oh!"))));
			
			//assertEquals("equals", "UPPER(b.CODE)=UPPER('Homer')", OperatorAndCriteriaProcessor.processCriteria(TestBean.class,new EqualCriteria<OperandSource>(new UpperOperand("b", (Object)"code", false), new UpperOperand("Homer")), JdbcDrivers.FIREBIRD));
			
			assertEquals("equals", "double=0.00001", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("double", 0.00001)));
			assertEquals("equals", "double=0.00001", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("double", new DefaultOperand(0.00001))));
			
			assertEquals("equals", "double=1000000000", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("double", 1000000000.0)));
			assertEquals("equals", "double=1000000000", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("double", new DefaultOperand(1000000000.0))));			
			
			assertEquals("equals", "double=-0.00001", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("double", -0.00001)));
			assertEquals("equals", "double=-0.00001", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("double", new DefaultOperand(-0.00001))));
			
			assertEquals("equals", "double=-1000000000", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("double", -1000000000.0)));
			assertEquals("equals", "double=-1000000000", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria("double", new DefaultOperand(-1000000000.0))));
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}	
	


}

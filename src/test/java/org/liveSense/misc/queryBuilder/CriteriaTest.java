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
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.jdbcDriver.JdbcDrivers;
import org.liveSense.misc.queryBuilder.operands.OperandSource;
import org.liveSense.misc.queryBuilder.operands.UpperOperand;

public class CriteriaTest {

	private ArrayList<Integer> intValue1List;
	private ArrayList<Integer> intValueMultiList;
	private Integer[] intValue1Array;
	private Integer[] intValueMultiArray;
	private ArrayList<Long> longValue1List;
	private ArrayList<Long> longValueMultiList;
	private Long[] longValue1Array;
	private Long[] longValueMultiArray;
	private ArrayList<String> stringValue1List;
	private ArrayList<String> stringValueMultiList;
	private String[] stringValue1Array;
	private String[] stringValueMultiArray;
	private ArrayList<Date> dateValue1List;
	private ArrayList<Date> dateValueMultiList;
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
		intValue1List = new ArrayList<Integer>();
		intValue1List.add(1);
		intValueMultiList = new ArrayList<Integer>();
		intValueMultiList.add(1);
		intValueMultiList.add(2);
		intValueMultiList.add(3);

		intValue1Array = new Integer[]{1};
		intValueMultiArray = new Integer[]{1,2,3};

		longValue1List = new ArrayList<Long>();
		longValue1List.add(new Long(1));
		longValueMultiList = new ArrayList<Long>();
		longValueMultiList.add(new Long(1));
		longValueMultiList.add(new Long(2));
		longValueMultiList.add(new Long(3));

		longValue1Array = new Long[]{new Long(1)};
		longValueMultiArray = new Long[]{new Long(1), new Long(2), new Long(3)};

	
		stringValue1List = new ArrayList<String>();
		stringValue1List.add("str1");
		stringValueMultiList = new ArrayList<String>();
		stringValueMultiList.add("str1");
		stringValueMultiList.add("str2");
		stringValueMultiList.add("str3");
		stringValueMultiList.add("don't");
		stringValue1Array = new String[]{"str1"};
		stringValueMultiArray = new String[]{"str1", "str2", "str3", "don't"};

		dateValue1List = new ArrayList<Date>();
		dateValue1List.add(df.parse("2001.12.31"));
		dateValueMultiList = new ArrayList<Date>();
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
			assertEquals("Equals Integer", "integer=1", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<Integer>("integer", 1)));
			assertEquals("Equals Long", "long=1", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<Long>("long", new Long(1))));
			assertEquals("Equals String", "string='str'", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<String>("string", "str")));
			assertEquals("Equals Date", "date='2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<Date>("date", df.parse("2000.12.31"))));
			assertEquals("Equals String", "string='don''t'", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<String>("string", "don't")));
			
			assertEquals("Equals Integer", "a.integer=1", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<Integer>("a", "integer", 1)));
			assertEquals("Equals Long", "a.long=1", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<Long>("a", "long", new Long(1))));
			assertEquals("Equals String", "a.string='str'", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<String>("a", "string", "str")));
			assertEquals("Equals Date", "a.date='2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<Date>("a", "date", df.parse("2000.12.31"))));			
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}

	}

	@Test
	public void BetweenCriteriaTest() {
		try {
			assertEquals("Between Integer", "integer BETWEEN 1 AND 2", OperatorAndCriteriaProcessor.processCriteria(new BetweenCriteria<Integer>("integer", 1, 2)));
			assertEquals("Between Long", "long BETWEEN 1 AND 2", OperatorAndCriteriaProcessor.processCriteria(new BetweenCriteria<Long>("long", new Long(1), new Long(2))));
			assertEquals("Between String", "string BETWEEN 'str1' AND 'str2'", OperatorAndCriteriaProcessor.processCriteria(new BetweenCriteria<String>("string", "str1", "str2")));
			assertEquals("Between Date", "date BETWEEN '2000.01.01' AND '2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new BetweenCriteria<Date>("date", df.parse("2000.01.01"), df.parse("2000.12.31"))));
			assertEquals("Between String", "string BETWEEN 'don''t' AND 'doesn''t'", OperatorAndCriteriaProcessor.processCriteria(new BetweenCriteria<String>("string", "don't", "doesn't")));
			
			assertEquals("Between Integer", "a.integer BETWEEN 1 AND 2", OperatorAndCriteriaProcessor.processCriteria(new BetweenCriteria<Integer>("a", "integer", 1, 2)));
			assertEquals("Between Long", "a.long BETWEEN 1 AND 2", OperatorAndCriteriaProcessor.processCriteria(new BetweenCriteria<Long>("a", "long", new Long(1), new Long(2))));
			assertEquals("Between String", "a.string BETWEEN 'str1' AND 'str2'", OperatorAndCriteriaProcessor.processCriteria(new BetweenCriteria<String>("a", "string", "str1", "str2")));
			assertEquals("Between Date", "a.date BETWEEN '2000.01.01' AND '2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new BetweenCriteria<Date>("a", "date", df.parse("2000.01.01"), df.parse("2000.12.31"))));			
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}

	}

	@Test
	public void LikeCriteriaTest() {
		try {
			assertEquals("Like String", "string LIKE '%str_1'", OperatorAndCriteriaProcessor.processCriteria(new LikeCriteria<String>("string", "%str_1")));
			assertEquals("Like String", "string LIKE '%don''t_1'", OperatorAndCriteriaProcessor.processCriteria(new LikeCriteria<String>("string", "%don't_1")));
			
			assertEquals("Like String", "a.string LIKE '%str_1'", OperatorAndCriteriaProcessor.processCriteria(new LikeCriteria<String>("a", "string", "%str_1")));
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}

	@Test (expected = QueryBuilderException.class)
	public void LikeCriteriaTest_Integer() throws QueryBuilderException {
			assertEquals("Like Integer", "integer LIKE 1", OperatorAndCriteriaProcessor.processCriteria(new LikeCriteria<Integer>("integer", 1)));
	}

	@Test (expected = QueryBuilderException.class)
	public void LikeCriteriaTest_Long() throws QueryBuilderException {
			assertEquals("Like Long", "integer LIKE 1", OperatorAndCriteriaProcessor.processCriteria(new LikeCriteria<Long>("long", new Long(1))));
	}

	@Test (expected = QueryBuilderException.class)
	public void LikeCriteriaTest_Date() throws QueryBuilderException {
		try {
			assertEquals("Like Date", "date LIKE '2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new LikeCriteria<Date>("date", df.parse("2000.12.31"))));
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		}
	}

	@Test
	public void InCriteriaTest() {
			try {
				assertEquals("In Integer 1 value (List)", "integer IN (1)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Integer>("integer", intValue1List)));
				assertEquals("In Integer 1 value (List)", "integer IN (1)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Integer>("integer", intValue1Array)));
				assertEquals("In Integer multi value (List)", "integer IN (1,2,3)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Integer>("integer", intValueMultiList)));
				assertEquals("In Integer multi value (List)", "integer IN (1,2,3)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Integer>("integer", intValueMultiArray)));

				assertEquals("In Long 1 value (List)", "long IN (1)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Long>("long", longValue1List)));
				assertEquals("In Long 1 value (List)", "long IN (1)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Long>("long", longValue1Array)));
				assertEquals("In Long multi value (List)", "long IN (1,2,3)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Long>("long", longValueMultiList)));
				assertEquals("In Long multi value (List)", "long IN (1,2,3)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Long>("long", longValueMultiArray)));

				assertEquals("In String 1 value (List)", "string IN ('str1')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<String>("string", stringValue1List)));
				assertEquals("In String 1 value (List)", "string IN ('str1')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<String>("string", stringValue1Array)));
				assertEquals("In String multi value (List)", "string IN ('str1','str2','str3','don''t')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<String>("string", stringValueMultiList)));
				assertEquals("In String multi value (List)", "string IN ('str1','str2','str3','don''t')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<String>("string", stringValueMultiArray)));

				assertEquals("In Date 1 value (List)", "date IN ('2001.12.31')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Date>("date", dateValue1List)));
				assertEquals("In Date 1 value (List)", "date IN ('2001.12.31')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Date>("date", dateValue1Array)));
				assertEquals("In Date multi value (List)", "date IN ('2001.12.31','2002.12.31','2003.12.31')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Date>("date", dateValueMultiList)));
				assertEquals("In Date multi value (List)", "date IN ('2001.12.31','2002.12.31','2003.12.31')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Date>("date", dateValueMultiArray)));
				
				
				assertEquals("In Integer 1 value (List)", "a.integer IN (1)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Integer>("a", "integer", intValue1List)));
				assertEquals("In Integer 1 value (List)", "a.integer IN (1)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Integer>("a", "integer", intValue1Array)));
				assertEquals("In Integer multi value (List)", "a.integer IN (1,2,3)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Integer>("a", "integer", intValueMultiList)));
				assertEquals("In Integer multi value (List)", "a.integer IN (1,2,3)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Integer>("a", "integer", intValueMultiArray)));

				assertEquals("In Long 1 value (List)", "a.long IN (1)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Long>("a", "long", longValue1List)));
				assertEquals("In Long 1 value (List)", "a.long IN (1)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Long>("a", "long", longValue1Array)));
				assertEquals("In Long multi value (List)", "a.long IN (1,2,3)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Long>("a", "long", longValueMultiList)));
				assertEquals("In Long multi value (List)", "a.long IN (1,2,3)", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Long>("a", "long", longValueMultiArray)));

				assertEquals("In String 1 value (List)", "a.string IN ('str1')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<String>("a", "string", stringValue1List)));
				assertEquals("In String 1 value (List)", "a.string IN ('str1')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<String>("a", "string", stringValue1Array)));
				assertEquals("In String multi value (List)", "a.string IN ('str1','str2','str3','don''t')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<String>("a", "string", stringValueMultiList)));
				assertEquals("In String multi value (List)", "a.string IN ('str1','str2','str3','don''t')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<String>("a", "string", stringValueMultiArray)));

				assertEquals("In Date 1 value (List)", "a.date IN ('2001.12.31')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Date>("a", "date", dateValue1List)));
				assertEquals("In Date 1 value (List)", "a.date IN ('2001.12.31')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Date>("a", "date", dateValue1Array)));
				assertEquals("In Date multi value (List)", "a.date IN ('2001.12.31','2002.12.31','2003.12.31')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Date>("a", "date", dateValueMultiList)));
				assertEquals("In Date multi value (List)", "a.date IN ('2001.12.31','2002.12.31','2003.12.31')", OperatorAndCriteriaProcessor.processCriteria(new InCriteria<Date>("a", "date", dateValueMultiArray)));
				

			} catch (QueryBuilderException e) {
				fail("QueryBuilderException"+e.getMessage());
			}
	}

	
	@Test
	public void LessCriteriaTest() {
		try {
			assertEquals("Less Integer", "integer<1", OperatorAndCriteriaProcessor.processCriteria(new LessCriteria<Integer>("integer", 1)));
			assertEquals("Less Long", "long<1", OperatorAndCriteriaProcessor.processCriteria(new LessCriteria<Long>("long", new Long(1))));
			assertEquals("Less String", "string<'str'", OperatorAndCriteriaProcessor.processCriteria(new LessCriteria<String>("string", "str")));			
			assertEquals("Less Date", "date<'2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new LessCriteria<Date>("date", df.parse("2000.12.31"))));
			assertEquals("Less String", "string<'don''t'", OperatorAndCriteriaProcessor.processCriteria(new LessCriteria<String>("string", "don't")));
			
			assertEquals("Less Integer", "a.integer<1", OperatorAndCriteriaProcessor.processCriteria(new LessCriteria<Integer>("a", "integer", 1)));
			assertEquals("Less Long", "a.long<1", OperatorAndCriteriaProcessor.processCriteria(new LessCriteria<Long>("a", "long", new Long(1))));
			assertEquals("Less String", "a.string<'str'", OperatorAndCriteriaProcessor.processCriteria(new LessCriteria<String>("a", "string", "str")));
			assertEquals("Less Date", "a.date<'2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new LessCriteria<Date>("a", "date", df.parse("2000.12.31"))));			
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}

	@Test
	public void LessOrEqualCriteriaTest() {
		try {
			assertEquals("LessOrEquals Integer", "integer<=1", OperatorAndCriteriaProcessor.processCriteria(new LessOrEqualCriteria<Integer>("integer", 1)));
			assertEquals("LessOrEquals Long", "long<=1", OperatorAndCriteriaProcessor.processCriteria(new LessOrEqualCriteria<Long>("long", new Long(1))));
			assertEquals("LessOrEquals String", "string<='str'", OperatorAndCriteriaProcessor.processCriteria(new LessOrEqualCriteria<String>("string", "str")));
			assertEquals("LessOrEquals Date", "date<='2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new LessOrEqualCriteria<Date>("date", df.parse("2000.12.31"))));
			assertEquals("LessOrEquals String", "string<='don''t'", OperatorAndCriteriaProcessor.processCriteria(new LessOrEqualCriteria<String>("string", "don't")));
			
			assertEquals("LessOrEquals Integer", "a.integer<=1", OperatorAndCriteriaProcessor.processCriteria(new LessOrEqualCriteria<Integer>("a", "integer", 1)));
			assertEquals("LessOrEquals Long", "a.long<=1", OperatorAndCriteriaProcessor.processCriteria(new LessOrEqualCriteria<Long>("a", "long", new Long(1))));
			assertEquals("LessOrEquals String", "a.string<='str'", OperatorAndCriteriaProcessor.processCriteria(new LessOrEqualCriteria<String>("a", "string", "str")));
			assertEquals("LessOrEquals Date", "a.date<='2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new LessOrEqualCriteria<Date>("a", "date", df.parse("2000.12.31"))));			
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}

	@Test
	public void GreaterCriteriaTest() {
		try {
			assertEquals("Greater Integer", "integer>1", OperatorAndCriteriaProcessor.processCriteria(new GreaterCriteria<Integer>("integer", 1)));
			assertEquals("Greater Long", "long>1", OperatorAndCriteriaProcessor.processCriteria(new GreaterCriteria<Long>("long", new Long(1))));
			assertEquals("Greater String", "string>'str'", OperatorAndCriteriaProcessor.processCriteria(new GreaterCriteria<String>("string", "str")));
			assertEquals("Greater Date", "date>'2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new GreaterCriteria<Date>("date", df.parse("2000.12.31"))));
			assertEquals("Greater String", "string>'don''t'", OperatorAndCriteriaProcessor.processCriteria(new GreaterCriteria<String>("string", "don't")));
			
			assertEquals("Greater Integer", "a.integer>1", OperatorAndCriteriaProcessor.processCriteria(new GreaterCriteria<Integer>("a", "integer", 1)));
			assertEquals("Greater Long", "a.long>1", OperatorAndCriteriaProcessor.processCriteria(new GreaterCriteria<Long>("a", "long", new Long(1))));
			assertEquals("Greater String", "a.string>'str'", OperatorAndCriteriaProcessor.processCriteria(new GreaterCriteria<String>("a", "string", "str")));
			assertEquals("Greater Date", "a.date>'2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new GreaterCriteria<Date>("a", "date", df.parse("2000.12.31"))));
			
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}

	@Test
	public void GreaterOrEqualCriteriaTest() {
		try {
			assertEquals("GreaterOrEquals Integer", "integer>=1", OperatorAndCriteriaProcessor.processCriteria(new GreaterOrEqualCriteria<Integer>("integer", 1)));
			assertEquals("GreaterOrEquals Long", "long>=1", OperatorAndCriteriaProcessor.processCriteria(new GreaterOrEqualCriteria<Long>("long", new Long(1))));
			assertEquals("GreaterOrEquals String", "string>='str'", OperatorAndCriteriaProcessor.processCriteria(new GreaterOrEqualCriteria<String>("string", "str")));
			assertEquals("GreaterOrEquals Date", "date>='2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new GreaterOrEqualCriteria<Date>("date", df.parse("2000.12.31"))));
			assertEquals("GreaterOrEquals String", "string>='don''t'", OperatorAndCriteriaProcessor.processCriteria(new GreaterOrEqualCriteria<String>("string", "don't")));
			
			assertEquals("GreaterOrEquals Integer", "a.integer>=1", OperatorAndCriteriaProcessor.processCriteria(new GreaterOrEqualCriteria<Integer>("a", "integer", 1)));
			assertEquals("GreaterOrEquals Long", "a.long>=1", OperatorAndCriteriaProcessor.processCriteria(new GreaterOrEqualCriteria<Long>("a", "long", new Long(1))));
			assertEquals("GreaterOrEquals String", "a.string>='str'", OperatorAndCriteriaProcessor.processCriteria(new GreaterOrEqualCriteria<String>("a", "string", "str")));
			assertEquals("GreaterOrEquals Date", "a.date>='2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new GreaterOrEqualCriteria<Date>("a", "date", df.parse("2000.12.31"))));
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}

	@Test
	public void BeanCriteriaTest() {
		try {
			assertEquals("Equals cutomerId", "ID_CUSTOMER=1", OperatorAndCriteriaProcessor.processCriteria(TestBean.class, new EqualCriteria<Integer>("customerId",1)));
			
			assertEquals("Equals cutomerId", "a.ID_CUSTOMER=1", OperatorAndCriteriaProcessor.processCriteria(TestBean.class, new EqualCriteria<Integer>("a", "customerId",1)));
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
			assertEquals("Equals cutomerId", "ID_CUSTOMER IN (1,2)", OperatorAndCriteriaProcessor.processCriteria(TestBean.class, new InCriteria<TestBean>("customerId", beans)));
			
			assertEquals("Equals cutomerId", "a.ID_CUSTOMER IN (1,2)", OperatorAndCriteriaProcessor.processCriteria(TestBean.class, new InCriteria<TestBean>("a", "customerId", beans)));
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}
	
	@Test
	public void IsNullCriteriaTest() {
		try {
			assertEquals("Null Integer", "integer IS NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNullCriteria<Integer>("integer")));
			assertEquals("Null Long", "long IS NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNullCriteria<Long>("long")));
			assertEquals("Null String", "string IS NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNullCriteria<String>("string")));
			assertEquals("Null Date", "date IS NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNullCriteria<Date>("date")));
			
			assertEquals("Null Integer", "a.integer IS NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNullCriteria<Integer>("a", "integer")));
			assertEquals("Null Long", "a.long IS NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNullCriteria<Long>("a", "long")));
			assertEquals("Null String", "a.string IS NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNullCriteria<String>("a", "string")));
			assertEquals("Null Date", "a.date IS NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNullCriteria<Date>("a", "date")));			
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}
	
	@Test
	public void IsNotNullCriteriaTest() {
		try {
			assertEquals("Not Null Integer", "integer IS NOT NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNotNullCriteria<Integer>("integer")));
			assertEquals("Not Null Long", "long IS NOT NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNotNullCriteria<Long>("long")));
			assertEquals("Not Null String", "string IS NOT NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNotNullCriteria<String>("string")));
			assertEquals("Not Null Date", "date IS NOT NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNotNullCriteria<Date>("date")));
			
			assertEquals("Not Null Integer", "a.integer IS NOT NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNotNullCriteria<Integer>("a", "integer")));
			assertEquals("Not Null Long", "a.long IS NOT NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNotNullCriteria<Long>("a", "long")));
			assertEquals("Not Null String", "a.string IS NOT NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNotNullCriteria<String>("a", "string")));
			assertEquals("Not Null Date", "a.date IS NOT NULL", OperatorAndCriteriaProcessor.processCriteria(new IsNotNullCriteria<Date>("a", "date")));			
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}
	
	@Test
	public void DistinctFromCriteriaTest() {
		try {
			assertEquals("Distinct from Integer", "integer IS DISTINCT FROM 1", OperatorAndCriteriaProcessor.processCriteria(new DistinctFromCriteria<Integer>("integer", 1)));
			assertEquals("Distinct from Long", "long IS DISTINCT FROM 1", OperatorAndCriteriaProcessor.processCriteria(new DistinctFromCriteria<Long>("long", new Long(1))));
			assertEquals("Distinct from String", "string IS DISTINCT FROM 'str'", OperatorAndCriteriaProcessor.processCriteria(new DistinctFromCriteria<String>("string", "str")));
			assertEquals("Distinct from Date", "date IS DISTINCT FROM '2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new DistinctFromCriteria<Date>("date", df.parse("2000.12.31"))));
			assertEquals("Distinct from String", "string IS DISTINCT FROM 'don''t'", OperatorAndCriteriaProcessor.processCriteria(new DistinctFromCriteria<String>("string", "don't")));
			
			assertEquals("Distinct from Integer", "a.integer IS DISTINCT FROM 1", OperatorAndCriteriaProcessor.processCriteria(new DistinctFromCriteria<Integer>("a", "integer", 1)));
			assertEquals("Distinct from Long", "a.long IS DISTINCT FROM 1", OperatorAndCriteriaProcessor.processCriteria(new DistinctFromCriteria<Long>("a", "long", new Long(1))));
			assertEquals("Distinct from String", "a.string IS DISTINCT FROM 'str'", OperatorAndCriteriaProcessor.processCriteria(new DistinctFromCriteria<String>("a", "string", "str")));
			assertEquals("Distinct from Date", "a.date IS DISTINCT FROM '2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new DistinctFromCriteria<Date>("a", "date", df.parse("2000.12.31"))));			
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}
	
	@Test
	public void StartingWithCriteriaTest() {
		try {
			assertEquals("Starting with String", "string STARTING WITH 'str1'", OperatorAndCriteriaProcessor.processCriteria(new StartingWithCriteria<String>("string", "str1")));
			assertEquals("Starting with String", "string STARTING WITH 'don''t'", OperatorAndCriteriaProcessor.processCriteria(new StartingWithCriteria<String>("string", "don't")));
			
			assertEquals("Starting with String", "a.string STARTING WITH 'str1'", OperatorAndCriteriaProcessor.processCriteria(new StartingWithCriteria<String>("a", "string", "str1")));
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}

	@Test (expected = QueryBuilderException.class)
	public void StartingWithCriteriaTest_Integer() throws QueryBuilderException {
			assertEquals("Starting with Integer", "integer STARTING WITH 1", OperatorAndCriteriaProcessor.processCriteria(new StartingWithCriteria<Integer>("integer", 1)));
	}

	@Test (expected = QueryBuilderException.class)
	public void StartingWithCriteriaTest_Long() throws QueryBuilderException {
			assertEquals("Starting with Long", "integer STARTING WITH 1", OperatorAndCriteriaProcessor.processCriteria(new StartingWithCriteria<Long>("long", new Long(1))));
	}

	@Test (expected = QueryBuilderException.class)
	public void StartingWithCriteriaTest_Date() throws QueryBuilderException {
		try {
			assertEquals("Starting with Date", "date STARTING WITH '2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new StartingWithCriteria<Date>("date", df.parse("2000.12.31"))));
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		}
	}	

	@Test
	public void NotEqualsCriteriaTest() {
		try {
			assertEquals("Not equals Integer", "integer<>1", OperatorAndCriteriaProcessor.processCriteria(new NotEqualCriteria<Integer>("integer", 1)));
			assertEquals("Not equals Long", "long<>1", OperatorAndCriteriaProcessor.processCriteria(new NotEqualCriteria<Long>("long", new Long(1))));
			assertEquals("Not equals String", "string<>'str'", OperatorAndCriteriaProcessor.processCriteria(new NotEqualCriteria<String>("string", "str")));
			assertEquals("Not equals Date", "date<>'2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new NotEqualCriteria<Date>("date", df.parse("2000.12.31"))));
			assertEquals("Not equals String", "string<>'don''t'", OperatorAndCriteriaProcessor.processCriteria(new NotEqualCriteria<String>("string", "don't")));
			
			assertEquals("Not equals Integer", "a.integer<>1", OperatorAndCriteriaProcessor.processCriteria(new NotEqualCriteria<Integer>("a", "integer", 1)));
			assertEquals("Not equals Long", "a.long<>1", OperatorAndCriteriaProcessor.processCriteria(new NotEqualCriteria<Long>("a", "long", new Long(1))));
			assertEquals("Not equals String", "a.string<>'str'", OperatorAndCriteriaProcessor.processCriteria(new NotEqualCriteria<String>("a", "string", "str")));
			assertEquals("Not equals Date", "a.date<>'2000.12.31'", OperatorAndCriteriaProcessor.processCriteria(new NotEqualCriteria<Date>("a", "date", df.parse("2000.12.31"))));			
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}
	
	@Test
	public void FeatureTest() {		
		try {
			assertEquals("equals", "integer=1", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<OperandSource>("integer", new OperandSource(1))));
			assertEquals("equals", "a.dbfield1=b.dbfield2", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<OperandSource>("a", "dbfield1", new OperandSource("b", "dbfield2", false))));			
			assertEquals("equals", "a.dbfield1=UPPER(b.dbfield2)", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<OperandSource>("a", "dbfield1", new UpperOperand("b", (Object)"dbfield2", false))));			
			assertEquals("equals", "b.ID_CUSTOMER=1", OperatorAndCriteriaProcessor.processCriteria(TestBean.class,new EqualCriteria<OperandSource>("b", "customerId", new OperandSource(1))));
			assertEquals("equals", "b.CODE=UPPER('Homer')", OperatorAndCriteriaProcessor.processCriteria(TestBean.class,new EqualCriteria<OperandSource>("b", "code", new UpperOperand("Homer"))));
			assertEquals("equals", "UPPER(b.CODE)=UPPER('Homer')", OperatorAndCriteriaProcessor.processCriteria(TestBean.class,new EqualCriteria<OperandSource>(new UpperOperand("b", (Object)"code", false), new UpperOperand("Homer"))));
			
			assertEquals("equals", "b.CODE=UPPER('D''oh!')", OperatorAndCriteriaProcessor.processCriteria(TestBean.class,new EqualCriteria<OperandSource>("b", "code", new UpperOperand("D'oh!"))));
			
			assertEquals("equals", "UPPER(b.CODE)=UPPER('Homer')", OperatorAndCriteriaProcessor.processCriteria(TestBean.class,new EqualCriteria<OperandSource>(new UpperOperand("b", (Object)"code", false), new UpperOperand("Homer")), JdbcDrivers.FIREBIRD));
			
			assertEquals("equals", "double=0.00001", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<Double>("double", 0.00001)));
			assertEquals("equals", "double=0.00001", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<OperandSource>("double", new OperandSource(0.00001))));
			
			assertEquals("equals", "double=1000000000", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<Double>("double", 1000000000.0)));
			assertEquals("equals", "double=1000000000", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<OperandSource>("double", new OperandSource(1000000000.0))));			
			
			assertEquals("equals", "double=-0.00001", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<Double>("double", -0.00001)));
			assertEquals("equals", "double=-0.00001", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<OperandSource>("double", new OperandSource(-0.00001))));
			
			assertEquals("equals", "double=-1000000000", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<Double>("double", -1000000000.0)));
			assertEquals("equals", "double=-1000000000", OperatorAndCriteriaProcessor.processCriteria(new EqualCriteria<OperandSource>("double", new OperandSource(-1000000000.0))));
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}	
	


}

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
import org.liveSense.misc.queryBuilder.criterias.EqualCriteria;
import org.liveSense.misc.queryBuilder.criterias.InCriteria;
import org.liveSense.misc.queryBuilder.criterias.LikeCriteria;
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;

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
		stringValue1Array = new String[]{"str1"};
		stringValueMultiArray = new String[]{"str1", "str2", "str3"};

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
			assertEquals("Equals Integer", "integer=1", new EqualCriteria<Integer>("integer", 1).process());
			assertEquals("Equals Long", "long=1", new EqualCriteria<Long>("long", new Long(1)).process());
			assertEquals("Equals String", "string='str'", new EqualCriteria<String>("string", "str").process());
			assertEquals("Equals Date", "date='2000.12.31'", new EqualCriteria<Date>("date", df.parse("2000.12.31")).process());
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}

	}
	
	@Test
	public void BetweenCriteriaTest() {
		try {
			assertEquals("Between Integer", "integer BETWEEN 1 AND 2", new BetweenCriteria<Integer>("integer", 1, 2).process());
			assertEquals("Between Long", "long BETWEEN 1 AND 2", new BetweenCriteria<Long>("long", new Long(1), new Long(2)).process());
			assertEquals("Between String", "string BETWEEN 'str1' AND 'str2'", new BetweenCriteria<String>("string", "str1", "str2").process());
			assertEquals("Between Date", "date BETWEEN '2000.01.01' AND '2000.12.31'", new BetweenCriteria<Date>("date", df.parse("2000.01.01"), df.parse("2000.12.31")).process());
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}

	}

	@Test
	public void LikeCriteriaTest() {
		try {
			assertEquals("Like String", "string LIKE 'str1%'", new LikeCriteria<String>("string", "str1").process());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException"+e.getMessage());
		}
	}

	@Test (expected = QueryBuilderException.class)
	public void LikeCriteriaTest_Integer() throws QueryBuilderException {
			assertEquals("Like Integer", "integer LIKE '1%'", new LikeCriteria<Integer>("integer", 1).process());
	}

	@Test (expected = QueryBuilderException.class)
	public void LikeCriteriaTest_Long() throws QueryBuilderException {
			assertEquals("Like Long", "integer LIKE '1%'", new LikeCriteria<Long>("long", new Long(1)).process());
	}

	@Test (expected = QueryBuilderException.class)
	public void LikeCriteriaTest_Date() throws QueryBuilderException {
		try {
			assertEquals("Like Date", "date LIKE '2000.12.31%'", new LikeCriteria<Date>("date", df.parse("2000.12.31")).process());
		} catch (ParseException e) {
			fail("ParseException"+e.getMessage());
		}
	}

	@Test
	public void InCriteriaTest() {
			try {
				assertEquals("In Integer 1 value (List)", "integer IN (1)", new InCriteria<Integer>("integer", intValue1List).process());
				assertEquals("In Integer 1 value (List)", "integer IN (1)", new InCriteria<Integer>("integer", intValue1Array).process());
				assertEquals("In Integer multi value (List)", "integer IN (1,2,3)", new InCriteria<Integer>("integer", intValueMultiList).process());
				assertEquals("In Integer multi value (List)", "integer IN (1,2,3)", new InCriteria<Integer>("integer", intValueMultiArray).process());

				assertEquals("In Long 1 value (List)", "long IN (1)", new InCriteria<Long>("long", longValue1List).process());
				assertEquals("In Long 1 value (List)", "long IN (1)", new InCriteria<Long>("long", longValue1Array).process());
				assertEquals("In Long multi value (List)", "long IN (1,2,3)", new InCriteria<Long>("long", longValueMultiList).process());
				assertEquals("In Long multi value (List)", "long IN (1,2,3)", new InCriteria<Long>("long", longValueMultiArray).process());

				assertEquals("In String 1 value (List)", "string IN ('str1')", new InCriteria<String>("string", stringValue1List).process());
				assertEquals("In String 1 value (List)", "string IN ('str1')", new InCriteria<String>("string", stringValue1Array).process());
				assertEquals("In String multi value (List)", "string IN ('str1','str2','str3')", new InCriteria<String>("string", stringValueMultiList).process());
				assertEquals("In String multi value (List)", "string IN ('str1','str2','str3')", new InCriteria<String>("string", stringValueMultiArray).process());

				assertEquals("In Date 1 value (List)", "date IN ('2001.12.31')", new InCriteria<Date>("date", dateValue1List).process());
				assertEquals("In Date 1 value (List)", "date IN ('2001.12.31')", new InCriteria<Date>("date", dateValue1Array).process());
				assertEquals("In Date multi value (List)", "date IN ('2001.12.31','2002.12.31','2003.12.31')", new InCriteria<Date>("date", dateValueMultiList).process());
				assertEquals("In Date multi value (List)", "date IN ('2001.12.31','2002.12.31','2003.12.31')", new InCriteria<Date>("date", dateValueMultiArray).process());

			} catch (QueryBuilderException e) {
				fail("QueryBuilderException"+e.getMessage());
			}
	}

}

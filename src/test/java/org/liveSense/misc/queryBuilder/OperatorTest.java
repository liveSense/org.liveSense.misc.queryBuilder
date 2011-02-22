package org.liveSense.misc.queryBuilder;


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.liveSense.misc.queryBuilder.criterias.EqualCriteria;
import org.liveSense.misc.queryBuilder.exception.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operators.AndOperator;

import static org.junit.Assert.*;

public class OperatorTest {

	private SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test (expected = QueryBuilderException.class)
	public void andOperator_withInvalidObject() throws QueryBuilderException {
		new AndOperator(new Object[]{new Object()}).process(null);
	}
	
	@Test
	public void andOperator_withValidObjects() {
		try {
			assertEquals("Null parameter", "", new AndOperator(null).process(null));
			assertEquals("Empty object[] parameter", "", new AndOperator(new Object[]{}).process(null));
			
			assertEquals("Simple object[] parameter", "(size=12)", new AndOperator(new Object[]{new EqualCriteria<Integer>("size", 12)}).process(null));
			assertEquals("Multiple object[] parameter", "(a1=11 AND name='valami')", new AndOperator(new Object[]{new EqualCriteria<Integer>("a1", 11), 
					new EqualCriteria<String>("name", "valami"),}).process(null));
			assertEquals("Multiple object[] and Operator parameter", "(size=12 AND (a1=11 AND name='valami') AND test='2000.01.01')", 
			new AndOperator(
					new Object[]{
							new EqualCriteria<Integer>("size", 12), 
							new AndOperator(
									new Object[] {
											new EqualCriteria<Integer>("a1", 11), 
											new EqualCriteria<String>("name", "valami"),
									}), 
							new EqualCriteria<Date>("test",df.parse("2000.01.01") )
					}
			).process(null));

		} catch (QueryBuilderException e) {
			fail("QueryBuilderException: "+e.getMessage());
		} catch (ParseException e) {
			fail("ParseException: "+e.getMessage()); 
		}
	}
}

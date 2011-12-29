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
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operators.AndOperator;
import org.liveSense.misc.queryBuilder.operators.NotOperator;
import org.liveSense.misc.queryBuilder.operators.OrOperator;

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
		OperatorAndCriteriaProcessor.processOperator(new AndOperator(new Object[]{new Object()}));
	}
	
	@Test
	public void andOperator_withValidObjects() {
		try {
			assertEquals("Null parameter", "", OperatorAndCriteriaProcessor.processOperator(new AndOperator(null)));
			assertEquals("Empty object[] parameter", "", OperatorAndCriteriaProcessor.processOperator(new AndOperator(new Object[]{})));
			
			assertEquals("Simple object[] parameter", "(size=12)", OperatorAndCriteriaProcessor.processOperator(new AndOperator(new Object[]{new EqualCriteria("size", 12)})));
			assertEquals("Multiple object[] parameter", "(a1=11 AND name='valami')", OperatorAndCriteriaProcessor.processOperator(new AndOperator(new Object[]{new EqualCriteria("a1", 11), 
					new EqualCriteria("name", "valami"),})));
			assertEquals("Multiple object[] and Operator parameter", "(size=12 AND (a1=11 AND name='valami') AND test='2000.01.01')", 
				OperatorAndCriteriaProcessor.processOperator(new AndOperator(
					new Object[]{
							new EqualCriteria("size", 12), 
							new AndOperator(
									new Object[] {
											new EqualCriteria("a1", 11), 
											new EqualCriteria("name", "valami"),
									}), 
							new EqualCriteria("test",df.parse("2000.01.01") )
					}
			)));

		} catch (QueryBuilderException e) {
			fail("QueryBuilderException: "+e.getMessage());
		} catch (ParseException e) {
			fail("ParseException: "+e.getMessage()); 
		}
	}
	
	@Test (expected = QueryBuilderException.class)
	public void orOperator_withInvalidObject() throws QueryBuilderException {
		OperatorAndCriteriaProcessor.processOperator(new OrOperator(new Object[]{new Object()}));
	}
	
	@Test
	public void orOperator_withValidObjects() {
		try {
			assertEquals("Null parameter", "", OperatorAndCriteriaProcessor.processOperator(new OrOperator(null)));
			assertEquals("Empty object[] parameter", "", OperatorAndCriteriaProcessor.processOperator(new OrOperator(new Object[]{})));
			
			assertEquals("Simple object[] parameter", "(size=12)", OperatorAndCriteriaProcessor.processOperator(new OrOperator(new Object[]{new EqualCriteria("size", 12)})));
			assertEquals("Multiple object[] parameter", "(a1=11 OR name='valami')", OperatorAndCriteriaProcessor.processOperator(new OrOperator(new Object[]{new EqualCriteria("a1", 11), 
					new EqualCriteria("name", "valami"),})));
			assertEquals("Multiple object[] and Operator parameter", "(size=12 OR (a1=11 OR name='valami') OR test='2000.01.01')", 
				OperatorAndCriteriaProcessor.processOperator(new OrOperator(
					new Object[]{
							new EqualCriteria("size", 12), 
							new OrOperator(
									new Object[] {
											new EqualCriteria("a1", 11), 
											new EqualCriteria("name", "valami"),
									}), 
							new EqualCriteria("test",df.parse("2000.01.01") )
					}
			)));

		} catch (QueryBuilderException e) {
			fail("QueryBuilderException: "+e.getMessage());
		} catch (ParseException e) {
			fail("ParseException: "+e.getMessage()); 
		}
	}
	
	@Test (expected = QueryBuilderException.class)
	public void notOperator_withInvalidObject() throws QueryBuilderException {
		OperatorAndCriteriaProcessor.processOperator(new NotOperator(new Object[]{new Object()}));
	}
	
	@Test
	public void notOperator_withValidObjects() {
		try {
			assertEquals("Null parameter", "", OperatorAndCriteriaProcessor.processOperator(new NotOperator(null)));
			assertEquals("Empty object[] parameter", "", OperatorAndCriteriaProcessor.processOperator(new NotOperator(new Object[]{})));
			
			assertEquals("Simple object[] parameter", "(NOT size=12)", OperatorAndCriteriaProcessor.processOperator(new NotOperator(new Object[]{new EqualCriteria("size", 12)})));
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException: "+e.getMessage());
		}
	}	
}

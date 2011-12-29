package org.liveSense.misc.queryBuilder;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.liveSense.misc.queryBuilder.criterias.EqualCriteria;
import org.liveSense.misc.queryBuilder.domains.Operator;
import org.liveSense.misc.queryBuilder.exceptions.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operators.AndOperator;

public class SimpleSQLQueryBuilderTest {

	private Operator params;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		params = new AndOperator(new Object[]{new EqualCriteria("size", 12)});
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetBaseQuery() {
		try {
			assertEquals("Simple query without parameters", "", (new SimpleSQLQueryBuilder(null)).buildWhere());
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException: " + e.getMessage());
		}
	}

	@Test
	public void testSimpleSQLQueryBuilderString() {
		try {
			assertEquals("Simple query with empty parameter", "", (new SimpleSQLQueryBuilder(null, (Operator)null)).buildWhere());			
			assertEquals("Simple query with single parameter", "(size=12)", (new SimpleSQLQueryBuilder(null, params)).buildWhere());
			assertEquals("Simple query with single parameter", "(size=12)", (new SimpleSQLQueryBuilder(null)).buildWhere(params));
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException: " + e.getMessage());
		}
	}
 
}

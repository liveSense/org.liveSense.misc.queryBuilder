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

public class QueryBuilderTest {

	private QueryBuilder sampleQueryBuilder;
	private Operator params;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sampleQueryBuilder = new QueryBuilder() {
			@Override
			public String getQuery() {
				return null;
			}
		};
		
		params = new AndOperator(new Object[]{new EqualCriteria("size", 12)});
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuild() {
		try {
			assertEquals("Simple query without parameters", "", sampleQueryBuilder.buildWhere());
			assertEquals("Simple query with parameters", "(size=12)", sampleQueryBuilder.buildWhere(params));
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException: "+e.getMessage());
		}
	}

}

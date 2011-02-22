package org.liveSense.misc.queryBuilder;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.liveSense.misc.queryBuilder.criterias.EqualCriteria;
import org.liveSense.misc.queryBuilder.exception.QueryBuilderException;
import org.liveSense.misc.queryBuilder.operators.AndOperator;
import org.liveSense.misc.queryBuilder.querybuilder.QueryBuilder;

public class QueryBuilderTest {

	private QueryBuilder sampleQueryBuilder;
	private Object params;

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
		
		params = new AndOperator(new Object[]{new EqualCriteria<Integer>("size", 12)});
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuild() {
		try {
			assertEquals("Simple query without parameters", "", sampleQueryBuilder.buildParameters());
			assertEquals("Simple query with parameters", "(size=12)", sampleQueryBuilder.buildParameters(params));
		} catch (QueryBuilderException e) {
			fail("QueryBuilderException: "+e.getMessage());
		}
	}

}

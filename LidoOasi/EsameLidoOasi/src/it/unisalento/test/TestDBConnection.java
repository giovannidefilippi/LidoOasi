package it.unisalento.test;

import static org.junit.Assert.*;
import it.unisalento.DbInterface.DbConnection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDBConnection {
DbConnection dbc;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		dbc=DbConnection.getInstance();
		
	}

	@After
	public void tearDown() throws Exception {
		dbc.disconnetti();
	}

	
	@Test
	public void testisConnesso() {
		assertTrue(dbc.isConnesso());
	}


}

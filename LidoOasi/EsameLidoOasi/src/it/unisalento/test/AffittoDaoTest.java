package it.unisalento.test;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import it.unisalento.business.AffittoBusiness;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AffittoDaoTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testAffittoMaxId() 
	{
		int max =AffittoBusiness.getInstance().getMaxIdAffitto();
		AffittoBusiness.getInstance().registraAffitto(max+1, 0, 12, new GregorianCalendar(2010,0,02),
				new GregorianCalendar(2010,1,23), "si", "si", "si", 101, 500.00);
		int nuovoMax = AffittoBusiness.getInstance().getMaxIdAffitto();
		assertTrue(nuovoMax == (max +1));
		AffittoBusiness.getInstance().cancellaAffitto(nuovoMax);
	}

	

}

package it.unisalento.test;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import it.unisalento.business.ClienteBusiness;
import it.unisalento.model.Cliente;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest 
{
	Cliente c;
	boolean esiste = false;

	@Before
	public void setUp() throws Exception 
	{
		c = new Cliente(101, "Giovanni", "De Filippi","GioDef",
				48, 'm', "giovanni@libero.it") ;
		esiste = ClienteBusiness.getInstance().verificaUsername(101);
		c.setDataRegistrazione(new GregorianCalendar(2014,0,29));
		c.setOperatorelido(0);
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testVerifica()
	{
		assertTrue(esiste);
	}

	
	@Test
	public void testRecupera() {
		Cliente b = ClienteBusiness.getInstance().trovaCliente(101);
		GregorianCalendar data = b.getDataRegistrazione();
		assertEquals(data,c.getDataRegistrazione() );
	}

}

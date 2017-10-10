package it.unisalento.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import it.unisalento.business.SistemaBusiness;
import it.unisalento.dao.SistemaDao;
import it.unisalento.model.Cabina;
import it.unisalento.model.Ombrellone;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SistemaBusinessTest 
{
	Cabina cabina;
	ArrayList<Ombrellone> ombrelloni;
	ArrayList<Cabina> cabine;

	@Before
	public void setUp() throws Exception 
	{
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testLiberaTutti() 
	{
		SistemaBusiness.getInstance().liberaTutti();
		ombrelloni = SistemaBusiness.getInstance().verificaOmbrelloni();
		for(Ombrellone o : ombrelloni )
		{
			assertFalse(o.isOccupato());
		}
	}

	@Test
	public void testOccupaCabina() 
	{
		
		SistemaBusiness.getInstance().occupaCabina(12);
		cabine = SistemaBusiness.getInstance().verificaCabine();
		cabina = cabine.get(1);
		assertTrue(cabina.isOccupato());   // la cabina si mette a posto da sola alla chiamata del Frame
	}



}

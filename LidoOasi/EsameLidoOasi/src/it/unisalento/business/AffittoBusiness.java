package it.unisalento.business;

import java.util.GregorianCalendar;

import it.unisalento.model.Affitto;
import it.unisalento.model.Noleggio;

public class AffittoBusiness
{
private static AffittoBusiness instance;
	
	//SINGLETON
	public static AffittoBusiness getInstance()
	{
		if(instance == null)
			instance = new AffittoBusiness();
		return instance;
	}
	
	public int getMaxIdAffitto()
	{
		Affitto aff = new Affitto();
		return aff.getMaxId();
	}
	
	public Affitto trovaAffitto(int IdAffitto)
	{
		Affitto a = new Affitto( IdAffitto);
		return a.recupera();
	}	
	
	public boolean registraAffitto(int idAffitto, int operatorelido, int cabina,
			GregorianCalendar inizio,GregorianCalendar fine,
			String acquaCorrente, String elettricità, String asciugamani,
			int idCliente, double costo)
	{
		Affitto a = new Affitto(idAffitto,operatorelido,cabina,
		                       inizio,fine,
				 	acquaCorrente, elettricità, asciugamani,
				idCliente, costo);
		//c.setOperatorelido(codice);
		return a.registra();
	}
	
/**
 * Metodo chiamato dalla classe di Test
 * per cancellare l'affitto di prova
 * @param l'id affitto da cancellare
 * @param nuovoMax
 * @return true se l'affitto è stato cancellato
 */
	
	public boolean cancellaAffitto(int nuovoMax)
	{
		Affitto a = new Affitto(nuovoMax);
		return(a.deleteAffitto());
	}
}
	
	
	
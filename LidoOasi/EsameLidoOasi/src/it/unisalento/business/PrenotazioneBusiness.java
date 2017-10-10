package it.unisalento.business;

import java.util.GregorianCalendar;
import it.unisalento.model.Prenotazione;

public class PrenotazioneBusiness 
{
private static PrenotazioneBusiness instance;
	
	//SINGLETON
	public static PrenotazioneBusiness getInstance()
	{
		if(instance == null)
			instance = new PrenotazioneBusiness();
		return instance;
	}
	
	public int getMaxIdPrenotazione()
	{
		Prenotazione pren = new Prenotazione();
		return pren.getMaxId();
	}

	public Prenotazione trovaPrenotazione(int IdPrenotazione)
	{
		Prenotazione p = new Prenotazione(IdPrenotazione);
		return p.recupera();
	}	
	
	
	public boolean registraPrenotazione(int idPrenotazione,int cabina, int  idCliente, 
			GregorianCalendar inizio,GregorianCalendar fine,
			String elettricità, String acquaCorrente, String asciugamani,
			 double costo)
	{
		Prenotazione p = new Prenotazione(idPrenotazione,cabina,idCliente,inizio,fine,
				 	elettricità,acquaCorrente, asciugamani,costo);
		//c.setOperatorelido(codice);
		return p.registra();
	}
/**
 * Setta a 'confermata' la prenotazione indicata	
 * @param idPrenotazione
 * @return true se la prenotazione è stata 'confermata' sul Db
 */

	public boolean brucia(int idPrenotazione)
	{
		Prenotazione p = new Prenotazione();
		return p.cancella(idPrenotazione);
	}
	
}

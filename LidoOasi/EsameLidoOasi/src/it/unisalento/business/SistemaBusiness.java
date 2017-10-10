package it.unisalento.business;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import it.unisalento.model.Affitto;
import it.unisalento.model.Cabina;
import it.unisalento.model.Noleggio;
import it.unisalento.model.Ombrellone;
import it.unisalento.model.Prenotazione;
import it.unisalento.model.Sistema;

public class SistemaBusiness
{
private static SistemaBusiness instance;
	
	//SINGLETON
	public static SistemaBusiness getInstance()
	{
		if(instance == null)
			instance = new SistemaBusiness();
		return instance;
	}
	
public boolean liberaTutti()
	
	{
		Sistema sistema = new Sistema();
		return(sistema.libera());
	}
	public  ArrayList<Ombrellone> verificaOmbrelloni()
	{
		Sistema sistema = new Sistema();
		return sistema.inizializzaOmbrelloni();
	}

public boolean occupaOmbrellone(int idOmbrellone)
{
	Sistema sistema = new Sistema();
	return sistema.blindaOmbrellone(idOmbrellone);
}
	
public ArrayList<Cabina> verificaCabine()
   {
	Sistema sistema = new Sistema();
	return sistema.inizializzaCabine();
   }
public boolean occupaCabina(int idCabina)
{
	Sistema sistema = new Sistema();
	return sistema.blindaCabina(idCabina);
}

public boolean prenotaCabina(int idCabina)
{
	Sistema sistema = new Sistema();
	return sistema.fermaCabina(idCabina);
}

/**
 * Controlla che la data inizio di un affitto futuro
 * non si sovrapponga ad un altro affitto.
 *  
 * @return vero se la srcittura sul db è possibile
 */
public boolean controlloScritturaAffitti(GregorianCalendar dataIn,GregorianCalendar dataFin,int idCabina)
   {
	Sistema sistema = new Sistema();
	return sistema.controlloScrittura(dataIn,dataFin,idCabina);
	}

public void resettaCabine()
  {
	Sistema sistema = new Sistema();
	sistema.resetDb();
   }


/**
 * Prende tutte le prenotazioni non confermate
 * @return un Array di Prenotazione
 */
	public ArrayList<Prenotazione> getPrenotazioniNon()
	{
		Sistema sistema = new Sistema();
		return sistema.getPrenotazioni();
	}
/**
 * Prende tutte le prenotazioni relative ad un dato cliente
 * 
 * @param idCliente il codice del cliente
 * @return un Array di Prenotazione
 */
public ArrayList<Prenotazione> getTuttePrenotazioni(int idCliente)
{
  Sistema sistema = new Sistema();
	return sistema.getTuttePrenotazioni(idCliente);
}
				
/**
* Prende tutti gli affitti relativi ad un dato cliente
* @param idCliente il codice del cliente
* @return un Array di Affitto
 */
public ArrayList<Affitto> getTuttiAffitti(int idCliente)
{
	Sistema sistema = new Sistema();
	return sistema.getTuttiAffitti(idCliente);
}
						
/**
* Prende tutti i noleggi relativi ad un dato cliente
* @param idCliente il codice del cliente
* @return un Array di Noleggio
*/
	public ArrayList<Noleggio> getTuttiNoleggi(int idCliente)
	{
		Sistema sistema = new Sistema();
	     return sistema.getTuttiNoleggi(idCliente);

	}
	
/**
 * Controlla lo stato delle cabine nel periodo indicato
 * @param in
 * @param out
 * @return un'array di cabine con lo stato settato a occupato 
 * se la cabina è affittata nel periodo indicato
 */

/*public Cabina []  periodoPrenotazione(GregorianCalendar in,GregorianCalendar out)
   {
	
	Sistema sistema = new Sistema();
	 return sistema.controllaPeriodo(in,out);
	
	}

 public ArrayList<Cabina> crea()
{
	ArrayList<Cabina> cabine = new ArrayList<Cabina>();
	
	for(int i = 0; i<10;i++)
	{
	Cabina cabb = new Cabina(i+11,false);
	cabine.add(cabb);
	}
	return cabine;
	}
*/

	}
	

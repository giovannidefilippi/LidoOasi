package it.unisalento.model;

import it.unisalento.dao.SistemaDao;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Sistema 
{
	private ArrayList<Ombrellone> ombrelloni;
	private ArrayList<Cabina> cabine;
	private ArrayList<Affitto> affitti;
	private ArrayList<Prenotazione>  prenotazioni;
	public static final int  NUMERO_PRIMA_CABINA = 11;
	public static final int  NUMERO_ULTIMA_CABINA = 20;
	
	public Sistema()
	{
		ombrelloni = new ArrayList<Ombrellone>();
		cabine =   new ArrayList<Cabina>();
		affitti = new ArrayList<Affitto>();
		prenotazioni = new ArrayList<Prenotazione>();
	}
		
	public ArrayList<Ombrellone> getOmbrelloni() {
		return ombrelloni;
	}

	public void setOmbrelloni(ArrayList<Ombrellone> ombrelloni) {
		this.ombrelloni = ombrelloni;
	}

	public ArrayList<Cabina> getCabine() {
		return cabine;
	}

	public void setCabine(ArrayList<Cabina> cabine) {
		this.cabine = cabine;
	}
	
	public ArrayList<Affitto> getAffitti() {
		return affitti;
	}

	public void setAffitti(ArrayList<Affitto> affitti) {
		this.affitti = affitti;
	}

	public boolean libera()
	{
		return(SistemaDao.getInstance().liberaOmbrelloni());
	}
	
	public ArrayList<Ombrellone> inizializzaOmbrelloni()
	{
		
		return(SistemaDao.getInstance().acquisisciOmbrelloni(this));
		
	}
	
	public boolean blindaOmbrellone(int idOmbrellone)
	{
		return(SistemaDao.getInstance().arrossaOmbrellone(idOmbrellone));
	}
	
	public ArrayList<Cabina> inizializzaCabine()
	{
		
		return(SistemaDao.getInstance().acquisisciCabine(this));
		
	}

	public boolean blindaCabina(int idCabina)
	{
		return(SistemaDao.getInstance().arrossaCabina(idCabina));
	}
	
	public boolean fermaCabina(int idCabina)
	{
		return(SistemaDao.getInstance().ingiallaCabina(idCabina));
	}
	
	public boolean controlloScrittura(GregorianCalendar in,GregorianCalendar out,int idCabina)
	{
		boolean flag = true;
		affitti = SistemaDao.getInstance().getAffitti(this,idCabina);
		
		for(Affitto a : affitti)
		{
			
		    GregorianCalendar inizio = a.getDataInizio();
			GregorianCalendar fine = a.getDataFine();
			
			if(!(in.after(fine) && out.before(inizio)|| out.before(inizio)||in.after(fine)))
				{
				flag =false;
				break;
				}
			
			}
			
		return flag;
		
	}
	
	
public void resetDb()
{
	SistemaDao.getInstance().liberaCabine();
  for(int i = NUMERO_PRIMA_CABINA;i<=NUMERO_ULTIMA_CABINA;i++)
	{
			boolean affittato = SistemaDao.getInstance().isAffittoInCorso(i);
			  if(affittato)
			  {
				  SistemaDao.getInstance().arrossaCabina(i);
			  }
			  else
			  {
				  boolean prenotato = SistemaDao.getInstance().isPrenotata(i);
				   if(prenotato)
				   {
					   SistemaDao.getInstance().ingiallaCabina(i);
				   }
				  
			  }
		}
			
	  }

   public ArrayList<Prenotazione> getPrenotazioni() 
   {
	   prenotazioni = SistemaDao.getInstance().prendiPrenotazioni();
	
	   return prenotazioni;
     }

   public void setPrenotazioni(ArrayList<Prenotazione> prenotazioni) 
   {
	this.prenotazioni = prenotazioni;
   }

	
/**
* Prende tutte le prenotazioni relative ad un dato cliente
* 
* @param idCliente il codice del cliente
* @return un Array di Prenotazione
*/
public ArrayList<Prenotazione> getTuttePrenotazioni(int idCliente)
{
 
	return SistemaDao.getInstance().getTuttePrenotazioni(idCliente);
}
				
/**
* Prende tutti gli affitti relativi ad un dato cliente
* @param idCliente il codice del cliente
* @return un Array di Affitto
*/
public ArrayList<Affitto> getTuttiAffitti(int idCliente)
{
	
	return SistemaDao.getInstance().getTuttiAffitti(idCliente);
}
						
/**
* Prende tutti i noleggi relativi ad un dato cliente
* @param idCliente il codice del cliente
* @return un Array di Noleggio
*/
	public ArrayList<Noleggio> getTuttiNoleggi(int idCliente)
	{
		
	     return SistemaDao.getInstance().getTuttiNoleggi(idCliente);

	}
/**
 * Metodo che compara la scelta del periodo indicato 
 * con la situazione affiti reale
 * 
 * @param in
 * @param out
 * @param idCabina
 * @return true se nel periodo selezionato nn ci sono affitti
 */
	
	/*
	public Cabina[] controllaPeriodo(GregorianCalendar in,GregorianCalendar out)
	{
		Cabina [] cabineVuote = new Cabina[10];
		
	for (int i = 0; i < cabineVuote.length  ;i++)
	   {
		affitti = SistemaDao.getInstance().getAffitti(this,i+10);
		cabineVuote[i] = new Cabina();
		for(Affitto a : affitti)
		{
			
		    GregorianCalendar inizio = a.getDataInizio();
			GregorianCalendar fine = a.getDataFine();
			
			if(!(in.after(fine) && out.before(inizio)|| out.before(inizio)||in.after(fine)))
				{
				cabineVuote[i].setPrenotato(true);
				break;
				}
			else
				cabineVuote[i].setPrenotato(false);
			}
			
		
	    }

	return cabineVuote;
	
  }
  */
}
	


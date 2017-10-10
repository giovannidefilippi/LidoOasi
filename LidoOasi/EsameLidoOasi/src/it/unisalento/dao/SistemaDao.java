package it.unisalento.dao;

import it.unisalento.DbInterface.DbConnection;
import it.unisalento.model.Affitto;
import it.unisalento.model.Cabina;
import it.unisalento.model.Dimensione;
import it.unisalento.model.Noleggio;
import it.unisalento.model.Ombrellone;
import it.unisalento.model.Prenotazione;
import it.unisalento.model.Sistema;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;

public class SistemaDao 
{
private static  SistemaDao instance;
	
	public static SistemaDao getInstance()
	{
		if(instance==null)
		{	
			instance = new SistemaDao();
		}
		return instance;
	}
	
	public boolean liberaOmbrelloni()
	{
		//query
		DbConnection.getInstance().eseguiAggiornamento("update ombrellone set occupato = '0' ");
		
		return(true);
	}
	
	public ArrayList<Ombrellone> acquisisciOmbrelloni(Sistema sistema)
	  {
		    ArrayList<Ombrellone> ombrelloni = sistema.getOmbrelloni();
		    boolean occupato = false;
		   	Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("select * from Ombrellone ");
			
			Iterator<String[]> iter = risultato.iterator();
			
	while (iter.hasNext())
		{
			
			//int colonne = tupla.length;
			for (int i=1;i<=10;i++)
			   {
				String[] tupla = iter.next();
			if(Integer.parseInt(tupla[2]) == 1)
					occupato = true;
				else if (Integer.parseInt(tupla[2]) == 0)
					occupato = false;
				ombrelloni.add(new Ombrellone(Integer.parseInt(tupla[0]),Double.parseDouble(tupla[1]),occupato));
			   }
		}		
		return(ombrelloni);
	}

	

	public boolean arrossaOmbrellone(int idOmbrellone)
	{
		
		DbConnection.getInstance().eseguiAggiornamento("update ombrellone set occupato = '1' "+
		" where idOmbrellone = \'"+idOmbrellone+"\'");
		return(true);
	}
	
	public ArrayList<Cabina> acquisisciCabine(Sistema sistema)
	  {
		    ArrayList<Cabina> cabine = sistema.getCabine();
		    boolean occupato = false;
		    boolean prenotato = false;
		   	Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("select * from Cabina ");
			
			Iterator<String[]> iter = risultato.iterator();
			
	while (iter.hasNext())
		{
			
			//int colonne = tupla.length;
			for (int i=1;i<=10;i++)
			   {
				String[] tupla = iter.next();
							
				String tipo = tupla[4];
				Dimensione dim;   
				dim = DimensioneDao.getInstance().getDimensione(tipo);
				if(Integer.parseInt(tupla[2]) == 1)
					occupato = true;
				else if (Integer.parseInt(tupla[2]) == 0)
					occupato = false;
				
				if(Integer.parseInt(tupla[1]) == 1)
					prenotato = true;
				else if (Integer.parseInt(tupla[1]) == 0)
					prenotato = false;
				
				cabine.add(new Cabina(dim,prenotato,occupato,Double.parseDouble(tupla[3])));
			   }
		}		
		return(cabine);
	}
	
	
	public boolean arrossaCabina(int idCabina)
	{
		
		DbConnection.getInstance().eseguiAggiornamento("update cabina set occupato = '1' "+
		" where idCabina = \'"+idCabina+"\'");
		return(true);
	}

	
	public boolean ingiallaCabina(int idCabina)
	{
		
		DbConnection.getInstance().eseguiAggiornamento("update cabina set prenotato = '1' "+
		" where idCabina = \'"+idCabina+"\'");
		return(true);
	}
	
/**Acquisisce gli affitti relativi ad una data cabina
 * 
 * @param sistema
 * @param idCabina
 * @return un vettore con tutti gli affitti della cabina
 */
	
	
	public ArrayList<Affitto> getAffitti(Sistema sistema,int idCabina)
	  {
		    ArrayList<Affitto> affitti = sistema.getAffitti();
		   
		   	Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("select * from affitto "+
		   	" where Cabina = \'"+idCabina+"\'");
			
			Iterator<String[]> iter = risultato.iterator();
			
	while (iter.hasNext())
		{
			
			//int colonne = tupla.length;
			for (int i=0;i<risultato.size();i++)
			   {
				String[] tupla = iter.next();
							
				int annoIn = Integer.parseInt(tupla[2].substring(0,4));
				int meseIn = Integer.parseInt(tupla[2].substring(5,7));
				int giornoIn = Integer.parseInt(tupla[2].substring(8,10));
				
				int annoOut = Integer.parseInt(tupla[3].substring(0,4));
				int meseOut = Integer.parseInt(tupla[3].substring(5,7));
				int giornoOut = Integer.parseInt(tupla[3].substring(8,10));
				
				int cliente = Integer.parseInt(tupla[0]);
				
				affitti.add(new Affitto(new GregorianCalendar(annoIn,meseIn-1,giornoIn),
						new GregorianCalendar(annoOut,meseOut-1,giornoOut),cliente));
					
				
			   }
			}
				
		return(affitti);

	
		}
	
/**Verifica se alla data odierna la cabina è affittata
 * (cioè è
 * occupata)
 * 
 * @param idCabina
 * @return true se la cabina ha un affitto in corso
 */

	
	public boolean isAffittoInCorso(int idCabina)
	{
		//SINGLETON
				Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select DataInizio,DataFine from Affitto "+
				"where Cabina=\'"+ idCabina +"\' and DataInizio <= curdate() and DataFine >= curdate() " );
				
				return (result.size() == 1);
	}
	
/**Verifica se la cabina ha affitti in futuro
 * (cioè è prenotata)
 * 
 * @param idCabina
 * @return vero se risultano affitti futuri rispetto ad oggi
 */
	
	public boolean isPrenotata(int idCabina) 
	{
		//SINGLETON
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select DataInizio,DataFine from Affitto "+
				"where Cabina=\'"+ idCabina +"\' and DataInizio > curdate()  " );
				
				
				return (result.size() != 0);
	}
	
/**
 * Libera tutte le cabine ponendo a falso sia il flag prenotato
 * che quello occupato
 */
	
	public void liberaCabine()
	{
		DbConnection.getInstance().eseguiAggiornamento("update cabina set occupato = '0',prenotato = '0' ");
			
	}
	
	public  ArrayList<Prenotazione> prendiPrenotazioni()
	{
		
			    ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
			   
			   	Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("select * from prenotazione "+
			   	" where confermato =  '0'");
				
				Iterator<String[]> iter = risultato.iterator();
				
		while (iter.hasNext())
			{
				
				//int colonne = tupla.length;
				for (int i=0;i<risultato.size();i++)
				   {
					String[] tupla = iter.next();
					
					int cliente = Integer.parseInt(tupla[0]);
					int cabina = Integer.parseInt(tupla[1]);
					int id = Integer.parseInt(tupla[4]);
					
					String luce = tupla[5];
					String acqua = tupla[6];
					String asciugamani = tupla[7];
					
					double costo = Double.parseDouble(tupla[9]);
							
					int annoIn = Integer.parseInt(tupla[2].substring(0,4));
					int meseIn = Integer.parseInt(tupla[2].substring(5,7));
					int giornoIn = Integer.parseInt(tupla[2].substring(8,10));
					
					int annoOut = Integer.parseInt(tupla[3].substring(0,4));
					int meseOut = Integer.parseInt(tupla[3].substring(5,7));
					int giornoOut = Integer.parseInt(tupla[3].substring(8,10));
						
					prenotazioni.add(new Prenotazione(id,cabina,cliente,new GregorianCalendar(annoIn,meseIn-1,giornoIn),
							new GregorianCalendar(annoOut,meseOut-1,giornoOut),luce,acqua,asciugamani,costo));
						
					
				      }
				}
					
			    return(prenotazioni);		
			}
	
	
	///////////
	
	public  ArrayList<Prenotazione> getTuttePrenotazioni(int IdCliente)
	{
		
			    ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
			    
			   
			   	Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("select * from prenotazione "+
			   	" where Cliente = \'"+IdCliente+"\'");
				
				Iterator<String[]> iter = risultato.iterator();
				
		while (iter.hasNext())
			{
				
				//int colonne = tupla.length;
				for (int i=0;i<risultato.size();i++)
				   {
					String[] tupla = iter.next();
					boolean con = false;
					int cliente = IdCliente;
					int cabina = Integer.parseInt(tupla[1]);
					int id = Integer.parseInt(tupla[4]);
					
					String luce = tupla[5];
					String acqua = tupla[6];
					String asciugamani = tupla[7];
					
					double costo = Double.parseDouble(tupla[9]);
							
					int annoIn = Integer.parseInt(tupla[2].substring(0,4));
					int meseIn = Integer.parseInt(tupla[2].substring(5,7));
					int giornoIn = Integer.parseInt(tupla[2].substring(8,10));
					
					int annoOut = Integer.parseInt(tupla[3].substring(0,4));
					int meseOut = Integer.parseInt(tupla[3].substring(5,7));
					int giornoOut = Integer.parseInt(tupla[3].substring(8,10));
					
					int confer = Integer.parseInt(tupla[8]);
					 if (confer == 1)
						con = true;
					
					prenotazioni.add(new Prenotazione(id,cabina,cliente,new GregorianCalendar(annoIn,meseIn-1,giornoIn),
							new GregorianCalendar(annoOut,meseOut-1,giornoOut),luce,acqua,asciugamani,con,costo));
						
					
				      }
				}
					
			    return(prenotazioni);		
			}
	public  ArrayList<Affitto> getTuttiAffitti(int IdCliente)
	{
		
			    ArrayList<Affitto> affitti = new ArrayList<Affitto>();
			   
			   	Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("select * from Affitto "+
			   	" where Cliente = \'"+IdCliente+"\'");
				
				Iterator<String[]> iter = risultato.iterator();
				
		while (iter.hasNext())
			{
				
				//int colonne = tupla.length;
				for (int i=0;i<risultato.size();i++)
				   {
					String[] tupla = iter.next();
					
					int cliente = IdCliente;
					int cabina = Integer.parseInt(tupla[1]);
					int id = Integer.parseInt(tupla[4]);
					
					String luce = tupla[6];
					String acqua = tupla[5];
					String asciugamani = tupla[7];
					int operatore = Integer.parseInt(tupla[8]);
					double costo = Double.parseDouble(tupla[9]);
							
					int annoIn = Integer.parseInt(tupla[2].substring(0,4));
					int meseIn = Integer.parseInt(tupla[2].substring(5,7));
					int giornoIn = Integer.parseInt(tupla[2].substring(8,10));
					
					int annoOut = Integer.parseInt(tupla[3].substring(0,4));
					int meseOut = Integer.parseInt(tupla[3].substring(5,7));
					int giornoOut = Integer.parseInt(tupla[3].substring(8,10));
						
					affitti.add(new Affitto(id,operatore,cabina,new GregorianCalendar(annoIn,meseIn-1,giornoIn),
							new GregorianCalendar(annoOut,meseOut-1,giornoOut),acqua,luce,asciugamani,cliente,costo));
						
					
				      }
				}
					
			    return(affitti);		
			}
	
	public  ArrayList<Noleggio> getTuttiNoleggi(int IdCliente)
	{
		
			    ArrayList<Noleggio> noleggi = new ArrayList<Noleggio>();
			   
			   	Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("select * from noleggio "+
			   	" where cliente = \'"+IdCliente+"\'");
				
				Iterator<String[]> iter = risultato.iterator();
				
		while (iter.hasNext())
			{
				
				//int colonne = tupla.length;
				for (int i=0;i<risultato.size();i++)
				   {
					String[] tupla = iter.next();
					
					int cliente = IdCliente;
					int ombrellone = Integer.parseInt(tupla[2]);
					int id = Integer.parseInt(tupla[0]);
					int lettini =Integer.parseInt(tupla[4]);
					int operatore =Integer.parseInt(tupla[5]);
								
					double costo = Double.parseDouble(tupla[6]);
					
					
					int anno = Integer.parseInt(tupla[1].substring(0,4));
					int mese = Integer.parseInt(tupla[1].substring(5,7));
					int giorno = Integer.parseInt(tupla[1].substring(8,10));
						
					noleggi.add(new Noleggio(id,operatore,ombrellone,new GregorianCalendar(anno,mese-1,giorno),
							lettini,cliente,costo));
						
					
				      }
				}
					
			    return(noleggi);		
			}
		
	}


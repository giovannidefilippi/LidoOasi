package it.unisalento.dao;
import it.unisalento.DbInterface.DbConnection;
import it.unisalento.model.Prenotazione;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JOptionPane;

public class PrenotazioneDao
{
private static PrenotazioneDao instance;
	
	public static PrenotazioneDao getInstance()
	{
		if(instance==null)
		{	
			instance = new PrenotazioneDao();
		}
		return instance;
	}
	
	
	
	public int prenotazioneMaxId()
	{
		Vector<String[]> risultato=DbConnection.getInstance().eseguiQuery("select max(IdPrenotazione) from Prenotazione " );
		Iterator<String[]> iter = risultato.iterator();
		String[] tupla = iter.next();
		return Integer.parseInt(tupla[0]);
	}


	public Prenotazione getPrenotazione(Prenotazione p)
	{
		int idprenotazione = p.getIdPrenotazione();
		
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("select * from Prenotazione "+
				"where idPrenotazione=\""+ idprenotazione +"\"" );
		Prenotazione prenotazione = new Prenotazione(idprenotazione);
		
		if (risultato.size() == 1)
		{
		Iterator<String[]> iter = risultato.iterator();
		String[] tupla = iter.next();
		
		prenotazione.setCabina(Integer.parseInt(tupla[1])) ;
		prenotazione.setIdCliente(Integer.parseInt(tupla[0]));
		
		prenotazione.setAcquaCorrente(tupla[6]);
		prenotazione.setElettricità(tupla[5]);
		prenotazione.setAsciugamani(tupla[7]);
				
		
		prenotazione.setCosto(Double.parseDouble(tupla[9]));
		
		int annoI = Integer.parseInt(tupla[2].substring(0,4));
		int meseI = Integer.parseInt(tupla[2].substring(5,7));
		int giornoI = Integer.parseInt(tupla[2].substring(8,10));
		
		int annoF = Integer.parseInt(tupla[3].substring(0,4));
		int meseF = Integer.parseInt(tupla[3].substring(5,7));
		int giornoF = Integer.parseInt(tupla[3].substring(8,10));
			
		prenotazione.setDataInizio(new GregorianCalendar(annoI,meseI-1,giornoI));
		prenotazione.setDataFine(new GregorianCalendar(annoF,meseF-1,giornoF));
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Numero Prenotazione non trovato.Controlla e ripeti operazione.");
		}
		
		return(prenotazione); 
	}
	
	public boolean inserisciPrenotazione(Prenotazione pren)
	{
		
		
		Vector<String[]> risultato1= DbConnection.getInstance().eseguiQuery("select count(*) from Prenotazione " );
		Iterator<String[]> iter1 = risultato1.iterator();
		String[] tupla1 = iter1.next();
		int countPrima = Integer.parseInt(tupla1[0]);
		
		
				
		int idPren = pren.getIdPrenotazione();
		int cab = pren.getCabina();
		int cl = pren.getIdCliente();
		double costo = pren.getCosto();
		String acqua = pren.getAcquaCorrente();
		String luce = pren.getElettricità();
		String asciugamani = pren.getAsciugamani();
		
		GregorianCalendar out = pren.getDataFine();
		GregorianCalendar in = pren.getDataInizio();
		
		if (in == null || out ==null)
		{
			
		      DbConnection.getInstance().eseguiAggiornamento("insert into prenotazione(Cliente,Cabina,DataInizio,"+
				"DataFine,IdPrenotazione,Elettricità,AcquaCorrente,Asciugamani,Confermato,CostoTotale)"+
				"values(\'"+cl+"\',\'"+cab+"\',curdate(),curdate(),\'"+idPren+
				"\',\'"+luce+"\',\'"+acqua+"\',\'"+asciugamani+"\',\'"+false+"\',\'"+costo+"\')");
		}
		
		else
		{
			long millIn = in.getTimeInMillis();
			long millOut =out.getTimeInMillis();
			
			Date dataIn = new Date(millIn);
			Date dataOut = new Date(millOut);
			

		      DbConnection.getInstance().eseguiAggiornamento("insert into prenotazione(Cliente,Cabina,DataInizio,"+
				"DataFine,IdPrenotazione,Elettricità,AcquaCorrente,Asciugamani,Confermato,CostoTotale)"+
				"values(\'"+cl+"\',\'"+cab+"\',\'"+dataIn+"\',\'"+dataOut+"\',\'"+idPren+
				"\',\'"+luce+"\',\'"+acqua+"\',\'"+asciugamani+"\',\'"+0+"\',\'"+costo+"\')");
			
			
		}
		Vector<String[]> risultato2 =DbConnection.getInstance().eseguiQuery("select count(*) from Prenotazione " );
		Iterator<String[]> iter2 = risultato2.iterator();
		String[] tupla2 = iter2.next();
		int countDopo = Integer.parseInt(tupla2[0]);
		
		if (countPrima == countDopo)
			return(false);
		else 
			return(true);
		
	}
	
	public boolean settaPrenotata(int idPrenotazione)
	{
		Vector<String[]> risultato1= DbConnection.getInstance().eseguiQuery("select count(*) from Prenotazione "+
	" where confermato = '1'" );
		Iterator<String[]> iter1 = risultato1.iterator();
		String[] tupla1 = iter1.next();
		int countPrima = Integer.parseInt(tupla1[0]);
		
		DbConnection.getInstance().eseguiAggiornamento("update prenotazione set confermato = '1' "+
				" where idPrenotazione = \'"+idPrenotazione+"\'");
		
		Vector<String[]> risultato2 =DbConnection.getInstance().eseguiQuery("select count(*) from Prenotazione "+
		" where confermato = '1' ");
		Iterator<String[]> iter2 = risultato2.iterator();
		String[] tupla2 = iter2.next();
		int countDopo = Integer.parseInt(tupla2[0]);
		
		if (countPrima == countDopo)
			return(false);
		else 
			return(true);
	}
}

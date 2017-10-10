package it.unisalento.dao;

import it.unisalento.DbInterface.DbConnection;
import it.unisalento.model.Affitto;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;



public class AffittoDao 
{
private static AffittoDao instance;
	
	public static AffittoDao getInstance()
	{
		if(instance==null)
		{	
			instance = new AffittoDao();
		}
		return instance;
	}
	
	
	
	public int affittoMaxId()
	{
		Vector<String[]> risultato=DbConnection.getInstance().eseguiQuery("select max(IdAffitto) from Affitto " );
		Iterator<String[]> iter = risultato.iterator();
		String[] tupla = iter.next();
		return Integer.parseInt(tupla[0]);
	}

	
	public Affitto getAffitto(Affitto a)
	{
		int idaffitto = a.getIdAffitto();
		
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("select * from Affitto "+
				"where idAffitto=\""+ idaffitto +"\"" );
		Affitto affitto = new Affitto(idaffitto);
		if (risultato.size() == 1)
		{
		Iterator<String[]> iter = risultato.iterator();
		String[] tupla = iter.next();
		
		
		affitto.setCabina(Integer.parseInt(tupla[1])) ;
		affitto.setIdCliente(Integer.parseInt(tupla[0]));
		
		affitto.setAcquaCorrente(tupla[5]);
		affitto.setElettricità(tupla[6]);
		affitto.setAsciugamani(tupla[7]);
				
		affitto.setOperatorelido(Integer.parseInt(tupla[8]));
		affitto.setCosto(Double.parseDouble(tupla[9]));
		
		int annoI = Integer.parseInt(tupla[2].substring(0,4));
		int meseI = Integer.parseInt(tupla[2].substring(5,7));
		int giornoI = Integer.parseInt(tupla[2].substring(8,10));
		
		int annoF = Integer.parseInt(tupla[3].substring(0,4));
		int meseF = Integer.parseInt(tupla[3].substring(5,7));
		int giornoF = Integer.parseInt(tupla[3].substring(8,10));
			
		affitto.setDataInizio(new GregorianCalendar(annoI,meseI-1,giornoI));
		affitto.setDataFine(new GregorianCalendar(annoF,meseF-1,giornoF));
		}
		else
		{
			JOptionPane.showMessageDialog(null,"IdAffitto non trovato.Controlla e ripeti operazione.");
		}
		
		return(affitto); 
	}
	
	public boolean inserisciAffitto(Affitto aff)
	{
		
		
		Vector<String[]> risultato1= DbConnection.getInstance().eseguiQuery("select count(*) from Affitto " );
		Iterator<String[]> iter1 = risultato1.iterator();
		String[] tupla1 = iter1.next();
		int countPrima = Integer.parseInt(tupla1[0]);
		
		
				
		int idAff = aff.getIdAffitto();
		int operatore = aff.getOperatorelido();
		int cab = aff.getCabina();
		int cl = aff.getIdCliente();
		double costo = aff.getCosto();
		String acqua = aff.getAcquaCorrente();
		String luce = aff.getElettricità();
		String asciugamani = aff.getAsciugamani();
		
		GregorianCalendar out = aff.getDataFine();
		GregorianCalendar in = aff.getDataInizio();
		
		if (in == null || out ==null)
		{
			
		      DbConnection.getInstance().eseguiAggiornamento("insert into affitto(Cliente,Cabina,DataInizio,"+
				"DataFine,IdAffitto,AcquaCorrente,Elettricità,Asciugamani,Operatore,CostoTotale)"+
				"values(\'"+cl+"\',\'"+cab+"\',curdate(),curdate(),\'"+idAff+
				"\',\'"+acqua+"\',\'"+luce+"\',\'"+asciugamani+"\',\'"+operatore+"\',\'"+costo+"\')");
		}
		
		else
		{
			long millIn = in.getTimeInMillis();
			long millOut =out.getTimeInMillis();
			
			Date dataIn = new Date(millIn);
			Date dataOut = new Date(millOut);
			
			DbConnection.getInstance().eseguiAggiornamento("insert into affitto(Cliente,Cabina,DataInizio,"+
					"DataFine,IdAffitto,AcquaCorrente,Elettricità,Asciugamani,Operatore,CostoTotale)"+
					"values(\'"+cl+"\',\'"+cab+"\',\'"+dataIn+"\',\'"+dataOut+"\',\'"+idAff+
					"\',\'"+acqua+"\',\'"+luce+"\',\'"+asciugamani+"\',\'"+operatore+"\',\'"+costo+"\')");
			
			
		}
		Vector<String[]> risultato2 =DbConnection.getInstance().eseguiQuery("select count(*) from Affitto " );
		Iterator<String[]> iter2 = risultato2.iterator();
		String[] tupla2 = iter2.next();
		int countDopo = Integer.parseInt(tupla2[0]);
		
		if (countPrima == countDopo)
			return(false);
		else 
			return(true);
		
	}
	
	public boolean cancellaAffitto(Affitto aff)
	{
		Vector<String[]> risultato1= DbConnection.getInstance().eseguiQuery("select count(*) from Affitto " );
		Iterator<String[]> iter1 = risultato1.iterator();
		String[] tupla1 = iter1.next();
		int countPrima = Integer.parseInt(tupla1[0]);
		
		int idAff = aff.getIdAffitto();
		
		
		DbConnection.getInstance().eseguiAggiornamento("delete from Affitto where IdAffitto = \' "+
				idAff+"\'");
		
		
		
		Vector<String[]> risultato2 =DbConnection.getInstance().eseguiQuery("select count(*) from Affitto " );
		Iterator<String[]> iter2 = risultato2.iterator();
		String[] tupla2 = iter2.next();
		int countDopo = Integer.parseInt(tupla2[0]);
		
		if (countPrima == countDopo)
			return(false);
		else 
			return(true);
		
	}
	
}

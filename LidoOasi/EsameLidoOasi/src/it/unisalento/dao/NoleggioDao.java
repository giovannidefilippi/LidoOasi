package it.unisalento.dao;

import it.unisalento.DbInterface.DbConnection;
import it.unisalento.model.Noleggio;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JOptionPane;

public class NoleggioDao 
{
private static NoleggioDao instance;
	
	public static NoleggioDao getInstance()
	{
		if(instance==null)
		{	
			instance = new NoleggioDao();
		}
		return instance;
	}
	
	public int maxId()
	{
		Vector<String[]> risultato=DbConnection.getInstance().eseguiQuery("select max(IdNoleggio) from Noleggio " );
		Iterator<String[]> iter = risultato.iterator();
		String[] tupla = iter.next();
		return Integer.parseInt(tupla[0]);
	}
	
	public Noleggio getNoleggio(Noleggio n)
	{
		int idnoleggio = n.getIdNoleggio();
		
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("select * from Noleggio "+
				"where idNoleggio=\""+ idnoleggio +"\"" );
		Noleggio noleggio = new Noleggio(idnoleggio);
		if (risultato.size() == 1)
		{
		Iterator<String[]> iter = risultato.iterator();
		String[] tupla = iter.next();
		
		
		noleggio.setOmbrellone(Integer.parseInt(tupla[2])) ;
		noleggio.setIdCliente(Integer.parseInt(tupla[3]));
		noleggio.setNumeroLettini(Integer.parseInt(tupla[4]));
		noleggio.setOperatorelido(Integer.parseInt(tupla[5]));
		noleggio.setCosto(Double.parseDouble(tupla[6]));
		
		int anno = Integer.parseInt(tupla[1].substring(0,4));
		int mese = Integer.parseInt(tupla[1].substring(5,7));
		int giorno = Integer.parseInt(tupla[1].substring(8,10));
			
		noleggio.setData(new GregorianCalendar(anno,mese-1,giorno));
		
		
		
		}
		else
		{
			JOptionPane.showMessageDialog(null,"IdNoleggio non trovato.Controlla e ripeti operazione.");
		}
		
		return(noleggio); 
	}
	
	public Boolean inserisciNoleggio(Noleggio nol)
	{
		
		
		Vector<String[]> risultato1= DbConnection.getInstance().eseguiQuery("select count(*) from Noleggio " );
		Iterator<String[]> iter1 = risultato1.iterator();
		String[] tupla1 = iter1.next();
		int countPrima = Integer.parseInt(tupla1[0]);
				
		int idNol = nol.getIdNoleggio();
		int operatore = nol.getOperatorelido();
		int ombr = nol.getOmbrellone();
		int lett = nol.getNumeroLettini();
		int cl = nol.getIdCliente();
		double costo = nol.getCosto();
		
		DbConnection.getInstance().eseguiAggiornamento("insert into noleggio(idNoleggio,Data,Ombrellone,Cliente,NumeroLettini"+
		",Operatore,CostoTotale) values(\'"+idNol+"\',curdate(),\'"+ombr+"\',\'"+cl+"\',\'"+lett+"\',\'"+operatore+"\',\'"+costo+"\')");
		
		Vector<String[]> risultato2 =DbConnection.getInstance().eseguiQuery("select count(*) from Noleggio " );
		Iterator<String[]> iter2 = risultato2.iterator();
		String[] tupla2 = iter2.next();
		int countDopo = Integer.parseInt(tupla2[0]);
		
		if (countPrima == countDopo)
			return(false);
		else 
			return(true);
		
	}

	
	
}

package it.unisalento.dao;

import it.unisalento.DbInterface.DbConnection;
import it.unisalento.model.Bagnino;
import it.unisalento.model.Cliente;
import it.unisalento.model.Operatorelido;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

public class BagninoDao 
{
    private static BagninoDao instance;
	
	public static BagninoDao getInstance()
	{
		if(instance==null)
		{	
			instance = new BagninoDao();
		}
		return instance;
	}
	
	public boolean userExists(Operatorelido a)
	{
		int username = a.getCodiceOperatore();
		String password = a.getPassword();
		
		//SINGLETON
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from Operatorelido "+
		"join Bagnino on CodiceOperatore = IdBagnino where "+
				"CodiceOperatore=\""+ username +"\" and password=\""+password+"\"");
		
		return (result.size() == 1);
	}
	
	public boolean usernameExists(Bagnino  b)
	{
		int username = b.getCodiceOperatore();
				
		//SINGLETON
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from OperatoreLido "+
		"where CodiceOperatore=\'"+ username +"\'" );
		
		return (result.size() == 1);
	}
	
	public boolean inserisciBagnino(Bagnino b)
	{
		
		Vector<String[]> risultato1= DbConnection.getInstance().eseguiQuery("select count(*) from Bagnino " );
		Iterator<String[]> iter1 = risultato1.iterator();
		String[] tupla1 = iter1.next();
		int countPrima = Integer.parseInt(tupla1[0]);
		
		int username = b.getCodiceOperatore();
		String nome = b.getNome();
		String cognome = b.getCognome();
		String password = b.getPassword();
		int età = b.getEtà();
		char sesso = b.getSesso();
		int codice = b.getCodiceAmministratoreAssunzione();
		DbConnection.getInstance().eseguiAggiornamento("insert into OperatoreLido(CodiceOperatore,Nome,Cognome,Password)"+
" values(\'"+username+"\',\'"+nome+"\',\'"+cognome+"\',\'"+password+"\')");
		
		DbConnection.getInstance().eseguiAggiornamento("insert into Bagnino(idBagnino,Età,Sesso,DataAssunzione,AmministratoreAssunzione)"+
				" values(\'"+username+"\',\'"+età+"\',\'"+sesso+"\',curdate(),\'"+codice+"\')");
						
	
		Vector<String[]> risultato2 =DbConnection.getInstance().eseguiQuery("select count(*) from Bagnino " );
		Iterator<String[]> iter2 = risultato2.iterator();
		String[] tupla2 = iter2.next();
		int countDopo = Integer.parseInt(tupla2[0]);
		
		if (countPrima == countDopo)
			return(false);
		else 
			return(true);
	
	
	}
	
	
	public Bagnino getBagnino(Bagnino b)
	{
		int username = b.getCodiceOperatore();
		
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("select * from OperatoreLido o join Bagnino b "+
				"on b.idBagnino = o.CodiceOperatore "+
				 " where b.idBagnino =\""+ username +"\"" );
		
		Bagnino bagnino = new Bagnino(username);
		if (risultato.size() == 1)
		{
		Iterator<String[]> iter = risultato.iterator();
		String[] tupla = iter.next();
		
		
		bagnino.setNome(tupla[1]) ;
		bagnino.setCognome(tupla[2]);
		bagnino.setPassword(tupla[3]);
		bagnino.setEtà(Integer.parseInt(tupla[5]));
		bagnino.setSesso(tupla[6].charAt(0));
		
		int anno = Integer.parseInt(tupla[7].substring(0,4));
		int mese = Integer.parseInt(tupla[7].substring(5,7));
		int giorno = Integer.parseInt(tupla[7].substring(8,10));
			
		bagnino.setDataAssunzione(new GregorianCalendar(anno,mese-1,giorno));
		bagnino.setCodiceAmministratoreAssunzione(Integer.parseInt(tupla[8]));
		
		
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Bagnino non trovato.Controlla e ripeti operazione.");
		}
		
		return(bagnino); 
	}


}

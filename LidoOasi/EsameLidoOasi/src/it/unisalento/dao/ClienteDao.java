package it.unisalento.dao;

import it.unisalento.DbInterface.DbConnection;
import it.unisalento.model.Cliente;








import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

public class ClienteDao
{
private static ClienteDao instance;
	
	public static ClienteDao getInstance()
	{
		if(instance==null)
		{	
			instance = new ClienteDao();
		}
		return instance;
	}
	
	public boolean userExists(Cliente  c)
	{
		int username = c.getIdCliente();
		String password = c.getPassword();
		
		//SINGLETON
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from Cliente "+
		"where IdCliente=\""+ username +"\" and password=\""+password+"\"");
		
		return (result.size() == 1);
	}

	public boolean usernameExists(Cliente  c)
	{
		int username = c.getIdCliente();
				
		//SINGLETON
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from Cliente "+
		"where IdCliente=\'"+ username +"\'" );
		
		return (result.size() == 1);
	}
	
	public boolean inserisciCliente(Cliente c)
	{
		Vector<String[]> risultato1= DbConnection.getInstance().eseguiQuery("select count(*) from Cliente " );
		Iterator<String[]> iter1 = risultato1.iterator();
		String[] tupla1 = iter1.next();
		int countPrima = Integer.parseInt(tupla1[0]);
		
		int username = c.getIdCliente();
		String nome = c.getNome();
		String cognome = c.getCognome();
		String password = c.getPassword();
		int età = c.getEtà();
		char sesso = c.getSesso();
		String email = c.getEmail();
		int codice = c.getOperatorelido();
		DbConnection.getInstance().eseguiAggiornamento("insert into cliente(idCliente,Nome,Cognome,Età,Sesso,Email"+
		",Password,DataRegistrazione,OperatoreRegistrazione)"+
" values(\'"+username+"\',\'"+nome+"\',\'"+cognome+"\',\'"+età+"\',\'"+sesso+"\',\'"+email+"\',\'"+password+"\',curdate(),\'"+codice+"\')");
	
		Vector<String[]> risultato2 =DbConnection.getInstance().eseguiQuery("select count(*) from Cliente " );
		Iterator<String[]> iter2 = risultato2.iterator();
		String[] tupla2 = iter2.next();
		int countDopo = Integer.parseInt(tupla2[0]);
		
		if (countPrima == countDopo)
			return(false);
		else 
			return(true);
	
	
	}
	
/**
 * Recupera dal Db il cliente
 * @param c il cliente da trovare nel Db cercato per Id
 * @return cliente il cliente completo di tutti i suoi attributi
 */
	
	public Cliente getCliente(Cliente c)
	{
		int username = c.getIdCliente();
		
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("select * from Cliente "+
				"where idCliente=\""+ username +"\"" );
		//Cliente cliente = new Cliente(username);
		if (risultato.size() == 1)
		       {
		Iterator<String[]> iter = risultato.iterator();
		String[] tupla = iter.next();
		/*cliente.setNome(tupla[1]) ;
		cliente.setCognome(tupla[2]);
		cliente.setEtà(Integer.parseInt(tupla[3]));
		cliente.setSesso(tupla[4].charAt(0));
		cliente.setEmail(tupla[5]);
		cliente.setPassword(tupla[6]);
		int anno = Integer.parseInt(tupla[7].substring(0,4));
		int mese = Integer.parseInt(tupla[7].substring(5,7));
		int giorno = Integer.parseInt(tupla[7].substring(8,10));
			
		cliente.setDataRegistrazione(new GregorianCalendar(anno,mese-1,giorno));
		cliente.setOperatorelido(Integer.parseInt(tupla[8]));
		*/
		
		c.setNome(tupla[1]) ;
		c.setCognome(tupla[2]);
		c.setEtà(Integer.parseInt(tupla[3]));
		c.setSesso(tupla[4].charAt(0));
		c.setEmail(tupla[5]);
		c.setPassword(tupla[6]);
		int anno = Integer.parseInt(tupla[7].substring(0,4));
		int mese = Integer.parseInt(tupla[7].substring(5,7));
		int giorno = Integer.parseInt(tupla[7].substring(8,10));
			
		c.setDataRegistrazione(new GregorianCalendar(anno,mese-1,giorno));
		c.setOperatorelido(Integer.parseInt(tupla[8]));
		
		  }
	else
		   {
			JOptionPane.showMessageDialog(null,"idCliente non trovato.Controlla e ripeti operazione.");
		   }
		
		return(c); 
	}

}

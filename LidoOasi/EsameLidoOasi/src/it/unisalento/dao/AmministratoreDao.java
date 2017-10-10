package it.unisalento.dao;

import it.unisalento.DbInterface.DbConnection;
import it.unisalento.model.Operatorelido;

import java.util.Vector;


public class AmministratoreDao {

	private static AmministratoreDao instance;
	
	public static AmministratoreDao getInstance()
	{
		if(instance==null)
		{	
			instance = new AmministratoreDao();
		}
		return instance;
	}
	
	public boolean userExists(Operatorelido a)
	{
		int username = a.getCodiceOperatore();
		String password = a.getPassword();
		
		//SINGLETON
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from Operatorelido "+
		"join Amministratore on CodiceOperatore = CodiceAmministratore where "+
				"CodiceOperatore=\""+ username +"\" and password=\""+password+"\"");
		
		return (result.size() == 1);
	}
	
}

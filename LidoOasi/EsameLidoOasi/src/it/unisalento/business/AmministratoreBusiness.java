package it.unisalento.business;

import it.unisalento.model.Amministratore;
import it.unisalento.model.Operatorelido;

public class AmministratoreBusiness 
{
private static AmministratoreBusiness instance;
	
	//SINGLETON
	public static AmministratoreBusiness getInstance()
	{
		if(instance == null)
			instance = new AmministratoreBusiness();
		return instance;
	}
	
	public boolean verificaLogin(int username, String password)
	{
		Amministratore p=new Amministratore(username, password);
		return p.login();
	}

}

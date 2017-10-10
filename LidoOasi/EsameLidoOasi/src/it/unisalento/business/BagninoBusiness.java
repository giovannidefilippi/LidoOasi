package it.unisalento.business;

import it.unisalento.model.Bagnino;
import it.unisalento.model.Cliente;

public class BagninoBusiness 
{
private static BagninoBusiness instance;
	
	//SINGLETON
	public static BagninoBusiness getInstance()
	{
		if(instance == null)
			instance = new BagninoBusiness();
		return instance;
	}
	
	public boolean verificaLogin(int username, String password)
	{
		Bagnino b=new Bagnino(username, password);
		return b.login();
	}
	public boolean verificaUsername(int username)
	{
		Bagnino b = new Bagnino(username);
		return b.verifica();


    }
	
	public boolean registraBagnino(int IdBagnino,String nome,String cognome,
			String password,int età,char sesso,int codice)
	{
		Bagnino b = new Bagnino( IdBagnino, nome,cognome,
			     password,età,sesso);
		b.setCodiceAmministratoreAssunzione(codice);
		return b.registra();
	}
	
	public Bagnino trovaBagnino(int IdBagnino)
	{
		Bagnino b = new Bagnino( IdBagnino);
		return b.recupera();
	}
}

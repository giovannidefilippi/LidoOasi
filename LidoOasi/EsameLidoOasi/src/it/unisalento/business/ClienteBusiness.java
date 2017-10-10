package it.unisalento.business;


import it.unisalento.model.Cliente;

public class ClienteBusiness
{
private static ClienteBusiness instance;
	
	//SINGLETON
	public static ClienteBusiness getInstance()
	{
		if(instance == null)
			instance = new ClienteBusiness();
		return instance;
	}
	
	public boolean verificaLogin(int username, String password)
	{
		Cliente c=new Cliente(username, password);
		return c.login();
	}
	public boolean verificaUsername(int username)
	{
		Cliente c = new Cliente(username);
		return c.verifica();
	}
	
	
	public boolean registraCliente(int IdCliente,String nome,String cognome,
			String password,int età,char sesso,String Email,int codice)
	{
		Cliente c = new Cliente( IdCliente, nome,cognome,
			     password,età,sesso, Email);
		c.setOperatorelido(codice);
		return c.registra();
	}
	
	public Cliente trovaCliente(int IdCliente)
	{
		Cliente c = new Cliente( IdCliente);
		return c.recupera();
	}

}

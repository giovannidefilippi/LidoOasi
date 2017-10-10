package it.unisalento.business;

import it.unisalento.model.Cliente;
import it.unisalento.model.Noleggio;

public class NoleggioBusiness
{
private static NoleggioBusiness instance;
	
	//SINGLETON
	public static NoleggioBusiness getInstance()
	{
		if(instance == null)
			instance = new NoleggioBusiness();
		return instance;
	}
	
	public int getMaxIdNoleggio()
	{
		Noleggio nol = new Noleggio();
		return nol.getMaxId();
	}
	
	public Noleggio trovaNoleggio(int IdNoleggio)
	{
		Noleggio n = new Noleggio( IdNoleggio);
		return n.recupera();
	}
	
	public boolean registraNoleggio(int IdNoleggio,int operatore,int ombrellone,
			int lettini,int cliente,double costo)
	{
		Noleggio n = new Noleggio( IdNoleggio, operatore,ombrellone,
			    lettini, cliente,costo);
		//c.setOperatorelido(codice);
		return n.registra();
	}
	
}

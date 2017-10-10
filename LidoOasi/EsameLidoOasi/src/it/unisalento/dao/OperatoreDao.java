package it.unisalento.dao;

import it.unisalento.model.Bagnino;

public class OperatoreDao
{
	private static OperatoreDao instance;
	
	public static OperatoreDao getInstance()
	{
		if(instance==null)
		{	
			instance = new OperatoreDao();
		}
		return instance;
	}

	public void inserisciBagnino(Bagnino b)
	{
		
	}
}

package it.unisalento.dao;

import it.unisalento.DbInterface.DbConnection;
import it.unisalento.model.Dimensione;
import java.util.Iterator;
import java.util.Vector;

public class DimensioneDao 
 {
 private static DimensioneDao instance;
	
	public static DimensioneDao getInstance()
	{
		if(instance==null)
		{	
			instance = new DimensioneDao();
		}
		return instance;
	}
	
	public void setDimensione(Dimensione d)
	{
		String tipo = d.getTipo();
		double costo = d.getCostogiornaliero();
		
		DbConnection.getInstance().eseguiAggiornamento("insert into Dimensione(tipo,Costogiornaliero)"+
		"values (\'"+tipo+"\',"+costo+")");
		
		
	}
	
    public Dimensione getDimensione(String tipo)
    {
    	
        Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("select * from Dimensione "+
				"where Tipo=\""+ tipo +"\"" );
		Dimensione dimensione = new Dimensione(tipo);
		if (risultato.size() == 1)
		   {
		Iterator<String[]> iter = risultato.iterator();
		String[] tupla = iter.next();
		
				
		dimensione.setCostogiornaliero(Double.parseDouble(tupla[1]));
		
		    }
		return(dimensione);
	}
  }


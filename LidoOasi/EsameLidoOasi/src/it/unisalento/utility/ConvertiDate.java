package it.unisalento.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class ConvertiDate 

{
   private static GregorianCalendar dataGregoriana;
   private  Date data;
    
    public ConvertiDate()
    {
    	
    }
    
    public static GregorianCalendar convertiInGregoriano(Date data)
    {
    	DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		String d = formatter.format(data);
		int giorno = Integer.parseInt(d.substring(0,2));
		int mese = Integer.parseInt(d.substring(3,5));
		int anno = Integer.parseInt(d.substring(6,10));
		GregorianCalendar dataGregoriana = new GregorianCalendar(anno, mese-1, giorno);
    	
    	return dataGregoriana;
    }
    
    public static Date convertiInDate(GregorianCalendar gregData)
    {
    	
    	int anno = gregData.get(GregorianCalendar.YEAR);
    	int mese = gregData.get(GregorianCalendar.MONTH)+1;
    	int giorno = gregData.get(GregorianCalendar.DATE);
    	
    	@SuppressWarnings("deprecation")
		Date data = new Date(anno,mese,giorno);
    	
    	
    	return data;
    }
    
    
    
}

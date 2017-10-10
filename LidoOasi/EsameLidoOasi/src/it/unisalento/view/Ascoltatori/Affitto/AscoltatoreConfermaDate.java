package it.unisalento.view.Ascoltatori.Affitto;

import it.unisalento.view.AffittoJFrame;
import it.unisalento.view.PrenotazioneJFrame;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

   public class AscoltatoreConfermaDate implements ActionListener
{
	  private  AffittoJFrame frame;
	  private  int numGiorni;
	
     public AscoltatoreConfermaDate(AffittoJFrame frame)
     {
    	 this.frame = frame;
     }

	  public void actionPerformed(ActionEvent e) 
	  
	  {
		
		  JDateChooser dataInizio = frame.getCalendario().getCalendarioInizio();
		  JDateChooser dataFine = frame.getCalendario().getCalendarioFine();
			Date datainiz = dataInizio.getDate();
			Date datafin = dataFine.getDate();
		
			GregorianCalendar inizioAffitto = this.convertiInGregoriano(datainiz);
			GregorianCalendar fineAffitto = this.convertiInGregoriano(datafin);
			
			long millisec1 = inizioAffitto.getTimeInMillis();
			long millisec2 = fineAffitto.getTimeInMillis();
			long numGiorni = (millisec2-millisec1)/(24*60*60*1000);
			this.numGiorni =(int)numGiorni;
			
		if (numGiorni <0)
				JOptionPane.showMessageDialog(null, "Controlla le date inserite!!");
		else
			{
			
			frame.carrelloAffitto.numGiorni.setText(""+(numGiorni+1));
			
			AffittoJFrame.inizioData =datainiz;
			AffittoJFrame.fineData =datafin;
			}
			
		
	  }
	  
	  public  GregorianCalendar convertiInGregoriano(Date data)
	    {
	    	DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			
			String d = formatter.format(data);
			int giorno = Integer.parseInt(d.substring(0,2));
			int mese = Integer.parseInt(d.substring(3,5));
			int anno = Integer.parseInt(d.substring(6,10));
			GregorianCalendar dataGregoriana = new GregorianCalendar(anno, mese-1, giorno);
	    	
	    	return dataGregoriana;
	    }

	public int getNumGiorni() {
		return numGiorni;
	}

	public void setNumGiorni(int numGiorni) {
		this.numGiorni = numGiorni;
	}

	
	    

}

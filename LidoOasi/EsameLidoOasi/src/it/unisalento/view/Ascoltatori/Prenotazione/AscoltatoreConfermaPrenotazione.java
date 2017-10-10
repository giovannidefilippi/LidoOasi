package it.unisalento.view.Ascoltatori.Prenotazione;

import it.unisalento.business.AffittoBusiness;
import it.unisalento.business.ClienteBusiness;
import it.unisalento.business.PrenotazioneBusiness;
import it.unisalento.business.SistemaBusiness;
import it.unisalento.model.Cabina;
import it.unisalento.view.PrenotazioneJFrame;
import it.unisalento.view.Ascoltatori.Accesso.AscoltatoreAffitto;
import it.unisalento.view.Pannelli.ServiziAggiuntiviPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class AscoltatoreConfermaPrenotazione implements ActionListener 

{
     PrenotazioneJFrame frame;
      
     public AscoltatoreConfermaPrenotazione(PrenotazioneJFrame frame)
     {
    	 this.frame = frame;
     }
     
	public void actionPerformed(ActionEvent e) throws IllegalArgumentException,IndexOutOfBoundsException,NullPointerException
		{
			int idPrenotazione = frame.max+1;
			int cliente = frame.getCodiceCliente();   
		
			
		try
			{
				String ordine = frame.carrelloAffitto.areaSup.getText();
				
				int numCabina =Integer.parseInt(ordine.substring(4,6).trim());
				double costo = frame.getCostoTotale();
				String mialuce = "no";
				String miaacqua = "no";
				String mioasciugamani = "no";
				ServiziAggiuntiviPanel pannello = frame.getPannelloServizi();
				
				GregorianCalendar dataIn = this.convertiInGregoriano(PrenotazioneJFrame.inizioData);
				GregorianCalendar dataFin = this.convertiInGregoriano(PrenotazioneJFrame.fineData);
				
				
				if(pannello.acqua.isSelected())
					miaacqua = "si";
			    if(pannello.luce.isSelected())
					mialuce = "si";
				if(pannello.asciugamani.isSelected())
					mioasciugamani = "si";
			
			     boolean prenotato = PrenotazioneBusiness.getInstance().registraPrenotazione(idPrenotazione, 
			    		              numCabina,cliente,dataIn,dataFin,mialuce,miaacqua,mioasciugamani,costo);
			  
			  
			  if(prenotato)
			    {
				   JOptionPane.showMessageDialog(null, "Prenotazione registrata.Verrà confermata via E-mail.Clicca ok per continuare!");
				   
				     
				   frame.getCarrelloAffitto().dispose();
			       frame.dispose();
			       
			       PrenotazioneJFrame confermata =new PrenotazioneJFrame();
				   confermata.setCodiceCliente(cliente);
				   
			       
			       
			      }
			     else
				  JOptionPane.showMessageDialog(null, "Non è stato possibile effettuare registrazione.Clicca ok per continuare!");
			}
			
			catch (NumberFormatException numb)
			{
				String exc = numb.getMessage();
			  if(exc.equals("null"))
				{				
				}			
				else
				   {			
			         JOptionPane.showMessageDialog(null, "Valori inseriti non corretti,fai attenzione username deve essere un numero!!");
			       } 
			}
			
			catch (IndexOutOfBoundsException ind)
			{
				JOptionPane.showMessageDialog(null, " Se possibile,devi prima scegliere qualcosa!!??");
				
			}
		
			catch(NullPointerException excep)
			{
				JOptionPane.showMessageDialog(null, " Devi scegliere la data!!??");
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
}

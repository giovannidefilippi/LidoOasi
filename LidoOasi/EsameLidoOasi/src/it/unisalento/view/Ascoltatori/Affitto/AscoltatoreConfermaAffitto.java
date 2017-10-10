package it.unisalento.view.Ascoltatori.Affitto;

import it.unisalento.business.AffittoBusiness;
import it.unisalento.business.ClienteBusiness;
import it.unisalento.business.SistemaBusiness;
import it.unisalento.view.AffittoJFrame;
import it.unisalento.view.Pannelli.ServiziAggiuntiviPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class AscoltatoreConfermaAffitto implements ActionListener 
{
	AffittoJFrame frame;
	private  GregorianCalendar oggi = new GregorianCalendar();
	
	public AscoltatoreConfermaAffitto(AffittoJFrame frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) throws IllegalArgumentException,IndexOutOfBoundsException,NullPointerException
	{
		int idAffitto = frame.max+1;
		int operatore = frame.getOperatore();
		int cliente = frame.getCarrelloAffitto().getCodCliente();
		
		
				
		boolean usernameEsiste = ClienteBusiness.getInstance().verificaUsername(cliente);
	if(!usernameEsiste)
		{
		JOptionPane.showMessageDialog(null, "Il cliente non è stato inserito o non è registrato.");
		}
				
    else
	  {
		try
		{
			String ordine = frame.carrelloAffitto.areaSup.getText();
			
			int numCabina =Integer.parseInt(ordine.substring(4,6).trim());
			
			double costo = frame.getCostoTotale();
			String mialuce = "no";
			String miaacqua = "no";
			String mioasciugamani = "no";
			ServiziAggiuntiviPanel pannello = frame.getPannelloServizi();
			GregorianCalendar dataIn = this.convertiInGregoriano(AffittoJFrame.inizioData);
			GregorianCalendar dataFin = this.convertiInGregoriano(AffittoJFrame.fineData);
			
			
			if(pannello.acqua.isSelected())
				miaacqua = "si";
		    if(pannello.luce.isSelected())
				mialuce = "si";
			if(pannello.asciugamani.isSelected())
				mioasciugamani = "si";
			
		    boolean controllato = SistemaBusiness.getInstance().controlloScritturaAffitti(dataIn,dataFin,numCabina);
		  
		  if(controllato)
		  {
		     boolean affittato = AffittoBusiness.getInstance().registraAffitto(idAffitto, operatore, numCabina,dataIn,dataFin,miaacqua,mialuce,mioasciugamani, cliente,costo);
		  
		  
		  if(affittato)
		    {
			   JOptionPane.showMessageDialog(null, "Registrazione effettuata.Clicca ok per continuare!");
			     if (dataIn.after(oggi))
			     {
			       SistemaBusiness.getInstance().prenotaCabina(numCabina);
			     }
			     else
			     {			   
		           SistemaBusiness.getInstance().occupaCabina(numCabina);
			     }
			  cliente = 0;
			   		   
			   frame.getCarrelloAffitto().dispose();
		       frame.dispose();
		       
		       AffittoJFrame confermato =new AffittoJFrame();
			   confermato.setFlag(frame.getFlag());
		       confermato.setOperatore(frame.getOperatore());
		       
		      }
		     else
			  JOptionPane.showMessageDialog(null, "Non è stato possibile effettuare registrazione.Clicca ok per continuare!");
		
		    }
		  else
			  JOptionPane.showMessageDialog(null, "Il periodo selezionato è gia affittato.Clicca ok per continuare!");
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

package it.unisalento.view.Ascoltatori.Noleggio;

import it.unisalento.business.ClienteBusiness;
import it.unisalento.business.NoleggioBusiness;
import it.unisalento.business.SistemaBusiness;
import it.unisalento.model.Lettino;
import it.unisalento.view.NoleggioJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class AscoltatoreConfermaNoleggio implements ActionListener 
{
	NoleggioJFrame frame;

    public AscoltatoreConfermaNoleggio(NoleggioJFrame frame)
    {
    	this.frame = frame;
    }

	public void actionPerformed(ActionEvent e) throws IllegalArgumentException,IndexOutOfBoundsException
	{
		int idNoleggio = frame.max+1;
		int operatore = frame.getCodiceOperatore();
		int cliente = frame.getCarrello().getIdCliente();
		int lettini = frame.getLettini().getNumLettini();
		
				
		boolean usernameEsiste = ClienteBusiness.getInstance().verificaUsername(cliente);
	if(!usernameEsiste)
		{
		JOptionPane.showMessageDialog(null, "Il cliente non è stato inserito o non è registrato.");
		}
				
    else
	  {
		try
		  {
			String ordine = frame.getCarrello().areaInf.getText();
			
			int ombrellone =Integer.parseInt(ordine.substring(11,13).trim());
			
			
			double costo = frame.ombrelloni.get(ombrellone - 1).getCostoGiornaliero()+ Lettino.COSTO_GIORNALIERO * lettini;
			
		   boolean registrato = NoleggioBusiness.getInstance().registraNoleggio(idNoleggio, operatore, ombrellone, lettini, cliente,costo);
		    if(registrato)
		    {
			   JOptionPane.showMessageDialog(null, "Registrazione effettuata.Clicca ok per continuare!");
		       SistemaBusiness.getInstance().occupaOmbrellone(ombrellone);
			   cliente = 0;
			   NoleggioJFrame confermato =new NoleggioJFrame();
			   confermato.setFlag(frame.getFlag());
			   confermato.setCodiceOperatore(frame.getCodiceOperatore());
		       frame.dispose();
		       frame.getCarrello().dispose();
		       frame.getLettini().dispose();
		       
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
			JOptionPane.showMessageDialog(null, " Devi prima scegliere qualcosa!!??");
		}
	  }
	 
	  
   }
}


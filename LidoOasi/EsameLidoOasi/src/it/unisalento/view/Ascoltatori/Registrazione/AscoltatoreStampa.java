package it.unisalento.view.Ascoltatori.Registrazione;

import it.unisalento.business.AffittoBusiness;
import it.unisalento.business.ClienteBusiness;
import it.unisalento.business.NoleggioBusiness;
import it.unisalento.business.PrenotazioneBusiness;
import it.unisalento.model.Affitto;
import it.unisalento.model.Cliente;
import it.unisalento.model.Noleggio;
import it.unisalento.model.Prenotazione;
import it.unisalento.view.AffittoJFrame;
import it.unisalento.view.ConfermaPrenotazioniJFrame;
import it.unisalento.view.NoleggioJFrame;
import it.unisalento.view.PrenotazioneJFrame;
import it.unisalento.view.RegistrazioneJFrame;
import it.unisalento.view.RegistrazioneOpJFrame;
import it.unisalento.view.RegistrazioneOpJFrameAmministratore;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AscoltatoreStampa implements ActionListener 
{
	JFrame frame;
	PrintWriter out;
	
	public AscoltatoreStampa(JFrame frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) throws IllegalArgumentException,NullPointerException
	{
		try
		{
            if ((frame instanceof RegistrazioneJFrame) || (frame instanceof RegistrazioneOpJFrame) || (frame instanceof RegistrazioneOpJFrameAmministratore))
	           {
	               String in =JOptionPane.showInputDialog(null,"Inserisci codice numerico Cliente");
		
	        	try
		     {
			out = new PrintWriter("Clienti/cliente.txt");
			int codicecliente = Integer.parseInt(in);
		    Cliente presoCliente = ClienteBusiness.getInstance().trovaCliente(codicecliente);
		    if( presoCliente!= null )
		     {	
		    	out.println(presoCliente);
		        JOptionPane.showMessageDialog(null, "Stampato su file.Premi ok per proseguire.");
		     
		     }    
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
		catch (FileNotFoundException e1) 
		{			
			e1.printStackTrace();
		}
		catch(NullPointerException t)
		{}
	}
		else if (frame instanceof NoleggioJFrame)
		{
			String in =JOptionPane.showInputDialog(null,"Inserisci codice numerico Noleggio");
			try
			{
				out = new PrintWriter("Noleggi/noleggio.txt");
				int codicenoleggio = Integer.parseInt(in);
			    Noleggio presoNoleggio = NoleggioBusiness.getInstance().trovaNoleggio(codicenoleggio);
			    if(presoNoleggio!=null)
			     {	
			    	out.println(presoNoleggio);
			        JOptionPane.showMessageDialog(null, "Stampato su file.Premi ok per proseguire.");
			     
			     }    
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
			catch (FileNotFoundException e1) 
			{			
				e1.printStackTrace();
			}
			catch(NullPointerException t)
			{}
			
			}

		else if (frame instanceof AffittoJFrame)
		{
			String in =JOptionPane.showInputDialog(null,"Inserisci codice numerico Affitto");
			try
			{
				out = new PrintWriter("Affitti/affitto.txt");
				int codiceaffitto = Integer.parseInt(in);
			    Affitto presoAffitto = AffittoBusiness.getInstance().trovaAffitto(codiceaffitto);
			    if(presoAffitto != null)
			     {	
			    	out.println(presoAffitto);
			        JOptionPane.showMessageDialog(null, "Stampato su file.Premi ok per proseguire.");
			     
			     }    
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
			catch (FileNotFoundException e1) 
			{			
				e1.printStackTrace();
			}
			catch(NullPointerException t)
			{}
			}
			
			else if (frame instanceof PrenotazioneJFrame || frame instanceof ConfermaPrenotazioniJFrame)
			{
				String in =JOptionPane.showInputDialog(null,"Inserisci codice numerico Prenotazione");
				try
				{
					out = new PrintWriter("Prenotazioni/prenotazione.txt");
					int codiceprenotazione = Integer.parseInt(in);
				    Prenotazione presaPrenotazione = PrenotazioneBusiness.getInstance().trovaPrenotazione(codiceprenotazione);
				    if(presaPrenotazione !=null)
				     {	
				    	out.println(presaPrenotazione);
				        JOptionPane.showMessageDialog(null, "Stampato su file.Premi ok per proseguire.");
				     
				     }    
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
				catch (FileNotFoundException e1) 
				{			
					e1.printStackTrace();
				}
				catch(NullPointerException t)
				{}
			
			}
	   }
	finally
       {
		out.close();
		}
		
		
	}

}

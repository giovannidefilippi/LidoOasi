package it.unisalento.view.Ascoltatori.VisualizzaStorico;

import it.unisalento.business.AffittoBusiness;
import it.unisalento.business.ClienteBusiness;
import it.unisalento.business.NoleggioBusiness;
import it.unisalento.business.PrenotazioneBusiness;
import it.unisalento.model.Affitto;
import it.unisalento.model.Cliente;
import it.unisalento.model.Noleggio;
import it.unisalento.model.Prenotazione;
import it.unisalento.view.VisualizzaStoricoJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class AscoltatoreStampaStorico implements ActionListener 
{
	private VisualizzaStoricoJFrame frame;
	
	public final static String aA = "a";
	public final static String bB = "b";
	public final static String cC = "c";
	
	PrintWriter out;
	
	
	
	public AscoltatoreStampaStorico(VisualizzaStoricoJFrame frame)
	{
		this.frame = frame;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String com = e.getActionCommand();
		
		if (com == aA)
		{
			try
			{
			  String in =JOptionPane.showInputDialog(null,"Inserisci codice Prenotazione");
				
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
	  finally
	           { out.close();
	           }
		}
		else if (com == bB)
		{
			try
			{
			  String in =JOptionPane.showInputDialog(null,"Inserisci codice Affitto");
				
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
	  finally
	           { out.close();
	           }
		}
		else if (com == cC)
		{
			try
			{
			  String in =JOptionPane.showInputDialog(null,"Inserisci codice Noleggio");
				
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
	  finally
	           { out.close();
	           }
		}

	}

}

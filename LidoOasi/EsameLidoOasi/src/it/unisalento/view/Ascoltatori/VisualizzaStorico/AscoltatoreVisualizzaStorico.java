package it.unisalento.view.Ascoltatori.VisualizzaStorico;

import it.unisalento.business.ClienteBusiness;
import it.unisalento.business.SistemaBusiness;
import it.unisalento.view.VisualizzaStoricoJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AscoltatoreVisualizzaStorico implements ActionListener 
{
	private VisualizzaStoricoJFrame frame;
	private int cliente;

	public AscoltatoreVisualizzaStorico(VisualizzaStoricoJFrame frame)
	{
		this.frame = frame;
	}

	
	public void actionPerformed(ActionEvent e) throws NumberFormatException
	
	{
	try
	   {
		
		
      if(frame.getCodiceOp() != 0)
		  {
			String in =JOptionPane.showInputDialog(null,"Inserisci codice Cliente");
			int cl = Integer.parseInt(in);
			 boolean usernameEsiste = ClienteBusiness.getInstance().verificaUsername(cl);
	           if(!usernameEsiste)
		          {
		           JOptionPane.showMessageDialog(null, "Il cliente non è registrato.");
		           //frame.a.addActionListener(new AscoltatoreVisualizzaStorico(frame));
		           }
	           else
			      	cliente = cl;
		}
			 
			   			
	  else
		  {
		    cliente = frame.getCodiceCliente();
		    frame.a.removeActionListener(this);
		    }
		
		frame.setPrenotazioni(SistemaBusiness.getInstance().getTuttePrenotazioni(cliente));
		frame.setAffitti(SistemaBusiness.getInstance().getTuttiAffitti(cliente));
		frame.setNoleggi(SistemaBusiness.getInstance().getTuttiNoleggi(cliente));		
			
		    for(int i=0;i<frame.getPrenotazioni().size();i++)
		    {
			frame.prenotazione.append(frame.getPrenotazioni().get(i).stampa());
			frame.prenotazione.append("\n");
		    }
		
		for(int i=0;i<frame.getAffitti().size();i++)
		  {
			frame.affitto.append(frame.getAffitti().get(i).toString());
			frame.affitto.append("\n");
		  }
		
		for(int i=0;i<frame.getNoleggi().size();i++)
		  {
			frame.noleggio.append(frame.getNoleggi().get(i).toString());
			frame.noleggio.append("\n");
		  }
		
		   
	
	}
	  catch(NumberFormatException exc)
	    {
		
	     }
	
       }
	}



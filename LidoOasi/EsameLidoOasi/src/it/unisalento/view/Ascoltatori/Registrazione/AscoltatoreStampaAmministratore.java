package it.unisalento.view.Ascoltatori.Registrazione;

import it.unisalento.business.BagninoBusiness;
import it.unisalento.business.ClienteBusiness;
import it.unisalento.model.Bagnino;
import it.unisalento.model.Cliente;
import it.unisalento.view.RegistrazioneJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AscoltatoreStampaAmministratore implements ActionListener 
{
	JFrame frame;
	PrintWriter out;
	
	public AscoltatoreStampaAmministratore(JFrame frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) throws IllegalArgumentException
	{
		String in =JOptionPane.showInputDialog(null,"Inserisci codice numerico Bagnino");
		
		try
		{
			out = new PrintWriter("Bagnini/bagnino.txt");
			int codiceBagnino = Integer.parseInt(in);
		    Bagnino presoBagnino = BagninoBusiness.getInstance().trovaBagnino(codiceBagnino);
		    if(!presoBagnino.equals(null))
		     {	
		    	out.println(presoBagnino);
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
		out.close();
		
	}

}

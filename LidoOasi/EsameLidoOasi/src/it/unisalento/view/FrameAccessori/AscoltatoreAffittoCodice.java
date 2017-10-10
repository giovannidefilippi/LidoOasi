package it.unisalento.view.FrameAccessori;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AscoltatoreAffittoCodice implements ActionListener 
{
	private CarrelloDellaSpesaAffitto frame;
	private  int codiceCliente;
	
	public AscoltatoreAffittoCodice(CarrelloDellaSpesaAffitto frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String in = JOptionPane.showInputDialog(null, "Inserisci codice Cliente");
		
		try
		{
		   codiceCliente = Integer.parseInt(in);
		   frame.setCodCliente(codiceCliente);
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

	}
	


}

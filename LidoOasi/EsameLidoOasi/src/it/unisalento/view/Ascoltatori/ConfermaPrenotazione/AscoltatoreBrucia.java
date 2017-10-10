package it.unisalento.view.Ascoltatori.ConfermaPrenotazione;

import it.unisalento.business.PrenotazioneBusiness;
import it.unisalento.business.SistemaBusiness;
import it.unisalento.view.ConfermaPrenotazioniJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AscoltatoreBrucia implements ActionListener
{
	ConfermaPrenotazioniJFrame frame;
	
	public AscoltatoreBrucia(ConfermaPrenotazioniJFrame frame)throws IllegalArgumentException
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String in =JOptionPane.showInputDialog(null,"Inserisci codice Prenotazione che hai "+
	    "confermato in Affitto");
		
		try
		{
			boolean settatoAPrenotato =PrenotazioneBusiness.getInstance()
					.brucia(Integer.parseInt(in));
			if(settatoAPrenotato)
			{
				JOptionPane.showMessageDialog(null, "Prenotazione cancellata."+
			"Premi ok per proseguire e poi su 'Visualizza tutte'.");
			
			frame.setPrenotazioniNon(SistemaBusiness.getInstance().getPrenotazioniNon());
			
			frame.prenotazioni.setText("");
			frame.tutte.addActionListener(new AscoltatoreTutte(frame));
			}
			else
			{
				JOptionPane.showMessageDialog(null, "La Prenotazione non esiste."+
						"Controlla Id.Premi ok per proseguire .");
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
		          JOptionPane.showMessageDialog(null, "Valori inseriti non corretti,fai attenzione  deve essere un numero!!");
		     } 
	    }
		
	}

}

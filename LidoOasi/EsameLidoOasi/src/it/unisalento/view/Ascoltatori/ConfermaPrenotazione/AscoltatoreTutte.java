package it.unisalento.view.Ascoltatori.ConfermaPrenotazione;

import it.unisalento.view.ConfermaPrenotazioniJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AscoltatoreTutte implements ActionListener 
{
	ConfermaPrenotazioniJFrame frame;
	
	public AscoltatoreTutte(ConfermaPrenotazioniJFrame frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		for(int i=0;i<frame.getPrenotazioniNon().size();i++)
		{
			frame.prenotazioni.append(frame.getPrenotazioniNon().get(i).stampa());
			frame.prenotazioni.append("\n");
			frame.tutte.removeActionListener(this);
		}

	}

}

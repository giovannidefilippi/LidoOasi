package it.unisalento.view.Ascoltatori.ConfermaPrenotazione;

import it.unisalento.view.ConfermaPrenotazioniJFrame;
import it.unisalento.view.JFrameAmministratore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AscoltatoreRitorna implements ActionListener 
{
	ConfermaPrenotazioniJFrame frame;
	
	public AscoltatoreRitorna(ConfermaPrenotazioniJFrame frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		frame.dispose();
		JFrameAmministratore nuovo = new JFrameAmministratore();
		nuovo.setCodiceAmministratore(frame.getCodiceAmministratore());
		

	}

}

package it.unisalento.view.Ascoltatori.Accesso;

import it.unisalento.view.ConfermaPrenotazioniJFrame;
import it.unisalento.view.JFrameAmministratore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AscoltatoreVerificaPrenotazione implements ActionListener 
{
	JFrameAmministratore frame;
	
	public AscoltatoreVerificaPrenotazione(JFrameAmministratore frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		frame.dispose();
		ConfermaPrenotazioniJFrame pren = new ConfermaPrenotazioniJFrame();
		pren.setCodiceAmministratore(frame.getCodiceAmministratore());
		

	}

}

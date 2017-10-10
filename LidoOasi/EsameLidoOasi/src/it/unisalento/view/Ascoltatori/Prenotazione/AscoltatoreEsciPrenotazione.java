package it.unisalento.view.Ascoltatori.Prenotazione;

import it.unisalento.view.JFrameCliente;
import it.unisalento.view.PrenotazioneJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AscoltatoreEsciPrenotazione implements ActionListener
{
	PrenotazioneJFrame frame;
	
	public AscoltatoreEsciPrenotazione(PrenotazioneJFrame frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{	
		frame.dispose();
		frame.carrelloAffitto.dispose();
		JFrameCliente nuovo  = new JFrameCliente();
		nuovo.setIdCliente(frame.getCodiceCliente());
		
	}

}

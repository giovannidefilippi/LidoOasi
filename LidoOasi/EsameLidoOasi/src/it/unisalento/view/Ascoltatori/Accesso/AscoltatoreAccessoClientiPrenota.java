package it.unisalento.view.Ascoltatori.Accesso;

import it.unisalento.view.JFrameCliente;
import it.unisalento.view.PrenotazioneJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AscoltatoreAccessoClientiPrenota implements ActionListener 
{
	JFrameCliente frame;
	
	public AscoltatoreAccessoClientiPrenota(JFrameCliente frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		PrenotazioneJFrame prenotazione = new PrenotazioneJFrame();
		int codcliente = frame.getIdCliente();
		prenotazione.setCodiceCliente(codcliente);
		frame.dispose();
		
	}

}

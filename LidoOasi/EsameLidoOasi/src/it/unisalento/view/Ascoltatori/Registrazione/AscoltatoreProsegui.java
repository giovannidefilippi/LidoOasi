package it.unisalento.view.Ascoltatori.Registrazione;

import it.unisalento.view.JFrameAmministratore;
import it.unisalento.view.JFrameBagnino;
import it.unisalento.view.RegistrazioneOpJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ascoltatore tasto prosegui della registrazione cliente 
 * da operatore per distinguere tra bagnino ed amministratore
 */

public class AscoltatoreProsegui implements ActionListener 
{
	RegistrazioneOpJFrame frame;
	
	public AscoltatoreProsegui(RegistrazioneOpJFrame frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (frame.getFlag() == 0)
		{
			JFrameBagnino nuovo =   new JFrameBagnino();
			nuovo.setCodiceBagnino(frame.getCodiceOperatore());
		    }
		else if (frame.getFlag() == 1)
		{
			JFrameAmministratore nuovo =	new JFrameAmministratore();
			nuovo.setCodiceAmministratore(frame.getCodiceOperatore());	
		}
			
		frame.dispose();

	}

}

package it.unisalento.view.Ascoltatori.Registrazione;

import it.unisalento.view.JFrameAmministratore;
import it.unisalento.view.RegistrazioneOpJFrameAmministratore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AscoltatoreProseguiAmministratore implements ActionListener 
{
	RegistrazioneOpJFrameAmministratore frame;
	
	public AscoltatoreProseguiAmministratore(RegistrazioneOpJFrameAmministratore frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JFrameAmministratore nuovo =  new JFrameAmministratore();
		nuovo.setCodiceAmministratore(frame.getCodice());
			
		frame.dispose();

	}

}

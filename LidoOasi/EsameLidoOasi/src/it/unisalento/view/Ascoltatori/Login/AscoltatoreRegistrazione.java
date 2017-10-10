package it.unisalento.view.Ascoltatori.Login;

import it.unisalento.view.InizioJFrame;
import it.unisalento.view.RegistrazioneJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AscoltatoreRegistrazione implements ActionListener
{
private InizioJFrame frame;
	
	public AscoltatoreRegistrazione(InizioJFrame frame)
	{
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		new RegistrazioneJFrame(); 
		frame.dispose();

	}

}

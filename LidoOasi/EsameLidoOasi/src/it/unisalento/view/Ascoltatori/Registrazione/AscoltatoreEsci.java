package it.unisalento.view.Ascoltatori.Registrazione;

import it.unisalento.view.InizioJFrame;
import it.unisalento.view.RegistrazioneJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class AscoltatoreEsci implements ActionListener 
{
	private JFrame frame;
	
	public AscoltatoreEsci(JFrame frame)
	{
		this.frame = frame;
	}

	
	public void actionPerformed(ActionEvent e) 
	{
		new InizioJFrame(); 
		frame.dispose();

	}

}

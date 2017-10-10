package it.unisalento.view.Ascoltatori.Registrazione;

import it.unisalento.view.RegistrazioneJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AscoltatoreOperatoreNull implements ActionListener 
{
	private RegistrazioneJFrame frame;

	public AscoltatoreOperatoreNull(RegistrazioneJFrame frame)
	{
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		JOptionPane.showMessageDialog(null, "Bottone non Attivo");

	}

}

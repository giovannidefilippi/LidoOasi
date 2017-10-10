package it.unisalento.view.Ascoltatori.Registrazione;

import it.unisalento.business.ClienteBusiness;
import it.unisalento.view.InizioJFrame;
import it.unisalento.view.RegistrazioneJFrame;
import it.unisalento.view.RegistrazioneOpJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AscoltatoreVerificaOp implements ActionListener 
{
	RegistrazioneOpJFrame frame;
	
	public AscoltatoreVerificaOp(RegistrazioneOpJFrame frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) throws IllegalArgumentException
	{
		JTextField user = frame.username;
		
		try
		{
		boolean usernameEsiste = ClienteBusiness.getInstance().verificaUsername(Integer.parseInt(user.getText()));
		if(usernameEsiste)
		{
		JOptionPane.showMessageDialog(null, "Il valore inserito è già utilizzato.Scegli un altro numero.");
		
		}
	    
	else
		JOptionPane.showMessageDialog(null, "Valore accettabile.Puoi confermare la registrazione!");
		}
		catch (NumberFormatException numb)
		{
		 JOptionPane.showMessageDialog(null, "Valori inseriti non corretti,fai attenzione username deve essere un numero!!");
		}

	}

}

package it.unisalento.view.Ascoltatori.Registrazione;

import it.unisalento.business.BagninoBusiness;
import it.unisalento.view.RegistrazioneOpJFrameAmministratore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AscoltatoreVerificaOpAmministratore implements ActionListener 
{
	RegistrazioneOpJFrameAmministratore frame;
	
	public AscoltatoreVerificaOpAmministratore(RegistrazioneOpJFrameAmministratore frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) throws IllegalArgumentException
	{
		JTextField user = frame.username;
		
		try
		{
			//rifare x Bagnino
		boolean usernameBagninoEsiste = BagninoBusiness.getInstance().verificaUsername(Integer.parseInt(user.getText()));
		if(usernameBagninoEsiste)
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

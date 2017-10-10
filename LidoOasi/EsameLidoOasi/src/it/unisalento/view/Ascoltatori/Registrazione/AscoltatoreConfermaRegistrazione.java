package it.unisalento.view.Ascoltatori.Registrazione;

import it.unisalento.business.ClienteBusiness;
import it.unisalento.view.RegistrazioneJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AscoltatoreConfermaRegistrazione implements ActionListener 
{
	private RegistrazioneJFrame frame;
	
	
	
	
	public AscoltatoreConfermaRegistrazione(RegistrazioneJFrame frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) throws IllegalArgumentException
	{
		
		JTextField nome = frame.nome;
		JTextField cognome = frame.cognome;
		JTextField età = frame.età;
		JTextField Email = frame.Email;
		JTextField username = frame.username;
		JTextField password = frame.password;
		
		char sesso = AscoltatoreSesso.getSesso();
		
		
	try
		{
		boolean registrato = ClienteBusiness.getInstance().registraCliente(Integer.parseInt(username.getText()), nome.getText(), cognome.getText(), password.getText(), Integer.parseInt(età.getText()), sesso, Email.getText(),0);
		if(registrato)
		   {
			JOptionPane.showMessageDialog(null, "Registrazione effettuata.Clicca ok per continuare!");
		new RegistrazioneJFrame();
		frame.dispose();
		   }
		else
		   { 
			JOptionPane.showMessageDialog(null, "Non è stato possibile effettuare registrazione.Clicca ok per continuare!");
		   }
		}
		catch (NumberFormatException numb)
		 {
			JOptionPane.showMessageDialog(null, "Valori inseriti non corretti,fai attenzione username deve essere un numero!!");
		 }
	}

}

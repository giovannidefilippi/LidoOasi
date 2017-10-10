package it.unisalento.view.Ascoltatori.Registrazione;

import it.unisalento.business.ClienteBusiness;
import it.unisalento.view.RegistrazioneOpJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AscoltatoreConfermaRegistrazioneOp implements ActionListener 
{
	private RegistrazioneOpJFrame frame;
	
	
	
	
	public AscoltatoreConfermaRegistrazioneOp(RegistrazioneOpJFrame frame)
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
		int codice = frame.getCodiceOperatore();
		
		try
		{
			if (codice == 0)
				codice++;
		boolean registrato = ClienteBusiness.getInstance().registraCliente(Integer.parseInt(username.getText()), nome.getText(), cognome.getText(), password.getText(), Integer.parseInt(età.getText()), sesso, Email.getText(),codice);
		if(registrato)
		{
			JOptionPane.showMessageDialog(null, "Registrazione effettuata.Clicca ok per continuare!");
			frame.dispose();
		RegistrazioneOpJFrame ritorna =  new RegistrazioneOpJFrame();
		ritorna.setFlag(frame.getFlag());
		ritorna.setCodiceOperatore(codice);
		
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

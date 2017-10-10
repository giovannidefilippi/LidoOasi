package it.unisalento.view.Ascoltatori.Registrazione;

import it.unisalento.business.BagninoBusiness;
import it.unisalento.view.RegistrazioneOpJFrameAmministratore;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AscoltatoreConfermaRegistrazioneOpAmministratore implements ActionListener 
{
	private RegistrazioneOpJFrameAmministratore frame;
	
	
	
	
	public AscoltatoreConfermaRegistrazioneOpAmministratore(RegistrazioneOpJFrameAmministratore frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) throws IllegalArgumentException
	{
		
		JTextField nome = frame.nome;
		JTextField cognome = frame.cognome;
		JTextField età = frame.età;
		JTextField codiceAmministratore = frame.codiceAmministratore;
		JTextField username = frame.username;
		JTextField password = frame.password;
		
		char sesso = AscoltatoreSesso.getSesso();
			
	try
		{
			int codice = Integer.parseInt(codiceAmministratore.getText());
		    boolean registrato = BagninoBusiness.getInstance().registraBagnino(Integer.parseInt(username.getText()), nome.getText(), cognome.getText(), password.getText(), Integer.parseInt(età.getText()), sesso,codice);
		    if(registrato)
		      {
			JOptionPane.showMessageDialog(null, "Registrazione effettuata.Clicca ok per continuare!");
			RegistrazioneOpJFrameAmministratore ritorna =new RegistrazioneOpJFrameAmministratore();
			ritorna.setCodice(frame.getCodice());
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

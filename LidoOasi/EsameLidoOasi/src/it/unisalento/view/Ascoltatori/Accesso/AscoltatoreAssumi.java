package it.unisalento.view.Ascoltatori.Accesso;

import it.unisalento.view.InizioJFrame;
import it.unisalento.view.JFrameAmministratore;
import it.unisalento.view.JFrameBagnino;
import it.unisalento.view.RegistrazioneJFrame;
import it.unisalento.view.RegistrazioneOpJFrame;
import it.unisalento.view.RegistrazioneOpJFrameAmministratore;
import it.unisalento.view.Ascoltatori.Login.AscoltatoreAmministratore;
import it.unisalento.view.Ascoltatori.Login.AscoltatoreBagnino;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class AscoltatoreAssumi implements ActionListener 
{

private JFrameAmministratore frame;
private int codiceAmministratore;
	
	public AscoltatoreAssumi(JFrameAmministratore frame)
	{
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
		frame.dispose();
			
		RegistrazioneOpJFrameAmministratore nuovo =  
				new RegistrazioneOpJFrameAmministratore(); 
			nuovo.setCodice(frame.getCodiceAmministratore());

	}

	public int getCodiceAmministratore() {
		return codiceAmministratore;
	}

	public void setCodiceAmministratore(int codiceAmministratore) {
		this.codiceAmministratore = codiceAmministratore;
	}


}

package it.unisalento.view.Ascoltatori.Accesso;

import it.unisalento.view.InizioJFrame;
import it.unisalento.view.JFrameAmministratore;
import it.unisalento.view.JFrameBagnino;
import it.unisalento.view.RegistrazioneJFrame;
import it.unisalento.view.RegistrazioneOpJFrame;
import it.unisalento.view.Ascoltatori.Login.AscoltatoreAmministratore;
import it.unisalento.view.Ascoltatori.Login.AscoltatoreBagnino;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class AscoltatoreRegistra implements ActionListener 
{

private JFrame frame;
private int flag;
private int operatore;
	
	public AscoltatoreRegistra(JFrame frame)
	{
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
		if (frame instanceof JFrameBagnino)
		{
			operatore = ((JFrameBagnino)frame).getCodiceBagnino();
			flag = 0;
			}
		else if (frame instanceof JFrameAmministratore)
		{
			operatore = ((JFrameAmministratore)frame).getCodiceAmministratore();
			flag = 1;}
			
		RegistrazioneOpJFrame reg = new RegistrazioneOpJFrame(); 
		reg.setFlag(flag);
		reg.setCodiceOperatore(operatore);
		
		frame.dispose();
		

	}


}

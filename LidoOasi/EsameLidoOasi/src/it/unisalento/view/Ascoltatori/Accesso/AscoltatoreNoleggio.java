package it.unisalento.view.Ascoltatori.Accesso;

import it.unisalento.view.JFrameAmministratore;
import it.unisalento.view.JFrameBagnino;
import it.unisalento.view.NoleggioJFrame;
import it.unisalento.view.RegistrazioneOpJFrame;
import it.unisalento.view.Ascoltatori.Login.AscoltatoreAmministratore;
import it.unisalento.view.Ascoltatori.Login.AscoltatoreBagnino;
import it.unisalento.view.FrameAccessori.CarrelloDellaSpesa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class AscoltatoreNoleggio implements ActionListener
{
   private	JFrame frame;
	public  int codiceOperatore;
	private int flag;
	
	public AscoltatoreNoleggio(JFrame frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{

	
		
		if (frame instanceof JFrameBagnino)
		{
			flag = 0;
			codiceOperatore = ((JFrameBagnino)frame).getCodiceBagnino();
			}
		else if (frame instanceof JFrameAmministratore)
		{
			flag = 1;
			codiceOperatore = ((JFrameAmministratore)frame).getCodiceAmministratore();
			}
		
		NoleggioJFrame nol = new NoleggioJFrame(); 
		nol.setCodiceOperatore(codiceOperatore);
		nol.setFlag(flag);	
		
		
		frame.dispose();

	}

	public int getCodiceOperatore() {
		return codiceOperatore;
	}

	public void setCodiceOperatore(int codiceOperatore) {
		this.codiceOperatore = codiceOperatore;
	}
	

}

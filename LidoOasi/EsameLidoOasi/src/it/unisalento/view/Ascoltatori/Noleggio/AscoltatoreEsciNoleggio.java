package it.unisalento.view.Ascoltatori.Noleggio;

import it.unisalento.view.JFrameAmministratore;
import it.unisalento.view.JFrameBagnino;
import it.unisalento.view.NoleggioJFrame;
import it.unisalento.view.Ascoltatori.Accesso.AscoltatoreNoleggio;
import it.unisalento.view.Ascoltatori.Login.AscoltatoreAmministratore;
import it.unisalento.view.Ascoltatori.Login.AscoltatoreBagnino;
import it.unisalento.view.FrameAccessori.CarrelloDellaSpesa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class AscoltatoreEsciNoleggio implements ActionListener
{
	NoleggioJFrame frame;
		
	public AscoltatoreEsciNoleggio(NoleggioJFrame frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
				
		if (frame.getFlag() == 0 )
		{
			JFrameBagnino nuovo =  new JFrameBagnino();
		    nuovo.setCodiceBagnino(frame.getCodiceOperatore());	
		}
		else if (frame.getFlag() == 1)
		{
			JFrameAmministratore nuovo = new JFrameAmministratore();
			nuovo.setCodiceAmministratore(frame.getCodiceOperatore());
		}
			
		
		frame.dispose();
		frame.getCarrello().dispose();
		frame.getLettini().dispose();

	}

	

}

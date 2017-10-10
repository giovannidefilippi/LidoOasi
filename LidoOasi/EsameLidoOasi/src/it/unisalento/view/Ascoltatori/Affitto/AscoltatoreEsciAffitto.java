package it.unisalento.view.Ascoltatori.Affitto;


import it.unisalento.view.AffittoJFrame;
import it.unisalento.view.JFrameAmministratore;
import it.unisalento.view.JFrameBagnino;
import it.unisalento.view.NoleggioJFrame;
import it.unisalento.view.Ascoltatori.Accesso.AscoltatoreNoleggio;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class AscoltatoreEsciAffitto implements ActionListener
{
	AffittoJFrame frame;
		
	public AscoltatoreEsciAffitto(AffittoJFrame frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		
		if (frame.getFlag() == 0)
		{
			JFrameBagnino nuovo =   new JFrameBagnino();
		    nuovo.setCodiceBagnino(frame.getOperatore());	
		}
		else if (frame.getFlag() == 1)
		{
			JFrameAmministratore nuovo =	new JFrameAmministratore();
			nuovo.setCodiceAmministratore(frame.getOperatore());	
		}
			
		
		frame.dispose();
		frame.carrelloAffitto.dispose();//Aggiungere chiusure Ulteriorii
		//frame.getLettini().dispose();

	}

	

}

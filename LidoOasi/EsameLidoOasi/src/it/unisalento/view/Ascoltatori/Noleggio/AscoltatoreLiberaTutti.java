package it.unisalento.view.Ascoltatori.Noleggio;
import it.unisalento.business.SistemaBusiness;
import it.unisalento.view.NoleggioJFrame;
import it.unisalento.view.Ascoltatori.Accesso.AscoltatoreNoleggio;
import it.unisalento.view.FrameAccessori.CarrelloDellaSpesa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AscoltatoreLiberaTutti implements ActionListener 
{
	NoleggioJFrame frame;
		
	public AscoltatoreLiberaTutti(NoleggioJFrame frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
				
	  boolean liberati = SistemaBusiness.getInstance().liberaTutti();
	  NoleggioJFrame libero =new NoleggioJFrame();
	  libero.setCodiceOperatore(frame.getCodiceOperatore());
	  libero.setFlag(frame.getFlag());
	  frame.dispose();
	  frame.getCarrello().dispose();
	  frame.getLettini().dispose();
	}

}

package it.unisalento.view.Ascoltatori.VisualizzaStorico;

import it.unisalento.view.JFrameAmministratore;
import it.unisalento.view.JFrameBagnino;
import it.unisalento.view.JFrameCliente;
import it.unisalento.view.VisualizzaStoricoJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AscoltatoreProseguiStorico implements ActionListener {

	VisualizzaStoricoJFrame frame;

public AscoltatoreProseguiStorico(VisualizzaStoricoJFrame frame)
{
	this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent arg0)
	{
		frame.dispose();
		if(frame.getCodiceOp() == 0)
		{
		JFrameCliente nuovo = new JFrameCliente();
		nuovo.setIdCliente(frame.getCodiceCliente());
		}
		else
		   {
			 if(frame.getFlag() == 0)
			 {
				 
				 JFrameBagnino nuovo = new JFrameBagnino();
				 nuovo.setCodiceBagnino(frame.getCodiceOp());
				 
			 }
			 else if (frame.getFlag()== 1)
			 {
				 JFrameAmministratore nuovo = new JFrameAmministratore();
				 nuovo.setCodiceAmministratore(frame.getCodiceOp());
				 
			 }
		   }

	}

}

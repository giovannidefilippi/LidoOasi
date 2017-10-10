package it.unisalento.view.Ascoltatori.Accesso;

import it.unisalento.view.JFrameCliente;
import it.unisalento.view.VisualizzaStoricoJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AscoltatoreAccessoClientiStorico implements ActionListener
{
	JFrameCliente frame;

	public AscoltatoreAccessoClientiStorico(JFrameCliente frame)
	{
		this.frame = frame;
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		VisualizzaStoricoJFrame nuovo = new VisualizzaStoricoJFrame();
		nuovo.setCodiceCliente(frame.getIdCliente());
		frame.dispose();

	}

}

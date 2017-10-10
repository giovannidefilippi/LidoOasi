package it.unisalento.view.Ascoltatori.Accesso;

import it.unisalento.view.JFrameAmministratore;
import it.unisalento.view.JFrameBagnino;
import it.unisalento.view.VisualizzaStoricoJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class AscoltatoreAccessoStorico implements ActionListener 
{
	JFrame frame;

   public AscoltatoreAccessoStorico(JFrame frame)
   {
	   this.frame = frame;
   }

	public void actionPerformed(ActionEvent arg0) 
	{
         if(frame instanceof JFrameBagnino)
         {
        	 frame.dispose();
        	 VisualizzaStoricoJFrame nuovo = new VisualizzaStoricoJFrame();
        	 nuovo.setCodiceOp(((JFrameBagnino)frame).getCodiceBagnino());
        	 nuovo.setFlag(0);
         }
         else if (frame instanceof JFrameAmministratore)
         {
        	 frame.dispose();
        	 VisualizzaStoricoJFrame nuovo = new VisualizzaStoricoJFrame();
        	 nuovo.setCodiceOp(((JFrameAmministratore)frame).getCodiceAmministratore());
        	 nuovo.setFlag(1);
         }

	}

}

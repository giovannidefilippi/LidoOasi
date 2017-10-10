package it.unisalento.view.Ascoltatori.Accesso;


import it.unisalento.view.AffittoJFrame;
import it.unisalento.view.ConfermaPrenotazioniJFrame;
import it.unisalento.view.JFrameAmministratore;
import it.unisalento.view.JFrameBagnino;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class AscoltatoreAffitto implements ActionListener
{
	private JFrame frame;
	private  int codiceOperatore;
	private int flag;
	
	public AscoltatoreAffitto(JFrame frame)
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
		else if (frame instanceof ConfermaPrenotazioniJFrame)
		{
			flag = 1;
			codiceOperatore = ((ConfermaPrenotazioniJFrame)frame).getCodiceAmministratore();
		}
		
		AffittoJFrame nuovo = new AffittoJFrame(); 
		nuovo.setOperatore(codiceOperatore);	
		nuovo.setFlag(flag);
		
		frame.dispose();

	}

	public int getCodiceOperatore() {
		return codiceOperatore;
	}

	public void setCodiceOperatore(int codiceOperatore) {
		this.codiceOperatore = codiceOperatore;
	}
	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}

package it.unisalento.view.Ascoltatori.Registrazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AscoltatoreOperatoreAttivo implements ActionListener 
{
	private JFrame frame;
	private  int codiceOperatore;

	public AscoltatoreOperatoreAttivo(JFrame frame)
	{
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
		String in = JOptionPane.showInputDialog(null, "Inserisci codice Operatore");
		codiceOperatore = Integer.parseInt(in);
		

	}

	public int getCodiceOperatore() {
		return codiceOperatore;
	}

	public void setCodiceOperatore(int codiceOperatore) {
		this.codiceOperatore = codiceOperatore;
	}
	
	

}

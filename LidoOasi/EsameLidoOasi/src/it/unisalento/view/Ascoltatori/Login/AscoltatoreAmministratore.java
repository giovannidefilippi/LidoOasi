package it.unisalento.view.Ascoltatori.Login;

import it.unisalento.business.AmministratoreBusiness;
import it.unisalento.model.Amministratore;
import it.unisalento.view.InizioJFrame;
import it.unisalento.view.JFrameAmministratore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AscoltatoreAmministratore implements ActionListener {

	private InizioJFrame frame;
	//public Amministratore correnteAmministratore;
	private  int codiceAmministratore;
	
	public AscoltatoreAmministratore(InizioJFrame frame)
	{
		this.frame = frame;
	}
	@Override
	public void actionPerformed (ActionEvent e)throws IllegalArgumentException
	{
		JTextField user = frame.usernameOp;
		JTextField psw = frame.passwordOp;
		try
		{
		boolean utenteEsiste = AmministratoreBusiness.getInstance().verificaLogin(Integer.parseInt(user.getText()),psw.getText());
		if(utenteEsiste)
		{
		JOptionPane.showMessageDialog(null, "Amministratore riconosciuto.Clicca ok per accedere.");
		//Passi successivi area amministratore
		codiceAmministratore = Integer.parseInt(user.getText());
		frame.dispose();
		JFrameAmministratore amm =   new JFrameAmministratore();
		amm.setCodiceAmministratore(codiceAmministratore);
		
		}
	    
	else
		{
		JOptionPane.showMessageDialog(null, "Amministratore  non riconosciuto!");
		new InizioJFrame(); 
		frame.dispose();
		}
		
		}
		catch (NumberFormatException numb)
		{
		 JOptionPane.showMessageDialog(null, "Valori inseriti non corretti,fai attenzione username deve essere un numero!!");
		}
		
	}
	public int getCodiceAmministratore() {
		return codiceAmministratore;
	}
	public void setCodiceAmministratore(int codiceAmministratore) {
		this.codiceAmministratore = codiceAmministratore;
	}
	

}

package it.unisalento.view.Ascoltatori.Login;

import it.unisalento.business.ClienteBusiness;
import it.unisalento.view.InizioJFrame;
import it.unisalento.view.JFrameCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AscoltatoreCliente implements ActionListener {

    private InizioJFrame frame;
    private  int codiceCliente;
	
	public AscoltatoreCliente(InizioJFrame frame)
	{
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) throws IllegalArgumentException
	{
		JTextField user = frame.usernameCliente;
		JTextField psw = frame.passwordCliente;
try
	{
		boolean utenteEsiste = ClienteBusiness.getInstance().verificaLogin(Integer.parseInt(user.getText()),psw.getText());
		if(utenteEsiste)
		{
		JOptionPane.showMessageDialog(null, "Cliente riconosciuto.Clicca ok per accedere!");
		codiceCliente =Integer.parseInt(user.getText());
		JFrameCliente nuovo = new JFrameCliente(); 
		nuovo.setIdCliente(codiceCliente);
		frame.dispose();
		}
	    
	else
		{
		JOptionPane.showMessageDialog(null, "Cliente non riconosciuto.Riprova o effettua Registrazione.");
		new InizioJFrame(); 
		frame.dispose();
		}
	}
		catch (NumberFormatException numb)
		{
		 JOptionPane.showMessageDialog(null, "Valori inseriti non corretti,fai attenzione username deve essere un numero!!");
		}
		
	}
	public  int getCodice()
	{
		return codiceCliente;
	}



}

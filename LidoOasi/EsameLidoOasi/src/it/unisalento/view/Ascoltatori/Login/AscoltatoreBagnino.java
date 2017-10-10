package it.unisalento.view.Ascoltatori.Login;


import it.unisalento.business.BagninoBusiness;
import it.unisalento.view.InizioJFrame;
import it.unisalento.view.JFrameBagnino;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AscoltatoreBagnino implements ActionListener {

   private InizioJFrame frame;
    private  int codiceBagnino;
	
	public AscoltatoreBagnino(InizioJFrame frame)
	{
		this.frame = frame;
		
	}
	@Override
	public void actionPerformed(ActionEvent e)throws IllegalArgumentException
	{
		JTextField user = frame.usernameOp;
		JTextField psw = frame.passwordOp;
try
	{
		boolean utenteEsiste = BagninoBusiness.getInstance().verificaLogin(Integer.parseInt(user.getText()),psw.getText());
		if(utenteEsiste)
		{
		JOptionPane.showMessageDialog(null, "Bagnino riconosciuto!Clicca ok per accedere");
		codiceBagnino = Integer.parseInt(user.getText());
		frame.dispose();
		JFrameBagnino bag =new JFrameBagnino();
		bag.setCodiceBagnino(codiceBagnino);
	
		}
	    
	else
		{
		JOptionPane.showMessageDialog(null, "Bagnino  non riconosciuto");
		new InizioJFrame();
		frame.dispose();
		}
	}
catch (NumberFormatException numb)
		{
		 JOptionPane.showMessageDialog(null, "Valori inseriti non corretti,fai attenzione username deve essere un numero!!");
		}
		
	}
	public int getCodiceBagnino() {
		return codiceBagnino;
	}
	public void setCodiceBagnino(int codiceBagnino) {
		this.codiceBagnino = codiceBagnino;
	}
	

}

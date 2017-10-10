package it.unisalento.view;

import it.unisalento.view.Ascoltatori.Login.AscoltatoreAmministratore;
import it.unisalento.view.Ascoltatori.Login.AscoltatoreBagnino;
import it.unisalento.view.Ascoltatori.Login.AscoltatoreCliente;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InizioJFrame extends JFrame 
{
	public JTextField usernameCliente = new JTextField(10);
	public JPasswordField passwordCliente = new JPasswordField(10);
	public JLabel user1 = new JLabel("                     Inserisci username");
    public JLabel psw1 = new JLabel("                      Inserisci password");
    public JLabel user2 = new JLabel("                     Inserisci username");
    public JLabel psw2 = new JLabel("                      Inserisci password");
	public JButton loginClienti  = new JButton("Effettua login");
	public JButton registrazione = new JButton("Lido Oasi");
	public JTextField usernameOp = new JTextField(10);
	public JPasswordField passwordOp = new JPasswordField(10);
	public JButton loginAmmin = new JButton("Login Amministratore");
    public JButton loginBagnino = new JButton("Login Bagnino");
    
    public InizioJFrame()
    {
    	super("Finestra Iniziale di ACCESSO AL LIDO OASI");
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel pannello = new JPanel();
		pannello.setLayout(new GridLayout(1, 4));
		pannello.add(new JLabel(""));
		pannello.add(new JLabel("Area  Clienti"));
		pannello.add(new JLabel(""));
		pannello.add(new JLabel("Area  Riservata"));
		
		JPanel centro = new JPanel();
		centro.setLayout(new GridLayout(6, 4));
		centro.add(user1);
		centro.add(usernameCliente);
		centro.add(user2);
		centro.add(usernameOp);
		centro.add(new JLabel(""));
		centro.add(new JLabel(""));
		centro.add(new JLabel(""));
		centro.add(new JLabel(""));
		centro.add(psw1);
		centro.add(passwordCliente);
		centro.add(psw2);
		centro.add(passwordOp);
		centro.add(new JLabel(""));
		centro.add(new JLabel(""));
		centro.add(new JLabel(""));
		centro.add(new JLabel(""));
		centro.add(new JLabel("Se sei un cliente registrato"));
		centro.add(new JLabel("Se non sei registrato"));
		centro.add(new JLabel(""));
		centro.add(new JLabel(""));
		centro.add(loginClienti);
		//centro.add(registrazione);
		centro.add(loginAmmin);
		centro.add(loginBagnino);
		
		c.add(pannello,BorderLayout.NORTH);
		c.add(centro,BorderLayout.CENTER);
		pack();
		loginAmmin.addActionListener(new AscoltatoreAmministratore(this));
		loginBagnino.addActionListener(new AscoltatoreBagnino(this));
		loginClienti.addActionListener(new AscoltatoreCliente(this));
		//registrazione.addActionListener(new AscoltatoreRegistrazione(this));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int) ((dim.getWidth()-this.getWidth())/2) ,(int)((dim.getHeight()-this.getHeight())/2)-160);
		
		this.setSize(1000,480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
    }

}

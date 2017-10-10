package it.unisalento.view;

import it.unisalento.utility.Logo;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreConfermaRegistrazione;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreConfermaRegistrazioneOp;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreConfermaRegistrazioneOpAmministratore;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreEsci;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreOperatoreAttivo;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreOperatoreNull;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreProsegui;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreProseguiAmministratore;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreSesso;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreStampa;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreStampaAmministratore;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreVerifica;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreVerificaOp;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreVerificaOpAmministratore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegistrazioneOpJFrameAmministratore extends JFrame 
{
	public JLabel etich = new JLabel("Inserire i dati richiesti e dopo selezionare 'CONFERMA REGISTRAZIONE'");
	public JLabel etich3 = new JLabel("Nome");
	public JLabel etich4 = new JLabel("Cognome");
	public JLabel etich5 = new JLabel("Età");
	public JLabel etich6 = new JLabel("Sesso");
	public JLabel etich7 = new JLabel("Codice Amministratore");
	public JLabel etich8 = new JLabel("Username");
	public JLabel etich9 = new JLabel("Password");
	public JPanel nord = new JPanel();
	public JPanel centro = new JPanel();
	public JTextField nome = new JTextField(15);
	public JTextField cognome = new JTextField(15);
	public JTextField età = new JTextField(2);
	public JTextField codiceAmministratore = new JTextField(6);
	public JTextField username = new JTextField(8);
	public JPasswordField password = new JPasswordField(8);
	public JLabel verifica = new JLabel("Verifica che l'username non sia gia' stato assegnato.Clicca");
	public JButton bottoneVerifica = new JButton("Verifica username");
	public JPanel sesso = new JPanel();
	public JRadioButton maschio = new JRadioButton("maschio");
	public JRadioButton femmina = new JRadioButton("femmina");
	public JButton exit = new JButton("Esci");
	public JButton conferma = new JButton("Conferma Registrazione");
	public JButton stampa = new JButton("Stampa su file");
	public JButton esci = new JButton("Prosegui");
	public JPanel pan1 = new JPanel();
	public JPanel pan2 = new JPanel();
	public JPanel pan3 = new JPanel();
	public JPanel pan4 = new JPanel();
	public JPanel pan5	= new JPanel();
	public JPanel pan6 = new JPanel();
	public JPanel pan7 = new JPanel();
	public JPanel pan8 = new JPanel();
	public JPanel pan9 = new JPanel();
	public JPanel pan10 = new JPanel();
	public JButton bottoneLogo1 = new JButton("");
	public JButton bottoneLogo2 = new JButton("");
	public JButton bottoneLogo3 = new JButton("");
	public JButton bottoneLogo4 = new JButton("");
	public ButtonGroup gruppo = new ButtonGroup();
	public JLabel attenzione = new JLabel("Solo a Registrazione Effettuata!");
	private int codice;
	private int flag;
	
	public RegistrazioneOpJFrameAmministratore()
	{
		super("Finestra  di REGISTRAZIONE BAGNINO AL LIDO OASI -Assunzione-");
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		
		centro.setLayout(new GridLayout(7, 2));
	   
	   c.add(nord,BorderLayout.NORTH);
	   c.add(centro,BorderLayout.CENTER);
	   
	    
	    
	    nord.add(etich);
	    
	    sesso.add(maschio);
	    sesso.add(femmina);
	    
	    
	    pan6.setBackground(Color.pink);
        
	    bottoneLogo1.add(new Logo());
	    bottoneLogo2.add(new Logo());
	    bottoneLogo3.add(new Logo());
	    bottoneLogo4.add(new Logo());

	    centro.add(bottoneLogo1);
	    centro.add(bottoneLogo2);
	    
	    centro.add(pan1);
	    centro.add(pan2);
	    centro.add(pan3);
	    centro.add(pan4);
	    centro.add(pan5);
	    centro.add(pan6);
	    centro.add(pan7);
	    centro.add(pan8);
	    centro.add(pan9);
	    centro.add(pan10);
	    
	    centro.add(bottoneLogo3);
	    centro.add(bottoneLogo4);
	    
	   	   
	   pan1.add(etich3);
	   pan1.add(nome);
	   pan2.add(etich4);
	   pan2.add(cognome);
	   
	   
	   pan3.add(etich5);
	   pan3.add(età);
	   pan4.add(etich6);
	   pan4.add(sesso);
	   
	   pan5.add(etich7);
	   pan5.add(codiceAmministratore);
	   pan6.add(etich8);
	   pan6.add(username);
	   
	   pan7.add(etich9);
	   pan7.add(password);
	   pan8.add(verifica);
	   pan8.add(bottoneVerifica);

	   pan9.add(exit);
	   pan9.add(conferma);
	   pan10.add(attenzione);
	   pan10.add(stampa);
	   pan10.add(esci);
	   
	   
	   gruppo.add(maschio);
	   gruppo.add(femmina);
	    //Assegnazione  Ascoltatori
	   
	   maschio.addActionListener(new AscoltatoreSesso(this));
	   femmina.addActionListener(new AscoltatoreSesso(this));
	   
	   
	   exit.addActionListener(new AscoltatoreEsci(this));
	   conferma.addActionListener(new AscoltatoreConfermaRegistrazioneOpAmministratore(this));//new AscoltatoreConfermaRegistrazioneOpAmministratore(this)
	   esci.addActionListener(new AscoltatoreProseguiAmministratore(this));
	   bottoneVerifica.addActionListener(new AscoltatoreVerificaOpAmministratore(this));//new AscoltatoreVerificaOpAmministratore(this)
	   stampa.addActionListener(new AscoltatoreStampaAmministratore(this));
	
	
	
	this.setSize(1200,600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	}
	
	public void setFlag(int i)
	{
		this.flag = i;
	}
	
	public int getFlag()
	{
		return flag;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}
	
}

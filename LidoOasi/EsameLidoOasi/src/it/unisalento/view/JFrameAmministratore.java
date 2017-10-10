package it.unisalento.view;

import it.unisalento.utility.Logo;
import it.unisalento.view.Ascoltatori.Accesso.AscoltatoreAccessoStorico;
import it.unisalento.view.Ascoltatori.Accesso.AscoltatoreAffitto;
import it.unisalento.view.Ascoltatori.Accesso.AscoltatoreAssumi;
import it.unisalento.view.Ascoltatori.Accesso.AscoltatoreNoleggio;
import it.unisalento.view.Ascoltatori.Accesso.AscoltatoreRegistra;
import it.unisalento.view.Ascoltatori.Accesso.AscoltatoreVerificaPrenotazione;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreConfermaRegistrazioneOp;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreEsci;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameAmministratore extends JFrame 
{

	JButton registra = new JButton("Registra Cliente");
	JButton visualizzaStorico = new JButton("Visualizza Storico");
	JButton affitta = new JButton("Affitta Cabina");
	JButton noleggia = new JButton("Noleggia Ombrelloni");
	JButton assumi = new JButton("Registra Bagnino");
	JButton verifica = new JButton("Verifica Prenotazione");
	JButton esci = new JButton("Esci");
	JButton vuoto1 = new JButton(" ");
	JButton vuoto2 = new JButton(" ");
	private int codiceAmministratore;
	
	
	public JFrameAmministratore()
	{
		super("Accesso Area AMMINISTRATORE");
		Container c = this.getContentPane(); 
		c.setLayout(new GridLayout(3,3));
		
		registra.add(new Logo());
		visualizzaStorico.add(new Logo());
		affitta.add(new Logo());
		noleggia.add(new Logo());
		assumi.add(new Logo());
		verifica.add(new Logo());
		esci.add(new Logo());
		vuoto1.add(new Logo());
		vuoto2.add(new Logo());
		
		c.add(registra);
		c.add(affitta);
		c.add(noleggia);
		c.add(visualizzaStorico);
		c.add(assumi);
		c.add(verifica);
		c.add(vuoto1);
		c.add(esci);
		c.add(vuoto2);
		
		esci.addActionListener(new AscoltatoreEsci(this));   // lo stesso di Registrazione
		registra.addActionListener(new AscoltatoreRegistra(this));
		affitta.addActionListener(new AscoltatoreAffitto(this));
		noleggia.addActionListener(new AscoltatoreNoleggio(this));
		visualizzaStorico.addActionListener(new AscoltatoreAccessoStorico(this));
		assumi.addActionListener(new AscoltatoreAssumi(this));
		verifica.addActionListener(new AscoltatoreVerificaPrenotazione(this));
		
		
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int) ((dim.getWidth()-this.getWidth())/2)-400 ,(int)((dim.getHeight()-this.getHeight())/2)-150);
		this.setSize(800,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	public int getCodiceAmministratore() {
		return codiceAmministratore;
	}

	public void setCodiceAmministratore(int codiceAmministratore) {
		this.codiceAmministratore = codiceAmministratore;
	}

	
	

}

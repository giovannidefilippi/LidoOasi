package it.unisalento.view;


import it.unisalento.business.SistemaBusiness;
import it.unisalento.model.Prenotazione;
import it.unisalento.view.Ascoltatori.Accesso.AscoltatoreAffitto;
import it.unisalento.view.Ascoltatori.ConfermaPrenotazione.AscoltatoreBrucia;
import it.unisalento.view.Ascoltatori.ConfermaPrenotazione.AscoltatoreRitorna;
import it.unisalento.view.Ascoltatori.ConfermaPrenotazione.AscoltatoreTutte;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreStampa;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ConfermaPrenotazioniJFrame extends JFrame

{
	private JPanel pannello0 = new JPanel();
	private JPanel pannello1 = new JPanel();
	private JPanel pannello2 = new JPanel();
	private JPanel pannello3 = new JPanel();
	private JPanel pannello4 = new JPanel();
	private JPanel pannello5 = new JPanel();
	private JPanel pannello6 = new JPanel();
	private JPanel pannello7 = new JPanel();
	
	public JButton tutte = new JButton("Visualizza Tutte");
	private JButton stampa = new JButton("Stampa Prenotazione");
	private JButton settaConfermato = new JButton("Brucia Prenotazione");
	private JButton confermaPrenotazione = new JButton("Vai agli Affitti");
	private JButton prosegui = new JButton("Prosegui");
	
	public JTextArea prenotazioni = new JTextArea(1280,400);
	
	private int codiceAmministratore;
    private ArrayList<Prenotazione> prenotazioniNon;
    
	
	public ConfermaPrenotazioniJFrame()
	{
		super("PRENOTAZIONI non confermate LIDO OASI");
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(3,1));
		c.add(pannello0);
		c.add(pannello1);
		c.add(pannello2);
		
		pannello2.setLayout(new GridLayout(1,5));
		
		pannello2.add(pannello3);
		pannello2.add(pannello7);
		
		pannello2.add(pannello5);
		pannello2.add(pannello4);
		pannello2.add(pannello6);
		
		pannello3.add(tutte);
		pannello4.add(settaConfermato);
		pannello5.add(confermaPrenotazione);
		pannello6.add(prosegui);
		pannello7.add(stampa);
		
		pannello0.setLayout(null);
		prenotazioni.setBounds(50, 50, 1130, 400);
		pannello0.add(prenotazioni);
		
		prenotazioniNon = SistemaBusiness.getInstance().getPrenotazioniNon();
		
			
		stampa.addActionListener(new AscoltatoreStampa(this));
		tutte.addActionListener(new AscoltatoreTutte(this));
		settaConfermato.addActionListener(new AscoltatoreBrucia(this));
		prosegui.addActionListener(new AscoltatoreRitorna(this));
		confermaPrenotazione.addActionListener(new AscoltatoreAffitto(this));
		
		
		pack();

		this.setSize(1280,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}


	public int getCodiceAmministratore() {
		return codiceAmministratore;
	}


	public void setCodiceAmministratore(int codiceAmministratore) {
		this.codiceAmministratore = codiceAmministratore;
	}


	public ArrayList<Prenotazione> getPrenotazioniNon() {
		return prenotazioniNon;
	}


	public void setPrenotazioniNon(ArrayList<Prenotazione> prenotazioniNon) {
		this.prenotazioniNon = prenotazioniNon;
	}
	
	
}

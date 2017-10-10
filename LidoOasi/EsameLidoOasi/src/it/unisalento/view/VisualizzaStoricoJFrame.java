package it.unisalento.view;


import it.unisalento.model.Affitto;
import it.unisalento.model.Noleggio;
import it.unisalento.model.Prenotazione;
import it.unisalento.utility.Logo;
import it.unisalento.view.Ascoltatori.VisualizzaStorico.AscoltatoreProseguiStorico;
import it.unisalento.view.Ascoltatori.VisualizzaStorico.AscoltatoreStampaStorico;
import it.unisalento.view.Ascoltatori.VisualizzaStorico.AscoltatoreVisualizzaStorico;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VisualizzaStoricoJFrame extends JFrame 
{
	private JPanel pannello1 = new JPanel();
	private JPanel pannello2 = new JPanel();
	private JPanel pannello3 = new JPanel();
	private JPanel pannello4 = new JPanel();
	private JPanel pannello5 = new JPanel();
	
	
	private JPanel pannelloA = new JPanel();
	private JPanel pannelloB = new JPanel();
	private JPanel pannelloC = new JPanel();
	private JPanel pannelloD = new JPanel();
	private JPanel pannelloE = new JPanel();
	
	private JLabel pren = new JLabel("PRENOTAZIONI");
	private JLabel aff = new JLabel("AFFITTI");
	private JLabel nol = new JLabel("NOLEGGI");
		
	public JButton a = new JButton("Visualizza Tutte");
	public JButton b = new JButton("Stampa Prenotazione");
	public JButton C = new JButton("Stampa Affitto");
	public JButton d = new JButton("Stampa Noleggio");
	public JButton e = new JButton("Prosegui");
	private JButton mare1 = new JButton();
	private JButton mare2 = new JButton();
	
	public JTextArea prenotazione = new JTextArea(1280,400);
	public JTextArea affitto = new JTextArea(1280,400);
	public JTextArea noleggio = new JTextArea(1280,400);
	
	private int codiceCliente ;
    private ArrayList<Prenotazione> prenotazioni;
    private ArrayList<Affitto> affitti;
    private ArrayList<Noleggio> noleggi;
    private int codiceOp;
    private int flag;
	
	public VisualizzaStoricoJFrame()
	{
		super("Storico Cliente LIDO OASI");
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(5,1));
		
		c.add(pannello1);
		c.add(pannello2);
		c.add(pannello3);
		c.add(pannello5);
		c.add(pannello4);
		
		pannello1.setLayout(null);
		pannello2.setLayout(null);
		pannello3.setLayout(null);
		pannello4.setLayout(new GridLayout(1,5));
		pannello5.setLayout(new GridLayout(1,2));
		
		pannelloA.add(a);
		pannelloB.add(b);
		pannelloC.add(C);
		pannelloD.add(d);
		pannelloE.add(e);
		
		pannello4.add(pannelloA);
		pannello4.add(pannelloB);
		pannello4.add(pannelloC);
		pannello4.add(pannelloD);
		pannello4.add(pannelloE);
		
		
			
		pren.setBounds(500, 10, 100, 100);
		pannello1.add(pren);
		prenotazione.setBounds(30, 70, 1170, 400);
		pannello1.add(prenotazione);
		
		
		aff.setBounds(530, 10, 100, 100);
		pannello2.add(aff);
		affitto.setBounds(30, 70, 1170, 400);
		pannello2.add(affitto);
		
		nol.setBounds(530, 10, 100, 100);
		pannello3.add(nol);
		noleggio.setBounds(30, 70, 1170, 400);
		pannello3.add(noleggio);
		mare1.add(new Logo());
		mare2.add(new Logo());
		pannello5.add(mare1);
		pannello5.add(mare2);
		
	//	prenotazioni = SistemaBusiness.getInstance().getTuttePrenotazioni(codiceCliente);
	//	affitti = SistemaBusiness.getInstance().getTuttiAffitti(codiceCliente);
	//	noleggi = SistemaBusiness.getInstance().getTuttiNoleggi(codiceCliente);		
			
		a.addActionListener(new AscoltatoreVisualizzaStorico(this));
		
		b.addActionListener(new AscoltatoreStampaStorico(this));
		b.setActionCommand(AscoltatoreStampaStorico.aA);
		
		C.addActionListener(new AscoltatoreStampaStorico(this));
		C.setActionCommand(AscoltatoreStampaStorico.bB);
		
		e.addActionListener(new AscoltatoreProseguiStorico(this));
		
		d.addActionListener(new AscoltatoreStampaStorico(this));
		d.setActionCommand(AscoltatoreStampaStorico.cC);
		
		
		pack();

		this.setSize(1280,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}


	public int getCodiceCliente() {
		return codiceCliente;
	}


	public void setCodiceCliente(int codiceCliente) {
		this.codiceCliente = codiceCliente;
	}


	public ArrayList<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}


	public void setPrenotazioni(ArrayList<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}


	public ArrayList<Affitto> getAffitti() {
		return affitti;
	}


	public void setAffitti(ArrayList<Affitto> affitti) {
		this.affitti = affitti;
	}


	public ArrayList<Noleggio> getNoleggi() {
		return noleggi;
	}


	public void setNoleggi(ArrayList<Noleggio> noleggi) {
		this.noleggi = noleggi;
	}


	public int getCodiceOp() {
		return codiceOp;
	}


	public void setCodiceOp(int codiceOp) {
		this.codiceOp = codiceOp;
	}


	public int getFlag() {
		return flag;
	}


	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	


}

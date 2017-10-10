package it.unisalento.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import it.unisalento.business.NoleggioBusiness;
import it.unisalento.business.SistemaBusiness;
import it.unisalento.model.Ombrellone;
import it.unisalento.utility.Logo;
import it.unisalento.utility.PallinoRossoOmbrellone;
import it.unisalento.utility.PallinoVerdeOmbrellone;
import it.unisalento.view.Ascoltatori.Noleggio.AscoltatoreConfermaNoleggio;
import it.unisalento.view.Ascoltatori.Noleggio.AscoltatoreEsciNoleggio;
import it.unisalento.view.Ascoltatori.Noleggio.AscoltatoreLiberaTutti;
import it.unisalento.view.Ascoltatori.Noleggio.AscoltatoreOmbrellone;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreStampa;
import it.unisalento.view.FrameAccessori.CarrelloDellaSpesa;
import it.unisalento.view.FrameAccessori.JFrameLettini;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NoleggioJFrame extends JFrame 
{
	JPanel pannello0 = new JPanel();
	JPanel pannello1 = new JPanel();
	JPanel pannello2 = new JPanel();
	JPanel pannello3 = new JPanel();
	JPanel pannello4 = new JPanel();
	JPanel pannello5 = new JPanel();
	JPanel pannello6 = new JPanel();
	
	public JButton ombr1 = new JButton("Ombrellone 1");
	private JButton ombr2 = new JButton("Ombrellone 2");
	private JButton ombr3 = new JButton("Ombrellone 3");
	private JButton ombr4 = new JButton("Ombrellone 4");
	private JButton ombr5 = new JButton("Ombrellone 5");
	private JButton ombr6 = new JButton("Ombrellone 6");
	private JButton ombr7 = new JButton("Ombrellone 7");
	private JButton ombr8 = new JButton("Ombrellone 8");
	private JButton ombr9 = new JButton("Ombrellone 9");
	private JButton ombr10 = new JButton("Ombrellone 10");
	private JButton mare1 = new JButton("Direzione  MARE");
	private JButton mare2 = new JButton("Direzione  MARE");
	private JButton cab1 = new JButton("Direzione CABINE");
	private JButton cab2 = new JButton("Direzione CABINE");
	private JButton conferma = new JButton("Conferma Ordine");
	private JButton esci = new JButton("Prosegui");
	private JButton stampa = new JButton("Stampa Noleggio");
	private JButton liberaTutti = new JButton("Libera Tutti");
	
	private JLabel libera = new JLabel("All'inizio della giornata");
	private JLabel fila1 = new JLabel("                                   FILA 1");
	private JLabel fila2 = new JLabel("                                   FILA 2");
	private JLabel attenzione = new JLabel("Stampare dopo aver confermato il noleggio!");
	private JLabel idNoleggio = new JLabel();
	
	private int flag;
	private CarrelloDellaSpesa carrello;
	private int codiceOperatore;
	public ArrayList<Ombrellone> ombrelloni;
	private JFrameLettini lettini;
	public int max;

	
	
	public NoleggioJFrame()
    {
    	super("NOLEGGIO OMBRELLONI LIDO OASI");
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(6,1));
		pannello1.setLayout(new GridLayout(1,2));
		pannello2.setLayout(new GridLayout(1,6));
		pannello3.setLayout(new GridLayout(1,6));
		pannello4.setLayout(new GridLayout(1,2));
		pannello0.setLayout(new GridLayout(1,2));
		
		c.add(pannello0);
		c.add(pannello1);
		c.add(pannello2);
		c.add(pannello3);
		c.add(pannello4);
		c.add(pannello5);
		
		pannello1.add(mare1);
		pannello0.add(idNoleggio);
		pannello0.add(pannello6);
		
		pannello6.add(libera);
		pannello6.add(liberaTutti);
		pannello1.add(mare2);
		
		pannello2.add(fila1);
		pannello2.add(ombr1);
		pannello2.add(ombr2);
		pannello2.add(ombr3);
		pannello2.add(ombr4);
		pannello2.add(ombr5);
		
		pannello3.add(fila2);
		pannello3.add(ombr6);
		pannello3.add(ombr7);
		pannello3.add(ombr8);
		pannello3.add(ombr9);
		pannello3.add(ombr10);
		
		pannello4.add(cab1);
		pannello4.add(cab2);
		
		pannello5.add(conferma);
		pannello5.add(attenzione);
		pannello5.add(stampa);
		pannello5.add(esci);
		
		mare1.add(new Logo());
		mare2.add(new Logo());
		cab1.add(new Logo());
		cab2.add(new Logo());
		
	    max = NoleggioBusiness.getInstance().getMaxIdNoleggio();
	    idNoleggio.setText("           Id Noleggio : "+(max+1));
		
		
		conferma.addActionListener(new AscoltatoreConfermaNoleggio(this));		
		esci.addActionListener(new AscoltatoreEsciNoleggio(this));// new AscoltatoreEsciNoleggio(this)
		stampa.addActionListener(new AscoltatoreStampa(this));//
		liberaTutti.addActionListener(new AscoltatoreLiberaTutti(this));//new AscoltatoreLiberaTutti(this)
		
		AscoltatoreOmbrellone listener = new AscoltatoreOmbrellone(this);
		
		ombr1.addActionListener(listener);//new AscoltatoreOmbrellone(this)
		ombr2.addActionListener(listener);
		ombr3.addActionListener(listener);
		ombr4.addActionListener(listener);
		ombr5.addActionListener(listener);
		ombr6.addActionListener(listener);
		ombr7.addActionListener(listener);
		ombr8.addActionListener(listener);
		ombr9.addActionListener(listener);
		ombr10.addActionListener(listener);
		
		
		JButton[] bottoni = {ombr1,ombr2,ombr3,ombr4,ombr5,ombr6,ombr7,ombr8,ombr9,ombr10}; 
		ombrelloni= SistemaBusiness.getInstance().verificaOmbrelloni();
		for(int i = 0; i<10;i++)
		{
			Ombrellone o = ombrelloni.get(i); 
			if(o.isOccupato())
			{
				bottoni[i].removeActionListener(listener);
				bottoni[i].add(new PallinoRossoOmbrellone());
				}
			else  
				bottoni[i].add(new PallinoVerdeOmbrellone());
		}
		
		
		
		carrello = new CarrelloDellaSpesa();
		lettini = new JFrameLettini();
		
		pack();
		
		
		this.setSize(1000,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
  }
	
	
	
	public int getCodiceOperatore() {
		return codiceOperatore;
	}



	public void setCodiceOperatore(int codiceOperatore) {
		this.codiceOperatore = codiceOperatore;
	}



	public CarrelloDellaSpesa getCarrello()
	{
		return carrello;
	}
	
	public JFrameLettini getLettini()
	{
		return lettini;
	}



	public int getFlag() {
		return flag;
	}



	public void setFlag(int flag) {
		this.flag = flag;
	}


	
	
}

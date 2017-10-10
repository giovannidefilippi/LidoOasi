package it.unisalento.view;

import it.unisalento.utility.Logo;
import it.unisalento.view.Ascoltatori.Accesso.AscoltatoreAccessoClientiStorico;
import it.unisalento.view.Ascoltatori.Accesso.AscoltatoreAccessoStorico;
import it.unisalento.view.Ascoltatori.Accesso.AscoltatoreAffitto;
import it.unisalento.view.Ascoltatori.Accesso.AscoltatoreNoleggio;
import it.unisalento.view.Ascoltatori.Accesso.AscoltatoreRegistra;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreEsci;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameBagnino extends JFrame 
{
	JButton registra = new JButton("Registra Cliente");
	JButton visualizzaStorico = new JButton("Visualizza Storico");
	JButton affitta = new JButton("Affitta Cabina");
	JButton noleggia = new JButton("  Noleggia Ombrelloni");
	JButton vuoto = new JButton(" ");
	JButton esci = new JButton("Esci");
	private int codiceBagnino;
	
		
		public JFrameBagnino()
		{
			super("Accesso Area BAGNINO");
			Container c = this.getContentPane(); 
			c.setLayout(new GridLayout(3,2));
			
			registra.add(new Logo());
			visualizzaStorico.add(new Logo());
			affitta.add(new Logo());
			noleggia.add(new Logo());
			vuoto.add(new Logo());
			esci.add(new Logo());
			
			c.add(registra);
			c.add(affitta);
			c.add(noleggia);
			c.add(visualizzaStorico);
			c.add(vuoto);
			c.add(esci);
			
			esci.addActionListener(new AscoltatoreEsci(this));
			registra.addActionListener(new AscoltatoreRegistra(this));
			affitta.addActionListener(new AscoltatoreAffitto(this));
			noleggia.addActionListener(new AscoltatoreNoleggio(this));// cominciamo...
			visualizzaStorico.addActionListener(new AscoltatoreAccessoStorico(this));
			
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			setLocation((int) ((dim.getWidth()-this.getWidth())/2)-250 ,(int)((dim.getHeight()-this.getHeight())/2)-150);
			this.setSize(500,300);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
			
		}


		public int getCodiceBagnino() {
			return codiceBagnino;
		}


		public void setCodiceBagnino(int codiceBagnino) {
			this.codiceBagnino = codiceBagnino;
		}
		
		
		


}

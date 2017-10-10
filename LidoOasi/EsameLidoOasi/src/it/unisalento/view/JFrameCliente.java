package it.unisalento.view;

import it.unisalento.utility.Logo;
import it.unisalento.view.Ascoltatori.Accesso.AscoltatoreAccessoClientiPrenota;
import it.unisalento.view.Ascoltatori.Accesso.AscoltatoreAccessoClientiStorico;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreEsci;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameCliente extends JFrame 
{
	JButton prenota = new JButton("Prenota Cabina");
	JButton visualizzaStorico = new JButton("Visualizza Storico");
	JButton vuoto = new JButton(" ");
	JButton esci = new JButton("Esci");
	int idCliente;
	
	public JFrameCliente()
	{
		super("Accesso Area CLIENTE");
		Container c = this.getContentPane(); 
		c.setLayout(new GridLayout(2,2));
		
		prenota.add(new Logo());
		visualizzaStorico.add(new Logo());
		vuoto.add(new Logo());
		esci.add(new Logo());
		
		c.add(prenota);
		c.add(visualizzaStorico);
		c.add(vuoto);
		c.add(esci);
		
		prenota.addActionListener(new AscoltatoreAccessoClientiPrenota(this));
		visualizzaStorico.addActionListener(new AscoltatoreAccessoClientiStorico(this));
		esci.addActionListener(new AscoltatoreEsci(this));
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int) ((dim.getWidth()-this.getWidth())/2)-250 ,(int)((dim.getHeight()-this.getHeight())/2)-100);
		this.setSize(500,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	

}

package it.unisalento.view.FrameAccessori;
import it.unisalento.utility.Logo;
import it.unisalento.view.Ascoltatori.Noleggio.AscoltatoreLettini;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JFrameLettini extends JFrame 
{
	public JRadioButton zero = new JRadioButton("0",true);
	public JRadioButton uno = new JRadioButton("1");
	public JRadioButton due = new JRadioButton("2");
	public JLabel clicca = new JLabel("Clicca sull'ombrellone scelto per confermare");
	public JPanel pannello = new JPanel();
	public JPanel pannello1 = new JPanel();
	public JPanel pannello2 = new JPanel();
	public JButton logo = new JButton("");
	public ButtonGroup gruppo = new ButtonGroup();
	
	private int numLettini;
	
	public JFrameLettini()
	{
		super("Numero LETTINI");
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(2,1));
		pannello.setLayout(new GridLayout(2,1));
		
		c.add(logo);
		c.add(pannello);
		pannello.add(pannello2);
		pannello.add(pannello1);
		
		pannello1.add(clicca);
		
		pannello2.add(zero);
		pannello2.add(uno);
		pannello2.add(due);
		
		//pannello1.add(logo);
		logo.add(new Logo());
		
		gruppo.add(zero);
		gruppo.add(uno);
		gruppo.add(due);
		
		zero.addActionListener(new AscoltatoreLettini(this));
		uno.addActionListener(new AscoltatoreLettini(this));
		due.addActionListener(new AscoltatoreLettini(this));
		
		
		
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int) (dim.getWidth()-275),(int)((dim.getHeight()-325)));
		
		this.setSize(270,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public int getNumLettini() {
		return numLettini;
	}

	public void setNumLettini(int numLettini) {
		this.numLettini = numLettini;
	}
	

	
}

package it.unisalento.view.FrameAccessori;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class CarrelloDellaSpesa extends JFrame
{
	public JButton codice = new JButton("Codice Cliente");
	public JButton cancella = new JButton("Cancella Ordine");
	public JButton bott3 = new JButton("3");
	public JButton bott4 = new JButton("4");
	public JPanel pannelloSup = new JPanel();
	public JPanel pannelloInf = new JPanel();
	public JPanel subPannelloInf = new JPanel();
	public JPanel pannelloBottoni = new JPanel();
	public JPanel pannelloBottoni1 = new JPanel();
	public JPanel pannelloBottoni2 = new JPanel();
	public JLabel costo = new JLabel("                            Costo TOTALE");
	public JTextField spesa = new JTextField(7);
	
	public JTextArea areaInf = new JTextArea();  // area ordine
	
	private int idCliente;
	
	public CarrelloDellaSpesa()
	 {
		super("Carrello della SPESA");
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(3,1));
		c.add(pannelloSup);
		c.add(pannelloInf);
		c.add(pannelloBottoni);
		
		pannelloSup.setLayout(null);
		Dimension areasup = areaInf.getPreferredSize();
		areaInf.setBounds(30, 10, 190, 250);
		pannelloSup.add(areaInf);
		
		pannelloInf.setLayout(new GridLayout(2,1));
		pannelloInf.add(costo);
		pannelloInf.add(subPannelloInf);
		
		subPannelloInf.add(spesa);
		
		pannelloBottoni.setLayout(new GridLayout(2,1));
		pannelloBottoni.add(pannelloBottoni1);
		pannelloBottoni.add(pannelloBottoni2);
		pannelloBottoni1.add(codice);
		pannelloBottoni2.add(cancella);
		
		codice.addActionListener(new AscoltatoreCodice(this));
	    cancella.addActionListener(new AscoltatoreCancella(this));
		
		
		
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	setLocation((int) (dim.getWidth()-255),(int)((dim.getHeight()-780)));
	
	this.setSize(250,400);
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

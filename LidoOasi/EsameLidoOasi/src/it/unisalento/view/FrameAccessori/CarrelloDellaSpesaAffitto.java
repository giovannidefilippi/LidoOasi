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

public class CarrelloDellaSpesaAffitto extends JFrame
{
	public JButton codice = new JButton("Codice Cliente");
	public JButton cancella = new JButton("Cancella Ordine");
	
	public JPanel pannello1 = new JPanel();
	public JPanel pannello2 = new JPanel();
	public JPanel pannello3 = new JPanel();
	public JPanel pannello4 = new JPanel();
	public JPanel subPannello2 = new JPanel();
	public JPanel pannello5 = new JPanel(); 
	public JPanel subPannello5 = new JPanel();
	public JPanel subPannelloInf = new JPanel();
	public JPanel pannelloBottoni = new JPanel();
	public JPanel pannelloBottoni1 = new JPanel();
	public JPanel pannelloBottoni2 = new JPanel();
	
	public JLabel costo = new JLabel("                       Costo GIORNALIERO");
	public JLabel costoTotale = new JLabel("                   Costo TOTALE");
	public JLabel servizi = new JLabel("                      SERVIZI AGGIUNTIVI");
	public JLabel giorni = new JLabel("                         NUMERO GIORNI");
	public JLabel cabina = new JLabel("                             CABINA");
	
	public JTextField spesa = new JTextField(7);
	public JTextField spesaTotale = new JTextField(7);
	public JTextField numGiorni =  new JTextField(4);
	public JTextArea areaSup = new JTextArea();
	public JTextArea areaInf = new JTextArea();
	
	private String[] service = {"","",""};
	private int codCliente;
	private AscoltatoreAffittoCodice ascoltatore;
	
	
	public CarrelloDellaSpesaAffitto()
	 {
		super("Carrello della SPESA");
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(6,1));
		c.add(pannello1);
		c.add(pannello2);
		c.add(pannello3);
		c.add(pannello5);
		
		c.add(pannello4);
		c.add(pannelloBottoni);
		
		pannello1.setLayout(new GridLayout(2,1));
			
		pannello1.add(cabina);
		pannello1.add(areaSup);
				
		pannello2.setLayout(new GridLayout(2,1));
				
		pannello2.add(servizi);
		pannello2.add(areaInf);
		
		pannello3.setLayout(new GridLayout(2,1));
		pannello3.add(costo);
		pannello3.add(subPannelloInf);
		
		pannello4.setLayout(new GridLayout(2,1));
		pannello4.add(costoTotale);
		pannello4.add(subPannello2);
		
		subPannelloInf.add(spesa);
		subPannello2.add(spesaTotale);
		
		pannello5.setLayout(new GridLayout(2,1));
		pannello5.add(giorni);
		subPannello5.add(numGiorni);
		pannello5.add(subPannello5);
		
		
		pannelloBottoni.setLayout(new GridLayout(2,1));
		pannelloBottoni.add(pannelloBottoni1);
		pannelloBottoni.add(pannelloBottoni2);
		pannelloBottoni1.add(codice);
		pannelloBottoni2.add(cancella);
		
		ascoltatore = new AscoltatoreAffittoCodice(this);
		
		codice.addActionListener(ascoltatore);
	    cancella.addActionListener(new AscoltatoreAffittoCancella(this));
	    
	 
			
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	setLocation((int) (dim.getWidth()-230),(int)((dim.getHeight()-800)));
	
	this.setSize(230,700);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	

   }


	public int getCodCliente() {
		return codCliente;
	}


	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}


	public AscoltatoreAffittoCodice getAscoltatore() {
		return ascoltatore;
	}


	public void setAscoltatore(AscoltatoreAffittoCodice ascoltatore) {
		this.ascoltatore = ascoltatore;
	}

	

}

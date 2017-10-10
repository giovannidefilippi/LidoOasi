package it.unisalento.view.Pannelli;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;


public class CalendarioPanel extends JPanel
{
	public JDateChooser calendarioInizio = new JDateChooser();
	public JDateChooser calendarioFine = new JDateChooser();
	private JPanel pannello = new JPanel();
	private JPanel pannello1 = new JPanel();
	
	private JLabel inizio = new JLabel("Inizio (compreso)");
	private JLabel fine = new JLabel("Fine (compreso)");
	
	
	
	
	
	public CalendarioPanel()
	    {
		
		this.setLayout(new GridLayout(2,2));
		pannello.add(calendarioInizio);
		pannello.add(inizio);
		pannello1.add(calendarioFine);
		pannello1.add(fine);
		
		
		
		this.add(pannello);
		this.add(pannello1);
		
		
		
		this.setSize(400, 400);
		
		this.setVisible(true);
	}



	public JDateChooser getCalendarioInizio() {
		return calendarioInizio;
	}



	public void setCalendarioInizio(JDateChooser calendarioInizio) {
		this.calendarioInizio = calendarioInizio;
	}



	public JDateChooser getCalendarioFine() {
		return calendarioFine;
	}



	public void setCalendarioFine(JDateChooser calendarioFine) {
		this.calendarioFine = calendarioFine;
	}



}

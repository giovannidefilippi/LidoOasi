package it.unisalento.view;
import it.unisalento.business.AffittoBusiness;
import it.unisalento.business.SistemaBusiness;
import it.unisalento.model.Cabina;
import it.unisalento.utility.Logo;
import it.unisalento.utility.LogoSpiaggia;
import it.unisalento.utility.PallinoGiallo;
import it.unisalento.utility.PallinoRosso;
import it.unisalento.utility.PallinoVerde;
import it.unisalento.view.Ascoltatori.Affitto.AscoltatoreCabina;
import it.unisalento.view.Ascoltatori.Affitto.AscoltatoreConfermaAffitto;
import it.unisalento.view.Ascoltatori.Affitto.AscoltatoreConfermaDate;
import it.unisalento.view.Ascoltatori.Affitto.AscoltatoreEsciAffitto;
import it.unisalento.view.Ascoltatori.Registrazione.AscoltatoreStampa;
import it.unisalento.view.FrameAccessori.CarrelloDellaSpesaAffitto;
import it.unisalento.view.Pannelli.CalendarioPanel;
import it.unisalento.view.Pannelli.ServiziAggiuntiviPanel;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AffittoJFrame extends JFrame 
{
private JPanel pannello0 = new JPanel();
private JPanel pannello1 = new JPanel();
private JPanel pannello2 = new JPanel();
private JPanel pannello3 = new JPanel();
private JPanel pannello4 = new JPanel();
private JPanel pannello5 = new JPanel();
private JPanel pannello6 = new JPanel();
private JPanel subPannello = new JPanel();

public ServiziAggiuntiviPanel pannelloServizi = new ServiziAggiuntiviPanel();
public CalendarioPanel calendario = new CalendarioPanel();


private JButton Cab11 = new JButton("Cab 11 'piccola'");
private JButton Cab12 = new JButton("Cab 12 'piccola'");
private JButton Cab13 = new JButton("Cab 13 'media'");
private JButton Cab14 = new JButton("Cab 14 'media'");
private JButton Cab15 = new JButton("Cab 15 'grande'");
private JButton Cab16 = new JButton("Cab 16 'grande'");
private JButton Cab17 = new JButton("Cab 17 'piccola'");
private JButton Cab18 = new JButton("Cab 18 'media'");
private JButton Cab19 = new JButton("Cab 19 'media'");
private JButton Cab20 = new JButton("Cab 20 'grande'");

JButton confermaDate = new JButton("Conferma");


private JButton spiaggia1 = new JButton("spiaggia");
private JButton spiaggia2 = new JButton("spiaggia");
private JButton spiaggia3 = new JButton("spiaggia");
private JButton spiaggia4 = new JButton("spiaggia");
private JButton spiaggia5 = new JButton("spiaggia");
private JButton spiaggia6 = new JButton("spiaggia");

private JButton docce = new JButton("DOCCE");
private JButton bar = new JButton("BAR");
private JButton ristorante = new JButton("RISTORANTE");
private JButton servizi = new JButton("SERVIZI");

private JButton mare1 = new JButton("Direzione  MARE");
private JButton mare2 = new JButton("Direzione  MARE");

private JButton conferma = new JButton("Conferma Ordine");
private JButton esci = new JButton("Altre Funzioni");
private JButton stampa = new JButton("Stampa Affitto");
//private JButton liberaCabine = new JButton("Allinea Cabine");

private JLabel warning1 = new JLabel("                        Clicca sull'omrellone scelto ");
private JLabel warning2 = new JLabel("                       x confermare i servizi selezionati");

private JLabel attenzione = new JLabel("Stampare dopo aver confermato l'affitto!");
private JLabel idAffitto = new JLabel();

private int flag;
public  CarrelloDellaSpesaAffitto carrelloAffitto;
public int operatore;
public ArrayList<Cabina> cabine;
public int max;
private double costoTotale;
private int codiceCliente;

public static Date inizioData;
public  static Date fineData;

public AffittoJFrame()
{
	super("AFFITTO CABINE LIDO OASI");
	Container c = this.getContentPane();
	c.setLayout(new GridLayout(6,1));
	pannello1.setLayout(new GridLayout(1,2));
	pannello2.setLayout(new GridLayout(1,8));
	pannello3.setLayout(new GridLayout(1,8));
	pannello4.setLayout(new GridLayout(1,2));
	pannello0.setLayout(new GridLayout(1,4));
	pannello6.setLayout(new GridLayout(2,1));
	c.add(pannello0);
	c.add(pannello1);
	c.add(pannello2);
	c.add(pannello3);
	c.add(pannello4);
	c.add(pannello5);
	
	pannello1.add(mare1);
	pannello1.add(mare2);
	pannello0.add(idAffitto);
	pannello0.add(subPannello);
	
	pannello0.add(pannello6);
	pannello0.add(pannelloServizi);
	
	subPannello.add(confermaDate);
	subPannello.add(calendario);
	
	
	pannello6.add(warning1);
	pannello6.add(warning2);
	
	
	pannello2.add(Cab11);
	pannello2.add(spiaggia1);
	pannello2.add(spiaggia2);
	pannello2.add(spiaggia3);
	pannello2.add(spiaggia4);
	pannello2.add(spiaggia5);
	pannello2.add(spiaggia6);
	pannello2.add(Cab20);
	
	pannello3.add(Cab12);
	pannello3.add(Cab13);
	pannello3.add(Cab14);
	pannello3.add(Cab15);
	pannello3.add(Cab16);
	pannello3.add(Cab17);
	pannello3.add(Cab18);
	pannello3.add(Cab19);

	
	pannello4.add(docce);
	pannello4.add(bar);
	pannello4.add(ristorante);
	pannello4.add(servizi);
	
	
	pannello5.add(conferma);
	pannello5.add(attenzione);
	pannello5.add(stampa);
	pannello5.add(esci);
	
	mare1.add(new Logo());
	mare2.add(new Logo());
	docce.add(new Logo());
	bar.add(new Logo());
	ristorante.add(new Logo());
	servizi.add(new Logo());
	
	spiaggia1.add(new LogoSpiaggia());
	spiaggia2.add(new LogoSpiaggia());
	spiaggia3.add(new LogoSpiaggia());
	spiaggia4.add(new LogoSpiaggia());
	spiaggia5.add(new LogoSpiaggia());
	spiaggia6.add(new LogoSpiaggia());
	
	
	
    max = AffittoBusiness.getInstance().getMaxIdAffitto();  
    idAffitto.setText("           Id Affitto : "+(max+1));
	
	
	conferma.addActionListener(new AscoltatoreConfermaAffitto(this));	
    confermaDate.addActionListener(new AscoltatoreConfermaDate(this));		
	esci.addActionListener(new AscoltatoreEsciAffitto(this));
	stampa.addActionListener(new AscoltatoreStampa(this));//
	//   Metodo che allinea le cabine ad ogni chiamata AffittoJFrame
	
	SistemaBusiness.getInstance().resettaCabine();
	
	AscoltatoreCabina listener = new AscoltatoreCabina(this);
	

    
    Cab11.addActionListener(listener);
	Cab12.addActionListener(listener);
	Cab13.addActionListener(listener);
	Cab14.addActionListener(listener);
	Cab15.addActionListener(listener);
	Cab16.addActionListener(listener);
	Cab17.addActionListener(listener);
	Cab18.addActionListener(listener);
	Cab19.addActionListener(listener);
	Cab20.addActionListener(listener);
	
		
	JButton[] bottoni = {Cab11,Cab12,Cab13,Cab14,Cab15,Cab16,Cab17,Cab18,Cab19,Cab20}; 
	
	cabine = SistemaBusiness.getInstance().verificaCabine();  
	for(int i = 0; i<10;i++)
	{
		Cabina cab = cabine.get(i); 
		if(cab.isOccupato())
		{
			bottoni[i].removeActionListener(listener);
			bottoni[i].add(new PallinoRosso());
			}
		else if (cab.isPrenotato() && !cab.isOccupato()) 
			bottoni[i].add(new PallinoGiallo());
			
		else
		   bottoni[i].add(new PallinoVerde());
	}
	
	
	carrelloAffitto = new CarrelloDellaSpesaAffitto(); 
	pannelloServizi.setCarrello(carrelloAffitto);        // non toglere!!
			
	pack();
	
			
	

	this.setSize(1050,700);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	
}



public int getOperatore() {
	return operatore;
}

public void setOperatore(int operatore) {
	this.operatore = operatore;
}

public double getCostoTotale() {
	return costoTotale;
}

public void setCostoTotale(double costoTotale) {
	this.costoTotale = costoTotale;
}

public ServiziAggiuntiviPanel getPannelloServizi() {
	return pannelloServizi;
}

public void setPannelloServizi(ServiziAggiuntiviPanel pannelloServizi) {
	this.pannelloServizi = pannelloServizi;
}

public CalendarioPanel getCalendario() {
	return calendario;
}

public void setCalendario(CalendarioPanel calendario) {
	this.calendario = calendario;
}

public  CarrelloDellaSpesaAffitto getCarrelloAffitto() {
	return carrelloAffitto;
}

public  void setCarrelloAffitto(CarrelloDellaSpesaAffitto carrelloAffitto) {
	this.carrelloAffitto = carrelloAffitto;
}


public int getCodiceCliente() {
	return codiceCliente;
}


public void setCodiceCliente(int codiceCliente) {
	this.codiceCliente = codiceCliente;
}



public int getFlag() {
	return flag;
}



public void setFlag(int flag) {
	this.flag = flag;
}


}

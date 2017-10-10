package it.unisalento.view.Pannelli;
import it.unisalento.view.Ascoltatori.Affitto.AscoltatoreServiziAggiuntivi;
import it.unisalento.view.FrameAccessori.CarrelloDellaSpesaAffitto;

import java.awt.*;

import javax.swing.*;


public class ServiziAggiuntiviPanel extends JPanel 
{
	public  JCheckBox acqua;
    public  JCheckBox luce;
    public  JCheckBox asciugamani;
   	private  int numero;
	private CarrelloDellaSpesaAffitto carrello;
	private String[] servizi = {"","",""};
    



	private JLabel etichetta = new JLabel(" Servizi Agguntivi");
   
	
	public ServiziAggiuntiviPanel ()
	{
		super(new BorderLayout());
		 
       acqua = new JCheckBox("Acqua Corrente");
       luce = new JCheckBox("Elettricità");
       asciugamani = new JCheckBox("Asciugamani");
       
       acqua.addItemListener(new AscoltatoreServiziAggiuntivi(this));
       luce.addItemListener(new AscoltatoreServiziAggiuntivi(this));
       asciugamani.addItemListener(new AscoltatoreServiziAggiuntivi(this));
         
       JPanel checkPanel = new JPanel(new GridLayout(0, 1));
       checkPanel.add(acqua);
       checkPanel.add(luce);
       checkPanel.add(asciugamani);
       

       add(checkPanel, BorderLayout.LINE_START);
       add(etichetta, BorderLayout.CENTER);
	   }
       
       

	public JCheckBox getAcqua() {
		return acqua;
	}

	public JCheckBox getLuce() {
		return luce;
	}

	
	public JCheckBox getAsciugamani() {
		return asciugamani;
	}



	
	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}

	 
	public CarrelloDellaSpesaAffitto getCarrello() {
		return carrello;
	}



	public void setCarrello(CarrelloDellaSpesaAffitto carrello) {
		this.carrello = carrello;
	}



	public String[] getServizi() {
		return servizi;
	}



	public void setServizi(String[] servizi) {
		this.servizi = servizi;
	}



  
   }


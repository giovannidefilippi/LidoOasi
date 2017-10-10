package it.unisalento.view;

import java.util.Date;
import java.util.GregorianCalendar;

import it.unisalento.business.AffittoBusiness;
import it.unisalento.dao.DimensioneDao;
import it.unisalento.model.Affitto;
import it.unisalento.model.Dimensione;
import it.unisalento.model.Noleggio;
import it.unisalento.model.Prenotazione;
import it.unisalento.utility.ConvertiDate;


public class Runner {

	public static void main(String[] args) {
		//new RegistrazioneJFrame();
		//new RegistrazioneOpJFrame();
		//new RegistrazioneOpJFrameAmministratore();
		
		new InizioJFrame(); 
        
		//new ConfermaPrenotazioniJFrame();
		//new VisualizzaStoricoJFrame();
		
		//new JFrameBagnino();
		//new JFrameCliente();
		//new NoleggioJFrame ();
		//new CarrelloDellaSpesa();
		//new JFrameAmministratore();
	   //new Prova();
		//new JFrameLettini();
		
		//new AffittoJFrame();
		
		//new PrenotazioneJFrame();
		
		//new CarrelloDellaSpesaAffitto();
		//Noleggio noleggio = new Noleggio(new GregorianCalendar(2014, 0, 21),2);
		//System.out.println(noleggio);
		 
		/*
		Dimensione dim;   
		dim = DimensioneDao.getInstance().getDimensione("Grande");
		System.out.println(dim.getCostogiornaliero());
		System.out.println(dim.getTipo());
		*/
	
		/*
		   Prenotazione prenotazione = new Prenotazione(5,18,101,new GregorianCalendar(2014, 0, 21),
				new GregorianCalendar(2014, 0, 28),"si","no","si",true,45.00);
		   System.out.println(prenotazione);
			
			
			//AffittoBusiness.getInstance().registraAffitto(6,57,20,
			//		new GregorianCalendar(2014, 0, 21),new GregorianCalendar(2014, 0, 28),"si","no","si",101,45.00);
	
				*/
	}
	
	

}

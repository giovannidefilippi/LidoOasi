package it.unisalento.view.Ascoltatori.Affitto;

import it.unisalento.view.AffittoJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AscoltatoreCabina implements ActionListener 
{
	AffittoJFrame frame;
	
	
	public AscoltatoreCabina(AffittoJFrame frame) throws NumberFormatException
	{
		this.frame = frame;
	}

	
	
	public void actionPerformed(ActionEvent e) 
	    {
		
		JButton bottone = (JButton) e.getSource();
		try
		{
				
		String ordine = bottone.getText();
		int posCabinaInCabine = Integer.parseInt(ordine.substring(4,6))-11;
			
		frame.carrelloAffitto.areaSup.setText(ordine);
		double costoGiornaliero = frame.cabine.get(posCabinaInCabine).getDimensione().getCostogiornaliero();
		String costo = " euro "+costoGiornaliero;
		frame.carrelloAffitto.spesa.setText(costo);
        int numServizi =0;
		if (frame.pannelloServizi.getNumero() == 1)
		{
			ordine = ordine +" + 1 Servizio Aggiuntivo";
			costo = " euro "+(costoGiornaliero+5.0);
			numServizi = 1;
		}
		else if (frame.pannelloServizi.getNumero() == 2)
		{
		 ordine = ordine +" + 2 Servizi Aggiuntivi";
		 costo = " euro  "+(costoGiornaliero+10.0);
		 numServizi = 2;
		}
		else if (frame.pannelloServizi.getNumero() == 3)
		{
		 ordine = ordine +" + 3 Servizi Aggiuntivi";
		 costo = " euro  "+(costoGiornaliero+15.0);
		 numServizi = 3;
		}
		else if (frame.pannelloServizi.getNumero() == 0)
		{
			ordine = ordine +" ";
			numServizi = 0;
		}
		
		String giorni = frame.carrelloAffitto.numGiorni.getText();
				
		if (Integer.parseInt(giorni) <= 0)
			JOptionPane.showMessageDialog(null, "Controlla le date inserite!!");
		else
		{
			int numeroGiorni =Integer.parseInt(giorni);
		    double costoTotale = (costoGiornaliero+numServizi*5.00)*numeroGiorni;
		
		   if (numeroGiorni >= 20)
		       costoTotale = costoTotale*0.80;
		
		
		
		frame.carrelloAffitto.areaSup.setText(ordine);
		frame.carrelloAffitto.spesa.setText(costo);
		frame.carrelloAffitto.spesaTotale.setText(" euro "+costoTotale);
		frame.setCostoTotale(costoTotale);
		
		}
		
	   }
	
	catch(NumberFormatException excep)
	   {
		JOptionPane.showMessageDialog(null, "Conferma le date inserite!!");
		
		}
	}
	

}


package it.unisalento.view.Ascoltatori.Noleggio;

import it.unisalento.view.NoleggioJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AscoltatoreOmbrellone implements ActionListener 
{
	NoleggioJFrame frame;
	
	public AscoltatoreOmbrellone(NoleggioJFrame frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) throws IndexOutOfBoundsException
	{
		int numeroLettini = frame.getLettini().getNumLettini();
		JButton bottone = (JButton) e.getSource();
		try
		{
		String ordine = bottone.getText();
		
		
		frame.getCarrello().areaInf.setText(ordine);
		
		
		
		String costo = " euro "+frame.ombrelloni.get(0).getCostoGiornaliero();
		frame.getCarrello().spesa.setText(costo);
		
		
		
		
		if (numeroLettini == 1)
		{
			ordine = ordine +" + 1 Lettino";
			costo = " euro 14.0";
		}
		else if (numeroLettini == 2)
		{
		 ordine = ordine +" + 2 Lettini";
		 costo = " euro 18.0 ";
		}
		else if (numeroLettini == 0)
		{
			ordine = ordine +" ";
		}
		frame.getCarrello().areaInf.setText(ordine);
		frame.getCarrello().spesa.setText(costo);
		
	}
		catch (IndexOutOfBoundsException ind)
		{
			JOptionPane.showMessageDialog(null, " Devi prima scegliere qualcosa!!??");
		}
		
	}

}

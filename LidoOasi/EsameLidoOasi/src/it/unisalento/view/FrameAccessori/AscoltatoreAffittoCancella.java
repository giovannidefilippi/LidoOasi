package it.unisalento.view.FrameAccessori;

import it.unisalento.view.Pannelli.ServiziAggiuntiviPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AscoltatoreAffittoCancella implements ActionListener 
{
	CarrelloDellaSpesaAffitto frame;
	
	public AscoltatoreAffittoCancella(CarrelloDellaSpesaAffitto frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		
		frame.areaSup.setText("");
		frame.spesa.setText("");
		frame.spesaTotale.setText("");
        frame.numGiorni.setText("");
        frame.areaInf.setText("");
        
       // frame.setNumgiorni(0);
       // frame.scriviGiorni();
        //String[] s = {"","",""};
       // frame.setService(s);
       // frame.getAcqua().setSelected(false);
        //ServiziAggiuntiviPanel.luce.setSelected(false);
        //ServiziAggiuntiviPanel.asciugamani.setSelected(false);
	}

}

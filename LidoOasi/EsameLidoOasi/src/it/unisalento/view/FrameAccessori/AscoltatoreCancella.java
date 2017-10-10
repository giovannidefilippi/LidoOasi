package it.unisalento.view.FrameAccessori;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AscoltatoreCancella implements ActionListener 
{
	CarrelloDellaSpesa frame;
	
	public AscoltatoreCancella(CarrelloDellaSpesa frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		frame.areaInf.setText("");	
		frame.spesa.setText("");

	}

}

package it.unisalento.view.Ascoltatori.Noleggio;

import it.unisalento.view.FrameAccessori.JFrameLettini;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AscoltatoreLettini implements ActionListener 
{
	private JFrameLettini frame;
	private  int numLettini;
	
	public AscoltatoreLettini(JFrameLettini frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String target = e.getActionCommand();
		numLettini = Integer.parseInt(target);
		frame.setNumLettini(numLettini);
		
	}
	
	

}

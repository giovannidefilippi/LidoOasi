package it.unisalento.view.Ascoltatori.Registrazione;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class AscoltatoreSesso implements ActionListener 
{
private JFrame frame;
public static  char sesso;
	
	public AscoltatoreSesso(JFrame frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String target = e.getActionCommand();
		sesso = target.charAt(0);
       
	}

	public static char getSesso()
	{
		return sesso;
	}
}

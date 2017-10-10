package it.unisalento.utility;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class PallinoVerde extends JComponent
{
	public void paintComponent(Graphics g)
	{
       Graphics2D g2 = (Graphics2D) g;
       Color verde = new Color(0,255,0);
       
       Ellipse2D cerchio = new Ellipse2D.Double(5, 5, 30, 30);
       g2.setColor(verde);
       g2.fill(cerchio);
       g2.drawString("Libera", 40, 20);
	
	}
}
package it.unisalento.utility;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class PallinoGiallo extends JComponent
{
	public void paintComponent(Graphics g)
	{
       Graphics2D g2 = (Graphics2D) g;
       Color giallo = new Color(255,200,0);
       
       Ellipse2D cerchio = new Ellipse2D.Double(5, 5, 30, 30);
       g2.setColor(giallo);
       g2.fill(cerchio);
       g2.drawString("Prenotata", 40, 20);
	
	}
}
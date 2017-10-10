package it.unisalento.utility;

	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.Rectangle;
	import java.awt.geom.Ellipse2D;
	import java.awt.geom.Line2D;

	import javax.swing.JComponent;
	

	public class LogoSpiaggia extends JComponent
	{
		@Override
		public void paintComponent(Graphics g)
		{
	       Graphics2D g2 = (Graphics2D) g;
	       Color giallo = new Color(255,255,0);
	       Color azzurro = new Color(0,255,255);
	       Color nero = new Color(0,0,0);
	       Color blu = new Color(0,0,255);
	       Rectangle box = new Rectangle(0,0,40, 31);
	       g2.setColor(azzurro);
	       g2.fill(box);
	       Ellipse2D cerchio1 = new Ellipse2D.Double(3, 3,27, 17);
	       g2.setColor(giallo);
	       g2.fill(cerchio1);
	       Rectangle box1 = new Rectangle(3,15,27,16);
	       g2.setColor(azzurro);
	       g2.fill(box1);
	       g2.setColor(blu);
	       
	       Line2D.Double linea1 = new Line2D.Double(17,15,17,28);
	       g2.setColor(nero);
	       g2.draw(linea1);
	       Line2D.Double linea2 = new Line2D.Double(18,15,18,28);
	       g2.setColor(nero);
	       g2.draw(linea2);
		
		}

}

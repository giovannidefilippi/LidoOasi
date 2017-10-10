package it.unisalento.utility;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Logo extends JComponent
{
	public void paintComponent(Graphics g)
	{
       Graphics2D g2 = (Graphics2D) g;
       Color giallo = new Color(255,255,0);
       Color rosso = new Color(255,0,0);
       Color blu = new Color(0,0,255);
       
       Ellipse2D cerchio1 = new Ellipse2D.Double(5, 5, 30, 30);
       g2.setColor(giallo);
       g2.fill(cerchio1);
       Ellipse2D cerchio2 = new Ellipse2D.Double(20,20, 30, 30);
       g2.setColor(rosso);
       g2.fill(cerchio2);
       g2.setColor(blu);
       g2.drawString("Lido Oasi", 60, 20);
	
	}
public static void main(String[] args)
	
	{
		JFrame frame = new JFrame();
		
		
		frame.setSize(600,120);
		frame.setTitle("Logo Oasi");
		
		Logo logo = new Logo();
		
		frame.add(logo);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
	}
}
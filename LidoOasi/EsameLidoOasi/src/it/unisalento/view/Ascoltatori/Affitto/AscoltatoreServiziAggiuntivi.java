package it.unisalento.view.Ascoltatori.Affitto;

import it.unisalento.view.AffittoJFrame;
import it.unisalento.view.Pannelli.ServiziAggiuntiviPanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public class AscoltatoreServiziAggiuntivi implements ItemListener 
{
	ServiziAggiuntiviPanel pannello;
	
	
	public AscoltatoreServiziAggiuntivi(ServiziAggiuntiviPanel pannello)
	{
		this.pannello = pannello;
	}

	@Override
	  public void itemStateChanged(ItemEvent e) 
    {
     Object source = e.getItemSelectable();
     
     String[] servizi =pannello.getServizi();
            
     if (source == pannello.acqua && e.getStateChange() == ItemEvent.SELECTED) 
        {
  	   servizi[0] = "ACQUA CORRENTE";
  	   
        } 
     else if (source == pannello.luce && e.getStateChange() == ItemEvent.SELECTED) 
        {
  	   servizi[1] = "ELETTRICITA'"; 
  	        	  
        } 
     else if (source == pannello.asciugamani && e.getStateChange() == ItemEvent.SELECTED) 
       {
  	   servizi[2] = "SERVIZIO ASCIUGAMANI";
  	 
       }
     
     else if (e.getStateChange() == ItemEvent.DESELECTED) 
        {
  	   if (source == pannello.acqua )
           {  
          	 servizi[0]="";
          	        
          	 }
           else if (source == pannello.luce )
           {
          	 servizi[1]="";
            		}
       		
          	 
           else if (source == pannello.asciugamani )
              {
          	 servizi[2]="";
          	 }
       	}
    
          pannello.setNumero(this.contaSelezionati());
          pannello.getCarrello().areaInf.setText("");
          pannello.setServizi(servizi);
          
         
          
    for (String s : servizi)
        {
    	pannello.getCarrello().areaInf.append(s);
    	pannello.getCarrello().areaInf.append("\n"); 
    	
    	   	
        }
      }
       
    
     
 
 
 public    int contaSelezionati()
 {
  JCheckBox[] bottoni = {pannello.acqua,pannello.luce,pannello.asciugamani};
  int numero = 0;
  for(JCheckBox c : bottoni)
      {
	   if(c.isSelected())
		   numero++;
           }
  
  return numero;
 }

 
 
}

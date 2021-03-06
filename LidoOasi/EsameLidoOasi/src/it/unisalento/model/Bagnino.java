package it.unisalento.model;
// Generated 24-gen-2014 21.43.37 by Hibernate Tools 3.4.0.CR1

import it.unisalento.dao.BagninoDao;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Bagnino generated by hbm2java
 */
public class Bagnino extends Operatorelido  {

	private int codAmministratoreAssunzione;
	private Integer et�;
	private Character sesso;
	private GregorianCalendar dataAssunzione;
	

	public Bagnino() 
	{
		super();
		
	}
	

	public Bagnino(int codice)
   {
		super(codice);
		
	}


	public Bagnino(int codice,String psw)
	{
		super(codice,psw);
	}
	
	public Bagnino(int amministratore,
			GregorianCalendar dataAssunzione) 
	{
		super();
		
		this.codAmministratoreAssunzione = amministratore;
		this.dataAssunzione = dataAssunzione;
	}

	public Bagnino(int amministratore,
			Integer et�, Character sesso, GregorianCalendar dataAssunzione) 
	{
		super();
		this.codAmministratoreAssunzione = amministratore;
		this.et� = et�;
		this.sesso = sesso;
		this.dataAssunzione = dataAssunzione;
	}

	public Bagnino(int codice,String nome,String cognome,String password,
			Integer et�, Character sesso)
	{
		super(codice,nome,cognome,password);
		this.sesso = sesso;
		
	}
	
	public int getCodiceAmministratoreAssunzione() 
	{
		return this.codAmministratoreAssunzione;
	}

	public void setCodiceAmministratoreAssunzione(int amministratore) {
		this.codAmministratoreAssunzione = amministratore;
	}

	public Integer getEt�() {
		return this.et�;
	}

	public void setEt�(Integer et�) {
		this.et� = et�;
	}

	public Character getSesso() {
		return this.sesso;
	}

	public void setSesso(Character sesso) {
		this.sesso = sesso;
	}

	public GregorianCalendar getDataAssunzione() {
		return this.dataAssunzione;
	}

	public void setDataAssunzione(GregorianCalendar dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}
/**
 * Sovrascrive toString di Object.
 * 
 *@return bagnino  la stringa formattata
 */

	public String toString()
	{
		int anno = dataAssunzione.get(Calendar.YEAR);
		int mese = dataAssunzione.get(Calendar.MONTH)+1;
		int giorno = dataAssunzione.get(Calendar.DATE);
		String bagnino ="Bagnino num. "+super.getCodiceOperatore()+"(=username)  Nome :"+super.getNome()+
				"  Cognome :"+super.getCognome()+"  Sesso :"+sesso+"  Data Assunzione :"+giorno+"-"+
				mese+"-"+anno+"  password :"+super.getPassword();
		return(bagnino);
	}
	
	public boolean login()
	{
		return BagninoDao.getInstance().userExists(this);
	}
	
	public boolean verifica()
	{
		return BagninoDao.getInstance().usernameExists(this);
	}
	

	public boolean registra()
	{
		
		return(BagninoDao.getInstance().inserisciBagnino(this));
	}
	public Bagnino recupera()
	{
		return(BagninoDao.getInstance().getBagnino(this));
	}
}

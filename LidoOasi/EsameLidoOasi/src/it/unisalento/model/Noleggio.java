package it.unisalento.model;
// Generated 24-gen-2014 21.43.37 by Hibernate Tools 3.4.0.CR1

import it.unisalento.business.ClienteBusiness;
import it.unisalento.dao.NoleggioDao;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Noleggio generated by hbm2java
 */
public class Noleggio 
{

	private int idNoleggio;
	private int operatorelido;
	private int ombrellone; 
	private Cliente cliente;
	private GregorianCalendar data;
	private int numeroLettini;
	private int IdCliente;
	private double costo;

	public Noleggio() 
	{
	}
	
	public Noleggio (int idNoleggio)
	{
		this.idNoleggio = idNoleggio;
		
		
	}

	

	public Noleggio(int operatorelido, int ombrellone,
			Cliente cliente) 
	{
		this.operatorelido = operatorelido;
		this.ombrellone = ombrellone;
		this.cliente = cliente;
	}

	public Noleggio( GregorianCalendar data, Integer numeroLettini)
	{
		this.data = data;
		this.numeroLettini = numeroLettini;
	}
	
	public Noleggio(int idNoleggio, int operatorelido, int ombrellone,
			 int numeroLettini, int idCliente,double costo) 
	{
		this.idNoleggio = idNoleggio;
		this.operatorelido = operatorelido;
		this.ombrellone = ombrellone;
		this.numeroLettini = numeroLettini;
		this.IdCliente = idCliente;
		this.costo = costo;
	}
	
	
	
	public Noleggio(int idNoleggio, int operatorelido, int ombrellone,
			 GregorianCalendar data, int numeroLettini,
			int idCliente, double costo) {
		this.idNoleggio = idNoleggio;
		this.operatorelido = operatorelido;
		this.ombrellone = ombrellone;
		this.data = data;
		this.numeroLettini = numeroLettini;
		IdCliente = idCliente;
		this.costo = costo;
	}

	public int getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Integer getIdNoleggio() {
		return this.idNoleggio;
	}

	public void setIdNoleggio(Integer idNoleggio) {
		this.idNoleggio = idNoleggio;
	}

	public int getOperatorelido() {
		return this.operatorelido;
	}

	public void setOperatorelido(int operatorelido) {
		this.operatorelido = operatorelido;
	}

	public int getOmbrellone() {
		return this.ombrellone;
	}

	public void setOmbrellone(int ombrellone) {
		this.ombrellone = ombrellone;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public GregorianCalendar getData() {
		return this.data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}

	public int getNumeroLettini() {
		return this.numeroLettini;
	}

	public void setNumeroLettini(int numeroLettini) {
		this.numeroLettini = numeroLettini;
	}
	
	public int getMaxId()
	{
		return NoleggioDao.getInstance().maxId();
	}
	
	public String toString()
	{
		cliente = ClienteBusiness.getInstance().trovaCliente(IdCliente);
		int anno = data.get(Calendar.YEAR);
		int mese = data.get(Calendar.MONTH)+1;
		int giorno = data.get(Calendar.DATE);
		
		String noleggio ="Noleggio num. :"+this.getIdNoleggio()+"  Codice Operatore  :"+this.getOperatorelido()+
				"   Cliente :"+this.cliente.getCognome()+" "+this.cliente.getNome()+"  Data Noleggio :"+giorno+"-"+
				mese+"-"+anno+"  Codice Ombrellone:"+this.getOmbrellone()+"  Numero Lettini :"+this.getNumeroLettini()+
				"   Costo totale : euro "+this.getCosto();
		
		return(noleggio);
				}

	public Noleggio recupera()
	{
		return(NoleggioDao.getInstance().getNoleggio(this));
	}
	
	public boolean registra()
	{
		
		return(NoleggioDao.getInstance().inserisciNoleggio(this));
	}
	
	
}

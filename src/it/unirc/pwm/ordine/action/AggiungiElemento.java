package it.unirc.pwm.ordine.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.bevanda.Bevanda;
import it.unirc.pwm.bevanda.BevandaDAO;
import it.unirc.pwm.bevanda.BevandaDAOFactory;
import it.unirc.pwm.ordine_bevanda.OrdineBevanda;
import it.unirc.pwm.ordine_piatto.OrdinePiatto;
import it.unirc.pwm.piatto.Piatto;
import it.unirc.pwm.piatto.PiattoDAO;
import it.unirc.pwm.piatto.PiattoDAOFactory;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;

public class AggiungiElemento extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	
	protected static final PiattoDAO pDAO = PiattoDAOFactory.getDAO();
	protected static final BevandaDAO bDAO = BevandaDAOFactory.getDAO();
	protected static final Map<String, Object> session = ActionContext.getContext().getSession();
	private Utente utente;

	private List<Piatto> piatti;
	private List<Bevanda> bevande;
	private List<OrdinePiatto> piattiAggiunti = new ArrayList<OrdinePiatto>();
	private List<OrdineBevanda> bevandeAggiunte = new ArrayList<OrdineBevanda>();
	private int tavolo;
	private int quantita;
	private int piatto;
	private int bevanda;
	private double totale;
	private String note;
	@SuppressWarnings("unchecked")
	private List<OrdinePiatto> piattiSalvati = (List<OrdinePiatto>) session.get("piattiSalvati");
	@SuppressWarnings("unchecked")
	private List<OrdineBevanda> bevandeSalvate = (List<OrdineBevanda>) session.get("bevandeSalvate");
	
	public List<Piatto> getPiatti() {
		this.piatti = pDAO.getPiatti();
		return piatti;
	}
	public void setPiatti(List<Piatto> piatti) {
		this.piatti = piatti;
	}
	public List<Bevanda> getBevande() {
		this.bevande = bDAO.getBevande();
		return bevande;
	}
	public void setBevande(List<Bevanda> bevande) {
		this.bevande = bevande;
	}
	public List<OrdinePiatto> getPiattiAggiunti() {
		return piattiAggiunti;
	}
	public void setPiattiAggiunti(List<OrdinePiatto> piattiAggiunti) {
		this.piattiAggiunti = piattiAggiunti;
	}
	public List<OrdineBevanda> getBevandeAggiunte() {
		return bevandeAggiunte;
	}
	public void setBevandeAggiunte(List<OrdineBevanda> bevandeAggiunte) {
		this.bevandeAggiunte = bevandeAggiunte;
	}
	public int getTavolo() {
		return tavolo;
	}
	public void setTavolo(int tavolo) {
		this.tavolo = tavolo;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public int getPiatto() {
		return piatto;
	}
	public void setPiatto(int piatto) {
		this.piatto = piatto;
	}
	public int getBevanda() {
		return bevanda;
	}
	public void setBevanda(int bevanda) {
		this.bevanda = bevanda;
	}	
	public double getTotale() {
		return totale;
	}
	public void setTotale(double totale) {
		this.totale = totale;
	}	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setUtente(Utente u) {
		this.utente = u;		
	}	
	public Utente getUtente() {
		return this.utente;
	}
	
	public String execute() {
		this.totale = 0;
		//Gestione aggiunta piatti
		OrdinePiatto ordinePiatto = new OrdinePiatto();
		Piatto piatto = new Piatto();
		if(this.piatto!=-1) {				
			piatto.setIdPiatto(this.piatto);
			ordinePiatto.setPiatto(pDAO.getPiatto(piatto));
			ordinePiatto.setQuantita(this.quantita);
			ordinePiatto.setPrezzo(this.quantita*ordinePiatto.getPiatto().getPrezzo());
			this.piattiAggiunti.add(ordinePiatto);
			this.totale += ordinePiatto.getPrezzo();
		}
		if(piattiSalvati!=null && piattiSalvati.size()!=0) {
			for(OrdinePiatto op : piattiSalvati) {
				this.piattiAggiunti.add(op);
				this.totale += op.getPrezzo();
			}
		}
		//Gestione aggiunta bevande
		OrdineBevanda ordineBevanda = new OrdineBevanda();
		Bevanda bevanda = new Bevanda();
		if(this.bevanda!=-1) {
			bevanda.setIdBevanda(this.bevanda);
			ordineBevanda.setBevanda(bDAO.getBevanda(bevanda));
			ordineBevanda.setQuantita(this.quantita);
			ordineBevanda.setPrezzo(this.quantita*ordineBevanda.getBevanda().getPrezzo());
			bevandeAggiunte.add(ordineBevanda);
			this.totale += ordineBevanda.getPrezzo();
		}	
		if(bevandeSalvate!=null && bevandeSalvate.size()!=0) {
			for(OrdineBevanda ob : bevandeSalvate) {
				bevandeAggiunte.add(ob);
				this.totale += ob.getPrezzo();
			}
		}
		this.quantita = 0;
		this.piatto = -1;
		this.bevanda = -1;
		return SUCCESS;
	}
}
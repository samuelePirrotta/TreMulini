package it.unirc.pwm.ordine.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.bevanda.Bevanda;
import it.unirc.pwm.bevanda.BevandaDAO;
import it.unirc.pwm.bevanda.BevandaDAOFactory;
import it.unirc.pwm.ordine.Ordine;
import it.unirc.pwm.ordine.OrdineDAO;
import it.unirc.pwm.ordine.OrdineDAOFactory;
import it.unirc.pwm.ordine_bevanda.OrdineBevanda;
import it.unirc.pwm.ordine_bevanda.OrdineBevandaDAO;
import it.unirc.pwm.ordine_bevanda.OrdineBevandaDAOFactory;
import it.unirc.pwm.ordine_bevanda.OrdineBevandaId;
import it.unirc.pwm.ordine_piatto.OrdinePiatto;
import it.unirc.pwm.ordine_piatto.OrdinePiattoDAO;
import it.unirc.pwm.ordine_piatto.OrdinePiattoDAOFactory;
import it.unirc.pwm.ordine_piatto.OrdinePiattoId;
import it.unirc.pwm.piatto.Piatto;
import it.unirc.pwm.piatto.PiattoDAO;
import it.unirc.pwm.piatto.PiattoDAOFactory;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.util.CollectionConverter;

public class SalvaOrdine extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	protected static final Map<String, Object> session = ActionContext.getContext().getSession();
	protected static final PiattoDAO pDAO = PiattoDAOFactory.getDAO();
	protected static final BevandaDAO bDAO = BevandaDAOFactory.getDAO();
	private Utente utente;
	
	private int tavolo;
	private double totale;
	private String note;
	private List<Piatto> piatti;
	private List<Bevanda> bevande;
	@SuppressWarnings("unchecked")
	private List<OrdinePiatto> piattiAggiunti = (List<OrdinePiatto>) session.get("piattiSalvati");
	@SuppressWarnings("unchecked")
	private List<OrdineBevanda> bevandeAggiunte = (List<OrdineBevanda>) session.get("bevandeSalvate");
		
	public int getTavolo() {
		return tavolo;
	}
	public void setTavolo(int tavolo) {
		this.tavolo = tavolo;
	}
	public double getTotale() {
		return totale;
	}public void setTotale(double totale) {
		this.totale = totale;
	}public String getNote() {
		return note;
	}public void setNote(String note) {
		this.note = note;
	}
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
	public void setUtente(Utente u) {
		this.utente = u;		
	}	
	public Utente getUtente() {
		return this.utente;
	}
	
	public String execute() {
		OrdineDAO oDAO = OrdineDAOFactory.getDAO();
		OrdineBevandaDAO obDAO = OrdineBevandaDAOFactory.getDAO();
		OrdinePiattoDAO opDAO = OrdinePiattoDAOFactory.getDAO();
		Ordine ordine = new Ordine();
		java.util.Date today = new java.util.Date();
		ordine.setData(new java.sql.Date(today.getTime()));
		ordine.setTavolo(this.tavolo);
		System.out.println(totale);
		ordine.setTotale(this.totale/10);
		ordine.setNote(this.note);
		ordine.setUtente((Utente) session.get("utente"));
		ordine.setOrdinePiatto(CollectionConverter.getSet(this.piattiAggiunti));
		ordine.setOrdineBevanda(CollectionConverter.getSet(this.bevandeAggiunte));
		int id = oDAO.saveOrdine(ordine);
		int contB = 0;
		int contP = 0;		
		for(OrdineBevanda o : this.bevandeAggiunte) {
			OrdineBevandaId idB = new OrdineBevandaId();
			idB.setIdBevanda(o.getBevanda().getIdBevanda());
			idB.setIdOrdine(id);
			o.setId(idB);
			if(obDAO.saveOrdineBevanda(o))
				contB++;
		}
		for(OrdinePiatto o : this.piattiAggiunti) {
			OrdinePiattoId idP = new OrdinePiattoId();
			idP.setIdPiatto(o.getPiatto().getIdPiatto());
			idP.setIdOrdine(id);
			o.setId(idP);
			if(opDAO.saveOrdinePiatto(o))
				contP++;
		}
		if(((contB+contP) == (this.piattiAggiunti.size()+this.bevandeAggiunte.size())) && id!=0) {
			this.addActionMessage(this.getText("text.success"));
			session.remove("piattiSalvati");
			session.remove("bevandeSalvate");
		}else {
			this.addActionError(this.getText("text.error"));
		}
		this.tavolo = 0;
		this.note = "";
		this.totale = 0;
		return SUCCESS;		
	}
}
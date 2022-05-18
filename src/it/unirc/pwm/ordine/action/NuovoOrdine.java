package it.unirc.pwm.ordine.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.bevanda.Bevanda;
import it.unirc.pwm.bevanda.BevandaDAO;
import it.unirc.pwm.bevanda.BevandaDAOFactory;
import it.unirc.pwm.piatto.Piatto;
import it.unirc.pwm.piatto.PiattoDAO;
import it.unirc.pwm.piatto.PiattoDAOFactory;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;

public class NuovoOrdine extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	
	private List<Piatto> piatti;
	private List<Bevanda> bevande;
	private Utente utente;
	
	public List<Piatto> getPiatti() {
		return piatti;
	}
	public void setPiatti(List<Piatto> piatti) {
		this.piatti = piatti;
	}
	public List<Bevanda> getBevande() {
		return bevande;
	}
	public void setBevande(List<Bevanda> bevande) {
		this.bevande = bevande;
	}
	public Utente getUtente() {
		return this.utente;
	}
	public void setUtente(Utente u) {
		this.utente = u;
	}
	
	public String execute() {
		PiattoDAO pDAO = PiattoDAOFactory.getDAO();
		BevandaDAO bDAO = BevandaDAOFactory.getDAO();
		piatti = pDAO.getPiatti();
		bevande = bDAO.getBevande();
		return SUCCESS;
	}
}
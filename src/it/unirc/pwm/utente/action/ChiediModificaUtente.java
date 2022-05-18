package it.unirc.pwm.utente.action;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.UtenteDAO;
import it.unirc.pwm.utente.UtenteDAOFactory;

public class ChiediModificaUtente extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	
	private Integer idUtente;
	private Utente utente;
	
	public Integer getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	public String execute() {
		UtenteDAO uDAO = UtenteDAOFactory.getDao();
		this.utente = new Utente();
		this.utente.setIdUtente(this.idUtente);		
		this.utente = uDAO.getUtente(utente);
		return SUCCESS;
	}
}
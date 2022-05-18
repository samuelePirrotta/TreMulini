package it.unirc.pwm.utente.action;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.utente.Utente;

public class ChiediCercaUtente extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	private Utente utente;
	
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	public String execute() {
		return SUCCESS;
	}
}
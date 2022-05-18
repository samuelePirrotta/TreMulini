package it.unirc.pwm.utente.action;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.utente.Utente;

public class ChiediNuovoUtente extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	private Utente utente; 
	
	public void setUtente(Utente u) {
		this.utente = u;		
	}	
	public Utente getUtente() {
		return this.utente;
	}
	
	public String execute() {
		return SUCCESS;
	}
}
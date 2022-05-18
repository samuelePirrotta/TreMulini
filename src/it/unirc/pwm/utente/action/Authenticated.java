package it.unirc.pwm.utente.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.utente.Utente;

public class Authenticated extends ActionSupport implements UtenteAware, Action {

	private static final long serialVersionUID = 1L;
	private Utente utente;
	
	public String execute(){
		return SUCCESS;
	}
	
	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
}
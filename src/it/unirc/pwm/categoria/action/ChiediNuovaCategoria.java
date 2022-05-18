package it.unirc.pwm.categoria.action;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;

public class ChiediNuovaCategoria extends ActionSupport implements UtenteAware {

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
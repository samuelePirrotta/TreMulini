package it.unirc.pwm.utente.action;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.UtenteDAO;
import it.unirc.pwm.utente.UtenteDAOFactory;

public class EliminaUtente extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;

	private Integer idUtente;
	private Utente utente;

	public Integer getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}
	public void setUtente(Utente u) {
		this.utente = u;		
	}	
	public Utente getUtente() {
		return this.utente;
	}
	
	public String execute() {
		UtenteDAO uDAO = UtenteDAOFactory.getDao();
		Utente utente = new Utente();
		utente.setIdUtente(this.idUtente);
		utente.setNome("");
		utente.setMansione("");
		utente.setPassword("");
		try {
			if(uDAO.deleteUtente(utente)) {
				this.addActionMessage(this.getText("text.delete.success"));
			}else {
				this.addActionError(this.getText("text.delete.error"));
			}
		}catch(javax.persistence.PersistenceException e) { //Violazione del vincolo di integrità referenziale con Ordine
			this.addActionMessage(this.getText("text.costraintViolation"));
			return ERROR;
		}
		return SUCCESS;
	}
}
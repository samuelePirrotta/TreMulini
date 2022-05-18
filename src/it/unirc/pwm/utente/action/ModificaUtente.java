package it.unirc.pwm.utente.action;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.UtenteDAO;
import it.unirc.pwm.utente.UtenteDAOFactory;

public class ModificaUtente extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	
	private Integer idUtente;
	private Utente utente;
	private String confermaPassword;
	
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
	public String getConfermaPassword() {
		return confermaPassword;
	}
	public void setConfermaPassword(String confermaPassword) {
		this.confermaPassword = confermaPassword;
	}
	
	public String execute() {
		UtenteDAO uDAO = UtenteDAOFactory.getDao();
		this.utente.setIdUtente(idUtente);
		
		if(uDAO.updateUtente(this.utente)) {
			this.addActionMessage(this.getText("text.update.success"));
		}else {
			this.addActionError(this.getText("text.update.error"));
		}
		return SUCCESS;			
	}
}
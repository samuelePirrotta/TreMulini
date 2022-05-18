package it.unirc.pwm.utente.action;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.UtenteDAO;
import it.unirc.pwm.utente.UtenteDAOFactory;

public class SalvaUtente extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String password;
	private String mansione;
	private String confermaPassword;
	private Utente utente;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMansione() {
		return mansione;
	}
	public void setMansione(String mansione) {
		this.mansione = mansione;
	}	
	public String getConfermaPassword() {
		return confermaPassword;
	}
	public void setConfermaPassword(String confermaPassword) {
		this.confermaPassword = confermaPassword;
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
		
		utente.setNome(this.nome);
		utente.setPassword(this.password);
		utente.setMansione(this.mansione);
		
		if(uDAO.saveUtente(utente)) {
			this.addActionMessage(this.getText("text.success"));
		}else {
			this.addActionError(this.getText("text.error"));
		}
		return SUCCESS;
	}
}
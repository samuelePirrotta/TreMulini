package it.unirc.pwm.utente.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.UtenteDAO;
import it.unirc.pwm.utente.UtenteDAOFactory;

public class CercaUtente extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	
	private Integer idUtente;
	private String nome;
	private String mansione;
	private List<Utente> utenti;
	private Utente utente;
	
	public Integer getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMansione() {
		return mansione;
	}
	public void setMansione(String mansione) {
		this.mansione = mansione;
	}	
	public List<Utente> getUtenti() {
		return utenti;
	}
	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	public String execute() {
		UtenteDAO uDAO = UtenteDAOFactory.getDao();
		Utente utente = new Utente();
		
		utente.setIdUtente(this.idUtente);
		if(!this.nome.equals("")) {
			utente.setNome(this.nome);
		}
		if(!this.mansione.equals("")) {
			utente.setMansione(this.mansione);
		}
		
		this.utenti = uDAO.cercaUtente(utente);
		if(this.utenti.size()==0) {
			this.addActionMessage(this.getText("text.null"));
		}	
		return SUCCESS;
	}
}
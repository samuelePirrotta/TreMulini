package it.unirc.pwm.bevanda.action;

import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.bevanda.Bevanda;
import it.unirc.pwm.bevanda.BevandaDAO;
import it.unirc.pwm.bevanda.BevandaDAOFactory;
import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;

public class EliminaBevanda extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	
	private int idBevanda;
	private List<Categoria> categorie = new LinkedList<Categoria>();
	private Utente utente;

	public int getIdBevanda() {
		return this.idBevanda;
	}
	public void setIdBevanda(int idBevanda) {
		this.idBevanda = idBevanda;
	}	
	public List<Categoria> getCategorie() {
		return categorie;
	}
	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}
	public void setUtente(Utente u) {
		this.utente = u;		
	}	
	public Utente getUtente() {
		return this.utente;
	}
	
	public String execute() {
		BevandaDAO bDAO = BevandaDAOFactory.getDAO();
		Bevanda b = new Bevanda();
		b.setIdBevanda(this.getIdBevanda());	
		b.setNome("");
		if(bDAO.deleteBevanda(b)) {
			this.addActionMessage(this.getText("text.delete.success"));
		}else {
			this.addActionError(this.getText("text.delete.error"));
		}
		return SUCCESS;
	}
}
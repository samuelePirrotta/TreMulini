package it.unirc.pwm.bevanda.action;

import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.categoria.CategoriaDAO;
import it.unirc.pwm.categoria.CategoriaDAOFactory;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;

public class ChiediNuovaBevanda extends ActionSupport implements UtenteAware {
	
	private static final long serialVersionUID = 1L;
	
	private List<Categoria> categorie = new LinkedList<Categoria>();
	private Utente utente;
	
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
		CategoriaDAO cDAO = CategoriaDAOFactory.getDAO();
		this.categorie = cDAO.getCategorieBevande();
		return SUCCESS;
	}
}
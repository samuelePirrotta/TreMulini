package it.unirc.pwm.piatto.action;

import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.categoria.CategoriaDAO;
import it.unirc.pwm.categoria.CategoriaDAOFactory;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;

public class ChiediCercaPiatto extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	private Utente utente;
	
	private List<Categoria> categorie = new LinkedList<Categoria>();

	public List<Categoria> getCategorie() {
		return categorie;
	}
	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	public String execute() {
		CategoriaDAO cDAO = CategoriaDAOFactory.getDAO();
		this.categorie = cDAO.getCategoriePiatti();
		return SUCCESS;
	}
}
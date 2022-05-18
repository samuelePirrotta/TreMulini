package it.unirc.pwm.piatto.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.categoria.CategoriaDAO;
import it.unirc.pwm.categoria.CategoriaDAOFactory;
import it.unirc.pwm.ingrediente.Ingrediente;
import it.unirc.pwm.ingrediente.IngredienteDAO;
import it.unirc.pwm.ingrediente.IngredienteDAOFactory;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;

public class ChiediNuovoPiatto extends ActionSupport implements UtenteAware {
	
	private static final long serialVersionUID = 1L;
	
	private List<Categoria> categorie;
	private List<Ingrediente> ingredienti;
	private Utente utente;

	public List<Categoria> getCategorie() {
		return categorie;
	}
	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}	
	public List<Ingrediente> getIngredienti() {
		return ingredienti;
	}
	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}
	public void setUtente(Utente u) {
		this.utente = u;		
	}	
	public Utente getUtente() {
		return this.utente;
	}
	
	public String execute() {
		CategoriaDAO cDAO = CategoriaDAOFactory.getDAO();
		IngredienteDAO iDAO = IngredienteDAOFactory.getDAO();
		this.categorie = cDAO.getCategoriePiatti();
		this.ingredienti = iDAO.getIngredienti();
		return SUCCESS;
	}
}
package it.unirc.pwm.piatto.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.categoria.CategoriaDAO;
import it.unirc.pwm.categoria.CategoriaDAOFactory;
import it.unirc.pwm.ingrediente.Ingrediente;
import it.unirc.pwm.ingrediente.IngredienteDAO;
import it.unirc.pwm.ingrediente.IngredienteDAOFactory;
import it.unirc.pwm.piatto.Piatto;
import it.unirc.pwm.piatto.PiattoDAO;
import it.unirc.pwm.piatto.PiattoDAOFactory;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;

public class ChiediModificaPiatto extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	
	private int idPiatto;
	private Piatto piatto;
	private List<Categoria> categorie;
	private List<Ingrediente> ingredienti;
	private Utente utente;

	public int getIdPiatto() {
		return idPiatto;
	}
	public void setIdPiatto(int idPiatto) {
		this.idPiatto = idPiatto;
	}
	public Piatto getPiatto() {
		return piatto;
	}
	public void setPiatto(Piatto piatto) {
		this.piatto = piatto;
	}	
	public List<Ingrediente> getIngredienti() {
		return ingredienti;
	}
	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}	
	public List<Categoria> getCategorie() {
		CategoriaDAO cDAO = CategoriaDAOFactory.getDAO();
		this.categorie = cDAO.getCategoriePiatti();
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
		PiattoDAO pDAO = PiattoDAOFactory.getDAO();
		this.piatto = new Piatto();
		this.piatto.setIdPiatto(this.idPiatto);
		this.piatto = pDAO.getPiatto(this.piatto);
		
		IngredienteDAO iDAO = IngredienteDAOFactory.getDAO();
		this.ingredienti = iDAO.getIngredienti();
		return SUCCESS;
	}
}
package it.unirc.pwm.ingrediente.action;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.ingrediente.Ingrediente;
import it.unirc.pwm.ingrediente.IngredienteDAO;
import it.unirc.pwm.ingrediente.IngredienteDAOFactory;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;

public class ChiediModificaIngrediente extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	
	private Integer idIngrediente;
	private Ingrediente ingrediente;
	private Utente utente;
	
	public Integer getIdIngrediente() {
		return idIngrediente;
	}
	public void setIdIngrediente(Integer idIngrediente) {
		this.idIngrediente = idIngrediente;
	}
	public Ingrediente getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	public void setUtente(Utente u) {
		this.utente = u;		
	}	
	public Utente getUtente() {
		return this.utente;
	}
	
	public String execute() {
		IngredienteDAO iDAO = IngredienteDAOFactory.getDAO();
		this.ingrediente = new Ingrediente();
		this.ingrediente.setIdIngrediente(this.idIngrediente);
		this.ingrediente = iDAO.getIngrediente(this.ingrediente);
		return SUCCESS;
	}
}
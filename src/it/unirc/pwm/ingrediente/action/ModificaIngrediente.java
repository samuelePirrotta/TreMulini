package it.unirc.pwm.ingrediente.action;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.ingrediente.Ingrediente;
import it.unirc.pwm.ingrediente.IngredienteDAO;
import it.unirc.pwm.ingrediente.IngredienteDAOFactory;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;

public class ModificaIngrediente extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	
	private Integer idIngrediente;
	private Ingrediente ingrediente;
	private String allergene;
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
	public String getAllergene() {
		return allergene;
	}
	public void setAllergene(String allergene) {
		this.allergene = allergene;
	}
	public void setUtente(Utente u) {
		this.utente = u;		
	}	
	public Utente getUtente() {
		return this.utente;
	}
	
	public String execute() {
		IngredienteDAO iDAO = IngredienteDAOFactory.getDAO();
		this.ingrediente.setIdIngrediente(this.idIngrediente);
		if(this.allergene.equals("Si")) {
			this.ingrediente.setAllergene(true);
		}else {
			this.ingrediente.setAllergene(false);
		}
		System.out.println(this.ingrediente.toString());
		if(iDAO.updateIngrediente(ingrediente)) {
			this.addActionMessage(this.getText("text.update.success"));
		}else {
			this.addActionError(this.getText("text.update.error"));
		}
		return SUCCESS;
	}
}
package it.unirc.pwm.ingrediente.action;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.ingrediente.Ingrediente;
import it.unirc.pwm.ingrediente.IngredienteDAO;
import it.unirc.pwm.ingrediente.IngredienteDAOFactory;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;

public class EliminaIngrediente extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	
	private Integer idIngrediente;
	private Utente utente;
	
	public Integer getIdIngrediente() {
		return idIngrediente;
	}
	public void setIdIngrediente(Integer idIngrediente) {
		this.idIngrediente = idIngrediente;
	}
	
	public void setUtente(Utente u) {
		this.utente = u;		
	}	
	public Utente getUtente() {
		return this.utente;
	}

	public String execute() {
		IngredienteDAO iDAO = IngredienteDAOFactory.getDAO();
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setIdIngrediente(this.idIngrediente);
		ingrediente.setNome("");
		ingrediente.setAllergene(false);
		ingrediente.setPrezzo(0);
		try {
			if(iDAO.deleteIngrediente(ingrediente)) {
				this.addActionMessage(this.getText("text.delete.success"));
			}else {
				this.addActionError(this.getText("text.delete.error"));
			}
		}catch(javax.persistence.PersistenceException e) { //Violazione del vincolo di integrità referenziale con Piatto
			this.addActionMessage(this.getText("text.costraintViolation"));
			return ERROR;
		}
		return SUCCESS;
	}
}
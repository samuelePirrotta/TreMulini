package it.unirc.pwm.categoria.action;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.categoria.CategoriaDAO;
import it.unirc.pwm.categoria.CategoriaDAOFactory;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;

public class EliminaCategoria extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	
	private Integer idCategoria;
	private Utente utente;

	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public void setUtente(Utente u) {
		this.utente = u;		
	}	
	public Utente getUtente() {
		return this.utente;
	}
	
	public String execute() {
		CategoriaDAO cDAO = CategoriaDAOFactory.getDAO();
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(this.idCategoria);
		categoria.setNome("");
		categoria.setTipo(false);
		try {
			if(cDAO.deleteCategoria(categoria)) {
				this.addActionMessage(this.getText("text.delete.success"));
			}else {
				this.addActionError(this.getText("text.delete.error"));
			}
		}catch(javax.persistence.PersistenceException e) { //Violazione del vincolo di integrità referenziale con Piatto o Bevanda
			this.addActionMessage(this.getText("text.costraintViolation"));
			return ERROR;
		}
		return SUCCESS;
	}
}
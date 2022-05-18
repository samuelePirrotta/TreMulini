package it.unirc.pwm.categoria.action;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.categoria.CategoriaDAO;
import it.unirc.pwm.categoria.CategoriaDAOFactory;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;

public class ModificaCategoria extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	
	private Integer idCategoria;
	private Categoria categoria;
	private String tipo;
	private Utente utente;
	
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setUtente(Utente u) {
		this.utente = u;		
	}	
	public Utente getUtente() {
		return this.utente;
	}
	
	public String execute() {
		CategoriaDAO cDAO = CategoriaDAOFactory.getDAO();
		this.categoria.setIdCategoria(this.idCategoria);
		if(this.tipo.equals("Piatto")) {
			this.categoria.setTipo(true);
		}else {
			this.categoria.setTipo(false);
		}
		if(cDAO.updateCategoria(this.categoria)) {
			this.addActionMessage(this.getText("text.update.success"));
		}else {
			this.addActionError(this.getText("text.update.error"));
		}
		return SUCCESS;
	}
}
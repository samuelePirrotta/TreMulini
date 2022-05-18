package it.unirc.pwm.categoria.action;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.categoria.CategoriaDAO;
import it.unirc.pwm.categoria.CategoriaDAOFactory;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;

public class ChiediModificaCategoria extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	
	private Integer idCategoria;
	private Categoria categoria;
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
	public void setUtente(Utente u) {
		this.utente = u;		
	}	
	public Utente getUtente() {
		return this.utente;
	}
	
	public String execute() {
		CategoriaDAO cDAO = CategoriaDAOFactory.getDAO();
		this.categoria = new Categoria();
		this.categoria.setIdCategoria(this.idCategoria);
		this.categoria = cDAO.getCategoria(this.categoria);
		return SUCCESS;
	}
}
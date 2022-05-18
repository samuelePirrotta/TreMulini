package it.unirc.pwm.bevanda.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.bevanda.Bevanda;
import it.unirc.pwm.bevanda.BevandaDAO;
import it.unirc.pwm.bevanda.BevandaDAOFactory;
import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.categoria.CategoriaDAO;
import it.unirc.pwm.categoria.CategoriaDAOFactory;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;

public class ModificaBevanda extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	
	protected static final CategoriaDAO cDAO = CategoriaDAOFactory.getDAO();
	
	private int categoria;
	private Bevanda bevanda;
	private List<Categoria> categorie;
	private Utente utente;
	
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public Bevanda getBevanda() {
		return this.bevanda;
	}
	public void setBevanda(Bevanda bevanda) {
		this.bevanda = bevanda;
	}	
	public List<Categoria> getCategorie() {
		this.categorie = cDAO.getCategorieBevande();
		return this.categorie;
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
		BevandaDAO bDAO = BevandaDAOFactory.getDAO();
		Categoria tmp = new Categoria();
		tmp.setIdCategoria(categoria);
		this.bevanda.setCategoria(cDAO.getCategoria(tmp));
		if(bDAO.updateBevanda(this.bevanda)) {
			this.addActionMessage(this.getText("text.update.success"));
		} else {
			this.addActionError(this.getText("text.update.error"));
		}
		return SUCCESS;
	}
}
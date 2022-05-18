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

public class ChiediModificaBevanda extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	
	private int idBevanda;
	private Bevanda bevanda;
	private List<Categoria> categorie;
	private Utente utente;
	
	public int getIdBevanda() {
		return this.idBevanda;
	}
	public void setIdBevanda(int idBevanda) {
		this.idBevanda = idBevanda;
	}
	public Bevanda getBevanda() {
		return this.bevanda;
	}
	public void setBevanda(Bevanda bevanda) {
		this.bevanda = bevanda;
	}
	public List<Categoria> getCategorie() {
		CategoriaDAO cDAO = CategoriaDAOFactory.getDAO();
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
		this.bevanda = new Bevanda();
		this.bevanda.setIdBevanda(this.idBevanda);
		this.bevanda = bDAO.getBevanda(this.bevanda);
		return SUCCESS;
	}
}
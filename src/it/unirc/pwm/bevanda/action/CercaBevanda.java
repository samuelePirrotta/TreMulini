package it.unirc.pwm.bevanda.action;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.bevanda.Bevanda;
import it.unirc.pwm.bevanda.BevandaDAO;
import it.unirc.pwm.bevanda.BevandaDAOFactory;
import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.categoria.CategoriaDAO;
import it.unirc.pwm.categoria.CategoriaDAOFactory;

public class CercaBevanda extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private Integer idBevanda;
	private String nome;
	private String tipo;
	private String cantina;
	private Integer categoria;
	private List<Bevanda> bevande;	
	private List<Categoria> categorie = new LinkedList<Categoria>();
	
	protected static final CategoriaDAO cDAO = CategoriaDAOFactory.getDAO();
	
	public Integer getIdBevanda() {
		return this.idBevanda;
	}
	public void setIdBevanda(Integer idBevanda) {
		this.idBevanda = idBevanda;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	} 
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCantina() {
		return this.cantina;
	}
	public void setCantina(String cantina) {
		this.cantina = cantina;
	}
	public Integer getCategoria() {
		return this.categoria;
	}
	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}	
	public List<Bevanda> getBevande() {
		return this.bevande;
	}
	public void setBevande(List<Bevanda> bevande) {
		this.bevande = bevande;
	}
	public List<Categoria> getCategorie() {
		this.categorie = cDAO.getCategorieBevande();
		return this.categorie;
	}
	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}
	
	public String execute() throws Exception {
		BevandaDAO bDAO = BevandaDAOFactory.getDAO();
		Bevanda bevanda = new Bevanda();
		bevanda.setIdBevanda(idBevanda);
		
		if(this.nome.equals("")) {
			this.nome = null;
		}else {
			bevanda.setNome(this.nome);
		}
		if(this.tipo.equals("")) {
			this.tipo = null;
		}else {
			bevanda.setTipo(this.tipo);
		}
		if(this.cantina.equals("")) {
			this.cantina = null;
		}else {
			bevanda.setCantina(this.cantina);
		}	
		
		if((this.categoria!=-1) && (this.idBevanda==null && this.nome==null && this.tipo==null && this.cantina==null)) {
			Categoria c = new Categoria();
			c.setIdCategoria(this.categoria);
			c = cDAO.getCategoria(c);
			this.bevande = bDAO.perCategoria(c);
			Collections.sort(this.bevande);
		}else {			
			this.bevande = bDAO.cercaBevanda(bevanda);
		}
		if(this.bevande.size()==0) {
			this.addActionMessage(this.getText("text.null"));
		}
		return SUCCESS;
	}
}
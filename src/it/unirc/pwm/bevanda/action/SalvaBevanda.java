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

public class SalvaBevanda extends ActionSupport implements UtenteAware {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private int categoria;
	private String tipo;
	private int pezzatura;
	private double costo;
	private double prezzo;
	private String cantina;
	private List<Categoria> categorie;
	private Utente utente;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getPezzatura() {
		return pezzatura;
	}
	public void setPezzatura(int pezzatura) {
		this.pezzatura = pezzatura;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getCantina() {
		return cantina;
	}
	public void setCantina(String cantina) {
		this.cantina = cantina;
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
		Bevanda bevanda = new Bevanda();
		Categoria c = new Categoria();
		bevanda.setNome(this.nome);
		c.setIdCategoria(this.categoria);
		bevanda.setCategoria(c);
		bevanda.setCosto(this.costo);	
		bevanda.setPrezzo(this.prezzo);
		bevanda.setCantina(this.cantina);
		bevanda.setPezzatura(this.pezzatura);
		bevanda.setTipo(this.tipo);
		if(bDAO.saveBevanda(bevanda)) {
			this.addActionMessage(this.getText("text.success"));		
		}else {
			this.addActionError(this.getText("text.error"));
		}		
		return SUCCESS;
	}
}
package it.unirc.pwm.bevanda.action.android;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.bevanda.Bevanda;
import it.unirc.pwm.bevanda.BevandaDAO;
import it.unirc.pwm.bevanda.BevandaDAOFactory;
import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.categoria.CategoriaDAO;
import it.unirc.pwm.categoria.CategoriaDAOFactory;

public class GetBevande extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private List<Bevanda> bevande;
	private String nome;
	
	public List<Bevanda> getBevande() {
		return bevande;
	}
	public void setBevande(List<Bevanda> bevande) {
		this.bevande = bevande;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String execute() {
		BevandaDAO bDAO = BevandaDAOFactory.getDAO();
		CategoriaDAO cDAO = CategoriaDAOFactory.getDAO();
		Categoria categoria = new Categoria();
		categoria = cDAO.getForName(this.nome);
		this.bevande = bDAO.perCategoria(categoria);
		return SUCCESS;
	}
}
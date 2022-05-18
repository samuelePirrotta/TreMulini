package it.unirc.pwm.piatto.action.android;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.categoria.CategoriaDAO;
import it.unirc.pwm.categoria.CategoriaDAOFactory;
import it.unirc.pwm.piatto.Piatto;
import it.unirc.pwm.piatto.PiattoDAO;
import it.unirc.pwm.piatto.PiattoDAOFactory;

public class GetPiatti extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private List<Piatto> piatti;
	private String nome;

	public List<Piatto> getPiatti() {
		return piatti;
	}
	public void setPiatti(List<Piatto> piatti) {
		this.piatti = piatti;
	}	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String execute() {
		PiattoDAO pDAO = PiattoDAOFactory.getDAO();
		CategoriaDAO cDAO = CategoriaDAOFactory.getDAO();
		Categoria categoria = new Categoria();
		categoria = cDAO.getForName(this.nome);
		this.piatti = pDAO.perCategoria(categoria);
		return SUCCESS;
	}	
}
package it.unirc.pwm.categoria.action.android;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.categoria.CategoriaDAO;
import it.unirc.pwm.categoria.CategoriaDAOFactory;

public class GetCategorie extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private int scelta;
	private List<Categoria> categorie;
	
	public int getScelta() {
		return scelta;
	}
	public void setScelta(int scelta) {
		this.scelta = scelta;
	}
	public List<Categoria> getCategorie() {
		return categorie;
	}
	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}
	
	public String execute() {
		CategoriaDAO cDAO = CategoriaDAOFactory.getDAO();
		if(scelta==0)
			this.categorie = cDAO.getCategoriePiatti();
		else 
			this.categorie = cDAO.getCategorieBevande();
		return SUCCESS;
	}
}
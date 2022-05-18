package it.unirc.pwm.categoria.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.categoria.CategoriaDAO;
import it.unirc.pwm.categoria.CategoriaDAOFactory;

public class CercaCategoria extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Integer idCategoria;
	private String tipo;
	private List<Categoria> categorie;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String isTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
		public List<Categoria> getCategorie() {
		return categorie;
	}
	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}
	
	public String execute() {
		CategoriaDAO cDAO = CategoriaDAOFactory.getDAO();
		Categoria categoria = new Categoria();
		
		categoria.setIdCategoria(this.idCategoria);
		if(this.nome.equals("")) {
			this.nome = null;
		}else {
			categoria.setNome(this.nome);
		}
		try {
			if(this.tipo.equals("Piatto")) {
				categoria.setTipo(true);
			}else {
				categoria.setTipo(false);
			}
		}catch (NullPointerException e) {
			categoria.setTipo(null);
		}
		
		this.categorie = cDAO.cercaCategoria(categoria);
		if(this.categorie.size()==0) {
			this.addActionMessage(this.getText("text.null"));
		}
		return SUCCESS;
	}
}
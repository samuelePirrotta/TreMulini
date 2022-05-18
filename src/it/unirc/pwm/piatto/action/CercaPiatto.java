package it.unirc.pwm.piatto.action;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.categoria.CategoriaDAO;
import it.unirc.pwm.categoria.CategoriaDAOFactory;
import it.unirc.pwm.piatto.Piatto;
import it.unirc.pwm.piatto.PiattoDAO;
import it.unirc.pwm.piatto.PiattoDAOFactory;

public class CercaPiatto extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private Integer idPiatto;
	private String nome;
	private String descrizione;
	private int categoria;
	private List<Categoria> categorie = new LinkedList<Categoria>();
	private List<Piatto> piatti;
	
	protected static final CategoriaDAO cDAO = CategoriaDAOFactory.getDAO();
	
	public Integer getIdPiatto() {
		return idPiatto;
	}
	public void setIdPiatto(Integer idPiatto) {
		this.idPiatto = idPiatto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public List<Piatto> getPiatti() {
		return piatti;
	}
	public void setPiatti(List<Piatto> piatti) {
		this.piatti = piatti;
	}
	public List<Categoria> getCategorie() {
		this.categorie = cDAO.getCategoriePiatti();
		return categorie;
	}
	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}
	
	public String execute() {
		PiattoDAO pDAO = PiattoDAOFactory.getDAO();
		Piatto piatto = new Piatto();
		
		piatto.setIdPiatto(this.idPiatto);		
		if(this.nome.equals("")) {
			this.nome = null;
		}else {
			piatto.setNome(this.nome);
		}
		if(this.descrizione.equals("")) {
			this.descrizione = null;
		}else {
			piatto.setDescrizione(this.descrizione);
		}
		if((this.categoria!=-1) && (this.idPiatto==null && this.nome==null && this.descrizione==null)) {
			Categoria c = new Categoria();
			c.setIdCategoria(this.categoria);
			c = cDAO.getCategoria(c);
			this.piatti = pDAO.perCategoria(c);
			Collections.sort(this.piatti);
		}else {
			this.piatti = pDAO.cercaPiatto(piatto);
		}
		if(this.piatti.size()==0) {
			this.addActionMessage(this.getText("text.null"));
		}
		return SUCCESS;
	}
}
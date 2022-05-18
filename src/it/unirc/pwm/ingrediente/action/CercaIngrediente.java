package it.unirc.pwm.ingrediente.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.ingrediente.Ingrediente;
import it.unirc.pwm.ingrediente.IngredienteDAO;
import it.unirc.pwm.ingrediente.IngredienteDAOFactory;

public class CercaIngrediente extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private Integer idIngrediente;
	private String nome;
	private String allergene;
	private String tipoAllergene;
	private List<Ingrediente> ingredienti;
	
	public Integer getIdIngrediente() {
		return idIngrediente;
	}
	public void setIdIngrediente(Integer idIngrediente) {
		this.idIngrediente = idIngrediente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAllergene() {
		return allergene;
	}
	public void setAllergene(String allergene) {
		this.allergene = allergene;
	}
	public String getTipoAllergene() {
		return tipoAllergene;
	}
	public void setTipoAllergene(String tipoAllergene) {
		this.tipoAllergene = tipoAllergene;
	}
	public List<Ingrediente> getIngredienti() {
		return ingredienti;
	}
	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}
	
	public String execute() {
		IngredienteDAO iDAO = IngredienteDAOFactory.getDAO();
		Ingrediente ingrediente = new Ingrediente();
		
		ingrediente.setIdIngrediente(this.idIngrediente);
		if(this.nome.equals("")) {
			ingrediente.setNome(null);
		}else {
			ingrediente.setNome(this.nome);
		}
		try {
			if(this.allergene.equals("Si")) {
				ingrediente.setAllergene(true);
			}else {
				ingrediente.setAllergene(false);
			}	
		}catch (NullPointerException e) {
			ingrediente.setAllergene(null);
		}
		if(this.tipoAllergene.equals("")) {
			ingrediente.setTipoAllergene(null);
		}else {
			ingrediente.setTipoAllergene(this.tipoAllergene);
		}
		
		this.ingredienti = iDAO.cercaIngrediente(ingrediente);
		if(this.ingredienti.size()==0) {
			this.addActionMessage(this.getText("text.null"));
		}
		return SUCCESS;
	}
}
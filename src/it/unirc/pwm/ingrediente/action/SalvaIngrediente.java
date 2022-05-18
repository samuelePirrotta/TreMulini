package it.unirc.pwm.ingrediente.action;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.ingrediente.Ingrediente;
import it.unirc.pwm.ingrediente.IngredienteDAO;
import it.unirc.pwm.ingrediente.IngredienteDAOFactory;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;

public class SalvaIngrediente extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;	
	
	private String nome;
	private double prezzo;
	private String allergene;
	private String tipoAllergene;
	private Utente utente;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
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
	public void setUtente(Utente u) {
		this.utente = u;		
	}	
	public Utente getUtente() {
		return this.utente;
	}
	
	public String execute() {
		IngredienteDAO iDAO = IngredienteDAOFactory.getDAO();
		Ingrediente ingrediente = new Ingrediente();
		
		ingrediente.setNome(this.nome);
		ingrediente.setPrezzo(this.prezzo);
		if(this.allergene.equals("Si")) {
			ingrediente.setAllergene(true);
		}else {
			ingrediente.setAllergene(false);
		}
		ingrediente.setTipoAllergene(this.tipoAllergene);
		
		if(iDAO.saveIngrediente(ingrediente)) {
			this.addActionMessage(this.getText("text.success"));
		}else {
			this.addActionError(this.getText("text.error"));
		}
		return SUCCESS;
	}
}
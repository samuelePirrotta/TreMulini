package it.unirc.pwm.categoria.action;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.categoria.CategoriaDAO;
import it.unirc.pwm.categoria.CategoriaDAOFactory;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;

public class SalvaCategoria extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String tipo;
	private Utente utente;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setUtente(Utente u) {
		this.utente = u;		
	}	
	public Utente getUtente() {
		return this.utente;
	}
	
	public String execute() {
		CategoriaDAO cDAO = CategoriaDAOFactory.getDAO();
		Categoria categoria = new Categoria();
		categoria.setNome(this.nome);
		if(this.tipo.equals("Piatto")) {
			categoria.setTipo(true);
		}else {
			categoria.setTipo(false);
		}
		if(cDAO.saveCategroia(categoria)) {
			this.addActionMessage(this.getText("text.success"));
		}else {
			this.addActionError(this.getText("text.error"));
		}
		return SUCCESS;
	}
}
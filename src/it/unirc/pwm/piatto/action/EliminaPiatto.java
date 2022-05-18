package it.unirc.pwm.piatto.action;

import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.piatto.Piatto;
import it.unirc.pwm.piatto.PiattoDAO;
import it.unirc.pwm.piatto.PiattoDAOFactory;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;

public class EliminaPiatto extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	
	private int idPiatto;
	private List<Categoria> categorie = new LinkedList<Categoria>();
	private Utente utente;
	
	public int getIdPiatto() {
		return idPiatto;
	}
	public void setIdPiatto(int idPiatto) {
		this.idPiatto = idPiatto;
	}
	public List<Categoria> getCategorie() {
		return categorie;
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
		PiattoDAO pDAO = PiattoDAOFactory.getDAO();
		Piatto tmp = new Piatto();
		tmp.setIdPiatto(this.idPiatto);
		tmp.setNome("");
		tmp.setDescrizione("");
		if(pDAO.deletePiatto(tmp)) {
			this.addActionMessage(this.getText("text.delete.success"));
		}else {
			this.addActionError(this.getText("text.delete.error"));
		}
		return SUCCESS;
	}
}
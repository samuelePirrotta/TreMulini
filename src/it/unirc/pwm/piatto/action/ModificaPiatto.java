package it.unirc.pwm.piatto.action;

import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.categoria.CategoriaDAO;
import it.unirc.pwm.categoria.CategoriaDAOFactory;
import it.unirc.pwm.ingrediente.Ingrediente;
import it.unirc.pwm.ingrediente.IngredienteDAO;
import it.unirc.pwm.ingrediente.IngredienteDAOFactory;
import it.unirc.pwm.piatto.Piatto;
import it.unirc.pwm.piatto.PiattoDAO;
import it.unirc.pwm.piatto.PiattoDAOFactory;
import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.action.UtenteAware;
import it.unirc.pwm.util.CollectionConverter;

public class ModificaPiatto extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	
	protected static final CategoriaDAO cDAO = CategoriaDAOFactory.getDAO();
	protected static final IngredienteDAO iDAO = IngredienteDAOFactory.getDAO();
	private Utente utente;
	
	private int idPiatto;
	private int categoria;
	private Piatto piatto;
	private List<Categoria> categorie;
	private List<Ingrediente> ingredienti = new LinkedList<Ingrediente>();
	private String id_ingredienti;
	private String nomi_ingredienti;
	
	public int getIdPiatto() {
		return idPiatto;
	}
	public void setIdPiatto(int idPiatto) {
		this.idPiatto = idPiatto;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public Piatto getPiatto() {
		return piatto;
	}
	public void setPiatto(Piatto piatto) {
		this.piatto = piatto;
	}
	public List<Categoria> getCategorie() {
		this.categorie = cDAO.getCategoriePiatti();
		return categorie;
	}
	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}	
	public List<Ingrediente> getIngredienti() {
		this.ingredienti = iDAO.getIngredienti();
		return ingredienti;
	}
	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}
	public String getId_ingredienti() {
		return id_ingredienti;
	}
	public void setId_ingredienti(String id_ingredienti) {
		this.id_ingredienti = id_ingredienti;
	}
	public String getNomi_ingredienti() {
		return nomi_ingredienti;
	}
	public void setNomi_ingredienti(String nomi_ingredienti) {
		this.nomi_ingredienti = nomi_ingredienti;
	}
	public void setUtente(Utente u) {
		this.utente = u;		
	}	
	public Utente getUtente() {
		return this.utente;
	}
	
	public String execute() {
		PiattoDAO pDAO = PiattoDAOFactory.getDAO();
		//Set della categoria selezionata
		Categoria c = new Categoria();
		c.setIdCategoria(this.categoria);
		//Set della lista di ingredienti selezionati
		
		if(!this.id_ingredienti.equals("")) {			
			String[] tmp = id_ingredienti.split(", ");
			for(int i=0; i<tmp.length; i++) {
				Ingrediente ing = new Ingrediente();
				ing.setIdIngrediente(Integer.parseInt(tmp[i]));
				this.ingredienti.add(iDAO.getIngrediente(ing));
			}
		}
		//Set degli attributi del piatto
		this.piatto.setCategoria(cDAO.getCategoria(c));
		this.piatto.setIdPiatto(this.idPiatto);
		this.piatto.setIngredienti(CollectionConverter.getSet(this.ingredienti));
		//Selvataggio delle modifiche nel DB
		if(pDAO.updatePiatto(this.piatto)) { //
			this.addActionMessage(this.getText("text.update.success"));
		}else {
			this.addActionError(this.getText("text.update.success"));
		}		
		return SUCCESS;
	}
}
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

public class SalvaPiatto extends ActionSupport implements UtenteAware {

	private static final long serialVersionUID = 1L;
	private Utente utente;
	
	private String nome;
	private int idPiatto;
	private int categoria;
	private double prezzo;
	private String descrizione;
	private List<Categoria> categorie;
	private List<Ingrediente> ingredienti = new LinkedList<Ingrediente>();
	private String id_ingredienti;
	private String nomi_ingredienti;
	private Piatto piatto;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public List<Categoria> getCategorie() {
		CategoriaDAO cDAO = CategoriaDAOFactory.getDAO();
		this.categorie = cDAO.getCategoriePiatti();
		return categorie;
	}
	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}	
	public List<Ingrediente> getIngredienti() {
		return ingredienti;
	}
	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}
	public String getId_ingredienti() {
		return id_ingredienti;
	}
	public String getNomi_ingredienti() {
		return nomi_ingredienti;
	}
	public void setNomi_ingredienti(String nomi_ingredienti) {
		this.nomi_ingredienti = nomi_ingredienti;
	}
	public void setId_ingredienti(String id_ingredienti) {
		this.id_ingredienti = id_ingredienti;
	}
	public int getIdPiatto() {
		return idPiatto;
	}
	public void setIdPiatto(int idPiatto) {
		this.idPiatto = idPiatto;
	}
	public Piatto getPiatto() {
		return piatto;
	}
	public void setPiatto(Piatto piatto) {
		this.piatto = piatto;
	}
	public void setUtente(Utente u) {
		this.utente = u;		
	}	
	public Utente getUtente() {
		return this.utente;
	}
	
	public String execute() {
		PiattoDAO pDAO = PiattoDAOFactory.getDAO();
		this.piatto = new Piatto();
		//Set della categoria selezionata
		Categoria c = new Categoria();
		c.setIdCategoria(this.categoria);
		//Set della lista di ingredienti selezionati
		IngredienteDAO iDAO = IngredienteDAOFactory.getDAO();
		String[] tmp = id_ingredienti.split(", ");
		for(int i=0; i<tmp.length; i++) {
			Ingrediente ing = new Ingrediente();
			ing.setIdIngrediente(Integer.parseInt(tmp[i]));
			this.ingredienti.add(iDAO.getIngrediente(ing));
		}
		//Set degli attributi del piatto
		this.piatto.setNome(this.nome);
		this.piatto.setCategoria(c);
		this.piatto.setPrezzo(this.prezzo);
		this.piatto.setDescrizione(this.descrizione);
		this.piatto.setIngredienti(CollectionConverter.getSet(this.ingredienti));
		//Salvataggio del piatto nel DB
		if(pDAO.savePiatto(piatto)) { //
			this.addActionMessage(this.getText("text.success"));
		}else {
			this.addActionError(this.getText("text.error"));
		}
		//Set dell'id del nuovo piatto creato
		this.idPiatto = pDAO.perNome(this.nome).getIdPiatto();		
		//Reset della lista di ingredienti
		this.ingredienti = iDAO.getIngredienti();
		return SUCCESS;
	}
}
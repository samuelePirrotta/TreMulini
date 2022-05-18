package it.unirc.pwm.piatto;

import java.util.HashSet;
import java.util.Set;

import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.ingrediente.Ingrediente;
//import it.unirc.pwm.ordine_piatto.OrdinePiatto;

public class Piatto implements java.io.Serializable, Comparable<Piatto> {

	private static final long serialVersionUID = 1L;
	private Integer idPiatto;
	private String nome;
	private Categoria categoria;
	private double prezzo;
	private String descrizione;
	private Set<Ingrediente> ingredienti = new HashSet<Ingrediente>();
	//private Set<OrdinePiatto> ordinePiatto = new HashSet<OrdinePiatto>();

	public Piatto() {
	}

	public Piatto(String nome, Categoria categoria, double prezzo, String descrizione) {
		this.nome = nome;
		this.categoria = categoria;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
	}

	public Piatto(String nome, Categoria categoria, double prezzo, String descrizione, Set<Ingrediente> ingredienti) { /*, Set<OrdinePiatto> ordinePiatto*/
		this.nome = nome;
		this.categoria = categoria;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
		this.ingredienti = ingredienti;
		//this.ordinePiatto = ordinePiatto;
	}

	public Integer getIdPiatto() {
		return this.idPiatto;
	}

	public void setIdPiatto(Integer idPiatto) {
		this.idPiatto = idPiatto;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Set<Ingrediente> getIngredienti() {
		return this.ingredienti;
	}

	public void setIngredienti(Set<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}

//	public Set<OrdinePiatto> getOrdinePiatto() {
//		return this.ordinePiatto;
//	}
//
//	public void setOrdinePiatto(Set<OrdinePiatto> ordinePiatto) {
//		this.ordinePiatto = ordinePiatto;
//	}

	@Override
	public String toString() {
		return "Piatto [idPiatto=" + idPiatto + ", nome=" + nome + ", categoria=" + categoria + ", prezzo=" + prezzo
				+ ", descrizione=" + descrizione + "]";
	}

	@Override
	public int compareTo(Piatto o) {
		return this.idPiatto.compareTo(o.idPiatto);
	}
}
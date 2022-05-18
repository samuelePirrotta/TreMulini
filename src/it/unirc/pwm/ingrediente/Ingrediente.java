package it.unirc.pwm.ingrediente;

import java.util.HashSet;
import java.util.Set;

import it.unirc.pwm.piatto.Piatto;

public class Ingrediente implements java.io.Serializable, Comparable<Ingrediente> {
	
	private static final long serialVersionUID = 1L;
	private Integer idIngrediente;
	private String nome;
	private Boolean allergene;
	private String tipoAllergene;
	private double prezzo;
	private Set<Piatto> piatti = new HashSet<Piatto>();

	public Ingrediente() {
	}

	public Ingrediente(String nome, Boolean allergene, double prezzo) {
		this.nome = nome;
		this.allergene = allergene;
		this.prezzo = prezzo;
	}

	public Ingrediente(String nome, Boolean allergene, String tipoAllergene, double prezzo, 
			Set<Piatto> piatti) {
		this.nome = nome;
		this.allergene = allergene;
		this.tipoAllergene = tipoAllergene;
		this.prezzo = prezzo;
		this.piatti = piatti;
	}

	public Integer getIdIngrediente() {
		return this.idIngrediente;
	}
	public void setIdIngrediente(Integer idIngrediente) {
		this.idIngrediente = idIngrediente;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Boolean isAllergene() {
		return this.allergene;
	}
	public void setAllergene(Boolean allergene) {
		this.allergene = allergene;
	}
	public String getTipoAllergene() {
		return this.tipoAllergene;
	}
	public void setTipoAllergene(String tipoAllergene) {
		this.tipoAllergene = tipoAllergene;
	}
	public double getPrezzo() {
		return this.prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public Set<Piatto> getPiatti() {
		return this.piatti;
	}
	public void setPiatti(Set<Piatto> piatti) {
		this.piatti = piatti;
	}
		
	public int compareTo(Ingrediente o) {
		return this.idIngrediente.compareTo(o.idIngrediente);
	}

	public String toString() {
		return "Ingrediente [idIngrediente=" + idIngrediente + ", nome=" + nome + ", allergene=" + allergene
				+ ", tipoAllergene=" + tipoAllergene + ", prezzo=" + prezzo + "]";
	}	
}
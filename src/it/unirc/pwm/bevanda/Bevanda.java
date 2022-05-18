package it.unirc.pwm.bevanda;

//import java.util.HashSet;
//import java.util.Set;

import it.unirc.pwm.categoria.Categoria;
//import it.unirc.pwm.ordine_bevanda.OrdineBevanda;

public class Bevanda implements java.io.Serializable, Comparable<Bevanda> {
	
	private static final long serialVersionUID = 1L;
	private Integer idBevanda;
	private Categoria categoria;
	private String nome;
	private int pezzatura;
	private double prezzo;
	private double costo;
	private String tipo;
	private String cantina;
	//private Set<OrdineBevanda> ordineBevanda = new HashSet<OrdineBevanda>();

	public Bevanda(){}

	public Bevanda(Categoria categoria, String nome, int pezzatura, double prezzo, double costo) {
		this.categoria = categoria;
		this.nome = nome;
		this.pezzatura = pezzatura;
		this.prezzo = prezzo;
		this.costo = costo;
	}

	public Bevanda(Categoria categoria, String nome, int pezzatura, double prezzo, double costo, String tipo,
			String cantina) { /*, Set<OrdineBevanda> ordineBevanda*/
		this.categoria = categoria;
		this.nome = nome;
		this.pezzatura = pezzatura;
		this.prezzo = prezzo;
		this.costo = costo;
		this.tipo = tipo;
		this.cantina = cantina;
		//this.ordineBevanda = ordineBevanda;
	}

	public Integer getIdBevanda() {
		return this.idBevanda;
	}

	public void setIdBevanda(Integer idBevanda) {
		this.idBevanda = idBevanda;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPezzatura() {
		return this.pezzatura;
	}

	public void setPezzatura(int pezzatura) {
		this.pezzatura = pezzatura;
	}

	public double getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public double getCosto() {
		return this.costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCantina() {
		return this.cantina;
	}

	public void setCantina(String cantina) {
		this.cantina = cantina;
	}

//	public Set<OrdineBevanda> getOrdineBevanda() {
//		return this.ordineBevanda;
//	}
//
//	public void setOrdineBevanda(Set<OrdineBevanda> ordineBevanda) {
//		this.ordineBevanda = ordineBevanda;
//	}

	@Override
	public String toString() {
		return "Bevanda [idBevanda=" + idBevanda + ", nome=" + nome + ", pezzatura="
				+ pezzatura + ", prezzo=" + prezzo + ", costo=" + costo + ", tipo=" + tipo + ", cantina=" + cantina + "]";
	}

	@Override
	public int compareTo(Bevanda o) {
		return this.idBevanda.compareTo(o.idBevanda);
	}
}
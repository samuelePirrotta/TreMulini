package it.unirc.pwm.ordine_bevanda;

import it.unirc.pwm.bevanda.Bevanda;
import it.unirc.pwm.ordine.Ordine;

public class OrdineBevanda implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private OrdineBevandaId id;
	private Bevanda bevanda;
	private Ordine ordine;
	private int quantita;
	private double prezzo;

	public OrdineBevanda(){}

	public OrdineBevanda(OrdineBevandaId id, Bevanda bevanda, Ordine ordine, int quantita, double prezzo) {
		this.id = id;
		this.bevanda = bevanda;
		this.ordine = ordine;
		this.quantita = quantita;
		this.prezzo = prezzo;
	}

	public OrdineBevandaId getId() {
		return this.id;
	}
	public void setId(OrdineBevandaId id) {
		this.id = id;
	}
	public Bevanda getBevanda() {
		return this.bevanda;
	}
	public void setBevanda(Bevanda bevanda) {
		this.bevanda = bevanda;
	}
	public Ordine getOrdine() {
		return this.ordine;
	}
	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}
	public int getQuantita() {
		return this.quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public double getPrezzo() {
		return this.prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
}
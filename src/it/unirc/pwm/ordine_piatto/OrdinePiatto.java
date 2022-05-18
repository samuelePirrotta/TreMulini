package it.unirc.pwm.ordine_piatto;

import it.unirc.pwm.ordine.Ordine;
import it.unirc.pwm.piatto.Piatto;

public class OrdinePiatto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private OrdinePiattoId id;
	private Ordine ordine;
	private Piatto piatto;
	private int quantita;
	private double prezzo;

	public OrdinePiatto() {
	}

	public OrdinePiatto(OrdinePiattoId id, Ordine ordine, Piatto piatto, int quantita, double prezzo) {
		this.id = id;
		this.ordine = ordine;
		this.piatto = piatto;
		this.quantita = quantita;
		this.prezzo = prezzo;
	}

	public OrdinePiattoId getId() {
		return this.id;
	}
	public void setId(OrdinePiattoId id) {
		this.id = id;
	}
	public Ordine getOrdine() {
		return this.ordine;
	}
	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}
	public Piatto getPiatto() {
		return this.piatto;
	}
	public void setPiatto(Piatto piatto) {
		this.piatto = piatto;
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
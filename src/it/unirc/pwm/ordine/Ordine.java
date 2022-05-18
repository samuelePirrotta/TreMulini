package it.unirc.pwm.ordine;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import it.unirc.pwm.ordine_bevanda.OrdineBevanda;
import it.unirc.pwm.ordine_piatto.OrdinePiatto;
import it.unirc.pwm.utente.Utente;

public class Ordine implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idOrdine;
	private Utente utente;
	private Date data;
	private int tavolo;
	private String note;
	private Double totale;
	private Set<OrdineBevanda> ordineBevanda = new HashSet<OrdineBevanda>();
	private Set<OrdinePiatto> ordinePiatto = new HashSet<OrdinePiatto>();

	public Ordine() {
	}

	public Ordine(Utente utente, Date data, int tavolo) {
		this.utente = utente;
		this.data = data;
		this.tavolo = tavolo;
	}

	public Ordine(Utente utente, Date data, int tavolo, String note, Double totale, Set<OrdineBevanda> ordineBevanda,
			Set<OrdinePiatto> ordinePiatto) {
		this.utente = utente;
		this.data = data;
		this.tavolo = tavolo;
		this.note = note;
		this.totale = totale;
		this.ordineBevanda = ordineBevanda;
		this.ordinePiatto = ordinePiatto;
	}

	public Integer getIdOrdine() {
		return this.idOrdine;
	}
	public void setIdOrdine(Integer idOrdine) {
		this.idOrdine = idOrdine;
	}
	public Utente getUtente() {
		return this.utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Date getData() {
		return this.data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getTavolo() {
		return this.tavolo;
	}
	public void setTavolo(int tavolo) {
		this.tavolo = tavolo;
	}
	public String getNote() {
		return this.note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Double getTotale() {
		return this.totale;
	}
	public void setTotale(Double totale) {
		this.totale = totale;
	}
	public Set<OrdineBevanda> getOrdineBevanda() {
		return this.ordineBevanda;
	}
	public void setOrdineBevanda(Set<OrdineBevanda> ordineBevanda) {
		this.ordineBevanda = ordineBevanda;
	}
	public Set<OrdinePiatto> getOrdinePiatto() {
		return this.ordinePiatto;
	}
	public void setOrdinePiatto(Set<OrdinePiatto> ordinePiatto) {
		this.ordinePiatto = ordinePiatto;
	}

	@Override
	public String toString() {
		return "Ordine [idOrdine=" + idOrdine + ", data=" + data + ", tavolo=" + tavolo + ", note=" + note + ", totale="
				+ totale + "]";
	}	
}
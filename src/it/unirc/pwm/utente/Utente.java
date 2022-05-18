package it.unirc.pwm.utente;

import java.util.HashSet;
import java.util.Set;

import it.unirc.pwm.ordine.Ordine;

public class Utente implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idUtente;
	private String nome;
	private String password;
	private String mansione;
	private Set<Ordine> ordini = new HashSet<Ordine>();

	public Utente() {
	}

	public Utente(Integer idUtente, String nome, String password, String mansione) {
		this.idUtente = idUtente;
		this.nome = nome;
		this.password = password;
		this.mansione = mansione;
	}

	public Utente(Integer idUtente, String nome, String password, String mansione, Set<Ordine> ordini) {
		this.idUtente = idUtente;
		this.nome = nome;
		this.password = password;
		this.mansione = mansione;
		this.ordini = ordini;
	}

	public Integer getIdUtente() {
		return this.idUtente;
	}
	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMansione() {
		return this.mansione;
	}
	public void setMansione(String mansione) {
		this.mansione = mansione;
	}
	public Set<Ordine> getOrdini() {
		return this.ordini;
	}
	public void setOrdini(Set<Ordine> ordines) {
		this.ordini = ordines;
	}

	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", nome=" + nome + ", password=" + password + ", mansione=" + mansione + "]";
	}
}
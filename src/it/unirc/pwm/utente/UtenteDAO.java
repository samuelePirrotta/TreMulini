package it.unirc.pwm.utente;

import java.util.List;

public interface UtenteDAO {
	public Utente getUtente(Utente u);
	public List<Utente> getUtenti();
	public List<Utente> cercaUtente(Utente u);
	public boolean saveUtente(Utente u);
	public boolean updateUtente(Utente u);
	public boolean deleteUtente(Utente u);
	public Utente login(Utente u);
}
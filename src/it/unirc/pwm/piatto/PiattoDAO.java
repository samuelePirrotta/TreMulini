package it.unirc.pwm.piatto;

import java.util.List;

import it.unirc.pwm.categoria.Categoria;

public interface PiattoDAO {
	public Piatto getPiatto(Piatto p);
	public List<Piatto> getPiatti();
	public List<Piatto> cercaPiatto(Piatto p);
	public List<Piatto> perCategoria(Categoria c);
	public Piatto perNome(String nome);
	public int getMaxId();
	public boolean savePiatto(Piatto p);
	public boolean updatePiatto(Piatto p);
	public boolean deletePiatto(Piatto p);
}
package it.unirc.pwm.bevanda;

import java.util.List;

import it.unirc.pwm.categoria.Categoria;

public interface BevandaDAO {
	public Bevanda getBevanda(Bevanda b);
	public List<Bevanda> getBevande();
	public List<Bevanda> cercaBevanda(Bevanda b);
	public List<Bevanda> perCategoria(Categoria categoria);
	public boolean saveBevanda(Bevanda b);
	public boolean updateBevanda(Bevanda b);
	public boolean deleteBevanda(Bevanda b);
}
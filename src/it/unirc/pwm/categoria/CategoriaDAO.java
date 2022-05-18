package it.unirc.pwm.categoria;

import java.util.List;

public interface CategoriaDAO {
	public Categoria getCategoria(Categoria c);
	public List<Categoria> getCategorie();
	public List<Categoria> getCategorieBevande();
	public List<Categoria> getCategoriePiatti();
	public List<Categoria> cercaCategoria(Categoria c);
	public Categoria getForName(String nome);
	public boolean saveCategroia(Categoria c);
	public boolean updateCategoria(Categoria c);
	public boolean deleteCategoria(Categoria c);
}
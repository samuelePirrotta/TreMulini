package it.unirc.pwm.ingrediente;

import java.util.List;

public interface IngredienteDAO {
	public Ingrediente getIngrediente(Ingrediente i);
	public List<Ingrediente> getIngredienti();
	public List<Ingrediente> cercaIngrediente(Ingrediente i);
	public boolean saveIngrediente(Ingrediente i);
	public boolean updateIngrediente(Ingrediente i);
	public boolean deleteIngrediente(Ingrediente i);
}
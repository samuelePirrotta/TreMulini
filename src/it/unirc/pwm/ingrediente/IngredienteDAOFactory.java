package it.unirc.pwm.ingrediente;

public class IngredienteDAOFactory {

	private static IngredienteDAO dao = null;
	
	private IngredienteDAOFactory(){}
	
	public static synchronized IngredienteDAO getDAO() {
		if (dao == null) {
			dao = new IngredienteDAOImpl();
		}
		return dao;
	}
}
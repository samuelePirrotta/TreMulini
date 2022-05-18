package it.unirc.pwm.categoria;

public class CategoriaDAOFactory {

	private static CategoriaDAO dao = null;
	
	private CategoriaDAOFactory(){}
	
	public static synchronized CategoriaDAO getDAO() {
		if (dao == null) {
			dao = new CategoriaDAOImpl();
		}
		return dao;
	}
}
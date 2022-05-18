package it.unirc.pwm.ordine_piatto;

public class OrdinePiattoDAOFactory {
	
	private static OrdinePiattoDAO dao = null;
	
	private OrdinePiattoDAOFactory () {}
	
	public static synchronized OrdinePiattoDAO getDAO() {
		if(dao == null) {
			dao = new OrdinePiattoDAOImpl();
		}
		return dao;
	}
}
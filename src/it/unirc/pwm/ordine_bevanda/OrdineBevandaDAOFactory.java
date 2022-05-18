package it.unirc.pwm.ordine_bevanda;

public class OrdineBevandaDAOFactory {
	
	private static OrdineBevandaDAO dao = null;
	
	private OrdineBevandaDAOFactory() {}
	
	public static synchronized OrdineBevandaDAO getDAO() {
		if(dao == null) {
			dao = new OrdineBevandaDAOImpl();
		}
		return dao;
	}
}
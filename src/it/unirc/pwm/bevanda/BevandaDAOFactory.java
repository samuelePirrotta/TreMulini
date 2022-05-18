package it.unirc.pwm.bevanda;

public class BevandaDAOFactory {

	private static BevandaDAO dao = null;
	
	private BevandaDAOFactory(){}
	
	public static synchronized BevandaDAO getDAO() {
		if (dao == null) {
			dao = new BevandaDAOImpl();
		}
		return dao;
	}
}
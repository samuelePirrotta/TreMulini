package it.unirc.pwm.piatto;

public class PiattoDAOFactory {

	private static PiattoDAO dao = null;
	
	private PiattoDAOFactory(){}
	
	public static synchronized PiattoDAO getDAO() {
		if (dao == null) {
			dao = new PiattoDAOImpl();
		}
		return dao;
	}
}
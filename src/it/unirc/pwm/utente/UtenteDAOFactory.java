package it.unirc.pwm.utente;

public class UtenteDAOFactory {

	private static UtenteDAO dao = null;
	
	private UtenteDAOFactory(){}

	public static synchronized UtenteDAO getDao() {
		if (dao == null) {
			dao = new UtenteDAOImpl();
		}
		return dao;
	}
}
package it.unirc.pwm.ordine_bevanda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unirc.pwm.util.HibernateUtil;

public class OrdineBevandaDAOImpl implements OrdineBevandaDAO {

	private static Logger logger = LogManager.getLogger("LOGGER ORDINE");
	public OrdineBevandaDAOImpl() {}
	
	public boolean saveOrdineBevanda(OrdineBevanda ordineBevanda) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = false;
		try {
			transaction = session.beginTransaction();
			session.save(ordineBevanda);
			transaction.commit();
			esito = true;
		}catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return esito;
	}
}
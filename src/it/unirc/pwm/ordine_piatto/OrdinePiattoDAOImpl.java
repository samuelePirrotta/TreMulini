package it.unirc.pwm.ordine_piatto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unirc.pwm.util.HibernateUtil;

public class OrdinePiattoDAOImpl implements OrdinePiattoDAO {
	
	private static Logger logger = LogManager.getLogger("LOGGER ORDINE_PIATTO");
	public OrdinePiattoDAOImpl() {}

	public boolean saveOrdinePiatto(OrdinePiatto ordinePiatto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = false;
		try {
			transaction = session.beginTransaction();
			session.save(ordinePiatto);
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
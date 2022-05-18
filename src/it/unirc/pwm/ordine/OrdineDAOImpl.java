package it.unirc.pwm.ordine;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unirc.pwm.util.HibernateUtil;

public class OrdineDAOImpl implements OrdineDAO{
	
	private static Logger logger = LogManager.getLogger("LOGGER ORDINE");
	protected OrdineDAOImpl() {}

	public Ordine getOrdine(Ordine o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Ordine res = null;
		try {
			transaction = session.beginTransaction();
			res = (Ordine) session.createQuery("from Ordine where id_ordine=?1").setParameter(1, o.getIdOrdine()).setMaxResults(1).uniqueResult();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public List<Ordine> getOrdini() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Ordine> res = null;
		try {
			transaction = session.beginTransaction();
			res = (List<Ordine>) session.createQuery("from Ordine").list();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return res;
	}

	public int saveOrdine(Ordine o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int id = 0;
		try {
			transaction = session.beginTransaction();
			session.save(o);
			transaction.commit();
			id = o.getIdOrdine();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return id;
	}

	public boolean updateOrdine(Ordine o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = false;
		try {
			transaction = session.beginTransaction();
			session.update(o);
			transaction.commit();
			esito = true;
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return esito;
	}

	public boolean deleteOrdine(Ordine o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = false;
		try {
			transaction = session.beginTransaction();
			session.delete(o);
			transaction.commit();
			esito = true;
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return esito;
	}	
}
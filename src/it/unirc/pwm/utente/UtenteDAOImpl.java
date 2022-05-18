package it.unirc.pwm.utente;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import it.unirc.pwm.util.HibernateUtil;

public class UtenteDAOImpl implements UtenteDAO {

	private static Logger logger = LogManager.getLogger("LOGGER UTENTE");
	protected UtenteDAOImpl(){}

	public Utente getUtente(Utente u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Utente res = null;
		try {
			transaction = session.beginTransaction();
			res = (Utente) session.createQuery("from Utente where id_utente=?1").setParameter(1, u.getIdUtente()).setMaxResults(1).uniqueResult();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public List<Utente> getUtenti() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Utente> res = null;
		try {
			transaction = session.beginTransaction();
			res = (List<Utente>) session.createQuery("from Utente").list();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return res;
	}
	
	public List<Utente> cercaUtente(Utente u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Utente> res = null;
		/* Creo l'HashMap nel modo più generico possibile, utilizzando String per la chiave che riporta il nome dell'attributo della tabella
		 * del DB e come valore un generico Object 
		 */
		HashMap<String, Object> hm = new HashMap<String, Object>();
		// Setto tutti i possibili campi dell'HashMap
		hm.put("nome", u.getNome());
		hm.put("mansione", u.getMansione());
		hm.put("id_utente", u.getIdUtente());
		int cont=0;
		String whereCondition = "";
		for(Entry<String, Object> e : hm.entrySet()) {
			if(e.getValue()!=null) {
				if(e.getKey().equals("nome") || e.getKey().equals("mansione")) {
					cont++;
					if(cont==1) {
						whereCondition += " WHERE "+e.getKey()+" LIKE ?"+String.valueOf(cont); 
					}else {
						whereCondition += " AND "+e.getKey()+" LIKE ?"+String.valueOf(cont); 
					}
				}else {
					cont++;
					if(cont==1) {
						whereCondition += " WHERE "+e.getKey()+"=?"+String.valueOf(cont);
					}else {
						whereCondition += " AND "+e.getKey()+"=?"+String.valueOf(cont);
					}						
				}
			} 			
		}
		try {
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			Query<Utente> query = session.createQuery("from Utente"+whereCondition);
			cont = 0;
			for(Entry<String, Object> e : hm.entrySet()) {
				if(e.getValue()!=null) {
					if(e.getKey().equals("nome") || e.getKey().equals("mansione")) {
						cont++;
						query.setParameter(cont, "%"+e.getValue()+"%"); 
					}
					else {
						cont++;
						query.setParameter(cont, e.getValue());
					}
				} 
			}
			res = (List<Utente>) query.list();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
			return null;
		} finally {
			session.close();
		}
		return res;
	}

	public boolean saveUtente(Utente u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = false;
		try {
			transaction = session.beginTransaction();
			session.save(u);
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

	public boolean updateUtente(Utente u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = true;
		try {
			transaction = session.beginTransaction();
			session.update(u);
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

	public boolean deleteUtente(Utente u) {
		Session session =  HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = true;
		try {
			transaction = session.beginTransaction();
			session.delete(u);
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
	
	public Utente login(Utente u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Utente res = null;
		try {
			transaction = session.beginTransaction();
			res = (Utente) session.createQuery("from Utente where nome=?1").setParameter(1, u.getNome()).setMaxResults(1).uniqueResult();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return res;
	}	
}
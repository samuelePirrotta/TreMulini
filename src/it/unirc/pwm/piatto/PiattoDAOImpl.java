package it.unirc.pwm.piatto;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import it.unirc.pwm.categoria.Categoria;
import it.unirc.pwm.util.HibernateUtil;

public class PiattoDAOImpl implements PiattoDAO {
	
	private static Logger logger = LogManager.getLogger("LOGGER PIATTO");
	protected PiattoDAOImpl(){}

	public Piatto getPiatto(Piatto p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Piatto res = null;
		try {
			transaction = session.beginTransaction();
			res = (Piatto) session.createQuery("from Piatto where id_piatto=?1").setParameter(1, p.getIdPiatto()).setMaxResults(1).uniqueResult();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public List<Piatto> getPiatti() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Piatto> res = null;
		try {
			transaction = session.beginTransaction();
			res = (List<Piatto>) session.createQuery("from Piatto").list();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Piatto> cercaPiatto(Piatto p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Piatto> res = null;
		/* Creo l'HashMap nel modo più generico possibile, utilizzando String per la chiave che riporta il nome dell'attributo della tabella
		 * del DB e come valore un generico Object 
		 */
		HashMap<String, Object> hm = new HashMap<String, Object>();
		// Setto tutti i possibili campi dell'HashMap
		hm.put("nome", p.getNome());
		hm.put("descrizione", p.getDescrizione());
		hm.put("id_piatto", p.getIdPiatto());
		int cont=0;
		String whereCondition = "";
		for(Entry<String, Object> e : hm.entrySet()) {
			if(e.getValue()!=null) {
				if(e.getKey().equals("nome") || e.getKey().equals("descrizione")) {
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
			Query<Piatto> query = session.createQuery("from Piatto"+whereCondition);
			cont = 0;
			for(Entry<String, Object> e : hm.entrySet()) {
				if(e.getValue()!=null) {
					if(e.getKey().equals("nome") || e.getKey().equals("descrizione")) {
						cont++;
						query.setParameter(cont, "%"+e.getValue()+"%"); 
					}
					else {
						cont++;
						query.setParameter(cont, e.getValue());
					}
				} 
			}
			res = (List<Piatto>) query.list();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
			return null;
		} finally {
			session.close();
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Piatto> perCategoria (Categoria categoria) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Piatto> res = null;
		try {
			transaction = session.beginTransaction();
			res = (List<Piatto>) session.createQuery("from Piatto where categoria=?1").setParameter(1, categoria).list();
		}catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
			return null;
		}finally {
			session.close();
		}
		return res;
	}
	
	public Piatto perNome(String nome) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Piatto res = null;
		try {
			transaction = session.beginTransaction();
			res = (Piatto) session.createQuery("from Piatto where nome=?1").setParameter(1, nome).setMaxResults(1).uniqueResult();
		}catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR", e);
		}finally {
			session.close();
		}
		return res;
	}
	
	public int getMaxId() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int res = 0;
		try {
			transaction = session.beginTransaction();
			res = (int) session.createSQLQuery("select max(id_piatto) from Piatto").setMaxResults(1).uniqueResult();
		}catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR", e);
		}finally {
			session.close();
		}
		return res;
	}

	public boolean savePiatto(Piatto p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = false;
		try {
			transaction = session.beginTransaction();
			session.save(p);
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

	public boolean updatePiatto(Piatto p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = false;
		try {
			transaction = session.beginTransaction();
			session.update(p);
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

	public boolean deletePiatto(Piatto p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = false;
		try {
			transaction = session.beginTransaction();
			session.delete(p);
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
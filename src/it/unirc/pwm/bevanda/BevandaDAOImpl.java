package it.unirc.pwm.bevanda;

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

public class BevandaDAOImpl implements BevandaDAO {
	
	private static Logger logger = LogManager.getLogger("LOGGER BEVANDA");
	
	protected BevandaDAOImpl(){}
	
	public Bevanda getBevanda(Bevanda b) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Bevanda res = null;
		try {
			transaction = session.beginTransaction();
			res = new Bevanda();
			res = (Bevanda) session.createQuery("from Bevanda WHERE id_bevanda=?1").setParameter(1, b.getIdBevanda()).setMaxResults(1).uniqueResult();
		} catch (HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
			return null;
		} finally {
			session.close();
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Bevanda> perCategoria(Categoria categoria) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Bevanda> res = null;
		try {
			transaction = session.beginTransaction();
			res = (List<Bevanda>) session.createQuery("from Bevanda WHERE categoria=?1").setParameter(1, categoria).list();
		} catch (HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
			return null;
		} finally {
			session.close();
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Bevanda> getBevande() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Bevanda> res = null;
		try {
			transaction = session.beginTransaction();
			res = (List<Bevanda>) session.createQuery("from Bevanda").list();
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
	public List<Bevanda> cercaBevanda(Bevanda b) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Bevanda> res = null;
		/* Creo l'HashMap nel modo più generico possibile, utilizzando String per la chiave che riporta il nome dell'attributo della tabella
		 * del DB e come valore un generico Object 
		 */
		HashMap<String, Object> hm = new HashMap<String, Object>();
		// Setto tutti i possibili campi dell'HashMap
		hm.put("tipo", b.getTipo());
		hm.put("nome", b.getNome());
		hm.put("cantina", b.getCantina());
		hm.put("id_bevanda", b.getIdBevanda());
		int cont=0;
		String whereCondition = "";
		for(Entry<String, Object> e : hm.entrySet()) {
			if(e.getValue()!=null) {
				if(e.getKey().equals("tipo") || e.getKey().equals("nome") || e.getKey().equals("cantina")) {
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
			Query<Bevanda> query = session.createQuery("from Bevanda"+whereCondition);
			cont = 0;
			for(Entry<String, Object> e : hm.entrySet()) {
				if(e.getValue()!=null) {
					if(e.getKey().equals("tipo") || e.getKey().equals("nome") || e.getKey().equals("cantina")) {
						cont++;
						query.setParameter(cont, "%"+e.getValue()+"%"); 
					}
					else {
						cont++;
						query.setParameter(cont, e.getValue());
					}
				} 
			}
			res = (List<Bevanda>) query.list();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
			return null;
		} finally {
			session.close();
		}
		return res;
	}
	
	public boolean saveBevanda(Bevanda b) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = false;
		try {
			transaction = session.beginTransaction();
			session.save(b);
			transaction.commit();
			esito = true;
		} catch (HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return esito;
	}
	
	public boolean updateBevanda(Bevanda b) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = false;
		try {
			transaction = session.beginTransaction();
			session.update(b);
			transaction.commit();
			esito = true;
		} catch (HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return esito;
	}
	
	public boolean deleteBevanda(Bevanda b) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = false;
		try {
			transaction = session.beginTransaction();
			session.delete(b);
			transaction.commit();
			esito = true;
		} catch (HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return esito;		
	}
}
package it.unirc.pwm.categoria;

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

public class CategoriaDAOImpl implements CategoriaDAO{

	private static Logger logger = LogManager.getLogger("LOGGER CATEGORIA");
	protected CategoriaDAOImpl(){}
	
	public Categoria getCategoria(Categoria c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Categoria res = null;
		try {
			transaction = session.beginTransaction();
			res = new Categoria();
			res = (Categoria) session.createQuery("from Categoria where id_categoria=?1").setParameter(1, c.getIdCategoria()).setMaxResults(1).uniqueResult();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> getCategorie() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Categoria> res = null;
		try {
			transaction = session.beginTransaction();
			res = (List<Categoria>) session.createQuery("from Categoria").list();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> getCategorieBevande() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Categoria> res = null;
		try {
			transaction = session.beginTransaction();
			res = (List<Categoria>) session.createQuery("from Categoria where tipo=?1").setParameter(1, false).list();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> getCategoriePiatti() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Categoria> res = null;
		try {
			transaction = session.beginTransaction();
			res = (List<Categoria>) session.createQuery("from Categoria where tipo=?1").setParameter(1, true).list();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return res;
	}
	
	public List<Categoria> cercaCategoria(Categoria c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Categoria> res = null;
		/* Creo l'HashMap nel modo più generico possibile, utilizzando String per la chiave che riporta il nome dell'attributo della tabella
		 * del DB e come valore un generico Object 
		 */
		HashMap<String, Object> hm = new HashMap<String, Object>();
		// Setto tutti i possibili campi dell'HashMap
		hm.put("nome", c.getNome());
		hm.put("tipo", c.isTipo());
		hm.put("id_categoria", c.getIdCategoria());
		int cont=0;
		String whereCondition = "";
		for(Entry<String, Object> e : hm.entrySet()) {
			if(e.getValue()!=null) {
				if(e.getKey().equals("nome")) {
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
			Query<Categoria> query = session.createQuery("from Categoria"+whereCondition);
			cont = 0;
			for(Entry<String, Object> e : hm.entrySet()) {
				if(e.getValue()!=null) {
					if(e.getKey().equals("nome")) {
						cont++;
						query.setParameter(cont, "%"+e.getValue()+"%"); 
					}
					else {
						cont++;
						query.setParameter(cont, e.getValue());
					}
				} 
			}
			res = (List<Categoria>) query.list();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
			return null;
		} finally {
			session.close();
		}
		return res;
	}
	
	public Categoria getForName(String nome) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Categoria res = new Categoria();
		try {
			transaction = session.beginTransaction();
			res = (Categoria) session.createQuery("from Categoria where nome=?1").setParameter(1, nome).setMaxResults(1).uniqueResult();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return res;
	}

	public boolean saveCategroia(Categoria c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = false;
		try {
			transaction = session.beginTransaction();
			session.save(c);
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

	public boolean updateCategoria(Categoria c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = false;
		try {
			transaction = session.beginTransaction();
			session.update(c);
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

	public boolean deleteCategoria(Categoria c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = false;
		try {
			transaction = session.beginTransaction();
			session.delete(c);
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
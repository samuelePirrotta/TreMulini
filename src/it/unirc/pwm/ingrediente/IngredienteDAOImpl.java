package it.unirc.pwm.ingrediente;

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

public class IngredienteDAOImpl implements IngredienteDAO {
	
	private static Logger logger = LogManager.getLogger("LOGGER INGREDIENTE");
	protected IngredienteDAOImpl(){}
	
	public Ingrediente getIngrediente(Ingrediente i) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Ingrediente res = null;
		try {
			transaction = session.beginTransaction();
			res = (Ingrediente) session.createQuery("from Ingrediente where id_ingrediente=?1").setParameter(1, i.getIdIngrediente()).setMaxResults(1).uniqueResult();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public List<Ingrediente> getIngredienti() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Ingrediente> res = null;
		try {
			transaction = session.beginTransaction();
			res = (List<Ingrediente>) session.createQuery("from Ingrediente").list();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
		} finally {
			session.close();
		}
		return res;
	}
	
	public List<Ingrediente> cercaIngrediente(Ingrediente i) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Ingrediente> res = null;
		/* Creo l'HashMap nel modo più generico possibile, utilizzando String per la chiave che riporta il nome dell'attributo della tabella
		 * del DB e come valore un generico Object 
		 */
		HashMap<String, Object> hm = new HashMap<String, Object>();
		// Setto tutti i possibili campi dell'HashMap
		hm.put("id_ingrediente", i.getIdIngrediente());
		hm.put("nome", i.getNome());
		hm.put("allergene", i.isAllergene());
		hm.put("tipo_allergene", i.getTipoAllergene());
		int cont=0;
		String whereCondition = "";
		for(Entry<String, Object> e : hm.entrySet()) {
			if(e.getValue()!=null) {
				if(e.getKey().equals("nome") || e.getKey().equals("tipo_allergene")) {
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
			Query<Ingrediente> query = session.createQuery("from Ingrediente"+whereCondition);
			cont = 0;
			for(Entry<String, Object> e : hm.entrySet()) {
				if(e.getValue()!=null) {
					if(e.getKey().equals("nome") || e.getKey().equals("tipo_allergene")) {
						cont++;
						query.setParameter(cont, "%"+e.getValue()+"%"); 
					}
					else {
						cont++;
						query.setParameter(cont, e.getValue());
					}
				} 
			}
			res = (List<Ingrediente>) query.list();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.fatal("FATAL ERROR:", e);
			return null;
		} finally {
			session.close();
		}
		return res;
	}

	public boolean saveIngrediente(Ingrediente i) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = false;
		try {
			transaction = session.beginTransaction();
			session.save(i);
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

	public boolean updateIngrediente(Ingrediente i) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = false;
		try {
			transaction = session.beginTransaction();
			session.update(i);
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

	public boolean deleteIngrediente(Ingrediente i) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean esito = false;
		try {
			transaction = session.beginTransaction();
			session.delete(i);
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
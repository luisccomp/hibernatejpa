package br.com.mycompany.hibernatejpa.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.mycompany.hibernatejpa.connection.ConnectionFactory;
import br.com.mycompany.hibernatejpa.model.bean.AbstractBean;

/**
 * This is a concrete implementation of DAO interface.
 * @author Luis
 *
 * @param <K> Primary key type of mapped entities.
 * @param <T> Type of mapped entities.
 */
public class ConcreteDAO<K, T extends AbstractBean> implements DAO<K, T> {

	/**
	 * Finds an entity on database given it's ID. If the entity exists, this method
	 * will return an instance of entity mapped class with each attribute filled with
	 * its corresponding table collumn.
	 */
	@Override
	public T find(Class<T> c, K k) {
		// TODO Auto-generated method stub
		EntityManager manager = new ConnectionFactory().getConnection();
		T t = null;
		
		try {
			t = manager.find(c, k);
		}
		catch (Exception e) {
			System.err.println(e);
		}
		finally {
			manager.close();
		}
		
		return t;
	}

	/**
	 * Return a list of all entities persisted on the database until present moment. 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> c) {
		// TODO Auto-generated method stub
		EntityManager manager = new ConnectionFactory().getConnection();
		List<T> ts = null;
		
		try {
			Query q = manager.createQuery("select o from " + c.getSimpleName() + " o");
			ts = q.getResultList();
		}
		catch (Exception e) {
			System.err.println(e);
		}
		finally {
			manager.close();
		}
		
		return ts;
	}

	/**
	 * Remove an entity from database given its primary key. If the entity exists,
	 * then it'll be deleted. Otherwise, nothing occurs. 
	 */
	@Override
	public T remove(Class<T> c, K k) {
		// TODO Auto-generated method stub
		EntityManager manager = new ConnectionFactory().getConnection();
		T t = null;
		
		try {
			t = manager.find(c, k);
			
			manager.getTransaction().begin();
			manager.remove(t);
			manager.getTransaction().commit();
		}
		catch (Exception e) {
			System.err.println(e);
			manager.getTransaction().rollback();
		}
		finally {
			manager.close();
		}
		
		return t;
	}

	/**
	 * Persist an entity inside database or update it's information. Note that in
	 * order to persist or update an existing entry.
	 */
	@Override
	public T save(T t) {
		// TODO Auto-generated method stub
		EntityManager manager = new ConnectionFactory().getConnection();
		
		try {
			manager.getTransaction().begin();
			
			if (t.getId() == null) {
				manager.persist(t);
			}
			else {
				manager.merge(t);
			}
			
			manager.getTransaction().commit();
		}
		catch (Exception e) {
			System.err.println(e);
			manager.getTransaction().rollback();
		}
		finally {
			manager.close();
		}
		
		return t;
	}
}

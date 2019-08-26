package br.com.mycompany.hibernatejpa.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.mycompany.hibernatejpa.connection.ConnectionFactory;
import br.com.mycompany.hibernatejpa.model.bean.AbstractBean;

public class ConcreteDAO<K, T extends AbstractBean> implements DAO<K, T> {

	/**
	 * 
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
	 * 
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
	 * 
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
	 * 
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

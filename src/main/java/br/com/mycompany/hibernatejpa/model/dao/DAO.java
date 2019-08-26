package br.com.mycompany.hibernatejpa.model.dao;

import java.util.List;

import br.com.mycompany.hibernatejpa.model.bean.AbstractBean;

/**
 * 
 * @author Luis
 *
 * @param <K>
 * @param <T>
 */
public interface DAO <K, T extends AbstractBean> {
	/**
	 * 
	 * @param c
	 * @param k
	 * @return
	 */
	public T find(Class<T> c, K k);
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public List<T> findAll(Class<T> c);
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public T remove(Class<T> c, K k);
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public T save(T t);
}

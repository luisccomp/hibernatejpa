package br.com.mycompany.hibernatejpa.model.dao;

import java.util.List;

import br.com.mycompany.hibernatejpa.model.bean.AbstractBean;

/**
 * This is an interface that defines a DAO. A DAO object must implement all four basic
 * operations of a database: find, findAll, remove and save. 
 * @author Luis
 *
 * @param <K> Primary key type of a given Entity.
 * @param <T> Type of Mapped instance object.
 */
public interface DAO <K, T extends AbstractBean> {
	/**
	 * Finds an entity on database given it's ID. If the entity exists, this method
	 * will return an instance of entity mapped class with each attribute filled with
	 * its corresponding table collumn.
	 * @param c Mapped entity class.
	 * @param k Entity primary key.
	 * @return an instance of a mapped Entity class or null if it doesn't exists or if
	 * an error occurs.
	 */
	public T find(Class<T> c, K k);
	
	/**
	 * Return a list of all entities persisted on the database until present moment.
	 * @param c Entity class.
	 * @return Return a list of instances of Mapped class c or null if an error
	 * occurs.
	 */
	public List<T> findAll(Class<T> c);
	
	/**
	 * Remove an entity from database given its primary key. If the entity exists,
	 * then it'll be deleted. Otherwise, nothing occurs.
	 * @param c mapped entity class.
	 * @param k entity primary key.
	 * @return the removed entity, if exists. null otherwise or if an error occurs.
	 */
	public T remove(Class<T> c, K k);
	
	/**
	 * Persist an entity inside database or update it's information. Note that in
	 * order to persist or update an existing entry.
	 * @param t an entity to be persisted on database.
	 * @return the same entity of argument with an aditional argument.
	 */
	public T save(T t);
}

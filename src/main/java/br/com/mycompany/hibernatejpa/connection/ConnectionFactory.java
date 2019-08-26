package br.com.mycompany.hibernatejpa.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernatejpa");
	
	public EntityManager getConnection() {
		return factory.createEntityManager();
	}
}

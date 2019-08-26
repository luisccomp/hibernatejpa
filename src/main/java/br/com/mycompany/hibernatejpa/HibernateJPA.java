package br.com.mycompany.hibernatejpa;

import br.com.mycompany.hibernatejpa.model.bean.Category;
import br.com.mycompany.hibernatejpa.model.dao.ConcreteDAO;
import br.com.mycompany.hibernatejpa.model.dao.DAO;

/**
 * 
 * @author Luis
 */
public class HibernateJPA {

	public static void main(String[] args) {
		DAO<Long, Category> dao = new ConcreteDAO<>();
		Category category = dao.remove(Category.class, 3L);
		
		System.out.println("ID: " + category.getId());
		System.out.println("Description: " + category.getDescription());
	}
}

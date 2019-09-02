package br.com.mycompany.hibernatejpa;

import br.com.mycompany.hibernatejpa.model.bean.Category;
import br.com.mycompany.hibernatejpa.model.bean.Product;
import br.com.mycompany.hibernatejpa.model.dao.ConcreteDAO;
import br.com.mycompany.hibernatejpa.model.dao.DAO;

/**
 * 
 * @author Luis
 */
public class HibernateJPA {

	public static void main(String[] args) {
		// Instanciando os DAO's
		DAO<Long, Product> productDAO = new ConcreteDAO<Long, Product>();
		DAO<Long, Category> categoryDAO = new ConcreteDAO<Long, Category>();
		
		Product product = new Product();
		product.setId(1L);
		product.setName("Play Station 4");
		product.setDescription("The powerful new generation console PS4.");
		product.setQuantity(10);
		product.setValue(1700.00);
		
		Category category = categoryDAO.find(Category.class, 1L);
		
		product.setCategory(category);
		
		// Persistindo o objeto no banco de dados
		productDAO.save(product);
	}
}

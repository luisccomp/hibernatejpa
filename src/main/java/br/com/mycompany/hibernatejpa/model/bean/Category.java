package br.com.mycompany.hibernatejpa.model.bean;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "sq_generator", sequenceName = "category_id_seq", allocationSize = 1)
public class Category extends AbstractBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5421438436799237245L;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

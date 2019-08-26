package br.com.mycompany.hibernatejpa.model.bean;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_generator", sequenceName = "product_id_seq", allocationSize = 1)
public class Product extends AbstractBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2712634783611541441L;
	private String name;
	private String description;
	private Integer quantity;
	private Double value;
	private Category category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}

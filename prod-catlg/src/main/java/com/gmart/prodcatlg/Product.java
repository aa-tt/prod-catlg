package com.gmart.prodcatlg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@Column String name;
	@Column String type;
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
	public Product() {}
	public Product(String name, String type) {
		this.name = name; this.type = type;
	}

}

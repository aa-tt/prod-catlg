package com.gmart.prodcatlg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@Column
	@JsonProperty("name")
	String name;
	
	@Column
	@JsonProperty("type")
	String type;
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
	public Product() {}
	public Product(Integer id, String name, String type) {
		this.id = id; this.name = name; this.type = type;
	}

}

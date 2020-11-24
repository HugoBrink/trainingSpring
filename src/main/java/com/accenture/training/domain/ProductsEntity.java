package com.accenture.training.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "\"TRAINING_PRODUCTS_TBIPRODUCTS\"")
public class ProductsEntity {
	
	@Id
	@Column(name = "\"ID\"")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	/*
	@Column(name = "\"CREATEDAT\"")
	@CreationTimestamp 
	private String createdat;
	*/
	
	@Column(name = "\"NAME\"")
	private String name;
	
	@Column(name = "\"MANUFACTURER\"")
	private String manufacturer;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/*
	public String getCreatedat() {
		return createdat;
	}
	public void setCreatedat(String createdat) {
		this.createdat = createdat;
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

}

package com.accenture.training.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.mapping.List;

@Entity
@Table(name = "\"TRAINING_PRODUCTS_TBIPRODUCTS\"")
public class ProductsEntity {
	
	@Id
	@Column(name = "\"ID\"")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	

	@Column(name = "\"VALIDFROM\"")
	private LocalDateTime validFrom;
	 
	@Column(name = "\"VALIDTO\"")
	private LocalDateTime validTo;
	
	@Column(name = "\"NAME\"")
	private String name;
	
	@Column(name = "\"MANUFACTURER\"")
	private String manufacturer;
	
	/*
	@OneToMany(mappedBy = "products", cascade = { CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH} )
	private List<SalesOrderEntity> sales;*/
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	} 
	
	public LocalDateTime getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(LocalDateTime validFrom) {
		this.validFrom = validFrom;
	}
	public LocalDateTime getValidTo() {
		return validTo;
	}
	public void setValidTo(LocalDateTime validTo) {
		this.validTo = validTo;
	}
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

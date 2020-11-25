package com.accenture.training.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "\"TRAINING_SALESORDER_TBISALESORDERITEM\"")
public class SalesOrderItemEntity {
	
	@Id
	@Column(name = "\"ID\"")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	

	@Column(name = "\"CREATEDAT\"")
	private LocalDateTime createdat;
	
	@Column(name = "\"MODIFIEDAT\"")
	private LocalDateTime modifiedat;
	
	@Column(name = "\"STATUS\"")
	private String status;
	
	@Column(name = "\"QUANTITY\"")
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "\"SALESORDER_ID\"")
	private SalesOrderEntity salesOrder;
	
	@ManyToOne
	@JoinColumn(name = "\"PRODUCT_ID\"")
	private ProductsEntity product;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getCreatedat() {
		return createdat;
	}

	public void setCreatedat(LocalDateTime createdat) {
		this.createdat = createdat;
	}

	public LocalDateTime getModifiedat() {
		return modifiedat;
	}

	public void setModifiedat(LocalDateTime modifiedat) {
		this.modifiedat = modifiedat;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public SalesOrderEntity getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(SalesOrderEntity salesOrder) {
		this.salesOrder = salesOrder;
	}

	public ProductsEntity getProduct() {
		return product;
	}

	public void setProduct(ProductsEntity product) {
		this.product = product;
	}

	

	
	

}

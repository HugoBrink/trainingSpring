package com.accenture.training.dto;

public class SalesOrderItemTO {
	
	private String id;
	private String createdat;
	private String modifiedat;
	private String status;
	private Integer quantity;
	private String salesorder;
	private ProductsTO product;
	
	public String getCreatedat() {
		return createdat;
	}
	public String getId() {
		return id;
	}
	public String getModifiedat() {
		return modifiedat;
	}
	public ProductsTO getProduct() {
		return product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public String getSalesorder() {
		return salesorder;
	}
	public String getStatus() {
		return status;
	}
	public void setCreatedat(String createdat) {
		this.createdat = createdat;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setModifiedat(String modifiedat) {
		this.modifiedat = modifiedat;
	}
	
	public void setProduct(ProductsTO product) {
		this.product = product;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public void setSalesorder(String salesorder) {
		this.salesorder = salesorder;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}

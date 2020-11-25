package com.accenture.training.dto;

public class SalesOrderTO {
	
	private String id;
	private String createdat;
	private String modifiedat;
	private String status;
	private UsersTO user;
	private ClientsTO client;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreatedat() {
		return createdat;
	}
	public void setCreatedat(String createdat) {
		this.createdat = createdat;
	}
	public String getModifiedat() {
		return modifiedat;
	}
	public void setModifiedat(String modifiedat) {
		this.modifiedat = modifiedat;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UsersTO getUser() {
		return user;
	}
	public void setUser(UsersTO user) {
		this.user = user;
	}
	public ClientsTO getClient() {
		return client;
	}
	public void setClient(ClientsTO client) {
		this.client = client;
	}
	

}

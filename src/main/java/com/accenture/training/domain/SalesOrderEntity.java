package com.accenture.training.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.mapping.List;

@Entity
@Table(name = "\"TRAINING_SALESORDER_TBISALESORDER\"")
public class SalesOrderEntity {
	
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
	
	@ManyToOne
	@JoinColumn(name = "\"USER_ID\"")
	private UsersEntity user;
	
	@ManyToOne
	@JoinColumn(name =  "\"CLIENT_ID\"")
	private ClientsEntity client;
	
	/*@OneToMany(mappedBy = "salesOrder", cascade = { CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH} )
	private List<SalesOrderItemEntity> items;*/
	
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

	public UsersEntity getUser() {
		return user;
	}

	public void setUser(UsersEntity user) {
		this.user = user;
	}

	public ClientsEntity getClient() {
		return client;
	}

	public void setClient(ClientsEntity client) {
		this.client = client;
	}
	

}

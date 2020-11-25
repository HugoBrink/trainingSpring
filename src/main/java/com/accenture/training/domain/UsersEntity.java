package com.accenture.training.domain;

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
@Table(name = "\"TRAINING_USER_TBIUSER\"")
public class UsersEntity {
	@Id
	@Column(name = "\"ID\"")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	/*@OneToMany(mappedBy = "users", cascade = { CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH} )
	private List<SalesOrderEntity> items;*/
	
	@Column(name = "\"NAME\"")
	private String name;

	public String getId() {return id;}
	
	public void setId(String id) {this.id = id;}
	
	public String getName() {return name;}
	
	public void setName(String name) {this.name = name;}
	
}

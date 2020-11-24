package com.accenture.training.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "\"TRAINING_CLIENT_TBICLIENT\"")
public class ClientsEntity {
	@Id
	@Column(name = "\"ID\"")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@Column(name = "\"NAME\"")
	private String name;

	@Column(name = "\"AGE\"")
	private Integer age;
	
	@Column(name = "\"FAMILYNAME\"")
	private String familyname;
	
	public String getId() {return id;}
	
	public void setId(String id) {this.id = id;}
	
	public String getName() {return name;}
	
	public void setName(String name) {this.name = name;}
	
	public Integer getAge() {return age;}
	
	public void setAge(Integer age) {this.age = age;}

	public String getFamilyname() {return familyname;}

	public void setFamilyname(String familyname) {this.familyname = familyname;}
}

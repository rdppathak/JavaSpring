package com.Example1.Company.Role;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="roles")
@Proxy(lazy=false)
@Transactional
public class Role {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long roleId;
	@Column(unique=true)
	private String title;
	@Column
	private String description;
	
	public Role(){}
	
	public Role(String title, String description){
		this.title = title;
		this.description = description;
	}
	public long getId() {
		return roleId;
	}
	public void setId(long id) {
		this.roleId = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

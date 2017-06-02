package com.projet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name = "role")
public class Role {
	
	@Id
	@GeneratedValue 
	@Column(name="role_id")
	private int role_id;

	@Column(name="role_name", nullable = false)
	private String role_name;

	
	/* Getters */
	public int getRole_id() { return role_id; }
	public String getRole_name() { return role_name; }

	
	/* Setters */
	public void setRole_id(int role_id) { this.role_id = role_id; }
	public void setRole_name(String role_name) { this.role_name = role_name; }

	
	/* Constructors */
	public Role() { }
	public Role(String role_name) { this.role_name = role_name; }
}

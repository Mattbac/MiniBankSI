package com.projet.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.projet.entity.Manager;

@Entity
@Table(name="counselor")
public class Counselor extends User {

	@ManyToOne
	@JoinColumn(name="manager", nullable=false)
	private Manager manager;
	
	
	/* Getter */
	public Manager getManager() { return manager; }

	
	/* Setter */
	public void setManager(Manager manager) { this.manager = manager; }
	
	
	/* Constructor */
	public Counselor() { }
	public Counselor(String login, String password, Role role_user, Manager manager) {
		super(login, password, role_user);
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Counselor [manager=" + manager + "]";
	}
		
}

package com.projet.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.projet.entity.Manager;

@Entity
@Table(name="counselor")
public class Counselor extends AbstractPerson {

	@OneToOne
	@JoinColumn(name="user", nullable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="manager", nullable=false)
	private Manager manager;

	/* Getter */
	public Manager getManager() { return manager; }
	public User getUser() { return user; }

	/* Setter */
	public void setManager(Manager manager) { this.manager = manager; }
	public void setUser(User user) { this.user = user; }
		
}

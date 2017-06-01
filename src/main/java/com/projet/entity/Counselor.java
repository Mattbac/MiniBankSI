package com.projet.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.projet.entity.Manager;

@Entity
@Table(name="counselor")
public class Counselor extends AbstractPerson {

	@ManyToOne
	@JoinColumn(name="manager", nullable=false)
	private Manager manager;

	/* Getter */
	public Manager getManager() { return manager; }

	/* Setter */
	public void setManager(Manager manager) { this.manager = manager; }
	
	
}

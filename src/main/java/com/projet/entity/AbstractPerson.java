package com.projet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="abstract_person")
public abstract class AbstractPerson {

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, unique=true)
	private long id;
	// First name = prenom
	@Column(name="firstName", nullable=false)
	private String firstName;
	// Last name = nom
	@Column(name="lastName", nullable=false)
	private String lastName;
	
	/* Getters */
	public long getId() { return id; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	
	/* Getters */
	public void setId(long id) { this.id = id; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	
}

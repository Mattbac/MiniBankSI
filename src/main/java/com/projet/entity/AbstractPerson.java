package com.projet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="abstract_person")
public abstract class AbstractPerson {

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, unique=true)
	private long id;
	// First name = prenom
	@Pattern(regexp="[a-zA-Z]{3,}[0-9]{0,}", message="invalid firstName")
	@Column(name="firstName", nullable=false)
	private String firstName;
	// Last name = nom
	@Pattern(regexp="[a-zA-Z]{3,}[0-9]{0,}", message="invalid lastName")
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

	/* Constructor */
	public AbstractPerson() { }
	public AbstractPerson(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "AbstractPerson [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}

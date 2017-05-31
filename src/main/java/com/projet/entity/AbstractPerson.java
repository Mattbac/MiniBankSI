package com.projet.entity;

public abstract class AbstractPerson {

	private long id;
	// First name = prenom
	private String firstName;
	// Last name = nom
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

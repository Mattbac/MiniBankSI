package com.projet.entity;


public class User {

	private String login;
	private String password;
	private AbstractPerson person;
	
	/* Getters */
	public String getLogin() { return login; }
	public String getPassword() { return password; }
	public AbstractPerson getPerson() { return person; }
	
	/* Setters */
	public void setLogin(String login) { this.login = login; }
	public void setPassword(String password) { this.password = password; }
	public void setPerson(AbstractPerson person) { this.person = person; }

}

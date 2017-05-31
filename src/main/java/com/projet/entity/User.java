package com.projet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="user", uniqueConstraints={@UniqueConstraint(columnNames= "user_login")})
public class User {
	
	@Id
	@Column(name="user_login", unique = true, nullable=false, length=11)
	private String login;
	
	@Column(name="user_password", nullable=false, length=11)
	private String password;
	
//	@JoinColumn(name = "person_id", nullable = false)
//	private AbstractPerson person;
	
	/* Getters */
	public String getLogin() { return login; }
	public String getPassword() { return password; }
//	public AbstractPerson getPerson() { return person; }
	
	/* Setters */
	public void setLogin(String login) { this.login = login; }
	public void setPassword(String password) { this.password = password; }
//	public void setPerson(AbstractPerson person) { this.person = person; }

}

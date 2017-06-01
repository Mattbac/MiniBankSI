package com.projet.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.projet.entity.Role;

@Entity
@Table(name="user")
public class User {
	
	public Role getRole_user() {
		return role_user;
	}
	public void setRole_user(Role role_user) {
		this.role_user = role_user;
	}
	@Id
	@Column(name="user_login", unique = true, nullable=false, length=11)
	private String login;
	
	@Column(name="user_password", nullable=false, length=11)
	private String password;
	
//	@JoinColumn(name = "person_id", nullable = false)
//	private AbstractPerson person;

	@ManyToOne
	@JoinColumn(name="role_user")
//	@JoinTable(name = "role", 
//	joinColumns = { @JoinColumn(name = "user_login") }, 
//	inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Role role_user;
	
	@Column(name="user_enabled", nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private boolean enabled;

	
	/* Getters */
	public String getLogin() { return login; }
	public String getPassword() { return password; }
//	public AbstractPerson getPerson() { return person; }
//	public Set<Role> getRole_user() { return role_user; }
	public boolean isEnabled() { return enabled; }
	
	
	/* Setters */
	public void setLogin(String login) { this.login = login; }
	public void setPassword(String password) { this.password = password; }
//	public void setPerson(AbstractPerson person) { this.person = person; }
//	public void setRole_user(Set<Role> role_user) { this.role_user = role_user; }
	public void setEnabled(boolean enabled) { this.enabled = enabled; }

}

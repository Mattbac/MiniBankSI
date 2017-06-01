package com.projet.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.projet.entity.Role;

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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_USER_ROLES", 
	joinColumns = { @JoinColumn(name = "USER_ID") }, 
	inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	private Set<Role> role_user = new HashSet<Role>(0);
	
	@Column(name="ENABLED", nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private boolean enabled;

	
	/* Getters */
	public String getLogin() { return login; }
	public String getPassword() { return password; }
//	public AbstractPerson getPerson() { return person; }
	public Set<Role> getRole_user() { return role_user; }
	public boolean isEnabled() { return enabled; }
	
	
	/* Setters */
	public void setLogin(String login) { this.login = login; }
	public void setPassword(String password) { this.password = password; }
//	public void setPerson(AbstractPerson person) { this.person = person; }
	public void setRole_user(Set<Role> role_user) { this.role_user = role_user; }
	public void setEnabled(boolean enabled) { this.enabled = enabled; }

}

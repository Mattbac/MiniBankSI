package com.projet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.projet.entity.Role;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="user")
public class User extends AbstractPerson {
	
	@Column(name="user_login", unique = true, nullable=false, length=11)
	private String login;
	
	@Column(name="user_password", nullable=false, length=11)
	private String password;
	
	@ManyToOne
	@JoinColumn(name="role_user")
	private Role role_user;
	
	@Column(name="user_enabled", nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private boolean enabled;

	
	/* Getters */
	public String getLogin() { return login; }
	public String getPassword() { return password; }
	public boolean isEnabled() { return enabled; }
	public Role getRole_user() { return role_user; }
		
	/* Setters */
	public void setLogin(String login) { this.login = login; }
	public void setPassword(String password) { this.password = password; }
	public void setEnabled(boolean enabled) { this.enabled = enabled; }
	public void setRole_user(Role role_user) { this.role_user = role_user; }
}

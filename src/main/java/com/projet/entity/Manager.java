package com.projet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="manager")
public class Manager extends AbstractPerson {
	
	@OneToOne
	@JoinColumn(name="user", nullable=false)
	private User user;
	
	@Column(name="agency_name", nullable=false)
	private String agencyName;

	/* Getter */
	public String getAgencyName() { return agencyName; }
	public User getUser() { return user; }

	/* Setter */
	public void setAgencyName(String agencyName) { this.agencyName = agencyName; }
	public void setUser(User user) { this.user = user; }
	
}

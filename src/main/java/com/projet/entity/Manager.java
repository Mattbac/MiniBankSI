package com.projet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="manager")
public class Manager extends User {
		
	@Column(name="agency_name", nullable=false)
	private String agencyName;

	
	/* Getter */
	public String getAgencyName() { return agencyName; }

	
	/* Setter */
	public void setAgencyName(String agencyName) { this.agencyName = agencyName; }
	
	
	/* Constructor */
	public Manager() { }
	public Manager(String login, String password, Role role_user, String agencyName) {
		super(login, password, role_user);
		this.agencyName = agencyName;		
	}

	@Override
	public String toString() {
		return "Manager [agencyName=" + agencyName + "]";
	}
	
}

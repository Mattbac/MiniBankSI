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
	
}

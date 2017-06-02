package com.projet.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="current_account")
public class CurrentAccount extends AbstractAccount {

	@Column(name="overdrawn", nullable=false)
	private BigDecimal overdrawn = new BigDecimal(1000.00);
	
	/* Getters */
	public BigDecimal getOverdrawn() { return overdrawn; }

	
	/* Setters */
	public void setOverdrawn(BigDecimal overdrawn) { this.overdrawn = overdrawn; }

	
	/* Constructor */
	public CurrentAccount() { 
		this.overdrawn = new BigDecimal(0);
	}
	public CurrentAccount(BigDecimal sold) {
		super(sold);
		this.overdrawn = new BigDecimal(0);
	}
	public CurrentAccount(BigDecimal sold, BigDecimal overdrawn) {
		super(sold);
		this.overdrawn = overdrawn;
	}
}

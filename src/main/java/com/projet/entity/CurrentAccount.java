package com.projet.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="current_account")
public class CurrentAccount extends AbstractAccount {

	@Column(name="overdrawn", nullable=false)
	private BigDecimal overdrawn;

	// Le decouvert autorise pour le compte, qui vaut 1000 par defaut
	@Column(name="overdraft")
	private BigDecimal overdraft = new BigDecimal(1000.00);

	
	/* Getters */
	public BigDecimal getOverdrawn() { return overdrawn; }
	public BigDecimal getOverdraft() { return overdraft; }

	
	/* Setters */
	public void setOverdrawn(BigDecimal overdrawn) { this.overdrawn = overdrawn; }
	public void setOverdraft(BigDecimal overdraft) { this.overdraft = overdraft; }
	
}

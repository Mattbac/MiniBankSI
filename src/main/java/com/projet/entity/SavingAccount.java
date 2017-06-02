package com.projet.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="saving_account")
public class SavingAccount extends AbstractAccount {

	@Column(name="remuneration_rate", nullable=false)
	private BigDecimal remunerationRate;

	
	/* Getter */
	public BigDecimal getRemunerationRate() { return remunerationRate; }

	
	/* Setter */
	public void setRemunerationRate(BigDecimal remunerationRate) { this.remunerationRate = remunerationRate; }
	
	
	/* Constructor */
	public SavingAccount() { 
		this.remunerationRate = new BigDecimal(0);
	}
	public SavingAccount(BigDecimal sold) {
		super(sold);
		this.remunerationRate = new BigDecimal(0);
	}
	public SavingAccount(BigDecimal sold, BigDecimal remunerationRate) {
		super(sold);
		this.remunerationRate = remunerationRate;
	}

	@Override
	public String toString() {
		return "SavingAccount [remunerationRate=" + remunerationRate + "]";
	}
	
}

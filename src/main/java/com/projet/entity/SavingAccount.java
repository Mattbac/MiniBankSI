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

	public BigDecimal getRemunerationRate() {
		return remunerationRate;
	}

	public void setRemunerationRate(BigDecimal remunerationRate) {
		this.remunerationRate = remunerationRate;
	}
}

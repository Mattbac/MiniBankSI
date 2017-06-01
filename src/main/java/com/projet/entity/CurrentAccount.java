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

	public BigDecimal getOverdrawn() {
		return overdrawn;
	}

	public void setOverdrawn(BigDecimal overdrawn) {
		this.overdrawn = overdrawn;
	}
}

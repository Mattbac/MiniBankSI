package com.projet.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="abstract_account")
public abstract class AbstractAccount {
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, unique=true)
	private Long id;
	
	@Column(name="accountNumber", nullable=false, unique=true)
	private String accountNumber;
	
	@Column(name="sold", nullable=false)
	private BigDecimal sold;
	
	@Column(name="created", nullable=false)
	private Date created;
	
	
	/* Getters */
	public long getId() { return id; }
	public BigDecimal getSold() { return sold; }
	public Date getCreated() { return created; }
	public String getAccountNumber() { return accountNumber; }	
	
	
	/* Setters */
	public void setId(Long id) { this.id = id; }
	public void setSold(BigDecimal sold) { this.sold = sold; }
	public void setCreated(Date created) { this.created = created; }
	public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
	
	
	/* Constructor */
	public AbstractAccount() {
		this.sold = new BigDecimal(0);
		this.accountNumber = generateAccountNumber();
		this.created = new Date();
	}
	public AbstractAccount(BigDecimal sold) {
		this.sold = sold;
		this.accountNumber = generateAccountNumber();
		this.created = new Date();
	}
	
	@Override
	public String toString() {
		return "AbstractAccount [id=" + id + ", sold=" + sold + ", accountNumber=" + accountNumber + ", created=" + created + "]";
	}
	
	private String generateAccountNumber() {
		return Long.toString((long) Math.floor((Math.random() * 1000000000) + 10000000)).substring(0,7);
	}
}

package com.projet.entity;

import com.projet.entity.SavingAccount;
import com.projet.entity.CurrentAccount;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.projet.entity.Counselor;

@Entity
@Table(name="client")
public class Client extends AbstractPerson {
	
	@NotNull
	@Column(name="adress", nullable=false)
	private String adress;
	@NotNull
	@Column(name="zipCode", nullable=false)
	private String zipCode;
	@NotNull
	@Column(name="city", nullable=false)
	private String city;
	@NotNull
	@Column(name="phoneNumber", nullable=false)
	private String phoneNumber;
	@OneToOne
	@JoinColumn(name="savingAccount")
	private SavingAccount savingAccount;
	@OneToOne
	@JoinColumn(name="currentAccount")
	private CurrentAccount currentAccount;
	@NotNull
	@ManyToOne
	@JoinColumn(name="counselor", nullable=false)
	private Counselor counselor;
	
	
	/* Getters */
	public String getAdress() { return adress; }
	public String getZipCode() { return zipCode; }
	public String getCity() { return city; }
	public String getPhoneNumber() { return phoneNumber; }
	public SavingAccount getSavingAccount() { return savingAccount; }
	public CurrentAccount getCurrentAccount() { return currentAccount; }
	public Counselor getCounselor() { return counselor; }
	
	
	/* Setters */
	public void setAdress(String adress) { this.adress = adress; }
	public void setZipCode(String zipCode) { this.zipCode = zipCode; }
	public void setCity(String city) { this.city = city; }
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
	public void setSavingAccount(SavingAccount savingAccount) { this.savingAccount = savingAccount; }
	public void setCurrentAccount(CurrentAccount currentAccount) { this.currentAccount = currentAccount; }
	public void setCounselor(Counselor counselor) { this.counselor = counselor; }

}


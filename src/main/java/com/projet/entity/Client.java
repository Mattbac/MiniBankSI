package com.projet.entity;

import com.projet.entity.SavingAccount;
import com.projet.entity.CurrentAccount;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.projet.entity.Counselor;

@Entity
@Table(name="client")
public class Client extends AbstractPerson {
	
	@Pattern(regexp="[0-9]{1,} [ a-zA-Z]{3,}", message="invalid adress")
	@Column(name="adress", nullable=false)
	private String adress;
	@Pattern(regexp="[0-9]{2} ?[0-9]{3}", message="invalid zipCode")
	@Column(name="zipCode", nullable=false)
	private String zipCode;
	@Pattern(regexp="[a-zA-z]{3,}-?[a-zA-z]{0,}-?[a-zA-z]{0,}", message="invalid city")
	@Column(name="city", nullable=false)
	private String city;
	@Pattern(regexp="(\\+33|\\+33\\(0\\)|\\+33 \\(0\\)|0)[ .]?[0-9]{1}([ .]?[0-9]{2}){4}", message="invalid phoneNumber")
	@Column(name="phoneNumber", nullable=false)
	private String phoneNumber;
	@OneToOne
	@JoinColumn(name="savingAccount")
	private SavingAccount savingAccount;
	@OneToOne
	@JoinColumn(name="currentAccount")
	private CurrentAccount currentAccount;
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
	
	/* Construtor */
	public Client() { }
	private Client(String firstName, String lastName, String adress, String zipCode, String city, String phoneNumber, Counselor counselor) {
		super(firstName, lastName);
		this.adress = adress;
		this.zipCode = zipCode;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.counselor = counselor;
	}
	public Client(String firstName, String lastName, String adress, String zipCode, String city, String phoneNumber, 
			CurrentAccount currentAccount, Counselor counselor) {
		this(firstName, lastName, adress, zipCode, city, phoneNumber, counselor);
		this.currentAccount = currentAccount;
	}
	public Client(String firstName, String lastName, String adress, String zipCode, String city, String phoneNumber, 
			SavingAccount savingAccount, Counselor counselor) {
		this(firstName, lastName, adress, zipCode, city, phoneNumber, counselor);
		this.savingAccount = savingAccount;
	}
	public Client(String firstName, String lastName, String adress, String zipCode, String city, String phoneNumber, 
			SavingAccount savingAccount, CurrentAccount currentAccount, Counselor counselor) {
		this(firstName, lastName, adress, zipCode, city, phoneNumber, counselor);
		this.savingAccount = savingAccount;
		this.currentAccount = currentAccount;
	}
	
	@Override
	public String toString() {
		return "Client [adress=" + adress + ", zipCode=" + zipCode + ", city=" + city + ", phoneNumber=" + phoneNumber
				+ ", savingAccount=" + savingAccount + ", currentAccount=" + currentAccount + ", counselor=" + counselor
				+ "]";
	}
	
}


package com.projet.entity;

import com.projet.entity.SavingAccount;
import com.projet.entity.CurrentAccount;
import com.projet.entity.Counselor;

public class Client extends AbstractPerson {
	
	private String adress;
	private String zipCode;
	private String city;
	private String phoneNumber;
	private SavingAccount savingAccount;
	private CurrentAccount currentAccount;
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


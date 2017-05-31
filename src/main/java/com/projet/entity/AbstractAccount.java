package com.projet.entity;

import java.util.Date;

public abstract class AbstractAccount {

	private long id;
	private double sold;
	private Date created;
	
	
	public long getId() {
		return id;
	}
	public double getSold() {
		return sold;
	}
	public Date getCreated() {
		return created;
	}
	
	
	public void setId(long id) {
		this.id = id;
	}
	public void setSold(double sold) {
		this.sold = sold;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
}

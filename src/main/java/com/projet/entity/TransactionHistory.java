package com.projet.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction_history")
public class TransactionHistory {

	@Id
	@GeneratedValue
	@Column(name="transaction_id", unique = true)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="debit_account")
	private AbstractAccount debitAccount;
	
	@ManyToOne
	@JoinColumn(name="credit_account")
	private AbstractAccount creditAccount;
	
	@Column(name="created")
	private Date created;
	
	@Column(name="sum")
	private BigDecimal sum;
	
	@ManyToOne
	@JoinColumn(name="user")
	private User user;
	
	public TransactionHistory(AbstractAccount creditAccount, AbstractAccount debitAccount, BigDecimal sum, User user){
		this.debitAccount = debitAccount;
		this.creditAccount = creditAccount;
		this.created = new Date();
		this.sum = sum;
		this.user = user;
	}
	

	public long getId() {		return id;	}
	public AbstractAccount getDebitAccount() {		return debitAccount;	}
	public AbstractAccount getCreditAccount() {		return creditAccount;	}
	public Date getCreated() {		return created;	}
	public BigDecimal getSum() {		return sum;	}
	public User getUser() {		return user;	}

	public void setId(long id) {		this.id = id;	}
	public void setDebitAccount(AbstractAccount debitAccount) {		this.debitAccount = debitAccount;	}
	public void setCreditAccount(AbstractAccount creditAccount) {		this.creditAccount = creditAccount;	}
	public void setCreated(Date created) {		this.created = created;	}
	public void setSum(BigDecimal sum) {		this.sum = sum;	}
	public void setUser(User user) {		this.user = user;	}
}

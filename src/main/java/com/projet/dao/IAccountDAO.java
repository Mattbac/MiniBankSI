package com.projet.dao;

import com.projet.entity.Account;

public interface IAccountDAO {

	public Account findAccountById(long id);
	public void createAccount();
	public void updateAccount(Account account);
	public void deleteAccount(Account account);
}

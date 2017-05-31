package com.projet.dao;

import com.projet.entity.AbstractAccount;

public interface IAccountDAO {

	public AbstractAccount findAccountById(long id);
	public void createAccount();
	public void updateAccount(AbstractAccount account);
	public void deleteAccount(AbstractAccount account);
}

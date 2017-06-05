package com.projet.dao;

import com.projet.entity.SavingAccount;

public interface ISavingAccountDAO {

	public SavingAccount findAccountById(Long id);
	public void createAccount(SavingAccount account);
	public void updateAccount(SavingAccount account);
	public void deleteAccount(SavingAccount account);
}

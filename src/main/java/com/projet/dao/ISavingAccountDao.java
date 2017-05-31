package com.projet.dao;

import com.projet.entity.SavingAccount;

public interface ISavingAccountDao {

	SavingAccount findAccountById(Long id);
	
	void createAccount(SavingAccount account);

	void updateAccount(SavingAccount account);

	void deleteAccount(SavingAccount account);

}

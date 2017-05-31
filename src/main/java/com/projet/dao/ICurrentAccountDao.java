package com.projet.dao;

import com.projet.entity.CurrentAccount;

public interface ICurrentAccountDao {

	CurrentAccount findAccountById(Long id);
	
	void createAccount(CurrentAccount account);

	void updateAccount(CurrentAccount account);

	void deleteAccount(CurrentAccount account);
}

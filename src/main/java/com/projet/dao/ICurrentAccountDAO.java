package com.projet.dao;

import com.projet.entity.CurrentAccount;

public interface ICurrentAccountDAO {

	CurrentAccount findAccountById(Long id);
	void createAccount(CurrentAccount account);
	void updateAccount(CurrentAccount account);
	void deleteAccount(CurrentAccount account);
}

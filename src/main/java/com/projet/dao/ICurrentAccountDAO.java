package com.projet.dao;

import com.projet.entity.CurrentAccount;

public interface ICurrentAccountDAO {

	public CurrentAccount findAccountById(Long id);
	public void createAccount(CurrentAccount account);
	public void updateAccount(CurrentAccount account);
	public void deleteAccount(CurrentAccount account);
}

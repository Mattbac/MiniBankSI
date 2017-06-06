package com.projet.dao;

import com.projet.entity.AbstractAccount;

public interface IAbstractAccountDAO {

	AbstractAccount findAccountByAccountNumber(String accountNumber);
	public void updateAccount(AbstractAccount account);
}

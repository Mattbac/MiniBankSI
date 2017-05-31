package com.projet.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.projet.dao.ISavingAccountDao;
import com.projet.entity.AbstractAccount;
import com.projet.entity.SavingAccount;

public class SavingAccountDaoImpl implements ISavingAccountDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public SavingAccount findAccountById(Long id) {
		return em.find(SavingAccount.class, id);
	}

	@Override
	public void createAccount(SavingAccount account) {
		em.persist(account);
	}

	@Override
	public void updateAccount(SavingAccount account) {
		em.merge(account);
	}

	@Override
	public void deleteAccount(SavingAccount account) {
		em.remove(account);
	}

}

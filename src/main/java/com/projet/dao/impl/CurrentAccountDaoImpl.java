package com.projet.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.projet.dao.ICurrentAccountDao;
import com.projet.entity.CurrentAccount;

public class CurrentAccountDaoImpl implements ICurrentAccountDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public CurrentAccount findAccountById(Long id) {
		return em.find(CurrentAccount.class, id);
	}

	@Override
	public void createAccount(CurrentAccount account) {
		em.persist(account);		
	}

	@Override
	public void updateAccount(CurrentAccount account) {
		em.merge(account);
	}

	@Override
	public void deleteAccount(CurrentAccount account) {
		em.remove(account);
	}

}

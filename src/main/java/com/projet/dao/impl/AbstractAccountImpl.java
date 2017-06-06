package com.projet.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projet.dao.IAbstractAccountDAO;
import com.projet.entity.AbstractAccount;

@Transactional
@Repository
public class AbstractAccountImpl implements IAbstractAccountDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public AbstractAccount findAccountByAccountNumber(String accountNumber) {
		TypedQuery<AbstractAccount> q = em.createQuery("from AbstractAccount where accountNumber = :aN", AbstractAccount.class);
		q.setParameter("aN", accountNumber);
		return q.getSingleResult();
	}
	
	@Override
	public void updateAccount(AbstractAccount account) {
		em.merge(account);
	}
	
}

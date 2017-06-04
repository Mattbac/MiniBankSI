package com.projet.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	public void updateAccount(AbstractAccount account) {
		em.merge(account);
	}
	
}

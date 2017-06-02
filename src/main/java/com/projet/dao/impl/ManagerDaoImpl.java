package com.projet.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projet.dao.IManagerDAO;
import com.projet.entity.Manager;

@Repository
@Transactional
public class ManagerDaoImpl implements IManagerDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void create(Manager manager) {
		em.persist(manager);
	}

}

package com.projet.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projet.dao.IRoleDAO;
import com.projet.entity.Role;

@Repository
@Transactional
public class RoleDaoImpl implements IRoleDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void create(Role role) {
		em.persist(role);
	}
}
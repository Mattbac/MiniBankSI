package com.projet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

	@Override
	public List<Role> get() {
		TypedQuery<Role> q = em.createQuery("from Role", Role.class);
		return q.getResultList();
	}
}
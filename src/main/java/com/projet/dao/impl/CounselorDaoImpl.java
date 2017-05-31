package com.projet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.projet.dao.ICounselorDAO;
import com.projet.entity.Counselor;
import com.projet.entity.Manager;

public class CounselorDaoImpl implements ICounselorDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Counselor> findCounselorsByManager(Manager manager) {
		TypedQuery<Counselor> q = em.createQuery("from counselor where manager.id = :id", Counselor.class);
		q.setParameter("id", manager.getId());
		return q.getResultList();
	}

}

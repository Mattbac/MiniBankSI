package com.projet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projet.dao.ITransactionHistoryDAO;
import com.projet.entity.Counselor;
import com.projet.entity.TransactionHistory;

@Repository
@Transactional
public class TransactionHistoryDaoImpl implements ITransactionHistoryDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<TransactionHistory> findAll() {
		TypedQuery<TransactionHistory> q = em.createQuery("from TransactionHistory", TransactionHistory.class);
		return q.getResultList();
	}

	@Override
	public List<TransactionHistory> findAllByCounselor(Counselor counselor) {
		TypedQuery<TransactionHistory> q = em.createQuery("from TransactionHistory where counselor = :counselor", TransactionHistory.class);
		q.setParameter("counselor", counselor.getLogin());
		return q.getResultList();
	}

	@Override
	public void create(TransactionHistory th) {
		em.persist(th);
	}

}

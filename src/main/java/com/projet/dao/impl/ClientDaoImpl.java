package com.projet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projet.dao.IClientDAO;
import com.projet.entity.Client;
import com.projet.entity.Counselor;

@Transactional
@Repository
public class ClientDaoImpl implements IClientDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void createClient(Client client) {
		em.persist(client);
	}

	@Override
	public Client findClientById(Long id) {
		return em.find(Client.class, id);
	}

	@Override
	public void updateClient(Client client) {
		em.merge(client);
	}

	@Override
	public void deleteClient(Client client) {
		em.remove(client);		
	}

	@Override
	public List<Client> findClientsByCounselor(Counselor counselor) {
		TypedQuery<Client> q = em.createQuery("from Client where counselor = :c", Client.class);
		q.setParameter("c", counselor);
		return q.getResultList();
	}

	@Override
	public List<Client> findClientsByNegativeSold() {
		TypedQuery<Client> q = em.createQuery("from Client where savingAccount.sold < 0 or currentAccount.sold < 0", Client.class);
		return q.getResultList();
	}

}

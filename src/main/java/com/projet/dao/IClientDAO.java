package com.projet.dao;

import java.util.List;

import com.projet.entity.Client;
import com.projet.entity.Counselor;
import com.projet.entity.Manager;

public interface IClientDAO {

	public void createClient(Client client);
	public Client findClientById(Long id);
	public void updateClient(Client client);
	public void deleteClient(Client client);
	public List<Client> findClientsByCounselor(Counselor counselor);
	public List<Client> findClientsByNegativeSold();
	public List<Client> findAllClientsByManager(Manager user);
}

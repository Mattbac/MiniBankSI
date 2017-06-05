package com.projet.service;

import java.util.List;

import com.projet.entity.Client;
import com.projet.entity.Counselor;
import com.projet.exception.ClientServiceException;

public interface IClientService {

	List<Client> getAllClientsByCounselor(Counselor counselor);
	Client findById(Long id);
	void update(Client client) throws ClientServiceException;
}

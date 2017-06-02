package com.projet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.dao.IClientDAO;
import com.projet.entity.Client;
import com.projet.entity.Counselor;
import com.projet.exception.ClientServiceException;
import com.projet.service.IClientService;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDAO clientDaoImpl;
	
	@Override
	public List<Client> getAllClientsByCounselor(Counselor counselor) {
		return clientDaoImpl.findClientsByCounselor(counselor);
	}

	@Override
	public Client findById(Long id) {
		return clientDaoImpl.findClientById(id);
	}

	@Override
	public void update(Client client) throws ClientServiceException {
		try {
			validate(client);
			clientDaoImpl.updateClient(client);
		}
		catch (ClientServiceException e) {
			throw e;
		}
	}

	private void validate(Client client) throws ClientServiceException{
		
	}

	
}

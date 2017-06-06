package com.projet.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.dao.IClientDAO;
import com.projet.entity.Client;
import com.projet.entity.Counselor;
import com.projet.exception.ClientServiceException;
import com.projet.service.IClientService;

@Transactional
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
		if (client.getFirstName() == null || client.getFirstName().trim().length() == 0) {
			throw new ClientServiceException ("firstName", "le pr�nom ne doit pas �tre nul");
		}
		if (client.getLastName() == null || client.getLastName().trim().length() == 0) {
			throw new ClientServiceException ("lastName", "le pr�nom ne doit pas �tre nul");
		}
		if (client.getAdress() == null || client.getAdress().trim().length() == 0) {
				throw new ClientServiceException ("adress", "le pr�nom ne doit pas �tre nul");
		}
		if (client.getZipCode() == null || client.getZipCode().trim().length() == 0) {
			throw new ClientServiceException ("zipCode", "le pr�nom ne doit pas �tre nul");
		}
		if (client.getZipCode() == null || client.getZipCode().trim().length() == 0) {
			throw new ClientServiceException ("zipCode", "le pr�nom ne doit pas �tre nul");
		}		
	}

	@Override
	public void delete(Long id) {
		Client client = clientDaoImpl.findClientById(id);
		if (validateToDelete(client)) {
			clientDaoImpl.deleteClient(client);
		}
	}

	private boolean validateToDelete(Client client) {
		return true;
	}
	
}

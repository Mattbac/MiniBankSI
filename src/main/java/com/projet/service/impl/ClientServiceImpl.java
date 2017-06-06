package com.projet.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.dao.IClientDAO;
import com.projet.dao.ICurrentAccountDAO;
import com.projet.dao.ISavingAccountDAO;
import com.projet.entity.AbstractAccount;
import com.projet.entity.Client;
import com.projet.entity.Counselor;
import com.projet.entity.CurrentAccount;
import com.projet.entity.SavingAccount;
import com.projet.exception.ClientServiceException;
import com.projet.service.IClientService;

@Transactional
@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDAO clientDaoImpl;
	@Autowired
	private ICurrentAccountDAO currentAccountDaoImpl;
	@Autowired
	private ISavingAccountDAO savingAccountDaoImpl;
	
	@Override
	public List<Client> getAllClientsByCounselor(Counselor counselor) {
		return clientDaoImpl.findClientsByCounselor(counselor);
	}

	@Override
	public Client findById(Long id) {
		return clientDaoImpl.findClientById(id);
	}
	
	@Override
	public void create(Client client, CurrentAccount currentAccount, SavingAccount savingAccount) throws ClientServiceException {
		try{
			validate(client);
			if(currentAccount != null){
				client.setCurrentAccount(currentAccount);
				currentAccountDaoImpl.createAccount(currentAccount);
			}
			if(savingAccount != null){
				client.setSavingAccount(savingAccount);
				savingAccountDaoImpl.createAccount(savingAccount);
			}
			clientDaoImpl.createClient(client);
		}
		catch (ClientServiceException e) {
			throw e;
		}
	}

	@Override
	public void update(Client client, Long id) throws ClientServiceException {
		Client clientTemp = clientDaoImpl.findClientById(id);
		try {
			validate(client);
			clientTemp.setFirstName(client.getFirstName());
			clientTemp.setLastName(client.getLastName());
			clientTemp.setAdress(client.getAdress());
			clientTemp.setZipCode(client.getZipCode());
			clientTemp.setCity(client.getCity());
			clientTemp.setPhoneNumber(client.getPhoneNumber());
			clientDaoImpl.updateClient(clientTemp);
		}
		catch (ClientServiceException e) {
			throw e;
		}
	}

	private void validate(Client client) throws ClientServiceException{
		if (client.getFirstName() == null || client.getFirstName().trim().length() == 0) {
			throw new ClientServiceException ("firstName", "le prénom ne doit pas être nul");
		}
		if (client.getLastName() == null || client.getLastName().trim().length() == 0) {
			throw new ClientServiceException ("lastName", "le prénom ne doit pas être nul");
		}
		if (client.getAdress() == null || client.getAdress().trim().length() == 0) {
				throw new ClientServiceException ("adress", "le prénom ne doit pas être nul");
		}
		if (client.getZipCode() == null || client.getZipCode().trim().length() == 0) {
			throw new ClientServiceException ("zipCode", "le prénom ne doit pas être nul");
		}
		if (client.getZipCode() == null || client.getZipCode().trim().length() == 0) {
			throw new ClientServiceException ("zipCode", "le prénom ne doit pas être nul");
		}
		if (client.getPhoneNumber() == null || client.getPhoneNumber().trim().length() == 0) {
			throw new ClientServiceException ("phoneNumber", "le prénom ne doit pas être nul");
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

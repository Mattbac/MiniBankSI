package com.projet.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.dao.IClientDAO;
import com.projet.dao.ICurrentAccountDAO;
import com.projet.dao.ISavingAccountDAO;
import com.projet.entity.Client;
import com.projet.entity.Counselor;
import com.projet.entity.CurrentAccount;
import com.projet.entity.Manager;
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
	public List<Client> getAllClientsByManager(Manager manager) {
		return clientDaoImpl.findAllClientsByManager(manager);
	}

	@Override
	public Client findById(Long id) {
		return clientDaoImpl.findClientById(id);
	}
	
	@Override
	public void create(Client client, CurrentAccount currentAccount, SavingAccount savingAccount) {
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

	@Override
	public void update(Client client, Long id) {
		Client clientTemp = clientDaoImpl.findClientById(id);
		clientTemp.setFirstName(client.getFirstName());
		clientTemp.setLastName(client.getLastName());
		clientTemp.setAdress(client.getAdress());
		clientTemp.setZipCode(client.getZipCode());
		clientTemp.setCity(client.getCity());
		clientTemp.setPhoneNumber(client.getPhoneNumber());
		clientDaoImpl.updateClient(clientTemp);
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

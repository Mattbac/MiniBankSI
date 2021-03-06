package com.projet.service;

import java.util.List;

import com.projet.entity.Client;
import com.projet.entity.Counselor;
import com.projet.entity.CurrentAccount;
import com.projet.entity.Manager;
import com.projet.entity.SavingAccount;
import com.projet.exception.ClientServiceException;

public interface IClientService {

	List<Client> getAllClientsByCounselor(Counselor counselor);
	Client findById(Long id);
	
	void update(Client client, Long id);
	void create(Client client, CurrentAccount currentAccount, SavingAccount savingAccount);
	void delete(Long id);
	List<Client> getAllClientsByManager(Manager manager);
}

package com.projet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projet.dao.IClientDAO;
import com.projet.entity.Client;
import com.projet.entity.Counselor;
import com.projet.service.IClientService;

public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDAO clientDaoImpl;
	
	@Override
	public List<Client> getAllClientsByCounselor(Counselor counselor) {
		return clientDaoImpl.findClientsByCounselor(counselor);
	}

}

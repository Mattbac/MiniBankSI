package com.projet.service;

import java.util.List;

import com.projet.entity.Client;
import com.projet.entity.Counselor;

public interface IClientService {

	List<Client> getAllClientsByCounselor(Counselor counselor);

}

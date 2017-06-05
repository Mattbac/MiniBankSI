package com.projet.dao;

import com.projet.entity.Manager;

public interface IManagerDAO {
	
	public void create(Manager manager);
	public Manager findByLogin(String login);
}

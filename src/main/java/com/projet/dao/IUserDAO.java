package com.projet.dao;

import com.projet.entity.User;

public interface IUserDAO {

	public User findByLogin(String login);
}

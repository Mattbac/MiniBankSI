package com.projet.dao;

import com.projet.entity.User;

public interface UserDAO {

	public User findByLogin(String login);
}

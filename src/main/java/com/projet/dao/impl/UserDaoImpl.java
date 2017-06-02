package com.projet.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projet.dao.ICounselorDAO;
import com.projet.dao.IUserDAO;
import com.projet.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements IUserDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ICounselorDAO counselorDaoImpl;
	
	@Override
	public User findByLogin(String login) {
		
		return (User) counselorDaoImpl.findByLogin(login);
	}
}

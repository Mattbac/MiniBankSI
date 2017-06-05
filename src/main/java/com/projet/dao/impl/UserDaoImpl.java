package com.projet.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projet.dao.ICounselorDAO;
import com.projet.dao.IManagerDAO;
import com.projet.dao.IUserDAO;
import com.projet.entity.Counselor;
import com.projet.entity.Manager;
import com.projet.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements IUserDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ICounselorDAO counselorDaoImpl;
	
	@Autowired
	private IManagerDAO managerDaoImpl;
	
	@Override
	public User findByLogin(String login) {
		
		Counselor counselor = counselorDaoImpl.findByLogin(login);
		Manager manager = managerDaoImpl.findByLogin(login);
		
		if(counselor != null){
			return (User) counselor;
		}else if(manager != null){
			return (User) manager;
		}else{
			return null;
		}
	}
}

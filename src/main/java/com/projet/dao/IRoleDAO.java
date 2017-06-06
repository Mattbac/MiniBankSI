package com.projet.dao;

import java.util.List;

import com.projet.entity.Role;

public interface IRoleDAO {
	
	public void create(Role role);
	public List<Role> get();
}

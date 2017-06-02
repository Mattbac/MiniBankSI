package com.projet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projet.dao.IUserDAO;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUserDAO userDaoImpl;
	
	public UserSecurity loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.projet.entity.User user = userDaoImpl.findByLogin(username);
		
		if(user == null){
			throw new UsernameNotFoundException("Username not found");
		}
		
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRole_user().getRole_name());
		return buildUserForAuthentication(user, authorities);
	}

	private UserSecurity buildUserForAuthentication(com.projet.entity.User user, List<GrantedAuthority> authorities) {
		return new UserSecurity(user.getLogin(), user.getPassword(), user.isEnabled(), true, true, true, authorities, user);
	}

	private List<GrantedAuthority> buildUserAuthority(String userRoles) {

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>();
		Result.add(new SimpleGrantedAuthority(userRoles));
		return Result;
	}

}
package com.projet.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.projet.entity.Counselor;
import com.projet.entity.Manager;

public class UserSecurity extends User {

	private static final long serialVersionUID = 7197911000941494240L;
	private Counselor couselor = null;
	private Manager manager = null;
	
	public UserSecurity(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, com.projet.entity.User user) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		
		if(user.getRole_user().getRole_name().equals("ROLE_counselor")){
			this.couselor = (Counselor) user;
		}else{
			this.manager = (Manager) user;
		}
	}

	public Counselor getCouselor() {
		return couselor;
	}

	public Manager getManager() {
		return manager;
	}

	public void setCouselor(Counselor couselor) {
		this.couselor = couselor;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
}

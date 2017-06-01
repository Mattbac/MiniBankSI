package com.projet.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet.dao.ICurrentAccountDao;

@Controller
public class HomeController {

	@Autowired
	public ICurrentAccountDao currentAccountDaoImpl;
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String home() {
//		CurrentAccount c = new CurrentAccount();
//		c.setCreated(new Date());
//		c.setOverdrawn(new BigDecimal(12.0));
//		c.setSold(new BigDecimal(45.0));
//		
//		currentAccountDaoImpl.createAccount(c);
		return "home";
	}
	
	@RequestMapping(value = {"/counselor"}, method = RequestMethod.GET)
	public String dashboardcounselor() {

		return "dashboard";
	}
	
	@RequestMapping(value = {"/manager"}, method = RequestMethod.GET)
	public String dashboardmanager() {

		return "dashboard";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
}

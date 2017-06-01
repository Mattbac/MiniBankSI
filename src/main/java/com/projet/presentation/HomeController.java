package com.projet.presentation;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet.dao.ICurrentAccountDao;
import com.projet.entity.CurrentAccount;

@Controller
public class HomeController {

	@Autowired
	public ICurrentAccountDao currentAccountDaoImpl;
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String home() {
		CurrentAccount c = new CurrentAccount();
		c.setCreated(new Date());
		c.setOverdrawn(new BigDecimal(12.0));
		c.setSold(new BigDecimal(45.0));
		
		currentAccountDaoImpl.createAccount(c);
		return "home";
	}
}

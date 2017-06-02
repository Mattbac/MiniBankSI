package com.projet.presentation;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projet.dao.ICounselorDAO;
import com.projet.dao.ICurrentAccountDAO;
import com.projet.exception.ClientServiceException;
import com.projet.dao.IManagerDAO;
import com.projet.dao.IRoleDAO;
import com.projet.dao.ISavingAccountDAO;
import com.projet.dao.IClientDAO;
import com.projet.entity.Client;
import com.projet.entity.Counselor;
import com.projet.entity.CurrentAccount;
import com.projet.entity.Manager;
import com.projet.entity.Role;
import com.projet.entity.SavingAccount;
import com.projet.service.IClientService;
import com.projet.service.UserSecurity;

@Controller
public class HomeController {

	final int CLIENTS_PER_PAGE = 4;
	
	@Autowired
	private IRoleDAO roleDaoImpl;
	@Autowired
	private IClientDAO clientDaoImpl;
	@Autowired
	private IManagerDAO managerDaoImpl;
	@Autowired
	private ICounselorDAO counselorDaoImpl;
	@Autowired
	private ICurrentAccountDAO currentAccountDaoImpl;
	@Autowired
	private ISavingAccountDAO savingAccountDaoImpl;
	
	@Autowired
	private IClientService clientServiceImpl;
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String home() {
		
		Role rc = new Role("ROLE_counselor");
		roleDaoImpl.create(rc);
		Role rm = new Role("ROLE_manager");
		roleDaoImpl.create(rm);
		
		int counselor = 0;
		
		for(int i = 0; i < 2 ;i++){
			Manager m = new Manager("manager"+i, "manager"+i, rm, "Agency "+i);
			managerDaoImpl.create(m);

			int g = (int) Math.floor((Math.random() * 5) + 3);
			
			for(int j = 0; j < g ;j++){
				Counselor c = new Counselor("counselor"+counselor, "counselor"+counselor, rc, m);
				counselor++;
				counselorDaoImpl.createCounselor(c);
				
				int r = (int) Math.floor((Math.random() * 9) + 1);
				
				for(int k = 0; k < r ;k++){
					
					CurrentAccount current = null;
					SavingAccount saving = null;
					
					if( Math.floor((Math.random() * 10)) < 5){
						current = new CurrentAccount(new BigDecimal(Math.floor((Math.random() * 10000))));
						currentAccountDaoImpl.createAccount(current);
						
					}
					
					if( current == null || Math.floor((Math.random() * 10)) < 5){
						saving = new SavingAccount(new BigDecimal(Math.floor((Math.random() * 10000))));
						savingAccountDaoImpl.createAccount(saving);
					}
					
					Client ct = null;
					
					if(current != null && saving != null){
						ct = new Client("firstname"+k, "lastname"+k, "adress", "zipcode", "city", "phonenumber", saving, current, c);
					}else if(current != null) {
						ct = new Client("firstname"+k, "lastname"+k, "adress", "zipcode", "city", "phonenumber", current, c);
					}else if(saving != null){
						ct = new Client("firstname"+k, "lastname"+k, "adress", "zipcode", "city", "phonenumber", saving, c);
					}
					clientDaoImpl.createClient(ct);
				}
			}
		}
		
		return "home";
	}
	
	@RequestMapping(value = {"/counselor"}, method = RequestMethod.GET)
	public String dashboardcounselor() {
		
		UserSecurity userDetails = (UserSecurity)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		System.out.println(userDetails.getCouselor().getManager().getAgencyName());
		
		return "dashboard";
	}


	@GetMapping("/counselor/see/clients")
	public ModelAndView listeClients(HttpSession session, @RequestParam(required = false) Integer pageNumber) {
		Counselor counselor = ((UserSecurity)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getCouselor();
		List<Client> clients = clientServiceImpl.getAllClientsByCounselor(counselor);
		PagedListHolder<Client> page = new PagedListHolder<>(clients);
		page.setPageSize(CLIENTS_PER_PAGE);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("liste-clients");
		mav.addObject("maxPages", page.getPageCount());
		page.setPage(pageNumber == null || pageNumber.equals(0) ? 0 : pageNumber - 1 );
		mav.addObject("currentPage", page.getPage());
		mav.addObject("clients", page.getPageList());
		return mav;
	}
	
	@GetMapping("/counselor/see/client/{id}")
	public ModelAndView seeClient(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("client", clientServiceImpl.findById(id));
		mav.setViewName("client");
		return mav;
	}
	
	@PostMapping("/counselor/see/client/{id}")
	public String modifyClient (@Valid @ModelAttribute("client") Client client, BindingResult result) {
		if (result.hasErrors()) {
			return "counselor/see/client";
		}
		try {
			clientServiceImpl.update(client);
			return "redirect:/counselor/see/clients";
		}
		catch (ClientServiceException e) {
			result.rejectValue(e.getChamp(), e.getChamp(), e.getMessage());
			return "counselor/see/client";
		}
	}
	
	@GetMapping("/counselor/create/client")
	public ModelAndView createClientOut(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("client", new Client());
		mav.setViewName("create-client");
		return mav;
	}
	
	@PostMapping("/counselor/create/client")
	public String createClientIn(@Valid @ModelAttribute("client") Client client, BindingResult result) {
		if (result.hasErrors()) {
			return "counselor/create/client";
		}
		try {
			clientServiceImpl.update(client);
			return "redirect:/counselor/see/clients";
		}
		catch (ClientServiceException e) {
			result.rejectValue(e.getChamp(), e.getChamp(), e.getMessage());
			return "counselor/create/client";
		}
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

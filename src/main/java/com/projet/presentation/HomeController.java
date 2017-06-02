package com.projet.presentation;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projet.dao.ICounselorDAO;
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

	final int CLIENTS_PER_PAGE = 5;
	
	@Autowired
	private IClientService clientServiceImpl;
	@Autowired
	private ICounselorDAO counselorDaoImpl;
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String home() {
		
		Role rc = new Role("ROLE_counselor");
		Role rm = new Role("ROLE_manager");
		
		for(int i = 0; i < 2 ;i++){
			Manager m = new Manager("manager"+i, "manager"+i, rm, "Agency "+i);
			
			int g = (int) Math.floor((Math.random() * 5) + 3);
			
			for(int j = 0; j < g ;j++){
				Counselor c = new Counselor("counselor"+j, "counselor"+j, rc, m);
				
				int r = (int) Math.floor((Math.random() * 9) + 1);
				
				for(int k = 0; k < r ;k++){
					
					/*CurrentAccount current = new CurrentAccount();
					SavingAccount saving = new SavingAccount();*/
					
					Client ct = new Client("firstname"+k, "lastname"+k, "adress", "zipcode", "city", "phonenumber", c);
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
		Counselor counselor = null;
//		List<Client> clients = clientServiceImpl.getAllClientsByCounselor(counselor);
//		PagedListHolder<Client> page = new PagedListHolder<>(clients);
//		page.setPageSize(CLIENTS_PER_PAGE);
		ModelAndView mav = new ModelAndView();
//		mav.setViewName("liste-clients");
//		mav.addObject("maxPages", page.getPageCount());
//		page.setPage(pageNumber == null || pageNumber.equals(0) ? 0 : pageNumber - 1 );
//		mav.addObject("currentPage", page.getPage());
//		mav.addObject("clients", page.getPageList());
		return mav;
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

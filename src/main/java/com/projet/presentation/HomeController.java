package com.projet.presentation;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.projet.entity.User;
import com.projet.service.AbstractAccountService;
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
	private AbstractAccountService abstractAccountService;
	@Autowired
	private IClientService clientServiceImpl;
	
	@RequestMapping(value = {"/", "/home", "/dashboard"}, method = RequestMethod.GET)
	public String home() {

		List<Client> listClients;
		User user = new User();
		if (((UserSecurity)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getCouselor() != null) {
			user = ((UserSecurity)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getCouselor();
			listClients = clientDaoImpl.findClientsByCounselor((Counselor) user);
		} else {
			user = ((UserSecurity)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getManager();
			listClients = clientDaoImpl.findAllClients();
		}
		
		BigDecimal sumSavingAccount = new BigDecimal(0);
		BigDecimal sumCurrentAccount = new BigDecimal(0);
		
		List<Client> listClientNegativ = new ArrayList<Client>();
		List<Client> listClientSavingOver500000 = new ArrayList<Client>();
		
		for(Client c : listClients){
			
			if(c.getSavingAccount() != null){
				sumSavingAccount.add(c.getSavingAccount().getSold());
				if(c.getSavingAccount().getSold().compareTo(new BigDecimal(500000)) == 1){
					listClientSavingOver500000.add(c);
				}
			}
			if(c.getCurrentAccount() != null){
				sumCurrentAccount.add(c.getCurrentAccount().getSold());
				
				if(c.getCurrentAccount().getSold().compareTo(new BigDecimal(0)) == -1){
					listClientNegativ.add(c);
				}
			}
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", user);
		mav.addObject("nbClients", listClients.size());
		mav.addObject("sumSavingAccount", sumSavingAccount);
		mav.addObject("sumCurrentAccount", sumCurrentAccount);
		mav.addObject("listClientNegativ", listClientNegativ);
		mav.addObject("listClientSavingOver500000", listClientSavingOver500000);
		return "dashboard";
	}
	
	@GetMapping("/see/clients")
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
	
	@GetMapping("/see/client/{id}")
	public ModelAndView seeClient(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("client", clientServiceImpl.findById(id));
		mav.setViewName("client");
		return mav;
	}
	
	@GetMapping("/modify/client/{id}")
	public ModelAndView modifyClient(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("client", clientServiceImpl.findById(id));
		mav.setViewName("edit-client");
		return mav;
	}
	
	@PostMapping("/modify/client/{id}")
	@Valid
	public ModelAndView modifyClient (@ModelAttribute("client") Client clientForm, BindingResult result, @PathVariable Long id) {
		ModelAndView mav = new ModelAndView();
		
		if (result.hasErrors()) {
			System.out.println(result.toString());
			mav.setViewName("edit-client");
			return mav;
		}
		try {
			System.out.println("update");
			clientServiceImpl.update(clientForm, id);
			return new ModelAndView("redirect:/see/client/"+id);
		}
		catch (ClientServiceException e) {
			System.out.println("update error");
			result.rejectValue(e.getChamp(), e.getChamp(), e.getMessage());
			mav.setViewName("edit-client");
			return mav;
		}
	}
	
	@GetMapping("/create/client")
	public ModelAndView createClientOut(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("client", new Client());
		mav.setViewName("create-client");
		return mav;
	}
	
	@PostMapping("/create/client")
//	@Valid
	public ModelAndView createClientIn(@ModelAttribute("client") Client client, BindingResult result, @RequestParam(required = false) boolean saving, @RequestParam(required = false) boolean current) {
		ModelAndView mav = new ModelAndView();
		
		if (result.hasErrors()) {
			mav.setViewName("create-client");
			return mav;
		}
		try {
			CurrentAccount c = null;
			SavingAccount s = null;
			if(current){
				c = new CurrentAccount();
			}
			
			if(saving){
				s = new SavingAccount();
			}
			
			if(!current && !saving){
				throw new ClientServiceException("", "No account checked");
			}
			
			client.setCounselor(((UserSecurity)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getCouselor());
			
			clientServiceImpl.create(client, c, s);
			return new ModelAndView("redirect:/see/clients");
		}
		catch (ClientServiceException e) {
			result.rejectValue(e.getChamp(), e.getChamp(), e.getMessage());
			mav.setViewName("create-client");
			return mav;
		}
	}
	
	@GetMapping("/delete/client/{id}")
	public ModelAndView deleteClient(@PathVariable Long id) {
		clientServiceImpl.delete(id);
		return new ModelAndView("redirect:/see/clients");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		/*
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
				
				int r = (int) Math.floor((Math.random() * 9) + 10);
				
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
						ct = new Client("firstname"+k, "lastname"+k, "12 Rue Victor Hugo", "59 000", "Lille", "06" + Long.toString((long) Math.floor((Math.random() * 1000000000) + 10000000)).substring(0,8), saving, current, c);
					}else if(current != null) {
						ct = new Client("firstname"+k, "lastname"+k, "12 Rue Victor Hugo", "59 000", "Lille", "06" + Long.toString((long) Math.floor((Math.random() * 1000000000) + 10000000)).substring(0,8), current, c);
					}else if(saving != null){
						ct = new Client("firstname"+k, "lastname"+k, "12 Rue Victor Hugo", "59 000", "Lille", "06" + Long.toString((long) Math.floor((Math.random() * 1000000000) + 10000000)).substring(0,8), saving, c);
					}
					clientDaoImpl.createClient(ct);
				}
			}
		}*/
		return "login";
	}

	@RequestMapping(value = {"/recherche", "/search"}, method = RequestMethod.GET)
	public String search() {
		return "search";
	}
	
	@RequestMapping(value = {"/transfert", "/virement"}, method = RequestMethod.GET)
	public String transfert() {
		return "transfert";
	}
	
	@RequestMapping(value = "/options", method = RequestMethod.GET)
	public String options() {
		return "options";
	}
}

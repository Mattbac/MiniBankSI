package com.projet.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projet.entity.Client;
import com.projet.entity.Counselor;
import com.projet.service.IClientService;

@Controller
public class HomeController {

	final int CLIENTS_PER_PAGE = 5;
	
	@Autowired
	private IClientService clientServiceImpl;
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
	public String dashboard() {

		return "dashboard";
	}

	@GetMapping("/counselor/see/clients")
	public ModelAndView listeClients(@RequestParam(required = false) Integer pageNumber) {
		Counselor counselor = null;
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
}

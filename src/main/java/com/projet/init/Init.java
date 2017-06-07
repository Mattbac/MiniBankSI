package com.projet.init;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.dao.IClientDAO;
import com.projet.dao.ICounselorDAO;
import com.projet.dao.ICurrentAccountDAO;
import com.projet.dao.IManagerDAO;
import com.projet.dao.IRoleDAO;
import com.projet.dao.ISavingAccountDAO;
import com.projet.entity.Client;
import com.projet.entity.Counselor;
import com.projet.entity.CurrentAccount;
import com.projet.entity.Manager;
import com.projet.entity.Role;
import com.projet.entity.SavingAccount;

@Service
public class Init implements IInit {
	
	@Autowired
	private IRoleDAO roleDaoImpl;
	@Autowired
	private IManagerDAO managerDaoImpl;
	@Autowired
	private ICounselorDAO counselorDaoImpl;
	@Autowired
	private ICurrentAccountDAO currentAccountDaoImpl;
	@Autowired
	private ISavingAccountDAO savingAccountDaoImpl;
	@Autowired
	private IClientDAO clientDaoImpl;

	@Override
	public void initialize () {
		
		if(roleDaoImpl.get().size() != 0) {
			return;
		}
		
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
						current = new CurrentAccount(new BigDecimal(Math.floor((Math.random() * 10000))-1000));
						currentAccountDaoImpl.createAccount(current);
					}
					
					if( current == null || Math.floor((Math.random() * 10)) < 5){
						saving = new SavingAccount(new BigDecimal(Math.floor((Math.random() * 600000))));
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
		}
	}
}

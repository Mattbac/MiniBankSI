package com.projet.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.projet.entity.AbstractAccount;
import com.projet.entity.CurrentAccount;
import com.projet.entity.SavingAccount;
import com.projet.entity.TransactionHistory;
import com.projet.dao.IAbstractAccountDAO;
import com.projet.dao.ITransactionHistoryDAO;
import com.projet.dao.impl.TransactionHistoryDaoImpl;

@Repository
public class AbstractAccountService {

	@Autowired
	private IAbstractAccountDAO abstractAccountDaoImpl;
	
	@Autowired
	private ITransactionHistoryDAO transactionHistoryDaoImpl;
	
	public boolean virement(AbstractAccount accountClient1, AbstractAccount accountClient2, BigDecimal money){

		BigDecimal tempValue = new BigDecimal(0);
		
		if( money.compareTo(new BigDecimal(0)) == 1){
			if(accountClient2.getClass().equals(SavingAccount.class) && accountClient2.getSold().compareTo(money) == 1){
				return makeVirement(accountClient1, accountClient2, money);
			}else if(accountClient2.getClass().equals(CurrentAccount.class) && tempValue.add(accountClient2.getSold()).add(((CurrentAccount)accountClient2).getOverdrawn()).compareTo(money) == 1){
				return makeVirement(accountClient1, accountClient2, money);
			}else {
				return false;
			}
		}else{
			return false;
		}
	}
	
	private boolean makeVirement(AbstractAccount accountClient1, AbstractAccount accountClient2, BigDecimal money){
		
		try {
			accountClient1.setSold(accountClient1.getSold().add(money));
			accountClient2.setSold(accountClient2.getSold().subtract(money));
			transactionHistoryDaoImpl.create(new TransactionHistory(accountClient1, accountClient2, money, ((UserSecurity)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getCouselor()));
				
			abstractAccountDaoImpl.updateAccount(accountClient1);
			abstractAccountDaoImpl.updateAccount(accountClient2);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}

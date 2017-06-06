package com.projet.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.projet.entity.AbstractAccount;
import com.projet.entity.CurrentAccount;
import com.projet.entity.SavingAccount;
import com.projet.entity.TransactionHistory;
import com.projet.exception.virementException;
import com.projet.dao.IAbstractAccountDAO;
import com.projet.dao.ITransactionHistoryDAO;

@Service
public class AbstractAccountService {

	@Autowired
	private IAbstractAccountDAO abstractAccountDaoImpl;
	
	@Autowired
	private ITransactionHistoryDAO transactionHistoryDaoImpl;
	
	public void virement(String creditAccount, String debitAccount, BigDecimal money) throws virementException {

		AbstractAccount accountClient1 = abstractAccountDaoImpl.findAccountByAccountNumber(creditAccount);
		AbstractAccount accountClient2 = abstractAccountDaoImpl.findAccountByAccountNumber(debitAccount);
		BigDecimal tempValue = new BigDecimal(0);
		
		if (money.compareTo(new BigDecimal(0)) < 1) {
			throw new virementException("", "negative amount");
		}
		
		if (accountClient2.getClass().equals(SavingAccount.class) && accountClient2.getSold().compareTo(money) < 0) {
			throw new virementException("", "not enough money");
		} 

		if (accountClient2.getClass().equals(CurrentAccount.class) && accountClient2.getSold().compareTo(money.subtract(((CurrentAccount)accountClient2).getOverdrawn())) < 0) {
			throw new virementException("", "not enough money");
		}

		makeVirement(accountClient1, accountClient2, money);
					
	}
	
	private void makeVirement(AbstractAccount accountClient1, AbstractAccount accountClient2, BigDecimal money){
		
			accountClient1.setSold(accountClient1.getSold().add(money));
			accountClient2.setSold(accountClient2.getSold().subtract(money));
			transactionHistoryDaoImpl.create(new TransactionHistory(accountClient1, accountClient2, money, ((UserSecurity)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getCouselor()));
				
			abstractAccountDaoImpl.updateAccount(accountClient1);
			abstractAccountDaoImpl.updateAccount(accountClient2);
	}
}

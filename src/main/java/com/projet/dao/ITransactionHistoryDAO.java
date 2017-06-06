package com.projet.dao;

import java.util.List;

import com.projet.entity.Counselor;
import com.projet.entity.TransactionHistory;

public interface ITransactionHistoryDAO {

	public List<TransactionHistory> findAll();
	public List<TransactionHistory> findAllByCounselor(Counselor counselor);
	public void create(TransactionHistory th);
}

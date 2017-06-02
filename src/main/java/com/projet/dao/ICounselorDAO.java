package com.projet.dao;

import java.util.List;

import com.projet.entity.Manager;
import com.projet.entity.Counselor;

public interface ICounselorDAO {

	public List<Counselor> findCounselorsByManager(Manager manager);
	public void createCounselor(Counselor counselor);
}

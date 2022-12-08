package kr.co.Kmarket.service.main;

import kr.co.Kmarket.dao.main.MainDao;

public enum MainService {

	INSTANCE;

	private MainDao dao;

	private MainService() {
		dao = new MainDao();
	}

}

package kr.co.Kmarket.service.cs;

import kr.co.Kmarket.dao.cs.CsDao;

public enum CsService {
	
	INSTANCE;
	private  CsDao dao;
	
	
	private CsService() {
		dao = new CsDao();
	
	}
	
	

}

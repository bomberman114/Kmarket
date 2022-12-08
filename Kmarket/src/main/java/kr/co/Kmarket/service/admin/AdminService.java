package kr.co.Kmarket.service.admin;

import kr.co.Kmarket.dao.admin.AdminDao;

public enum AdminService {
	
	INSTANCE;
	private  AdminDao dao;
	
	private AdminService() {
		dao = new AdminDao();
	}
		
		

}

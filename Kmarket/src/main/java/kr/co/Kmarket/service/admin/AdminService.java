package kr.co.Kmarket.service.admin;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

import kr.co.Kmarket.dao.admin.AdminDao;
import kr.co.Kmarket.vo.ProductVo;

public enum AdminService {
	
	INSTANCE;
	private  AdminDao dao;
	
	private AdminService() {
		dao = new AdminDao();
	}

	public MultipartRequest uploadFile(HttpServletRequest req, String path) {
		// TODO Auto-generated method stub
		return null;
	}

	public String renameFile(String fname, String uid, String path) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertArticle(ProductVo product) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void insertFile(int parent, String newName, String fname) {
		// TODO Auto-generated method stub
		
	}
		
		

}

package kr.co.Kmarket.service.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.Kmarket.dao.admin.AdminDao;
import kr.co.Kmarket.vo.ProductVo;

public enum AdminService {

	INSTANCE;

	private AdminDao dao;

	private AdminService() {
		dao = new AdminDao();
	}

	public int insertAdminProduct(ProductVo product) {
		return dao.insertAdminProduct(product);
	}

	public void selectAdminProduct() {
	}

	public List<ProductVo> selectAdminProducts() {
		return dao.selectAdminProducts();
	}

	public void updateAdminProduct() {
	}

	public void deleteAdminProduct() {
	}

	public MultipartRequest uploadFile(HttpServletRequest req, String path) throws IOException {
		int maxSize = 1024 * 1024 * 10;
		return new MultipartRequest(req, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
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

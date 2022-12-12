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

	public void insertAdminProduct() {}
	
	
	public List<ProductVo> selectAdminProducts(int limitStart) {
	 	return dao.selectAdminProducts(limitStart);
	}
	
	// paging
	
	// 현재 페이지 번호
	public int getCurrentPage(String pg) {
		int currentPage = 1;
		
		if(pg != null){
			currentPage = Integer.parseInt(pg);	
		}
		
		return currentPage;
	}
	
	// 전체 게시물 갯수
	public int selectCountTotal() {
		return dao.selectCountTotal();
	}
	
	// 마지막 페이지 번호
	public int getLastPageNum(int total) {
		
		int lastPageNum = 0;
		
		if(total % 10 == 0){
			lastPageNum = total / 10;
		}else{
			lastPageNum = total / 10 + 1;
		}
		
		return lastPageNum;
	}
	
	// 페이지 start, end 번호
	public int[] getPageGroupNum(int currentPage, int lastPageNum) {
		
		int currentPageGroup = (int)Math.ceil(currentPage / 10.0);
		
		int pageGroupStart = (currentPageGroup - 1) * 10 + 1;
		
		int pageGroupEnd = currentPageGroup * 10;
		
		if(pageGroupEnd > lastPageNum){
			pageGroupEnd = lastPageNum;
		}
		
		int[] result = {pageGroupStart, pageGroupEnd};
		
		return result;
	}
	
	// 페이지 시작번호
	public int getPageStartNum(int total, int currentPage) {
		int start = (currentPage - 1) * 10;
		return total - start;
	}
	
	// 시작 인덱스
	public int getStartNum(int currentPage) {
		return (currentPage - 1) * 10;
	}
	
	


	public int insertAdminProduct(ProductVo product) {
		return dao.insertAdminProduct(product);
	}

	public void selectAdminProduct() {
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

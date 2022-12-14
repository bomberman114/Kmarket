package kr.co.Kmarket.service.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.Kmarket.dao.admin.AdminDao;
import kr.co.Kmarket.vo.ProductVo;

public enum AdminService {

	INSTANCE;

	private AdminDao dao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private AdminService() {
		dao = new AdminDao();
	}

	public List<ProductVo> selectAdminProducts(int limitStart) {
	 	return dao.selectAdminProducts(limitStart);
	}
	
	public List<ProductVo> selectAdminProductsByKeyword(String category, String keyword, int limitStart) {
		return dao.selectAdminProductsByKeyword(category, keyword, limitStart);
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


	public ProductVo renameFile(HttpServletRequest req, ProductVo product, String path, MultipartRequest mr) {
		try {
		
		
		}catch (Exception e) {
			// TODO: handle exception
		}	
		return product;
	}



	public void dirCreate(String targetDir) {
		File Directory = new File(targetDir);
		if(!Directory.exists()) Directory.mkdirs();
	}



	public ProductVo uploadFile2(HttpServletRequest req, String saveDirectory,ProductVo product, String path) {

		
		try {
			logger.info("AdminService uploadFile2...");
			
			// 이미지 파일 불러오기
			Part thumb1 = req.getPart("thumb1");
			Part thumb2 = req.getPart("thumb2");
			Part thumb3 = req.getPart("thumb3");
			Part detail = req.getPart("detail");
			
			// 이미지 파일 이름 변경
			String thumb1FileName = fileReName(getFileName(thumb1));
			String thumb2FileName = fileReName(getFileName(thumb2));
			String thumb3FileName = fileReName(getFileName(thumb3));
			String detailFileName = fileReName(getFileName(detail));
			
			// 이미지 파일 출력(저장)
			fileOutPut(thumb1FileName, thumb1, path);
			fileOutPut(thumb2FileName, thumb2, path);
			fileOutPut(thumb3FileName, thumb3, path);
			fileOutPut(detailFileName, detail, path);
			
			// vo에 저장
			product.setThumb1(thumb1FileName);
			product.setThumb2(thumb2FileName);
			product.setThumb3(thumb3FileName);
			product.setDetail(detailFileName);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		
		
		return product;
	}


	public void fileOutPut(String fileName, Part filePart, String path) {
		try {
			logger.info("adminService fileoutput....");
			// 파일 이름 및 경로 설정
			File file = new File(path+fileName);
			// 해당 이미지의 내용을 inputStream으로 가져옴
			InputStream is = filePart.getInputStream();
			// 파일 출력 준비
			FileOutputStream fos = null;
			
			fos = new FileOutputStream(file);
			
			int temp = -1;
			// inputStream으로 가져온 이미지를 byte 단위로 읽음
			// 더이상 읽을 byte가 없을 경우 -1을 반환
			while((temp = is.read()) != -1) {
				// 읽은 byte를 출력
				fos.write(temp);
			}
			
			// 종료
			is.close();
			fos.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public String fileReName(String fileName) {
		// 난수 생성
		String now = UUID.randomUUID().toString();
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String newFileName = now+ext;
		
		return newFileName;
	}
	
	 public String getFileName(Part filePart) {
	        for(String filePartData : filePart.getHeader("Content-Disposition").split(";")) {
	            if(filePartData.trim().startsWith("filename")) {
	                return filePartData.substring(filePartData.indexOf("=") + 1).trim().replace("\"", "");
	            }
	        }
	        
	        return null;
		 }
		
	

	


}
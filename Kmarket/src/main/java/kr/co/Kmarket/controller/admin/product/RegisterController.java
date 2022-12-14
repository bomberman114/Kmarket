package kr.co.Kmarket.controller.admin.product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream.GetField;
import java.util.UUID;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;

import kr.co.Kmarket.service.admin.AdminService;
import kr.co.Kmarket.vo.ProductVo;

@WebServlet("/admin/product/register.do")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	private AdminService service = AdminService.INSTANCE;

	@Override
	public void init() throws ServletException {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/register.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("상품등록 도착");
		logger.debug("상품등록 도착");
		ProductVo product = new ProductVo();
		// 파일 업로드
		ServletContext ctx = req.getServletContext();
		String path = ctx.getRealPath("/file");

		logger.debug("here1 : " + path);

		MultipartRequest mr = service.uploadFile(req, path);

	
		String saveDirectory = "/home/kmarket/thumb/" + prodCate1 + "/" + prodCate2 + "/";
		service.dirCreate(saveDirectory);
		
		

		product.setSeller(req.getParameter("seller"));
		
		product.setProdName(req.getParameter("prodName"));
		product.setProdCate1(req.getParameter("category1"));
		product.setProdCate2(req.getParameter("category2"));
		product.setDescript(req.getParameter("descript"));
		product.setCompany(req.getParameter("company"));
		product.setPrice(req.getParameter("price"));
		product.setDiscount(req.getParameter("discount"));
		product.setPoint("point");
		product.setStock(req.getParameter("stock"));
		product.setDelivery(req.getParameter("delivery"));
		product.setIp(req.getRemoteAddr());
		
		product.setStatus(req.getParameter("status"));
		product.setDuty(req.getParameter("duty"));
		product.setReceipt(req.getParameter("receipt"));
		product.setBizType(req.getParameter("bizType"));
		product.setOrigin(req.getParameter("origin"));

		// UUID로 변환을 위해서 숫자를 더붙임
		// String thumb11 = mr.getFilesystemName("thumb1"); // 썸내일 이미지1
		// String thumb22 = mr.getFilesystemName("thumb2"); // 썸내일 이미지2
		// String thumb33 = mr.getFilesystemName("thumb3"); // 썸내일 이미지3
		// String detail = mr.getFilesystemName("detail"); // 상세페이지 이미지

		String ip = req.getRemoteAddr(); // 상품등록 ip

		
		// if (thumb11 != null && thumb22 != null && thumb33 != null) {
		logger.debug("here2");
	
		// UUID thumb1 = UUID.fromString(thumb11);
		// UUID thumb2 = UUID.fromString(thumb22);
		// UUID thumb3 = UUID.fromString(thumb33);
		// UUID detail = UUID.fromString(detail);

	
		product.setIp(ip);

		// 상품등록 등록

		product = service.uploadFile2(req, saveDirectory, product, path);

		System.out.println("어드민 컨트롤러:" + product);

		// 파일 테이블 Insert
		int result = service.insertAdminProduct(product);

		// 파일을 첨부했으면

		logger.debug("here3");

		resp.sendRedirect("/admin/product/register.do");
	}

}

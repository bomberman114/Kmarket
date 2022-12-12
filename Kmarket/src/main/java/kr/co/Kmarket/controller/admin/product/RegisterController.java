package kr.co.Kmarket.controller.admin.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.oreilly.servlet.MultipartRequest;

import kr.co.Kmarket.service.admin.AdminService;
import kr.co.Kmarket.vo.ProductVo;


@WebServlet("/admin/product/register.do")
public class RegisterController extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	private AdminService service = AdminService.INSTANCE;

	
	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		// 파일 업로드
		ServletContext ctx = req.getServletContext();
		String path = ctx.getRealPath("/file");

		MultipartRequest mr = service.uploadFile(req, path);

		// multipart 폼 데이터 수신
		String prodNo = mr.getParameter("prodNo");
		String prodCate1 = mr.getParameter("prodCate1");
		String prodCate2 = mr.getParameter("prodCate2");
		String prodName = mr.getParameter("prodName");
		String descript = mr.getParameter("descript");
		String company = mr.getParameter("company");
		String seller = mr.getParameter("seller");
		String price = mr.getParameter("price");
		String discount = mr.getParameter("discount");
		String point = mr.getParameter("point");
		String stock = mr.getParameter("stock");
		String sold = mr.getParameter("sold");
		String delivery = mr.getParameter("delivery");
		String hit = mr.getParameter("hit");
		String score = mr.getParameter("score");
		String review = mr.getParameter("review");
		String thumb1 = mr.getParameter("thumb1");
		String thumb2 = mr.getParameter("thumb2");
		String thumb3 = mr.getParameter("thumb3");
		String detail = mr.getParameter("detail");
		String status = mr.getParameter("status");
		String duty = mr.getParameter("duty");
		String receipt = mr.getParameter("receipt");
		String bizType = mr.getParameter("bizType");
		String origin = mr.getParameter("origin");
		String ip = req.getRemoteAddr();

		ProductVo product = new ProductVo();
		
		product.setProdNo(Integer.parseInt(String.valueOf(prodNo)));
		product.setProdCate1(Integer.parseInt(String.valueOf(prodCate1)));
		product.setProdCate2(Integer.parseInt(String.valueOf(prodCate2)));
		product.setProdName(prodName);
		product.setDescript(descript);
		product.setCompany(company);
		product.setSeller(seller);
		product.setPrice(Integer.parseInt(String.valueOf(price)));
		product.setDiscount(Integer.parseInt(String.valueOf(discount)));
		product.setPoint(Integer.parseInt(String.valueOf(point)));
		product.setStock(Integer.parseInt(String.valueOf(stock)));
		product.setSold(Integer.parseInt(String.valueOf(sold)));
		product.setDelivery(Integer.parseInt(String.valueOf(delivery)));
		product.setHit(Integer.parseInt(String.valueOf(hit)));
		product.setScore(Integer.parseInt(String.valueOf(score)));
		product.setReview(Integer.parseInt(String.valueOf(review)));
		product.setThumb1(thumb1);
		product.setThumb2(thumb2);
		product.setThumb3(thumb3);
		product.setDetail(detail);
		product.setStatus(status);
		product.setDuty(duty);
		product.setReceipt(receipt);
		product.setBizType(bizType);
		product.setOrigin(origin);
		product.setIp(ip);
		System.out.println("어드민 컨트롤러:"+product);
		// 글 등록
		int parent = service.insertAdminProduct(product);

		// 파일을 첨부했으면
		if (thumb1 != null && thumb2 != null && thumb3 != null ) {
			// 파일명 수정
			//String newName = service.renameFile(fname, uid, path);

			// 파일 테이블 Insert
		//	service.insertFile(parent, newName, fname);
		}

		resp.sendRedirect("/Jboard2/list.do");

	

	}
	
}

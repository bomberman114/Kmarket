package kr.co.Kmarket.controller.admin.product;

import java.io.IOException;
import java.util.UUID;

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
	public void init() throws ServletException {
	}

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
		String uid = mr.getParameter("uid");

		// multipart 폼 데이터 수신
		String prodCate1 = mr.getParameter("prodCate1"); //1차카테고리
		String prodCate2 = mr.getParameter("prodCate2"); //2차 카테고리
		String prodName = mr.getParameter("prodName"); //상품명
		String descript = mr.getParameter("descript"); //기본설명
		String company = mr.getParameter("company"); //제조회사
		String seller = mr.getParameter("uid"); // 판매자
		String price = mr.getParameter("price"); // 판매가격
		String discount = mr.getParameter("discount"); //할인율
		String point = mr.getParameter("point"); // 포인트
		String stock = mr.getParameter("stock"); // 재고수량
		String delivery = mr.getParameter("delivery");//배송비
		 //UUID로 변환을 위해서 숫자를 더붙임
		String thumb11 = mr.getParameter("thumb1");    //썸내일 이미지1 
		String thumb22 = mr.getParameter("thumb2");  //썸내일 이미지2
		String thumb33 = mr.getParameter("thumb3");  //썸내일 이미지3
		String detail = mr.getParameter("detail"); //상세페이지 이미지
		String status = mr.getParameter("status"); //제품상태
		String duty = mr.getParameter("duty"); //부가세 면세여부
		String receipt = mr.getParameter("receipt"); //영수증 발행
		String bizType = mr.getParameter("bizType"); //사업자 구분
		String origin = mr.getParameter("origin"); //원산지
		String ip = req.getRemoteAddr(); //상품등로 ip

		ProductVo product = new ProductVo();

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
		product.setDelivery(Integer.parseInt(String.valueOf(delivery)));
	
		product.setThumb1(thumb11);
		product.setThumb2(thumb22);
		product.setThumb3(thumb33);
		product.setDetail(detail);
		product.setStatus(status);
		product.setDuty(duty);
		product.setReceipt(receipt);
		product.setBizType(bizType);
		product.setOrigin(origin);
		product.setIp(ip);

		System.out.println("어드민 컨트롤러:" + product);
		// 글 등록
		int parent = service.insertAdminProduct(product);

		// 파일을 첨부했으면
		if (thumb11 != null && thumb22 != null && thumb33 != null) {
			// 파일명 수정
			
			UUID thumb1 = UUID.fromString(thumb11);
			UUID thumb2 = UUID.fromString(thumb22);
			UUID thumb3 = UUID.fromString(thumb33);

			 String newName = service.renameFile(thumb1,thumb2,thumb3,uid, path);

			// 파일 테이블 Insert
			 service.insertFile(parent, newName, thumb1,thumb2,thumb3);
		}

		resp.sendRedirect("kmarket/admin/product/register.do");

	}

}

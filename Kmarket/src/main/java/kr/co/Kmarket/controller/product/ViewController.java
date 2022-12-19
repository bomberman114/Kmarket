package kr.co.Kmarket.controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.product.ProductService;
import kr.co.Kmarket.vo.ProductCartVo;
import kr.co.Kmarket.vo.ProductVo;

@WebServlet("/product/view.do")
public class ViewController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int cate1 = Integer.parseInt(req.getParameter("cate1"));
		int cate2 = Integer.parseInt(req.getParameter("cate2"));
		int prodNo = Integer.parseInt(req.getParameter("prodNo"));
		
		// 카테고리 이름 가져오기
		String cateName[] = service.getCateName(cate1, cate2);
		
		// 상품 가져오기
		ProductVo product = service.selectProduct(prodNo);
		
		req.setAttribute("c1Name", cateName[0]);
		req.setAttribute("c2Name", cateName[1]);
		req.setAttribute("product", product);
		
		
		// 조회수 +1;
		service.updateProductHit(prodNo);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/view.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 장바구니 담기
		String uid = req.getParameter("uid");
		int prodNo = Integer.parseInt(req.getParameter("prodNo"));
		int count = Integer.parseInt(req.getParameter("count"));
		int price = Integer.parseInt(req.getParameter("price"));
		int discount = Integer.parseInt(req.getParameter("discount"));
		int point = Integer.parseInt(req.getParameter("point"));
		int delivery = Integer.parseInt(req.getParameter("delivery"));
		int total = count * price * (1- discount/100);

		
		ProductCartVo cart = new ProductCartVo();
		cart.setUid(uid);
		cart.setProdNo(prodNo);
		cart.setCount(count);
		cart.setPrice(price);
		cart.setDiscount(discount);
		cart.setPoint(point);
		cart.setDelivery(delivery);
		cart.setTotal(total);
		
		service.insertCart(cart);
	
	}
	
}

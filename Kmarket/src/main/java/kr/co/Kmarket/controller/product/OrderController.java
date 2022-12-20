package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;

import kr.co.Kmarket.service.product.ProductService;
import kr.co.Kmarket.vo.MemberVo;
import kr.co.Kmarket.vo.ProductCartVo;

@WebServlet("/product/order.do")
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE;
	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.info("orderController...");
		
		// 세션에서 가져오기
		HttpSession sess = req.getSession();
		MemberVo sessUser = (MemberVo) sess.getAttribute("sessUser");
		String uid = sessUser.getUid();

		// 장바구니 상품 띄우기
		// List<ProductCartVo> product = service.selectOrderProduct(uid);
		
		// req.setAttribute("product", product);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/order.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
}

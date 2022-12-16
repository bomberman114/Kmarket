package kr.co.Kmarket.controller.admin.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import kr.co.Kmarket.service.admin.AdminService;

@WebServlet("/admin/product/delete.do")
public class DeleteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private AdminService service = AdminService.INSTANCE;
	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("도착!");
		String prodNo = req.getParameter("prodNo");
		
		logger.debug("prodNo: " + prodNo);
		
		int result = service.deleteAdminProduct(prodNo);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/list.jsp");
		dispatcher.forward(req, resp);
		
		
		
	}
}

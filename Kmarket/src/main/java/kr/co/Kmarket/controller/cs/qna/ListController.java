package kr.co.Kmarket.controller.cs.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cs/qna/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 자주묻는 질문 그룹 
		int cate1 = Integer.parseInt(req.getParameter("cate1"));
		String c1name = null;
		
		switch(cate1) {
		case 1:
			c1name = "회원";
		    
			break;
		case 2:
			c1name = "쿠폰/이벤트";
			break;
		case 3:
			c1name = "주문/결제";
			break;
		case 4:
			c1name = "배송";
			break;
		case 5:
			c1name = "취소/반품/교환";
			break;
		case 6:
			c1name = "여행/숙박/항공";
			break;
		case 7:
			c1name = "안전거래";
			break;
		}
		
		req.setAttribute("cate1", cate1);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/qna/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}

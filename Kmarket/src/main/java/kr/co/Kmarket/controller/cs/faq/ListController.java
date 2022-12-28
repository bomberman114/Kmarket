package kr.co.Kmarket.controller.cs.faq;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.service.cs.CsService;
import kr.co.Kmarket.vo.csFaqVo;

@WebServlet("/cs/faq/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsService service = CsService.INSTANCE;
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cate1 = Integer.parseInt(req.getParameter("cate1"));
		//int cate2 = Integer.parseInt(req.getParameter("cate2"));
		
		List<csFaqVo> cateName = service.selectCateName(cate1);
		
		
		req.setAttribute("cate1", cate1);
		req.setAttribute("cateName", cateName);
		/*
		List<csFaqVo> csFaq1 = null;
		List<csFaqVo> csFaq2 = null;
		csFaq1 = service.selectFaq1(cate1, cate2);
		csFaq2 = service.selectFaq2(cate1, cate2);
		System.out.println("faq 리스트1:"+csFaq1);
		System.out.println("faq 리스트1:"+csFaq2);
		
		req.setAttribute("csFaq1", csFaq1);
		req.setAttribute("csFaq2", csFaq2);
		*/
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/faq/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}

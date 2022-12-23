package kr.co.Kmarket.controller.admin.cs.faq;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.service.admin.AdminService;

@WebServlet("/admin/cs/faq/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AdminService service = AdminService.INSTANCE;

	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void init() throws ServletException {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int cate = Integer.parseInt(req.getParameter("cate"));
		String pg = req.getParameter("pg");

		// 현재 페이지 번호
		int currentPage = service.getCurrentPage(pg);

		// 전체 게시물 갯수
		int total = service.selectFaqTotal(cate);

		// 페이지 마지막 번호
		int lastPageNum = service.getLastPageNum(total);

		// 페이지 그룹 start, end 번호
		int[] pageGroup = service.getPageGroupNum(currentPage, lastPageNum);

		// 시작 인덱스
		int start = service.getStartNum(currentPage);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/faq/list.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}

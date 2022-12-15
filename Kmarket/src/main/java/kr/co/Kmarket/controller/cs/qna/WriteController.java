package kr.co.Kmarket.controller.cs.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.cs.CsService;
import kr.co.Kmarket.vo.QnaArticleVo;

@WebServlet("/cs/qna/write.do")
public class WriteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsService service = CsService.INSTANCE;
	
	@Override
	public void init() throws ServletException {}
	
	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate1 = req.getParameter("cate1");
		
		req.setAttribute("cate1", cate1);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/qna/write.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("uid");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		
		QnaArticleVo vo = new QnaArticleVo();
		vo.setUid(uid);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setCate1(cate1);
		vo.setCate2(cate2);
		
		service.insertQnaArticle(vo);
		
		
		
		resp.sendRedirect("/Kmarket/cs/qna/list.do");
		
		
	
	}
	
}

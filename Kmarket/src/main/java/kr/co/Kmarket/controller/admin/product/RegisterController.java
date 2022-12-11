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
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String uid = mr.getParameter("uid");
		String fname = mr.getFilesystemName("fname");
		String regip = req.getRemoteAddr();

		ProductVo product = new ProductVo();
		/*
		product.setTitle(title);
		article.setContent(content);
		article.setUid(uid);
		article.setFname(fname);
		article.setRegip(regip);
		*/

		// 글 등록
		int parent = service.insertArticle(product);

		// 파일을 첨부했으면
		if (fname != null) {
			// 파일명 수정
			String newName = service.renameFile(fname, uid, path);

			// 파일 테이블 Insert
			service.insertFile(parent, newName, fname);
		}

		resp.sendRedirect("/Jboard2/list.do");

	
	}
	
}

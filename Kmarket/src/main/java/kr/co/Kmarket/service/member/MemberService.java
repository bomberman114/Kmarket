package kr.co.Kmarket.service.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.Kmarket.dao.member.MemberDao;
import kr.co.Kmarket.vo.MemberVo;
import kr.co.Kmarket.vo.TermsVo;

public enum MemberService {

	
	INSTANCE;
	private  MemberDao dao;
	
	private MemberService() {
		dao = new MemberDao();
	}

	public MemberVo selectMemberBySessId(String sessId) {
		return dao.selectMemberBySessId(sessId);
	}

	public MemberVo selectMember(String uid, String pass) {
		return dao.selectMember(uid, pass);
	}
	
	public TermsVo selectTerms() {
		return dao.selectTerms();
	}

	public int selectCountUid(String uid) {
		return dao.selectCountUid(uid); 
	}
	
	
	
	public void updateMemberForSessLimitDate(String sessId) {
		dao.updateMemberForSessLimitDate(sessId);
	}

	public void updateMemberForSession(String uid, String sessId) {
		dao.updateMemberForSession(uid, sessId);
	}

	public void updateMemberForSessionOut(String uid) {
		dao.updateMemberForSessionOut(uid);
	}
	
	// 추가적인 서비스 로직
	public void sendResult(int result, HttpServletResponse resp) throws IOException {
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);

		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
	}
	
}

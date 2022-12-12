package kr.co.Kmarket.service.member;

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
	
	public TermsVo selectMemberTerms() {
		return dao.selectMemberTerms();
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
	
	
}

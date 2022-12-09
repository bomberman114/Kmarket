package kr.co.Kmarket.service.member;

import kr.co.Kmarket.dao.member.MemberDao;
import kr.co.Kmarket.vo.MemberVo;

public enum MemberService {

	
	INSTANCE;
	private  MemberDao dao;
	
	private MemberService() {
		dao = new MemberDao();
	}

	public void updateMemberForSessLimitDate(String sessId) {
		
	}

	public MemberVo selectMemberBySessId(String sessId) {
		return null;
	}
	
	
}

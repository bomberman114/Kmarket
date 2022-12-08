package kr.co.Kmarket.service.member;

import kr.co.Kmarket.dao.member.MemberDao;

public enum MemberService {

	
	INSTANCE;
	private  MemberDao dao;
	
	private MemberService() {
		dao = new MemberDao();
	}
	
	
}

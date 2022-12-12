package kr.co.Kmarket.db;

public class MemberSql {
	
	public static final String SELECT_TERMS = "SELECT * FROM `km_member_terms`";

	public static final String SELECT_COUNT_UID = "select count(`uid`) from `km_member` where `uid`=?";
	
	
	
}

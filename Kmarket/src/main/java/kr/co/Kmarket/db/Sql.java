package kr.co.Kmarket.db;

public class Sql {

	public static final String SELECT_MEMBER_TERMS = "SELECT * FROM `km_member_terms`";
	
	public static final String SELECT_USER  = "select * from `km_member` where `uid`=? and `pass`=SHA2(?, 256)";
	public static final String SELECT_MEMBER_BY_SESSID =  "SELECT * FROM `km_member` WHERE `sessId`=? AND `sessLimitDate` > NOW()";
	public static final String UPDATE_MEMBER_FOR_SESSION = "UPDATE `km_member` SET `sessId`=?, `sessLimitDate` = DATE_ADD(NOW(), INTERVAL 3 DAY) WHERE `uid`=?";
	public static final String UPDATE_MEMBER_FOR_SESS_LIMIT_DATE = "UPDATE `km_member` SET `sessLimitDate` = DATE_ADD(NOW(), INTERVAL 3 DAY) WHERE `sessId`=?";
	public static final String UPDATE_MEMBER_FOR_SESSION_OUT = "UPDATE `km_member` SET `sessId`=NULL, `sessLimitDate`=NULL WHERE `uid`=?";
	
	public static final String SELECT_ADMIN_PRODUCTS = "select * from `km_product`";
	
	
}

package kr.co.Kmarket.db;

public class Sql {
	
	public static final String SELECT_MEMBER  = "select * from `km_member` where `uid`=? and `pass`=SHA2(?, 256)";
	
	public static final String SELECT_MEMBER_BY_SESSID =  "SELECT * FROM `km_member` WHERE `sessId`=? AND `sessLimitDate` > NOW()";
	public static final String UPDATE_MEMBER_FOR_SESSION = "UPDATE `km_member` SET `sessId`=?, `sessLimitDate` = DATE_ADD(NOW(), INTERVAL 3 DAY) WHERE `uid`=?";
	public static final String UPDATE_MEMBER_FOR_SESS_LIMIT_DATE = "UPDATE `km_member` SET `sessLimitDate` = DATE_ADD(NOW(), INTERVAL 3 DAY) WHERE `sessId`=?";
	public static final String UPDATE_MEMBER_FOR_SESSION_OUT = "UPDATE `km_member` SET `sessId`=NULL, `sessLimitDate`=NULL WHERE `uid`=?";
	
	// admin
	public static final String SELECT_ADMIN_PRODUCTS = "select * from `km_product`";

	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(`prodNo`) FROM `km_product` limit ?, 10";

	public static final String INSERT_ADMIN_PRODUCT = "insert into `km_product` set "
														+ "`prodNo`=?,"
														+ "`prodCate1`=?,"
														+ "`prodCate2`=?,"
														+ "`prodname`=?,"
														+ "`descript`=?,"
														+ "`company`=?,"
														+ "`seller`=?," //판매자
														+ "`price`=?,"
														+ "`discount`=?,"
														+ "`point`=?,"
														+ "`stock`=?,"
														+ "`delivery`=?,"
														+ "`thumb1`=?,"
														+ "`thumb2`=?,"
														+ "`thumb3`=?,"
														+ "`detail`=?,"
														+ "`status`=?,"
														+ "`duty`=?,"
														+ "`receipt`=?,"
														+ "`bizType`=?,"
														+ "`origin`=?,"
														+ "`ip`=?,"
														+ "`rate`=NOW()";

	public static final String SELECT_MAX_NO = "SELECT MAX(`no`) FROM `km_product`";

	
										

	
	
}

package kr.co.Kmarket.db;

public class Sql {
	
	public static final String SELECT_MEMBER  = "select * from `km_member` where `uid`=? and `pass`=SHA2(?, 256)";
	
	public static final String SELECT_MEMBER_BY_SESSID =  "SELECT * FROM `km_member` WHERE `sessId`=? AND `sessLimitDate` > NOW()";
	public static final String UPDATE_MEMBER_FOR_SESSION = "UPDATE `km_member` SET `sessId`=?, `sessLimitDate` = DATE_ADD(NOW(), INTERVAL 3 DAY) WHERE `uid`=?";
	public static final String UPDATE_MEMBER_FOR_SESS_LIMIT_DATE = "UPDATE `km_member` SET `sessLimitDate` = DATE_ADD(NOW(), INTERVAL 3 DAY) WHERE `sessId`=?";
	public static final String UPDATE_MEMBER_FOR_SESSION_OUT = "UPDATE `km_member` SET `sessId`=NULL, `sessLimitDate`=NULL WHERE `uid`=?";
	
	// admin
	
	// 일반 판매자
	public static final String SELECT_ADMIN_PRODUCTS = "select a.* from `km_product` as a "
														+ "join `km_member` as b "
														+ "on a.seller = b.uid "
														+ "where `uid` = ? "
														+ "order by `prodNo` desc "
														+ "limit ?, 10";
	
	public static final String SELECT_ADMIN_PRODUCTS_BY_PRODNAME = "select a.* from `km_product` as a "
																+ "join `km_member` as b "
																+ "on a.seller = b.uid "
																+ "where `uid` = ? and `prodName` like ? "
																+ "order by `prodNo` desc "
																+ "limit ?, 10";

	public static final String SELECT_ADMIN_PRODUCTS_BY_PRODNO = "select a.* from `km_product` as a "
																+ "join `km_member` as b "
																+ "on a.seller = b.uid "
																+ "where `uid` = ? and `prodNo` like ? "
																+ "order by `prodNo` desc "
																+ "limit ?, 10";

	public static final String SELECT_ADMIN_PRODUCTS_BY_SELLER = "select a.* from `km_product` as a "
																+ "join `km_member` as b "
																+ "on a.seller = b.uid "
																+ "where `uid` = ? and `seller` like ? "
																+ "order by `prodNo` desc "
																+ "limit ?, 10";
	
	// 최고 관리자
	public static final String SELECT_ADMIN_PRODUCTS7 = "select * from `km_product` "
														+ "order by `prodNo` desc "
														+ "limit ?, 10";
	
	public static final String SELECT_ADMIN_PRODUCTS_BY_PRODNAME7 = "select * from `km_product` "
			     													+ "where `prodName` like ? "
			     													+ "order by `prodNo` desc "
			     													+ "limit ?, 10";
	
	public static final String SELECT_ADMIN_PRODUCTS_BY_PRODNO7 = "select * from `km_product` "
																+ "where `prodNo` like ? "
																+ "order by `prodNo` desc "
																+ "limit ?, 10";
	
	public static final String SELECT_ADMIN_PRODUCTS_BY_SELLER7 = "select * from `km_product` "
																+ "where `seller` like ? "
																+ "order by `prodNo` desc "
																+ "limit ?, 10";
	
	

	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(`prodNo`) FROM `km_product`";

	public static final String INSERT_ADMIN_PRODUCT = 	"INSERT INTO `km_product` SET "
														+ "`prodCate1`=?, "
														+ "`prodCate2`=?, "
														+ "`prodName`=?, "
														+ "`descript`=?, "
														+ "`company`=?, "
														+ "`seller`=?, "
														+ "`price`=?, "
														+ "`discount`=?, "
														+ "`point`=?, "
														+ "`stock`=?, "
														+ "`delivery`=?, "
														+ "`thumb1`=?, "
														+ "`thumb2`=?, "
														+ "`thumb3`=?, "
														+ "`detail`=?, "
														+ "`status`=?, "
														+ "`duty`=?, "
														+ "`receipt`=?, "
														+ "`bizType`=?, "
														+ "`origin`=?, "
														+ "`ip`=?, "
														+ "`rdate`=NOW()";
	

	public static final String SELECT_MAX_NO = "SELECT MAX(`no`) FROM `km_product`";

	public static final String SELECT_ADMIN_PRODUCT_CATE1 = "SELECT * FROM `km_product_cate1`";

	public static final String SELECT_ADMIN_PRODUCT_CATE2 = "SELECT * FROM `km_product_cate2` WHERE `cate1`=?";

	public static final String SELECT_ORDER_COUNT = "SELECT COUNT(`ordNo`) FROM `km_product_order`";

	public static final String SELECT_ORDER_COUNT_Y =  "SELECT DATE_FORMAT(rdate, 	NOW()-1 ) AS date, count(`orderNo`) AS cnt " 
														+"FROM `km_product_order`"
														+"GROUP BY DATE_FORMAT(rdate, NOW()) ORDER BY date DESC";

	
	public static final String SELECT_ORDER_COUNT_W =  "SELECT DATE_FORMAT(rdate, 	NOW()-6 ) AS date, count(`orderNo`) AS cnt " 
														+"FROM `km_product_order` "
														+"GROUP BY DATE_FORMAT(rdate, NOW()) ORDER BY date DESC";

	
	public static final String SELECT_ORDER_COUNT_M =  "SELECT DATE_FORMAT(rdate, 	NOW()-30 ) AS date, count(`orderNo`) AS cnt " 
														+"FROM `km_product_order` "
														+"GROUP BY DATE_FORMAT(rdate, NOW()) ORDER BY date DESC";

	public static final String SELECT_MEMBER_COUNT = "SELECT COUNT(`uid`) FROM `km_member`";
	
	public static final String SELECT_MEMBER_COUNT_Y ="SELECT DATE_FORMAT(rdate, NOW()-1) AS date, COUNT(`uid`) AS cnt " 
														+"FROM `km_member` "
														+"GROUP BY DATE_FORMAT(rdate, NOW()) ORDER BY date DESC";

	public static final String SELECT_MEMBER_COUNT_W = "SELECT DATE_FORMAT(rdate, NOW()-6) AS date, COUNT(`uid`) AS cnt " 
															+"FROM `km_member` "
															+"GROUP BY DATE_FORMAT(rdate, NOW()) ORDER BY date DESC";
	
	public static final String SELECT_MEMBER_COUNT_M = "SELECT DATE_FORMAT(rdate, NOW()-30) AS date, COUNT(`uid`) AS cnt " 
														+"FROM `km_member` "
														+"GROUP BY DATE_FORMAT(rdate, NOW()) ORDER BY date DESC";

	public static final String SELECT_ORDER_PRICE = "SELECT SUM(`price`)  FROM  `km_product`" ;
	
	public static final String SELECT_ORDER_PRICE_Y = "SELECT DATE_FORMAT(rdate, NOW()-1) AS date, SUM(`price`) AS cnt " 
														+"FROM `km_product` "
														+"GROUP BY DATE_FORMAT(rdate, NOW()) ORDER BY date DESC";
	
	public static final String SELECT_ORDER_PRICE_W =  "SELECT DATE_FORMAT(rdate, NOW()-6 ) AS date, SUM(`price`) AS cnt " 
														+"FROM `km_product` "
														+"GROUP BY DATE_FORMAT(rdate, NOW()) ORDER BY date DESC";

	public static final String SELECT_ORDER_PRICE_M = "SELECT DATE_FORMAT(rdate, NOW()-30 ) AS date, SUM(`price`) AS cnt " 
														+"FROM `km_product` "
														+"GROUP BY DATE_FORMAT(rdate, NOW()) ORDER BY date DESC";


	public static final String SELECT_PRODUCT_COUNT =  "SELECT COUNT(`prodNo`) FROM `km_product`";




	public static final String SELECT_PRODUCT_Y = "SELECT DATE_FORMAT(rdate, 	NOW()-1 ) AS date, count(`prodNo`) AS cnt " 
													+"FROM `km_product` "
													+"GROUP BY DATE_FORMAT(rdate, NOW()) ORDER BY date DESC";
	
	public static final String SELECT_PRODUCT_W =  "SELECT DATE_FORMAT(rdate, 	NOW()-6 ) AS date, count(`prodNo`) AS cnt " 
														+"FROM `km_product` "
														+"GROUP BY DATE_FORMAT(rdate, NOW()) ORDER BY date DESC";

	public static final String SELECT_PRODUCT_M =  "SELECT DATE_FORMAT(rdate, 	NOW()-30 ) AS date, count(`prodNo`) AS cnt " 
														+"FROM `km_product` "
														+"GROUP BY DATE_FORMAT(rdate, NOW()) ORDER BY date DESC";

	public static final String SELECT_MAIN_DISCOUNT_PRODUCTS =" SELECT * FROM km_product ORDER BY discount  DESC LIMIT 8 ";
													


	public static final String DELETE_PRODUCT = "DELETE  FROM km_product WHERE `prodNo` = ? ";
	
	public static final String DELETE_PRODUCT_LIST = "DELETE  FROM km_product WHERE `prodNo` = ? ";

	public static final String SELECT_MAIN_HIT_PRODUCTS = " SELECT * FROM km_product ORDER BY HIT  DESC LIMIT 8 ";

	public static final String SELECT_MAIN_NEW_PRODUCTS =" SELECT * FROM km_product ORDER BY rdate  DESC LIMIT 8 ";

	public static final String SELECT_MAIN_SCORE_PRODUCTS =" SELECT * FROM km_product ORDER BY score  DESC LIMIT 8 ";

	public static final String SELECT_MAIN_BEST_PRODUCTS = " SELECT * FROM km_product ORDER BY sold  DESC  LIMIT 1,5 ";

	public static final String SELECT_MAIN_BEST1_PRODUCT = " SELECT * FROM km_product ORDER BY sold  DESC LIMIT 1 ";


	// admin - notice
	
	public static final String INSERT_NOTICE = "INSERT INTO `km_cs_notice_board` (`cate`, `title`, `content`, `uid`, `regip`, `rdate`, `cateName`) VALUES( ?, ?, ?, ?, ?, NOW(), ?)";

	public static final String SELECT_COUNT_NOTICE_TOTAL = "SELECT COUNT(`no`) FROM `km_cs_notice_board`";
	public static final String SELECT_COUNT_NOTICE_TOTAL_FOR_CATE = "SELECT COUNT(`no`) FROM `km_cs_notice_board` WHERE `cate`=?";

	
	public static final String SELECT_NOTICE = "SELECT * FROM `km_cs_notice_board` WHERE `no` = ?";
	public static final String SELECT_NOTICES = "SELECT * FROM `km_cs_notice_board` ORDER BY `no` DESC LIMIT ?,10;";
	public static final String SELECT_NOTICES_BY_CATE = "SELECT * FROM `km_cs_notice_board` WHERE `cate`=? ORDER BY `no` DESC LIMIT ?,10;";

	public static final String DELETE_NOTICE = "DELETE FROM `km_cs_notice_board` WHERE `no`=?";
	
	public static final String UPDATE_NOTICE_HIT = "UPDATE `km_cs_notice_board` SET `hit`= `hit`+1  WHERE `no` = ?";
	
	public static final String UPDATE_NOTICE = "UPDATE `km_cs_notice_board` SET `cate`=?, `cateName`=?, `title`=?, `content`=? WHERE `no`=?";
	
	
	// admin - Faq
	public static final String SELECT_COUNT_FAQ_TOTAL = "SELECT COUNT(`no`) FROM `km_cs_faq_board`";

	public static final String SELECT_COUNT_FAQ_TOTAL_FOR_CATE =  "SELECT COUNT(`no`) FROM `km_cs_faq_board` WHERE `cate`=?";

	public static final String SELECT_ADMIN_FAQ_CATE2 =  "SELECT * FROM `km_ca_faq_cate2` WHERE `cate1`=?";


	
}

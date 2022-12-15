package kr.co.Kmarket.db;

public class Sql {
	
	public static final String SELECT_MEMBER  = "select * from `km_member` where `uid`=? and `pass`=SHA2(?, 256)";
	
	public static final String SELECT_MEMBER_BY_SESSID =  "SELECT * FROM `km_member` WHERE `sessId`=? AND `sessLimitDate` > NOW()";
	public static final String UPDATE_MEMBER_FOR_SESSION = "UPDATE `km_member` SET `sessId`=?, `sessLimitDate` = DATE_ADD(NOW(), INTERVAL 3 DAY) WHERE `uid`=?";
	public static final String UPDATE_MEMBER_FOR_SESS_LIMIT_DATE = "UPDATE `km_member` SET `sessLimitDate` = DATE_ADD(NOW(), INTERVAL 3 DAY) WHERE `sessId`=?";
	public static final String UPDATE_MEMBER_FOR_SESSION_OUT = "UPDATE `km_member` SET `sessId`=NULL, `sessLimitDate`=NULL WHERE `uid`=?";
	
	// admin
	public static final String SELECT_ADMIN_PRODUCTS = "select `thumb1`, `prodNo`, `prodName`, `price`, `discount`, `point`, `stock`, `seller`, `hit` from `km_product` limit ?, 10";
	
	public static final String SELECT_ADMIN_PRODUCTS_BY_PRODNAME = "select `thumb1`, `prodNo`, `prodName`, `price`, `discount`, `point`, `stock`, `seller`, `hit` from `km_product` where `prodName` like ? limit ?, 10";
	public static final String SELECT_ADMIN_PRODUCTS_BY_PRODNO = "select `thumb1`, `prodNo`, `prodName`, `price`, `discount`, `point`, `stock`, `seller`, `hit` from `km_product` where `prodNo` like ? limit ?, 10";
	public static final String SELECT_ADMIN_PRODUCTS_BY_COMPANY = "select `thumb1`, `prodNo`, `prodName`, `price`, `discount`, `point`, `stock`, `seller`, `hit` from `km_product` where `company` like ? limit ?, 10";
	public static final String SELECT_ADMIN_PRODUCTS_BY_SELLER = "select `thumb1`, `prodNo`, `prodName`, `price`, `discount`, `point`, `stock`, `seller`, `hit` from `km_product` where `seller` like ? limit ?, 10";

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

	public static final String SELECT_ORDER_COUNT = "SELECT COUNT(`orddNo`) FROM `km_product_order`";

	public static final String SELECT_MEMBER_COUNT = "SELECT COUNT(`uid`) FROM `km_member`";

	public static final String SELECT_ORDER_PRICE = "SELECT SUM(`price`)  FROM  `km_product`" ;

	public static final String SELECT_PRODUCT_Y = "SELECT DATE_FORMAT(rdate, 	NOW()-1 ) AS date, count(`prodNo`) AS cnt" 
													+"FROM `km_product`"
													+"GROUP BY DATE_FORMAT(rdate, NOW()) ORDER BY date DESC";

	public static final String SELECT_PRODUCT_COUNT =  "SELECT COUNT(`prodNo`) FROM `km_product`";

										

	
	
}

package kr.co.Kmarket.db;

public class ProductSql {

	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(`prodNo`) FROM `km_product` WHERE `prodCate1`=? AND `prodCate2`=?";
	

	
	public static final String SELECT_PRODUCTS_SOLD = "SELECT a.*, FLOOR(`price` * (1 - `discount` / 100)) AS `disPrice` "
														+ "FROM `km_product` AS a WHERE `prodCate1`=? AND `prodCate2`=? "
														+ "ORDER BY `sold` DESC LIMIT ?, 10 ";
	
	public static final String SELECT_PRODUCTS_LOWPRICE = "SELECT a.*, FLOOR(`price` * (1 - `discount` / 100)) AS `disPrice` "
														+ "FROM `km_product` AS a WHERE `prodCate1`=? AND `prodCate2`=? "
														+ "ORDER BY `price` ASC LIMIT ?, 10 ";
	
	public static final String SELECT_PRODUCTS_HIGHPRICE = "SELECT a.*, FLOOR(`price` * (1 - `discount` / 100)) AS `disPrice` "
														+ "FROM `km_product` AS a WHERE `prodCate1`=? AND `prodCate2`=? "
														+ "ORDER BY `price` DESC LIMIT ?, 10 ";
	
	public static final String SELECT_PRODUCTS_SCORE = "SELECT a.*, FLOOR(`price` * (1 - `discount` / 100)) AS `disPrice` "
														+ "FROM `km_product` AS a WHERE `prodCate1`=? AND `prodCate2`=? "
														+ "ORDER BY `score` DESC LIMIT ?, 10 ";
	
	public static final String SELECT_PRODUCTS_REVIEW = "SELECT a.*, FLOOR(`price` * (1 - `discount` / 100)) AS `disPrice` "
														+ "FROM `km_product` AS a WHERE `prodCate1`=? AND `prodCate2`=? "
														+ "ORDER BY `review` DESC LIMIT ?, 10 ";
	
	public static final String SELECT_PRODUCTS_RDATE = "SELECT a.*, FLOOR(`price` * (1 - `discount` / 100)) AS `disPrice` "
														+ "FROM `km_product` AS a WHERE `prodCate1`=? AND `prodCate2`=? "
														+ "ORDER BY `rdate` DESC LIMIT ?, 10 ";
	
	
	
	
	
	public static final String SELECT_CATE_NAME = "SELECT a.c1Name, b.c2Name FROM `km_product_cate1` AS a " 
											  	+"JOIN `km_product_cate2` AS b "
											  	+"ON a.cate1 = b.cate1 WHERE b.cate1=? AND b.cate2=?";
	
	//-----------현길
	
	public static final String SELECT_CART_PRODUCTS =" SELECT *  FROM km_product  "
													+"	LEFT JOIN km_product_cart ON km_product.prodNo=  km_product_cart.prodNo WHERE seller = '?'";


}

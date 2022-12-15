package kr.co.Kmarket.db;

public class ProductSql {

	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(`prodNo`) FROM `km_product` WHERE `prodCate1`=? AND `prodCate2`=?";
	
	public static final String SELECT_PRODUCTS_SOLD = "SELECT * FROM `km_product` WHERE `prodCate1`=? AND `prodCate2`=? ORDER BY `sold` DESC";
	public static final String SELECT_PRODUCTS_LOWPRICE = "SELECT * FROM `km_product` WHERE `prodCate1`=? AND `prodCate2`=? ORDER BY `price` ASC";
	public static final String SELECT_PRODUCTS_HIGHPRICE = "SELECT * FROM `km_product` WHERE `prodCate1`=? AND `prodCate2`=? ORDER BY `price` DESC";
	public static final String SELECT_PRODUCTS_SCORE = "SELECT * FROM `km_product` WHERE `prodCate1`=? AND `prodCate2`=? ORDER BY `score` DESC";
	public static final String SELECT_PRODUCTS_REVEIW = "SELECT * FROM `km_product` WHERE `prodCate1`=? AND `prodCate2`=? ORDER BY `review` DESC";
	public static final String SELECT_PRODUCTS_RDATE = "SELECT * FROM `km_product` WHERE `prodCate1`=? AND `prodCate2`=? ORDER BY `rdate` DESC";

	public static final String SELECT_CATE_NAME = "SELECT a.c1Name, b.c2Name FROM `km_product_cate1` AS a " 
											  	+"JOIN `km_product_cate2` AS b "
											  	+"ON a.cate1 = b.cate1 WHERE b.cate1=? AND b.cate2=?";

}

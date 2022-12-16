package kr.co.Kmarket.dao.product;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.db.ProductSql;
import kr.co.Kmarket.vo.ProductVo;

public class ProductDao extends DBHelper {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 해빈
	
	public int selectCountTotal(int cate1, int cate2) {
		
		int total = 0;
		
		try {
			logger.info("selectCountTotal");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSql.SELECT_COUNT_TOTAL);
			psmt.setInt(1, cate1);
			psmt.setInt(2, cate2);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return total;
	}
	
	
	public List<ProductVo> selectProducts(int cate1, int cate2, String sort, int start) {
		
		List<ProductVo> products = new ArrayList<>();
		
		try {
			logger.info("selectProducts...");
			conn = getConnection();
			
			switch(sort) {
			case "sold":
				
				psmt = conn.prepareStatement(ProductSql.SELECT_PRODUCTS_SOLD);
				break;
				
			case "lowprice":
				
				psmt = conn.prepareStatement(ProductSql.SELECT_PRODUCTS_LOWPRICE);
				break;
				
			case "highprice":
				
				psmt = conn.prepareStatement(ProductSql.SELECT_PRODUCTS_HIGHPRICE);
				break;
				
			case "score":
				
				psmt = conn.prepareStatement(ProductSql.SELECT_PRODUCTS_SCORE);
				break;
				
			case "review":
				
				psmt = conn.prepareStatement(ProductSql.SELECT_PRODUCTS_REVIEW);
				break;
				
			case "rdate":
				psmt = conn.prepareStatement(ProductSql.SELECT_PRODUCTS_RDATE);
				break;
	
			}
			
			psmt.setInt(1, cate1);			
			psmt.setInt(2, cate2);	
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				ProductVo product = new ProductVo();
				int prodCate1 = rs.getInt("prodCate1");
				int prodCate2 = rs.getInt("prodCate2");
				String path = "/thumb/" + prodCate1 + "/" + prodCate2 + "/";
				
				product.setProdNo(rs.getInt("prodNo"));
				product.setProdCate1(prodCate1);
				product.setProdCate2(prodCate2);
				product.setProdName(rs.getString("prodName"));
				product.setDescript(rs.getString("descript"));
				product.setCompany(rs.getString("company"));
				product.setSeller(rs.getString("seller"));
				product.setPrice(rs.getInt("price"));
				product.setDiscount(rs.getInt("discount"));
				product.setPoint(rs.getInt("point"));
				product.setStock(rs.getInt("stock"));
				product.setSold(rs.getInt("sold"));
				product.setDelivery(rs.getInt("delivery"));
				product.setHit(rs.getInt("hit"));
				product.setScore(rs.getInt("score"));
				product.setReview(rs.getInt("review"));
				product.setThumb1(path + rs.getString("thumb1"));
				product.setThumb2(path + rs.getString("thumb2"));
				product.setThumb3(path + rs.getString("thumb3"));
				product.setDetail(path + rs.getString("detail"));
				product.setStatus(rs.getString("status"));
				product.setDuty(rs.getString("duty"));
				product.setReceipt(rs.getString("receipt"));
				product.setBizType(rs.getString("bizType"));
				product.setOrigin(rs.getString("origin"));
				product.setIp(rs.getString("ip"));
				product.setRdate(rs.getString("rdate"));
	
				products.add(product);
				
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return products;
	}
	
	
	
	public String[] getCateName(int cate1, int cate2) {
		
		String cateName[] = new String[2];
		
		try {
			logger.info("getCateName...");
			conn = getConnection();
			
			psmt = conn.prepareStatement(ProductSql.SELECT_CATE_NAME);
			psmt.setInt(1, cate1);
			psmt.setInt(2, cate2);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				
				cateName[0] = rs.getString(1);
				cateName[1] = rs.getString(2);
			
			}
			
			close();

		}catch(Exception e) {
			
		}
		return cateName;
	}
	
	
	
	// 현길
	
}

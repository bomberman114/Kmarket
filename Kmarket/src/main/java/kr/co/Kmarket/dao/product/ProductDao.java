package kr.co.Kmarket.dao.product;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.db.ProductSql;
import kr.co.Kmarket.db.Sql;
import kr.co.Kmarket.vo.ProductVo;

public class ProductDao extends DBHelper {

	Logger logger = LoggerFactory.getLogger(this.getClass());
		
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
	
	public List<ProductVo> selectProducts(int cate1, int cate2, String sort) {
		
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
				
				psmt = conn.prepareStatement(ProductSql.SELECT_PRODUCTS_REVEIW);
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

	public List<ProductVo> cart() {
		List<ProductVo> cart = new ArrayList<>();

		try {

			logger.info("MainProducts...");
			conn = getConnection();

			psmt = conn.prepareStatement(Sql.SELECT_MAIN_SCORE_PRODUCTS);
			// psmt.setString(1, uid);
			// psmt.setInt(2, limitStart);

			rs = psmt.executeQuery();

			while (rs.next()) {

				ProductVo vo = new ProductVo();
				String prodCate1 = rs.getString("prodCate1");
				String prodCate2 = rs.getString("prodCate2");
				String path = "/thumb/" + prodCate1 + "/" + prodCate2 + "/";

				vo.setProdNo(rs.getInt("prodNo"));
				vo.setProdCate1(prodCate1);
				vo.setProdCate2(prodCate2);
				vo.setProdName(rs.getString("prodName"));
				vo.setDescript(rs.getString("descript"));
				vo.setCompany(rs.getString("company"));
				vo.setSeller(rs.getString("seller"));
				vo.setPrice(rs.getInt("price"));
				vo.setDiscount(rs.getInt("discount"));
				vo.setPoint(rs.getInt("point"));
				vo.setStock(rs.getInt("stock"));
				vo.setSold(rs.getInt("sold"));
				vo.setDelivery(rs.getInt("delivery"));
				vo.setHit(rs.getInt("hit"));
				vo.setScore(rs.getInt("score"));
				vo.setReview(rs.getInt("review"));
				vo.setThumb1(path + rs.getString("thumb1"));
				vo.setThumb2(path + rs.getString("thumb2"));
				vo.setThumb3(path + rs.getString("thumb3"));
				vo.setDetail(path + rs.getString("detail"));
				vo.setStatus(rs.getString("status"));
				vo.setDuty(rs.getString("duty"));
				vo.setReceipt(rs.getString("receipt"));
				vo.setBizType(rs.getString("bizType"));
				vo.setOrigin(rs.getString("origin"));
				vo.setIp(rs.getString("ip"));
				vo.setRdate(rs.getString("rdate"));
				int price = vo.getPrice();
				int discount = vo.getDiscount();
				int a = 100 - discount;
				double z = (double) a / 100;
				double f = Math.round(price * z); // 소수점 반올림
				int disprice = (int) f; // 타입변환
				vo.setDisprice(disprice);
				cart.add(vo);

			}
			close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return cart;
	}
	
}

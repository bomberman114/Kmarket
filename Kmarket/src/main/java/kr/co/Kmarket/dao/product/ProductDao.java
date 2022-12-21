package kr.co.Kmarket.dao.product;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.db.ProductSql;
import kr.co.Kmarket.vo.ProductCartVo;
import kr.co.Kmarket.vo.ProductOrderVo;
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
	
	public ProductVo selectProduct(int prodNo) {
		
		ProductVo product = null;
		
		try {
			logger.info("selectProduct");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSql.SELECT_PRODUCT);
			psmt.setInt(1, prodNo);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				
				product = new ProductVo();
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
				product.setScore(0+rs.getInt("score")*40);
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
				product.setDisprice(rs.getInt("disPrice"));
	
			}
	
			
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return product;
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
			psmt.setInt(3, start);	
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
				product.setScore(37+rs.getInt("score")*16);
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
				product.setDisprice(rs.getInt("disPrice"));
	
				products.add(product);
				
			}
			
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return products;
	}
	
	
	public List<ProductVo> selectOrder(int prodNo, int count) {
		
		List<ProductVo> order = new ArrayList<>();
		
		try {
			
			logger.info("selectOrder...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSql.SELECT_ORDER);
			psmt.setInt(1, prodNo);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				ProductVo vo = new ProductVo();
	
				int prodCate1 = rs.getInt("prodCate1");
				int prodCate2 = rs.getInt("prodCate2");
				String path = "/thumb/" + prodCate1 + "/" + prodCate2 + "/";
				
				vo.setProdNo(rs.getInt("prodNo"));
				vo.setProdCate1(prodCate1);
				vo.setProdCate2(prodCate2);
				vo.setProdName(rs.getString("prodName"));
				vo.setDescript(rs.getString("descript"));
				vo.setCompany(rs.getString("company"));
				vo.setPoint(rs.getInt("point"));
				vo.setPrice(rs.getInt("price"));
				vo.setDiscount(rs.getInt("discount"));
				vo.setDelivery(rs.getInt("delivery"));
				vo.setThumb1(path + rs.getString("thumb1"));
				vo.setThumb2(path + rs.getString("thumb2"));
				vo.setThumb3(path + rs.getString("thumb3"));
				vo.setDisprice(rs.getInt("disprice"));
				vo.setTotal(count*(rs.getInt("price") - rs.getInt("disprice")));
				vo.setCount(count);
				
				order.add(vo);
		
			}
			
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}

		return order;
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
			logger.error(e.getMessage());
		}
		return cateName;
	}

	
	public void updateProductHit(int prodNo) {
		
		try {
			
			logger.info("updateProductHit...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSql.UPDATE_PRODUCT_HIT);
			psmt.setInt(1, prodNo);
			psmt.executeUpdate();

			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	
		
	}
	
	public int insertCart(ProductCartVo cart) {
		
		int result = 0;
		
		try {
		
			logger.info("insertCart...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSql.INSERT_CART);
			psmt.setString(1, cart.getUid());
			psmt.setInt(2, cart.getProdNo());
			psmt.setInt(3, cart.getCount());
			psmt.setInt(4, cart.getPrice());
			psmt.setInt(5, cart.getDiscount());
			psmt.setInt(6, cart.getPoint());
			psmt.setInt(7, cart.getDelivery());
			psmt.setInt(8, cart.getTotal());
			
			result = psmt.executeUpdate();
			
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return result;
		
	}
	
	
	
	// 현길
	
	public List<ProductVo> cart(String uid) {
		List<ProductVo> cart = new ArrayList<>();

		try {

			logger.info("cartProducts...");
			conn = getConnection();
			logger.info("하이1");
			psmt = conn.prepareStatement(ProductSql.SELECT_CART_PRODUCTS);
			logger.info("하이2");
			 psmt.setString(1, uid);
			 logger.info("하이3");
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
				vo.setCount(rs.getInt("count"));
				int price = vo.getPrice();
				int discount = vo.getDiscount();
				int a = 100 - discount;
				double z = (double) a / 100;
				double f = Math.round(price * z); // 소수점 반올림
				int disprice = (int) f; // 타입변환
				vo.setDisprice(disprice);
				vo.setTotal(rs.getInt("total"));
				vo.setCount(rs.getInt("count"));
				cart.add(vo);

			}
			close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return cart;
	}
	
	// 진우 
	/*
	public void insertOrderProduct(List<ProductOrderVo> orderProduct) {
		
		try {
			logger.info("insertOrderProduct...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSql.INSERT_PRODUCT_ORDER);
			psmt.setString(1, );
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	*/
	public int insertOrderProduct(ProductOrderVo vo) {
		
		int result = 0;
		
		try {
			logger.info("insertOrderProduct...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSql.INSERT_PRODUCT_ORDER);
			psmt.setString(1, vo.getOrdUid());
			psmt.setInt(2, vo.getOrdCount());
			psmt.setInt(3, vo.getOrdPrice());
			psmt.setInt(4, vo.getOrdDiscount());
			psmt.setInt(5, vo.getOrdDelivery());
			psmt.setInt(6, vo.getSavePoint());
			psmt.setInt(7, vo.getUsedPoint());
			psmt.setInt(8, vo.getOrdTotPrice());
			psmt.setString(9, vo.getRecipName());
			psmt.setString(10, vo.getRecipHp());
			psmt.setString(11, vo.getRecipZip());
			psmt.setString(12, vo.getRecipAddr1());
			psmt.setString(13, vo.getRecipAddr2());
			psmt.setInt(14, vo.getOrdPayment());
			
			logger.debug("psmt : " + psmt);
			
			result = psmt.executeUpdate();
			
			close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	
	
}

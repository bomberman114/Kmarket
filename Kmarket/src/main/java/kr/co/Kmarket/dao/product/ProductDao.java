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
				product.setProdNo(rs.getInt(1));
				product.setProdCate1(rs.getInt(1));
				product.setProdCate2(rs.getInt(1));
				product.setProdName(rs.getString(1));
				product.setDescript(rs.getString(1));
				product.setCompany(rs.getString(1));
				product.setSeller(rs.getString(1));
				product.setPrice(rs.getInt(1));
				product.setDiscount(rs.getInt(1));
				product.setPoint(rs.getInt(1));
				product.setStock(rs.getInt(1));
				
				
				
				
			}
			
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return products;
	}
	
}

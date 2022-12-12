package kr.co.Kmarket.dao.admin;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.db.Sql;
import kr.co.Kmarket.vo.ProductVo;

public class AdminDao extends DBHelper{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public void insertAdminProduct() {}
	public void selectAdminProduct() {}
	
	public List<ProductVo> selectAdminProducts() {
		
		List<ProductVo> products = new ArrayList<>();
		try {
			
			logger.info("selectAdminProducts...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_ADMIN_PRODUCTS);
			
			while(rs.next()) {
				ProductVo vo = new ProductVo();
				vo.setThumb1(rs.getString(1));
				vo.setProdNo(rs.getInt(2));
				vo.setProdName(rs.getString(3));
				vo.setPrice(rs.getInt(4));
				vo.setDiscount(rs.getInt(5));
				vo.setPoint(rs.getInt(6));
				vo.setStock(rs.getInt(7));
				vo.setSeller(rs.getString(8));
				vo.setHit(rs.getInt(9));
				
				products.add(vo);
			}
			close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}
	
	public void updateAdminProduct() {}
	public void deleteAdminProduct() {}
	
}

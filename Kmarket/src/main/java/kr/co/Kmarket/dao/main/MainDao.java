package kr.co.Kmarket.dao.main;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.db.Sql;
import kr.co.Kmarket.vo.ProductVo;

public class MainDao extends DBHelper {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<ProductVo> mainProduct() {
		List<ProductVo> products = new ArrayList<>();

		try {

			logger.info("MainProducts...");
			conn = getConnection();

			psmt = conn.prepareStatement(Sql.SELECT_MAIN_PRODUCTS);
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
				// vo.setThumb1(path + rs.getString("thumb1"));
				vo.setThumb2(path + rs.getString("thumb2"));
				// vo.setThumb3(path + rs.getString("thumb3"));
				// vo.setDetail(path + rs.getString("detail"));
				vo.setStatus(rs.getString("status"));
				vo.setDuty(rs.getString("duty"));
				vo.setReceipt(rs.getString("receipt"));
				vo.setBizType(rs.getString("bizType"));
				vo.setOrigin(rs.getString("origin"));
				vo.setIp(rs.getString("ip"));
				vo.setRdate(rs.getString("rdate"));
				int price = vo.getPrice();
				int discount = vo.getDiscount();
				int disprice = price*(100-discount);
				vo.setDisprice(disprice);
				products.add(vo);
			}
			close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}
}

package kr.co.Kmarket.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.db.Sql;
import kr.co.Kmarket.vo.ProductVo;

public class AdminDao extends DBHelper {

	Logger logger = LoggerFactory.getLogger(this.getClass());



	public void insertAdminProduct(ProductVo product) {


		int parent = 0;

		try {
			Connection conn = getConnection();
			// 트랜젝션 시작
			conn.setAutoCommit(false);

			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_ADMIN_PRODUCT);
			Statement stmt = conn.createStatement();

			psmt.setInt(1, product.getProdNo());
			psmt.setInt(2, product.getProdCate1());
			psmt.setInt(3, product.getProdCate2());
			psmt.setString(4, product.getProdName());
			psmt.setString(5, product.getDescript());
			psmt.setString(6, product.getCompany());
			psmt.setString(7, product.getSeller());
			psmt.setInt(8, product.getPrice());
			psmt.setInt(9, product.getDiscount());
			psmt.setInt(10, product.getPoint());
			psmt.setInt(11, product.getStock());
			psmt.setInt(12, product.getSold());
			psmt.setInt(13, product.getDelivery());
			psmt.setInt(14, product.getHit());
			psmt.setInt(15, product.getScore());
			psmt.setInt(16, product.getReview());
			psmt.setInt(17, product.getThumb1() == null ? 0 : 1);
			psmt.setInt(18, product.getThumb2() == null ? 0 : 1);
			psmt.setInt(19, product.getThumb3() == null ? 0 : 1);
			psmt.setString(20, product.getDetail());
			psmt.setString(21, product.getStatus());
			psmt.setString(22, product.getDuty());
			psmt.setString(23, product.getReceipt());
			psmt.setString(24, product.getBizType());
			psmt.setString(25, product.getOrigin());
			psmt.setString(26, product.getIp());
			psmt.setString(27, product.getRate());

			psmt.executeUpdate();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_MAX_NO);

			// 작업확정
			conn.commit();

			if (rs.next()) {
				parent = rs.getInt(1);
			}

			rs.close();
			stmt.close();
			psmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}

	public void selectAdminProduct() {
	}

	public List<ProductVo> selectAdminProducts(int limitStart) {

		List<ProductVo> products = new ArrayList<>();

		try {

			logger.info("selectAdminProducts...");
			conn = getConnection();

			psmt = conn.prepareStatement(Sql.SELECT_ADMIN_PRODUCTS);
			psmt.setInt(1, limitStart);

			rs = psmt.executeQuery();

			while (rs.next()) {

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

	// 전체 게시물 갯수
	public int selectCountTotal() {
		int total = 0;
		try {
			logger.info("selectCountTotal...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_COUNT_TOTAL);

			if (rs.next()) {
				total = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;
	}


	


}

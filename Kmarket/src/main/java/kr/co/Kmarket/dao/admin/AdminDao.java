package kr.co.Kmarket.dao.admin;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.db.Sql;
import kr.co.Kmarket.vo.ProductCate1Vo;
import kr.co.Kmarket.vo.ProductCate2Vo;
import kr.co.Kmarket.vo.ProductVo;

public class AdminDao extends DBHelper {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public int insertAdminProduct(ProductVo product) {


		int result = 0;

		try {
			// 트랜젝션 시작
			logger.info("insertProduct... 상품 등록");
			conn = getConnection();

			psmt = conn.prepareStatement(Sql.INSERT_ADMIN_PRODUCT);


			psmt.setInt(1, product.getProdCate1());
			psmt.setInt(2, product.getProdCate2());
			psmt.setString(3, product.getProdName());
			psmt.setString(4, product.getDescript());
			psmt.setString(5, product.getCompany());
			psmt.setString(6, product.getSeller());
			psmt.setInt(7, product.getPrice());
			psmt.setInt(8, product.getDiscount());
			psmt.setInt(9, product.getPoint());
			psmt.setInt(10, product.getStock());
			psmt.setInt(11, product.getDelivery());
			psmt.setString(12, product.getThumb1());
			psmt.setString(13, product.getThumb2());
			psmt.setString(14, product.getThumb3());
			psmt.setString(15, product.getDetail());
			psmt.setString(16, product.getStatus());
			psmt.setString(17, product.getDuty());
			psmt.setString(18, product.getReceipt());
			psmt.setString(19, product.getBizType());
			psmt.setString(20, product.getOrigin());
			psmt.setString(21, product.getIp());


			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
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

	public List<ProductVo> selectAdminProductsByKeyword(String category, String keyword, int limitStart) {

		List<ProductVo> products = new ArrayList<>();

		try {
			logger.info("selectAdminProductsByKeyword...");
			conn = getConnection();

			if (category.equals("prodName")) {
				psmt = conn.prepareStatement(Sql.SELECT_ADMIN_PRODUCTS_BY_PRODNAME);
			} else if (category.equals("prodNo")) {
				psmt = conn.prepareStatement(Sql.SELECT_ADMIN_PRODUCTS_BY_PRODNO);
			} else if (category.equals("company")) {
				psmt = conn.prepareStatement(Sql.SELECT_ADMIN_PRODUCTS_BY_COMPANY);
			} else if (category.equals("seller")) {
				psmt = conn.prepareStatement(Sql.SELECT_ADMIN_PRODUCTS_BY_SELLER);
			}
			psmt.setString(1, "%" + keyword + "%");
			psmt.setInt(2, limitStart);

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

	public List<ProductCate1Vo> selectcate1() {
		List<ProductCate1Vo> vos = new ArrayList<>();
		try {
			logger.info("selectcate1... 카테고리1 불러오기");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_ADMIN_PRODUCT_CATE1);
			while(rs.next()) {
				ProductCate1Vo vo = new ProductCate1Vo();
				vo.setCate1(rs.getInt(1));
				vo.setC1Name(rs.getString(2));
				vos.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return vos;
	}

	public List<ProductCate2Vo> selectcate2(String cate1) {
		List<ProductCate2Vo> vos = new ArrayList<>();
		try {
			logger.info("selectcate2... 카테고리2 불러오기");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ADMIN_PRODUCT_CATE2);
			psmt.setString(1, cate1);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductCate2Vo vo = new ProductCate2Vo();
				vo.setCate1(rs.getInt(1));
				vo.setCate2(rs.getInt(2));
				vo.setC2Name(rs.getString(3));
				vos.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return vos;
	}

}

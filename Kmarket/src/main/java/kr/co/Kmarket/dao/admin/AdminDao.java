package kr.co.Kmarket.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.db.Sql;
import kr.co.Kmarket.vo.AdminCsFaqCate2Vo;
import kr.co.Kmarket.vo.NoticeArticleVo;
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

	// 일반 판매자일 때
	public List<ProductVo> selectAdminProducts(String uid, int limitStart) {

		List<ProductVo> products = new ArrayList<>();

		try {

			logger.info("selectAdminProducts...");
			conn = getConnection();

			psmt = conn.prepareStatement(Sql.SELECT_ADMIN_PRODUCTS);
			psmt.setString(1, uid);
			psmt.setInt(2, limitStart);

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

				products.add(vo);
			}
			close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}

	public List<ProductVo> selectAdminProductsByKeyword(String uid, String category, String keyword, int limitStart) {

		List<ProductVo> products = new ArrayList<>();

		try {
			logger.info("selectAdminProductsByKeyword...");
			conn = getConnection();

			if (category.equals("prodName")) {
				psmt = conn.prepareStatement(Sql.SELECT_ADMIN_PRODUCTS_BY_PRODNAME);
			} else if (category.equals("prodNo")) {
				psmt = conn.prepareStatement(Sql.SELECT_ADMIN_PRODUCTS_BY_PRODNO);
			} else if (category.equals("seller")) {
				psmt = conn.prepareStatement(Sql.SELECT_ADMIN_PRODUCTS_BY_SELLER);
			}
			psmt.setString(1, uid);
			psmt.setString(2, "%" + keyword + "%");
			psmt.setInt(3, limitStart);

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

				products.add(vo);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}

	// 최고 관리자일 때
	public List<ProductVo> selectAdminProducts7(int limitStart) {

		List<ProductVo> products = new ArrayList<>();

		try {

			logger.info("selectAdminProducts7...");
			conn = getConnection();

			psmt = conn.prepareStatement(Sql.SELECT_ADMIN_PRODUCTS7);
			psmt.setInt(1, limitStart);

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

				products.add(vo);
			}
			close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}

	public List<ProductVo> selectAdminProductsByKeyword7(String category, String keyword, int limitStart) {

		List<ProductVo> products = new ArrayList<>();

		try {
			logger.info("selectAdminProductsByKeyword7...");
			conn = getConnection();

			if (category.equals("prodName")) {
				psmt = conn.prepareStatement(Sql.SELECT_ADMIN_PRODUCTS_BY_PRODNAME7);
			} else if (category.equals("prodNo")) {
				psmt = conn.prepareStatement(Sql.SELECT_ADMIN_PRODUCTS_BY_PRODNO7);
			} else if (category.equals("seller")) {
				psmt = conn.prepareStatement(Sql.SELECT_ADMIN_PRODUCTS_BY_SELLER7);
			}
			psmt.setString(1, "%" + keyword + "%");
			psmt.setInt(2, limitStart);

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

				products.add(vo);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}

	public int deleteAdminProduct(int prodNo) {

		int result = 0;
		try {
			logger.info("deleteAdminProduct...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.DELETE_PRODUCT);
			psmt.setInt(1, prodNo);
			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	public int deleteAdminProductlist(HashMap<Integer, Integer> map) {

		int result = 0;
		try {
			logger.info("deleteAdminProductlist...");
			for (int i = 1; i < map.size() + 1; i++) {
				conn = getConnection();
				psmt = conn.prepareStatement(Sql.DELETE_PRODUCT_LIST);
				psmt.setInt(1, map.get(i));
				result = psmt.executeUpdate();
				// psmt.executeQuery();
			}
			close();
			// result=1;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;

	}

	// 일반 판매자일 때

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
			while (rs.next()) {
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
			while (rs.next()) {
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

	public int orderCount() {
		int orderCount = 0;
		try {
			logger.info("orderCount..");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_ORDER_COUNT);

			if (rs.next()) {
				orderCount = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return orderCount;
	}

	public int orderCountY() {
		int orderCountY = 0;
		try {
			logger.info("orderCount..");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_ORDER_COUNT_Y);

			if (rs.next()) {
				orderCountY = rs.getInt(2);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return orderCountY;
	}

	public int orderCountW() {
		int orderCountW = 0;
		try {
			logger.info("orderCount..");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_ORDER_COUNT_W);

			if (rs.next()) {
				orderCountW = rs.getInt(2);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return orderCountW;
	}

	public int orderCountM() {
		int orderCountM = 0;
		try {
			logger.info("orderCount..");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_ORDER_COUNT_M);

			if (rs.next()) {
				orderCountM = rs.getInt(2);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return orderCountM;
	}

	public int orderPrice() {
		int orderPrice = 0;
		try {
			logger.info("orderPrice..");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_ORDER_PRICE);

			if (rs.next()) {
				orderPrice = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return orderPrice;
	}

	public int orderPriceY() {
		int orderPriceY = 0;
		try {
			logger.info("orderPrice..");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_ORDER_PRICE_Y);

			if (rs.next()) {
				orderPriceY = rs.getInt(2);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return orderPriceY;
	}

	public int orderPriceW() {
		int orderPriceW = 0;
		try {
			logger.info("orderPrice..");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_ORDER_PRICE_W);

			if (rs.next()) {
				orderPriceW = rs.getInt(2);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return orderPriceW;
	}

	public int orderPriceM() {
		int orderPriceM = 0;
		try {
			logger.info("orderPrice..");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_ORDER_PRICE_M);

			if (rs.next()) {
				orderPriceM = rs.getInt(2);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return orderPriceM;
	}

	public int memberCount() {
		int memberCount = 0;
		try {
			logger.info("MemberCount..");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_MEMBER_COUNT);

			if (rs.next()) {
				memberCount = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return memberCount;
	}

	public int memberCountY() {
		int memberCount = 0;
		try {
			logger.info("MemberCount..");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_MEMBER_COUNT_Y);

			if (rs.next()) {
				memberCount = rs.getInt(2);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return memberCount;
	}

	public int memberCountW() {
		int memberCount = 0;
		try {
			logger.info("MemberCount..");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_MEMBER_COUNT_W);

			if (rs.next()) {
				memberCount = rs.getInt(2);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return memberCount;
	}

	public int memberCountM() {
		int memberCount = 0;
		try {
			logger.info("MemberCount..");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_MEMBER_COUNT_M);

			if (rs.next()) {
				memberCount = rs.getInt(2);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return memberCount;
	}

	public int productCount() {
		int productCount = 0;
		try {
			logger.info("productNew..");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_PRODUCT_COUNT);

			if (rs.next()) {
				productCount = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return productCount;
	}

	public int productY() {
		int productY = 0;
		try {
			logger.info("productY..");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_PRODUCT_Y);

			if (rs.next()) {
				productY = rs.getInt(2);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return productY;
	}

	public int productW() {
		int productW = 0;
		try {
			logger.info("productW..");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_PRODUCT_W);

			if (rs.next()) {
				productW = rs.getInt(2);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return productW;
	}

	public int productM() {
		int productM = 0;
		try {
			logger.info("productM..");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_PRODUCT_M);

			if (rs.next()) {
				productM = rs.getInt(2);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return productM;
	}

	// admin notice list용
	public int selectCountTotal(int cate) {
		int total = 0;
		try {
			logger.info("selectCountNoticeTotal...");
			conn = getConnection();

			if (cate == 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(Sql.SELECT_COUNT_NOTICE_TOTAL);
			} else {
				psmt = conn.prepareStatement(Sql.SELECT_COUNT_NOTICE_TOTAL_FOR_CATE);
				psmt.setInt(1, cate);
				rs = psmt.executeQuery();
			}

			if (rs.next()) {
				total = rs.getInt(1);
			}

			close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;
	}

	public void insertNotice(NoticeArticleVo vo) {

		try {
			logger.info("insertNotice...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_NOTICE);
			psmt.setInt(1, vo.getCate());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getUid());
			psmt.setString(5, vo.getRegip());
			psmt.setString(6, vo.getCateName());

			psmt.executeUpdate();

			close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}
	
	public NoticeArticleVo selectNotice(String no) {
		
		NoticeArticleVo vo = null;
		
		try {
			
			logger.info("selectNotice...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_NOTICE);
			psmt.setString(1, no);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				
				vo = new NoticeArticleVo();
				
				vo.setNo(rs.getInt(1));
				vo.setCate(rs.getInt(2));
				vo.setCateName(rs.getString(3));
				vo.setTitle(rs.getString(4));
				vo.setContent(rs.getString(5));
				vo.setUid(rs.getString(6));
				vo.setHit(rs.getInt(7));
				vo.setRegip(rs.getString(8));
				vo.setRdate(rs.getString(9));
				
			}
			
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	

	public List<NoticeArticleVo> selectNotices(int start) {

		List<NoticeArticleVo> notices = new ArrayList<>();

		try {
			logger.info("selectNotices...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_NOTICES);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();

			while (rs.next()) {

				NoticeArticleVo vo = new NoticeArticleVo();
				vo.setNo(rs.getInt(1));
				vo.setCate(rs.getInt(2));
				vo.setCateName(rs.getString(3));
				vo.setTitle(rs.getString(4));
				vo.setContent(rs.getString(5));
				vo.setUid(rs.getString(6));
				vo.setHit(rs.getInt(7));
				vo.setRegip(rs.getString(8));
				vo.setRdate(rs.getString(9));

				notices.add(vo);

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return notices;
	}

	public List<NoticeArticleVo> selectNoticesByCate(int cate, int start) {

		List<NoticeArticleVo> notices = new ArrayList<>();

		try {
			logger.info("selectNoticesByCate...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_NOTICES_BY_CATE);
			psmt.setInt(1, cate);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();

			while (rs.next()) {

				NoticeArticleVo vo = new NoticeArticleVo();
				vo.setNo(rs.getInt(1));
				vo.setCate(rs.getInt(2));
				vo.setCateName(rs.getString(3));
				vo.setTitle(rs.getString(4));
				vo.setContent(rs.getString(5));
				vo.setUid(rs.getString(6));
				vo.setHit(rs.getInt(7));
				vo.setRegip(rs.getString(8));
				vo.setRdate(rs.getString(9));

				notices.add(vo);

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return notices;

	}
	
	public int deleteNotice(String no) {
		
		int result = 0;
		
		try {
			logger.info("deleteNotice...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.DELETE_NOTICE);
			psmt.setString(1, no);
			
			result = psmt.executeUpdate();
			
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	public int deleteNotices(String[] checkboxArr) {
		
		int result = 0;
		
		try {
			logger.info("deleteNotices...");
			conn = getConnection();
			
			String Sql ="DELETE FROM `km_cs_notice_board` WHERE ";
				   Sql += "`no`="+checkboxArr[0];
				for(int i=1; i < checkboxArr.length; i++) {
					Sql += " or `no`="+checkboxArr[i];
				}
				
			logger.debug(Sql);
				
			stmt = conn.createStatement();
			result = stmt.executeUpdate(Sql);
			
			close();
	
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return result;
	}
	
	public void updateNoticeHit(String no) {
		
		try {
			logger.info("updateNoticeHit...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_NOTICE_HIT);
			psmt.setString(1, no);
			
			psmt.executeUpdate();
			
			close();
			
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	
	public void updateNotice(NoticeArticleVo vo){
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_NOTICE);
			psmt.setInt(1, vo.getCate());
			psmt.setString(2, vo.getCateName());
			psmt.setString(3, vo.getTitle());
			psmt.setString(4, vo.getContent());
			psmt.setInt(5, vo.getNo());
			
			psmt.executeUpdate();
			
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	
	}
	
// admin Faq
	public int selectFaqTotal(int cate) {
		int total = 0;
		try {
			logger.info("selectCountFaqTotal...");
			conn = getConnection();

			if (cate == 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(Sql.SELECT_COUNT_FAQ_TOTAL);
			} else {
				psmt = conn.prepareStatement(Sql.SELECT_COUNT_FAQ_TOTAL_FOR_CATE);
				psmt.setInt(1, cate);
				rs = psmt.executeQuery();
			}

			if (rs.next()) {
				total = rs.getInt(1);
			}

			close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;
	}

	public List<AdminCsFaqCate2Vo> selectFaqcate2(String cate1) {
		List<AdminCsFaqCate2Vo> vos = new ArrayList<>();
		try {
			logger.info("selectFaqcate2... 카테고리2 불러오기");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ADMIN_FAQ_CATE2);
			psmt.setString(1, cate1);
			rs = psmt.executeQuery();
			while (rs.next()) {
				AdminCsFaqCate2Vo vo = new AdminCsFaqCate2Vo();
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

package kr.co.Kmarket.dao.cs;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.CsSql;
import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.vo.QnaArticleVo;
import kr.co.Kmarket.vo.csFaqVo;

public class CsDao extends DBHelper {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	// 진우
	public int insertQnaArticle(QnaArticleVo vo) {
		
		int result = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.INSERT_QNA_ARTICLE);
			stmt = conn.createStatement();
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setInt(4, vo.getCate1());
			psmt.setInt(5, vo.getCate2());
			psmt.setString(6, vo.getRegip());
			
			psmt.executeUpdate();
			
			rs = stmt.executeQuery(CsSql.SELECT_MAX_NO);
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	public QnaArticleVo selectArtlcle(String no) {
		
		QnaArticleVo vo = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_ARTITCLE);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo = new QnaArticleVo();
				vo.setNo(rs.getInt(1));
				vo.setParent(rs.getInt(2));
				vo.setComment(rs.getInt(3));
				vo.setCate1(rs.getInt(4));
				vo.setCate2(rs.getInt(5));
				vo.setTitle(rs.getString(6));
				vo.setContent(rs.getString(7));
				vo.setUid(rs.getString(8));
				vo.setRegip(rs.getString(9));
				vo.setRdate(rs.getString(10));
				vo.setC2Name(rs.getString(11));
			}
			close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	
	// 해빈
	
	public List<QnaArticleVo> selectArticles(int cate1, int start) {
		
		List<QnaArticleVo> articles = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_ARTICLES);
			psmt.setInt(1, cate1);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				QnaArticleVo article = new QnaArticleVo();
				article.setNo(rs.getInt(1));
				article.setParent(rs.getInt(2));
				article.setComment(rs.getInt(3));
				article.setCate1(rs.getInt(4));
				article.setCate2(rs.getInt(5));
				article.setTitle(rs.getString(6));
				article.setContent(rs.getString(7));
				article.setUid(rs.getString(8));
				article.setRegip(rs.getString(9));
				article.setRdate(rs.getString(10));
				article.setC2Name(rs.getString(11));
				
				articles.add(article);
			}
			
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return articles;
	}
	
	public int selectCountTotal(int cate1) {
		int total = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_COUNT_TOTAL);
			psmt.setInt(1, cate1);
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

	//현길
	public List<csFaqVo> selectFaq1(int cate1, int cate2) {
	List<csFaqVo> csFaq1 = new ArrayList<>();
	int start = 5;
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_CS_FAQ1);
			psmt.setInt(1, cate1);
			psmt.setInt(2, cate2);
			psmt.setInt(3, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				csFaqVo article = new csFaqVo();
				article.setFaqNo(rs.getInt(1));
				article.setCate1(rs.getInt(2));
				article.setCate2(rs.getInt(3));
				//article.setC1Name(rs.getString(4));
				//article.setC2Name(rs.getString(5));
				article.setTitle(rs.getString(4));
				article.setContent(rs.getString(5));
				article.setRegip(rs.getString(6));
				article.setRdate(rs.getString(7));
				article.setUid(rs.getString(8));
				//System.out.println("cs다오:"+article);
				csFaq1.add(article);
			}
			
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return csFaq1;
	}

	public List<csFaqVo> selectFaq2(int cate1, int cate2) {
		List<csFaqVo> csFaq2 = new ArrayList<>();
		int start = 5;
		int end = 5;
			
			try {
				
				conn = getConnection();
				psmt = conn.prepareStatement(CsSql.SELECT_CS_FAQ2);
				psmt.setInt(1, cate1);
				psmt.setInt(2, cate2);
				psmt.setInt(3, start);
				psmt.setInt(4, end);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					csFaqVo article = new csFaqVo();
					article.setFaqNo(rs.getInt(1));
					article.setCate1(rs.getInt(2));
					article.setCate2(rs.getInt(3));
					//article.setC1Name(rs.getString(4));
					//article.setC2Name(rs.getString(5));
					article.setTitle(rs.getString(4));
					article.setContent(rs.getString(5));
					article.setRegip(rs.getString(6));
					article.setRdate(rs.getString(7));
					article.setUid(rs.getString(8));
					//System.out.println("cs다오:"+article);
					csFaq2.add(article);
				}
				
				close();
				
			}catch(Exception e) {
				logger.error(e.getMessage());
			}
			
			return csFaq2;
		}

}

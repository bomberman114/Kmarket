package kr.co.Kmarket.dao.cs;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.CsSql;
import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.vo.QnaArticleVo;

public class CsDao extends DBHelper {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	// 진우
	
	
	
	// 해빈
	
	public List<QnaArticleVo> selectArticles(int cate1, int start) {
		
		List<QnaArticleVo> articles = new ArrayList<>();
		
		try {
			logger.info("selectArticles");
			
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
			logger.info("selectCountTotal");
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
	
}

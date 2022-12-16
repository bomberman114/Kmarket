package kr.co.Kmarket.db;

public class CsSql {

	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(`no`) FROM `km_cs_qna_board` WHERE `parent` = 0 AND `cate1`=?";
	
	public static final String SELECT_ARTICLES = "SELECT a.*, b.c2Name  FROM `km_cs_qna_board` AS a "
												+ "JOIN `km_cs_qna_cate` AS b "
												+ "ON a.cate1 = b.cate1 AND a.cate2 = b.cate2 "
												+ "WHERE `parent`= 0 AND a.`cate1`=? ORDER BY `no` DESC LIMIT ?,10 ";
	
	public static final String INSERT_QNA_ARTICLE = "insert into `km_cs_qna_board` set "
													+ "`uid` = ?, "
													+ "`title` = ?, "
													+ "`content` = ?, "
													+ "`cate1` = ?, "
													+ "`cate2` = ?, "
													+ "`regip` = ?, "
													+ "`rdate` = NOW()";

	public static final String SELECT_MAX_NO = "select max(`no`) from `km_cs_qna_board`";
	
	public static final String SELECT_ARTITCLE = "select * from `km_cs_qna_board` where `no` = ?";
	
}

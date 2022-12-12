package kr.co.Kmarket.dao.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.db.Sql;
import kr.co.Kmarket.vo.MemberVo;
import kr.co.Kmarket.vo.TermsVo;

public class MemberDao extends DBHelper {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public MemberVo selectMember(String uid, String pass) {
		MemberVo vo = null;
		try {
			logger.info("selectUser...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_USER);
			psmt.setString(1, uid);
			psmt.setString(2, pass);
			rs = psmt.executeQuery();

			if (rs.next()) {
				vo = new MemberVo();
				vo.setUid(rs.getString(1));
				vo.setPass(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setGender(rs.getInt(4));
				vo.setHp(rs.getString(5));
				vo.setEmail(rs.getString(6));
				vo.setType(rs.getInt(7));
				vo.setPoint(rs.getInt(8));
				vo.setLevel(rs.getInt(9));
				vo.setZip(rs.getString(10));
				vo.setAddr1(rs.getString(11));
				vo.setAddr2(rs.getString(12));
				vo.setCompany(rs.getString(13));
				vo.setCeo(rs.getString(14));
				vo.setBizRegNum(rs.getString(15));
				vo.setComRegNum(rs.getString(16));
				vo.setTel(rs.getString(17));
				vo.setManager(rs.getString(18));
				vo.setManagerHp(rs.getString(19));
				vo.setFax(rs.getString(20));
				vo.setRegip(rs.getString(21));
				vo.setWdate(rs.getString(22));
				vo.setRdate(rs.getString(22));
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			close();
		}
		return vo;
	}
	
	public TermsVo selectMemberTerms() {
		
		TermsVo vo = null;
		
		try {
			logger.info("selectMemberTerms...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_MEMBER_TERMS);
			
			if(rs.next()) {
				vo = new TermsVo();
				vo.setTerms(rs.getString(1));
				vo.setPrivacy(rs.getString(2));
				vo.setLocation(rs.getString(3));
				vo.setFinance(rs.getString(4));
				vo.setTax(rs.getString(5));
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return vo;
	}

	public MemberVo selectMemberBySessId(String sessId) {
		MemberVo vo = null;

		try {
			logger.info("selectUserBySessId...");

			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_MEMBER_BY_SESSID);
			psmt.setString(1, sessId);

			rs = psmt.executeQuery();

			if (rs.next()) {
				vo = new MemberVo();
				vo.setUid(rs.getString(1));
				vo.setPass(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setGender(rs.getInt(4));
				vo.setHp(rs.getString(5));
				vo.setEmail(rs.getString(6));
				vo.setType(rs.getInt(7));
				vo.setPoint(rs.getInt(8));
				vo.setLevel(rs.getInt(9));
				vo.setZip(rs.getString(10));
				vo.setAddr1(rs.getString(11));
				vo.setAddr2(rs.getString(12));
				vo.setCompany(rs.getString(13));
				vo.setCeo(rs.getString(14));
				vo.setBizRegNum(rs.getString(15));
				vo.setComRegNum(rs.getString(16));
				vo.setTel(rs.getString(17));
				vo.setManager(rs.getString(18));
				vo.setManagerHp(rs.getString(19));
				vo.setFax(rs.getString(20));
				vo.setRegip(rs.getString(21));
				vo.setWdate(rs.getString(22));
				vo.setRdate(rs.getString(22));
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			close();
		}

		return vo;
	}

	public void updateMemberForSessLimitDate(String sessId) {
		try {
			logger.info("updateUserForSessLimitDate...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_MEMBER_FOR_SESS_LIMIT_DATE);
			psmt.setString(1, sessId);
			psmt.executeUpdate();
		} catch (Exception e) {
			logger.error(e.getMessage());
			close();
		}
	}

	public void updateMemberForSession(String uid, String sessId) {
		try {
			logger.info("updateUserForSession...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_MEMBER_FOR_SESSION);
			psmt.setString(1, sessId);
			psmt.setString(2, uid);
			psmt.executeUpdate();
		} catch (Exception e) {
			logger.error(e.getMessage());
			close();
		}
	}

	public void updateMemberForSessionOut(String uid) {
		try {
			logger.info("updateUserForSessionOut...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_MEMBER_FOR_SESSION_OUT);
			psmt.setString(1, uid);
			psmt.executeUpdate();
		} catch (Exception e) {
			logger.error(e.getMessage());
			close();
		}
	}}

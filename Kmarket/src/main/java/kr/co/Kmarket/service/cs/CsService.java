package kr.co.Kmarket.service.cs;

import java.util.List;

import kr.co.Kmarket.dao.cs.CsDao;
import kr.co.Kmarket.vo.QnaArticleVo;

public enum CsService {
	
	INSTANCE;
	private  CsDao dao;
	
	
	private CsService() {
		dao = new CsDao();
	
	}
	
	// 진우
	
	
	
	// 해빈
	
	public List<QnaArticleVo> selectArticles(int cate1, int start) {
		return dao.selectArticles(cate1, start);
	}
	
	public int selectCountTotal(int cate1) {
		return dao.selectCountTotal(cate1);
	}
	
	
	public int getCurrentPage(String pg) {
		
		int currentPage = 1;
		
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		
		return currentPage;
		
	}
	
	public int getLastPageNum(int total) {
		
		int lastPageNum = 0;
		
		if(total % 10 == 0) {
			lastPageNum = (total / 10);
		}else {
			lastPageNum = (total / 10) + 1;
		}
		
		return lastPageNum;
	}
	
	public int[] getPageGroupNum(int currentPage, int lastPageNum) {
		
		int pageGroupCurrent = (int)Math.ceil(currentPage / 5.0);
		int pageGroupStart = (pageGroupCurrent -1) * 5 + 1;
		int pageGroupEnd = pageGroupCurrent * 5;
		
		if(pageGroupEnd > lastPageNum) {
			pageGroupEnd = lastPageNum;
		}
		
		int[] pageGroup = {pageGroupStart, pageGroupEnd};
		
		return pageGroup;
		
	}

	public int getStartNum(int currentPage) {
		
		return (currentPage -1) * 10;
	}	
	
	
	
	
	
	
	
	public String getC1name(int cate1) {
		
		String c1name = null;
		
		switch(cate1) {
		case 1:
			c1name = "회원";
			break;
		case 2:
			c1name = "쿠폰/이벤트";
			break;
		case 3:
			c1name = "주문/결제";
			break;
		case 4:
			c1name = "배송";
			break;
		case 5:
			c1name = "취소/반품/교환";
			break;
		case 6:
			c1name = "여행/숙박/항공";
			break;
		case 7:
			c1name = "안전거래";
			break;
		}
		
		return c1name;
	}
}

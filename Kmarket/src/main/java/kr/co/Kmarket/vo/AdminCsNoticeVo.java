package kr.co.Kmarket.vo;

import java.util.List;

public class AdminCsNoticeVo {
	
	private int cate;	
	private int currentPage;
	private int lastPageNum;
	private int pageGroupStart;
	private int pageGroupEnd;
	private int total;
	private List<NoticeArticleVo> notices;
	
	public int getCate() {
		return cate;
	}
	public void setCate(int cate) {
		this.cate = cate;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getLastPageNum() {
		return lastPageNum;
	}
	public void setLastPageNum(int lastPageNum) {
		this.lastPageNum = lastPageNum;
	}
	public int getPageGroupStart() {
		return pageGroupStart;
	}
	public void setPageGroupStart(int pageGroupStart) {
		this.pageGroupStart = pageGroupStart;
	}
	public int getPageGroupEnd() {
		return pageGroupEnd;
	}
	public void setPageGroupEnd(int pageGroupEnd) {
		this.pageGroupEnd = pageGroupEnd;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<NoticeArticleVo> getNotices() {
		return notices;
	}
	public void setNotices(List<NoticeArticleVo> notices) {
		this.notices = notices;
	}
}

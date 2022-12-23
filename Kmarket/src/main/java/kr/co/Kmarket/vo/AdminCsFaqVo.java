package kr.co.Kmarket.vo;

public class AdminCsFaqVo {
	private int cate1;
	private int cate2;
	private int currentPage;
	private int lastPageNum;
	private int pageGroupStart;
	private int pageGroupEnd;
	private int total;
	private int faqNo;
	private String title;
	private String content;
	private String regip;
	private String rdate;

	public AdminCsFaqVo() {
	}

	public AdminCsFaqVo(int cate1, int cate2, int currentPage, int lastPageNum, int pageGroupStart, int pageGroupEnd,
			int total, int faqNo, String title, String content, String regip, String rdate) {
		super();
		this.cate1 = cate1;
		this.cate2 = cate2;
		this.currentPage = currentPage;
		this.lastPageNum = lastPageNum;
		this.pageGroupStart = pageGroupStart;
		this.pageGroupEnd = pageGroupEnd;
		this.total = total;
		this.faqNo = faqNo;
		this.title = title;
		this.content = content;
		this.regip = regip;
		this.rdate = rdate;
	}

	public int getCate1() {
		return cate1;
	}

	public void setCate1(int cate1) {
		this.cate1 = cate1;
	}

	public int getCate2() {
		return cate2;
	}

	public void setCate2(int cate2) {
		this.cate2 = cate2;
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

	public int getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegip() {
		return regip;
	}

	public void setRegip(String regip) {
		this.regip = regip;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	@Override
	public String toString() {
		return "AdminCsFaqVo [cate1=" + cate1 + ", cate2=" + cate2 + ", currentPage=" + currentPage + ", lastPageNum="
				+ lastPageNum + ", pageGroupStart=" + pageGroupStart + ", pageGroupEnd=" + pageGroupEnd + ", total="
				+ total + ", faqNo=" + faqNo + ", title=" + title + ", content=" + content + ", regip=" + regip
				+ ", rdate=" + rdate + "]";
	}

}

package kr.green.lg.pagination;

import lombok.Data;

@Data
public class PageMaker {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum;
	private Criteria cri;
	private int finalPage;
	
	public void calcData() {
		endPage = (int) (Math.ceil(cri.getPage()/(double) displayPageNum)*displayPageNum);
		startPage = (endPage - displayPageNum)+1;
		finalPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		if(endPage > finalPage) 
			endPage = finalPage;
		prev = startPage == 1 ? false : true;
		next = endPage * cri.getPerPageNum() >= totalCount ? false:true;
	}
	public PageMaker(int totalCount, int displayPageNum, Criteria cri) {
		this.totalCount = totalCount;
		this.displayPageNum = displayPageNum;
		this.cri = cri;
		calcData();
	}
}

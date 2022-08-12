package kr.green.springtest.pagination;

import lombok.Data;

@Data
public class Criteria {

	private int page; 
	private int perPageNum;
	private String search;
	private String searchType;
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
		search = "";
		searchType = "all";
	}
	
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
}

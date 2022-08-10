package kr.green.spring.pagination;

import lombok.Data;

@Data
public class PageMaker {
	private int totalCount;//전체 컨텐츠 갯수(전체 페이지에서 마지막 페이지 번호를 구하기 위해)
	private int startPage; //시작 페이지 번호(현제 페이지네이션에서)
	private int endPage;	 //마지막 페이지 번호(현재 페이지네이션에서)
	private boolean prev;	//이전 버튼 활성화 여부(동작 방식에 따라 약간 다를 수 있음)
	private boolean next;	//다음 버튼 활성화 여부
	private int displayPageNum; //한 페이지네이션에서 보여지는 최대 페이지 개수
	private Criteria cri; //현재 페이지 정보
	
	/* endPage, startPage, prev, next 값 계산 */
	public void calcData() {
		/* starPage와 endPage는 현재 페이지 정보인 criteria와 displayPageNum을 이용하여 계산
		 * displayPageNum이 10이고 현재 페이지가 3페이지면 startPage = 1, endPage = 10이 되도록 계산 */
		endPage = (int) (Math.ceil(cri.getPage()/(double) displayPageNum)*displayPageNum);
		// criteria.getPage() : 6, displayPageNum : 10
		//endPage = (int) (Math.ceil(criteria.getPage()/(double) displayPageNum)*displayPageNum);
		//endPage = (int) (Math.ceil(6/10.0)*10);
		//endPage = (int) (1.0*10) = 10
		startPage = (endPage - displayPageNum)+1;
		//startPage = 1;
		//critera.getPerPageNum() : 10
		//totalCount : 101
		/* 총 콘텐츠 갯수를 이용하여 마지막 페이지 번호를 계산 */
		//tempEndPage : 마지막 페이지 번호(전체 페이지네이션중에서) 
		int tempEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		//int tempEndPage = (int)(Math.ceil(101/10.0));
		//int tempEndPage = (int)(Math.ceil(10.1));
		//int tempEndPage = (int)(11.0)=11;
		/* 현재 페이지에 계산된 현재 페이지메이커의 마지막 페이지 번호와 실제 마지막 페이지 번호를 비교하여
		 * 작은 값이 마지막 페이지 번호가 됨 */
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		//
		/* 현재 페이지메이커에 시작페이지가 1페이지면 prev가 없어야 함 */
		prev = startPage == 1 ? false : true;//첫번째 페이지네이션이면 이전버튼 비활성화
		//prev = criteria.getPage() == 1 ? false : true;//현재 페이지가 첫번째 페이지이면 이전버튼 비활성화
		/* 현재 페이지메이커에 마지막 페이지에 컨텐츠의 마지막이 포함되어 있으면 next가 없어야 함 */
		next = endPage * cri.getPerPageNum() >= totalCount ? false:true;//마지막 페이지네이션이면 다음버튼 비활성화
		//next = criteria.getPage() == endPage ? false : true;//현재 페이지가 마지막 페이지이면 다음버튼 비활성화 
	}
	
	public PageMaker(Criteria cri, int displayPageNum, int totalCount) {
		this.cri = cri;
		this.displayPageNum = displayPageNum;
		this.totalCount = totalCount;
		calcData();
	}
}

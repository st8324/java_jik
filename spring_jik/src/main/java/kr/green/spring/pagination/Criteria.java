package kr.green.spring.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //멤버변수가 모두 포함된 생성자
public class Criteria {
	//현재 페이지
	private int page; 
	//한 페이지 당 컨텐츠 갯수
	private int perPageNum;
	
	/* 쿼리문에서 limit에 사용되는 인덱스를 계산하는 getter */
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
}

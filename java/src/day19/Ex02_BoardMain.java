package day19;

import java.util.Scanner;

public class Ex02_BoardMain {

	public static void main(String[] args) {
		/*
		
		반복 : 종료 메뉴를 선택할 때까지

			콘솔창에 메뉴 출력
			
			실행할 메뉴를 콘솔에서 입력 받음
			
			입력받은 메뉴에 맞는 기능을 실행
				
				1번 메뉴를 선택 : 게시글 등록 기능을 실행
					타입 입력
					제목 입력
					내용 입력
					작성자 입력
					게시글 생성 후 저장(리스트에 생성한 게시글을 추가)
					
				
				2번 메뉴를 선택 : 게시글 확인 기능을 실행
					전체 게시글 확인
					게시글 선택
					게시글 상세 확인
				
				3번 메뉴를 선택 : 게시글 수정 기능을 실행
					전체 게시글 확인
					게시글 선택
					게시글 제목 입력
					게시글 내용 입력
					게시글 수정
				
				4번 메뉴를 선택 : 프로그램을 종료
				
				그외 메뉴를 선택 : 콘솔에 알림창 출력

		 */
		Scanner scan = new Scanner(System.in);
		String str1 = scan.next();
		scan.nextLine();
		String str2 = scan.nextLine();
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		

		

	}
	
}











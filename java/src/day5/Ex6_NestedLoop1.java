package day5;

public class Ex6_NestedLoop1 {

	public static void main(String[] args) {
		
		/* *****
		 * *****
		 * *****
		 * *****
		 * *****
		 */
		for(int i = 1; i<=5; i++) {
			//  * 5개 출력하고 엔터치는 코드를 
			//System.out.println("*****");
			//  * 5개 출력하고 엔터치는 반복문 코드로 수정
			// *을 5개 반복문으로 한줄에 출력
			for(int j = 1; j<=5; j++) {
				System.out.print("*");
			}
			// 엔터
			System.out.println();
		}
	}

}

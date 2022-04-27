package day3;

public class Ex12_For3_Even {

	public static void main(String[] args) {
		/* 1부터 10사이의 짝수를 출력하는 코드를 작성하세요. 
		 * 2	i=1
		 * 4	i=2
		 * 6	i=3
		 * 8	i=4
		 * 10	i=5
		 * 반복횟수 : i는 1부터 5까지 1씩 증가 
		 * 규칙성 : 2*i를 출력
		 * */
		int i;
		for(i=1; i<=5; i++) {
			System.out.println(2*i);
		}
		
		/* 1부터 10사이의 짝수를 출력하는 코드를 작성하세요. 
		 * 2	
		 * 4	
		 * 6	
		 * 8	
		 * 10	
		 * 반복횟수 : i는 1부터 10까지 1씩 증가
		 * 규칙성 : i가 짝수이면 i를 출력
		 * */
		for(i=1; i<=10; i++) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
		}
		/* 1부터 10사이의 짝수를 출력하는 코드를 작성하세요. 
		 * 2	
		 * 4	
		 * 6	
		 * 8	
		 * 10	
		 * 반복횟수 : i는 2부터 10까지 2씩 증가
		 * 규칙성 : i를 출력
		 * */
		for(i=2; i<=10; i +=2) {
			System.out.println(i);
		}
	}

}

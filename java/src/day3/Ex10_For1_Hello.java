package day3;

public class Ex10_For1_Hello {

	public static void main(String[] args) {
		/* 콘솔에 Hello를 5번 출력하세요.
		 * Hello	i=1	Hello
		 * Hello	i=2	Hello
		 * Hello	i=3	Hello
		 * Hello	i=4 Hello
		 * Hello	i=5 Hello
		 * 
		 * 반복횟수 : i는 1부터 5까지 1씩 증가
		 * 초기화 : i는 1부터
		 * 조건식 : i는 5까지(초기값에 따라 까지가 의미가 달라진다)
		 * 증감식 : i는 1씩 증가
		 * 규칙성(실행문) : Hello를 출력
		 * */
		int i;
		for(i = 1; i <= 5 ; i++) {
			System.out.println("Hello");
		}
	}
}

package day3;

public class Ex13_For4_Sum {

	public static void main(String[] args) {
		/* 1부터 5까지 합을 구하는 코드를 작성하세요.
		 * 		sum = 0
		 * i=1	sum = 0 + 1
		 * i=2	sum = 0 + 1 + 2
		 * i=3	sum = 0 + 1 + 2 + 3
		 * i=4	sum = 0 + 1 + 2 + 3 + 4
		 * i=5	sum = 0 + 1 + 2 + 3 + 4 + 5
		 * 
		 * 		sum = 0
		 * i=1	sum = sum + 1
		 * i=2	sum = sum + 2
		 * i=3	sum = sum + 3
		 * i=4	sum = sum + 4
		 * i=5	sum = sum + 5
		 * 반복횟수 : i는 1부터 5까지 1씩증가
		 * 규칙성 : sum = sum + i
		 * 반복문 종료 후 : sum을 출력
		 * */
		int i;
		int sum = 0;
		for(i = 1; i<=5; i++) {
			sum += i;//sum = sum + i;
		}
		System.out.println("1부터 5까지 합 : " + sum);
	}

}

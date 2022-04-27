package day3;

public class Ex14_For5_Divisor {
	
	public static void main(String [] args) {
		/* 정수 num의 약수를 출력하는 코드를 작성하세요. 
		 * A의 약수 : A를 어떤 수로 나누었을 때 나머지가 0과 같은 수
		 * 12의 약수 : 1 2 3 4 6 12
		 * 반복횟수 : i는 1부터 num까지 1씩 증가
		 * 규칙성 : i가 num의 약수이면 i를 출력
		 *  	  => num를 i로 나누었을 때 나머지가 0과 같다면 i를 출력
		 * */
		int i;
		int num = 12;
		for(i = 1; i <= num; i++) {
			if(num % i == 0 ) {
				System.out.print(i + " ");
			}
		}
	}
}

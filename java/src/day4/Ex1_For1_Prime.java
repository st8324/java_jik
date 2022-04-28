package day4;

public class Ex1_For1_Prime {

	public static void main(String[] args) {
		/* 정수가 num가 소수인지 아닌지 판별하는 코드를 작성하세요.
		 * 소수는 약수가 1과 자기자신인 수. 약수의 개수가 2개인 수
		 * 1 : 소수가 아님
		 * 2 : 소수. 1,2
		 * 3 : 소수. 1,3
		 * 4 : 소수가 아님. 1,2,4
		 * 
		 * 반복횟수 : num번 반복
		 *          i는 1부터 num까지 1씩 증가 
		 * 규칙성 : i가 num의 약수이면 약수의 개수를 하나 증가
		 * 		   num를 i로 나누었을 때 나머지가 0과 같다면 count를 1증가
		 * 반복문 종료 후 : 약수의 개수가 2개이면 소수라고 출력하고, 아니면 소수가 아님이라고 출력
		 * 		   		 count가 2와 같으면 소수라고 출력, 아니면 소수가 아님이라고 출력
		 * */
		int num = 1, i, count;
		//i는 1부터 num까지 1씩 증가 => 초기화, 조건식, 증감식으로 해야하는데 어떻게 해야하나요?
		//초기화는 ~부터
		//조건식은 ~까지. 초기화값이 기준값보다 작으면 <=로, 크면 >=로
		//증감식은 증가 또는 감소
		for(i=1, count=0 ; i <= num; i++) {
			//num를 i로 나누었을 때 나머지가 0과 같다면 count를 1증가
			if(num % i == 0) {
				count++;//count = count + 1;// count += 1;//++count;
			}
		}
		//count가 2와 같으면 소수라고 출력, 아니면 소수가 아님이라고 출력
		if(count == 2) {
			System.out.println(num + "는 소수");
		}else {
			System.out.println(num + "는 소수 아님");
		}
	}
}

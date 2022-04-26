package day2;

public class Ex5_Comparison {

	public static void main(String[] args) {
		/* >=를 반대로 쓰면 안됨 =>(x)
		 * <=를 반대로 쓰면 안됨 =<(x)
		 * ==를 =과 혼동하지 말자!
		 * 결과값이 참 또는 거짓
		 * 비교 연산자는 연산자를 기준으로 양쪽에 어떤 수가 나옴
		 * */
		int score = 95;
		System.out.println(score > 95);
		System.out.println(score >= 95);
		System.out.println(score < 95);
		System.out.println(score <= 95);
		System.out.println(score == 95);
		System.out.println(score != 95);

	}

}

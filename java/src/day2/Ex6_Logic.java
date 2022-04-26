package day2;

public class Ex6_Logic {

	public static void main(String[] args) {
		/* AND : &&, ~하고, ~이고, 둘다 참이면 참, 하나라도 거짓이면 거짓
		 * OR : ||, ~하거나, ~이거나, 둘다 거짓이면 거짓, 하나라도 참이면 참
		 * XOR : ^, 둘다 같으면 거짓, 다르면 참
		 * NOT : !, 참은 거짓, 거짓은 참
		 * 결과값이 참 또는 거짓 => 조건식
		 */
		/* 성적이 A학점인가? A학점의 기준 90점이상이고 100점이하
		 * score가 90점이상이고, score가 100점이하이다
		 * score가 90점이상 && score가 100점이하
		 * score >= 90 && score <= 100
		 */
		int score = 105;
		System.out.println(score + "점은 A학점인가? " + (score >= 90 && score <= 100));
		/* 잘못된 성적인가? 유효한 성적은 성적이 0점이상 100점이하
		 * 잘못된 성적은 성적이 0점미만이거나 100점초과
		 * 성적이 0점미만 || 성적이 100점 초과
		 * score < 0 || score > 100
		 * */
		System.out.println(score + "점은 잘못된 성적 인가? " + (score < 0 || score > 100));
		/* 유효한 성적인가? 잘못된 성적의 반대
		 * */
		System.out.println(score + "점은 유효한 성적 인가? " + !(score < 0 || score > 100));
	}

}

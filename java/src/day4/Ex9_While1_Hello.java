package day4;

public class Ex9_While1_Hello {

	public static void main(String[] args) {
		/* Hello를 5번 출력하는 예제 */
		int i = 1;
		while(i<=5) {
			System.out.println("Hello");
			i++;
		}
		i=5;
		while(i-- > 0) {
			System.out.println("Hi");
		}
	}

}

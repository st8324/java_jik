package day2;

public class Ex13_If3 {

	public static void main(String[] args) {
		/* num가 양수이면 양수라고 출력하고,
		 * num가 음수이면 음수라고 출력하고,
		 * num가 0이면 0이라고 출력하는 코드를 if문을 이용하여 작성하세요.
		 * */
		/* if문에서 
		 * if는 반드시 1개있어야 함.
		 * else if는 0개 이상 있을수 있음.
		 * else는 0개 또는 1개 있어야함.
		 * */
		int num = 5;
		if(num > 0 ) {
			System.out.println(num + "는 양수");
		}
		else if(num < 0) {
			System.out.println(num + "는 음수");
		}
		else{
			System.out.println(0);
		}
	}

}

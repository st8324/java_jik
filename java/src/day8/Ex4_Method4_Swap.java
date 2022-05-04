package day8;

public class Ex4_Method4_Swap {

	public static void main(String[] args) {
		/* 매개변수가 기본 타입 변수인 경우, 메소드 안에서 열심히 작업해도 원본은 안바뀜
		 * 매개변수가 참조 타입 변수인 경우, 메소드 안에서 원본이 값이 바뀔 수 있음 */
		Test num1 = new Test(10), num2 = new Test(20);
		System.out.println("main 메소드 - 전 num1 :" + num1 + ", num2 : " + num2);
		swap2(num1, num2);
		System.out.println("main 메소드 - 후 num1 :" + num1 + ", num2 : " + num2);
		
	}
	/* 기능 : 두 정수를 바꾸는 메소드 
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 없음 =>void
	 * 메소드명 : swap
	 * */
	public static void swap(int num1, int num2) {
		System.out.println("swap 메소드 - 전 num1 :" + num1 + ", num2 : " + num2);
		int tmp = num1;
		num1 = num2;
		num2 = tmp;
		System.out.println("swap 메소드 - 후 num1 :" + num1 + ", num2 : " + num2);
	}
	public static void swap2(Test num1, Test num2) {
		System.out.println("swap 메소드 - 전 num1 :" + num1 + ", num2 : " + num2);
		num1.num = 20;
		num2.num = 10;
		System.out.println("swap 메소드 - 후 num1 :" + num1 + ", num2 : " + num2);
	}
}
class Test{
	int num;
	public Test(int num) { 
		this.num = num;
	}
	public String toString() {
		return "" + num;
	}
}



package day15;

public class Ex10_Exception_Throw1 {

	public static void main(String[] args) {
		try {
			int num = 10;
			System.out.println("프로그램 시작");
			if(num % 2 == 0) {
				throw new ArithmeticException("예외");
			}
			System.out.println("프로그램 동작");
		}catch(ArithmeticException e) {
			System.out.println("산술 예외 발생");
		}catch(Exception e) {
			System.out.println("예외 발생");
		}
		System.out.println("프로그램 종료");

	}

}

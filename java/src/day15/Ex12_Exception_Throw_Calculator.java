package day15;

public class Ex12_Exception_Throw_Calculator {

	public static void main(String[] args) {
		int num1 = 1, num2 = 0;
		char op = '?';
		double res;
		
		try {
			res = calculator(num1, op, num2);
			System.out.println(""+ num1 + op + num2 +"=" + res);
		}catch(ArithmeticException e) {
			/* getMessage() : 예외 클래스에 저장된 메세지를 가져오는 메소드
			 * printStackTrace() : 예외가 발생한 메소드들의 위치를 찾아서 콘솔에 출력하는 메소드 */
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
	}
	/* 기능 : 두 정수와 산술 연산자가 주어지면 산술연산 결과를 알려주는 메소드
	 * 		 단, 연산자가 산술연산자가 아니면 예외가 발생
	 * 매개변수 : 두정수와 산술 연산자 => int num1, char op, int num2
	 * 리턴타입 : 산술연산결과 => 실수 => double
	 * 메소드명 : calculator
	 * */
	public static double calculator(int num1, char op, int num2) throws Exception{
		switch(op) {
		case '+':	return num1 + num2;
		case '-':	return num1 - num2;
		case '*':	return num1 * num2;
		case '/':
			if(num2 == 0) {
				throw new ArithmeticException("0으로 나눌 수 없습니다.");
			}
			return num1 / (double)num2;
		case '%':	return num1 % num2;
		default:	throw new Exception("산술연산자가 아닙니다.");
		}
	}
}

package day2;

public class Ex16_Test4 {

	public static void main(String[] args) {
		/* num1과 num2가 주어지고 산술 연산자 op가 주어졌을 때 산술 연산자에 맞는 결과가 출력되는 코드를 작성하세요. 
		 * op가 '+'이면 num1 + num2의 결과를 출력
		 * op가 '-'이면 num1 - num2의 결과를 출력
		 * op가 '*'이면 num1 * num2의 결과를 출력
		 * op가 '/'이면 num1 / num2의 결과를 출력
		 * op가 '%'이면 num1 % num2의 결과를 출력
		 * op가 산술 연산자가 아니면 잘못된 연산자라고 출력
		 * */
		int num1 = 1;
		int num2 = 2;
		char op = '?';
		if(op == '+') {
			System.out.println(""+num1 + op + num2 + "=" + (num1 + num2));
		}else if(op == '-') {
			System.out.println(""+num1 + op + num2 + "=" + (num1 - num2));
		}else if(op == '*') {
			System.out.println(""+num1 + op + num2 + "=" + (num1 * num2));
		}else if(op == '/') {
			System.out.println(""+num1 + op + num2 + "=" + (num1 / (double)num2));
		}else if(op == '%') {
			System.out.println(""+num1 + op + num2 + "=" + (num1 % num2));
		}else{
			System.out.println(op+"는 산술 연산자가 아닙니다.");
		} 
	}

}

package day3;

import java.util.Scanner;

public class Ex4_If1 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 코드를 작성하세요.
		 * 방법2 예제코드를 가져옴
		 * 
		 * op1이 +이면 num3 + num4를 출력하고,
		 * op1이 -이면 num3 - num4를 출력하고,
		 * op1이 *이면 num3 * num4를 출력하고,
		 * op1이 /이면 num3 / num4를 출력하고,
		 * op1이 %이면 num3 % num4를 출력하고,
		 * op1이 산술연산자가 아니면 op1은 산술연산자가 아니라고 출력
		 * 
		 * 두정수와 산술연산자를 입력하세요(예: 1 + 2) : 1 + 2
		 * 1+2=3
		 * */
	
		Scanner scan = new Scanner(System.in);
		System.out.print("정수와 산술연산자를 입력하세요(예: 1 + 2) : ");
		int num3 = scan.nextInt();
		char op1 = scan.next().charAt(0);
		int num4 = scan.nextInt();
		
		
		if(op1 == '+') {
			System.out.println(""+num3 + op1 + num4+"="+(num3+num4));
		}else if(op1 == '-') {
			System.out.println(""+num3 + op1 + num4+"="+(num3-num4));
		}else if(op1 == '*') {
			System.out.println(""+num3 + op1 + num4+"="+(num3*num4));
		}else if(op1 == '/') {
			System.out.println(""+num3 + op1 + num4+"="+((double)num3/num4));
		}else if(op1 == '%') {
			System.out.println(""+num3 + op1 + num4+"="+(num3%num4));
		}else {
			System.out.println(op1+"는 산술연산자가 아닙니다.");
		}
		
		
		scan.close();
	}

}

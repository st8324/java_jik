package day3;

import java.util.Scanner;

public class Ex3_Scanner3 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자(+ - * / %)를 입력받아 출력하는 코드를 작성하세요.
		 * 산술연산자는 문자로 받아주세요.
		 * 
		 * 방법1.
		 * 정수1을 입력하세요 : 1
		 * 정수2를 입력하세요 : 2
		 * 산술 연산자를 입력하세요 : +
		 * 1+2
		 * 
		 * 방법2.
		 * 두정수와 산술연산자를 입력하세요(예: 1 + 2) : 1 + 2
		 * 1+2
		 * */
		Scanner scan = new Scanner(System.in);
		//방법1
		System.out.print("정수1을 입력하세요 : ");
		int num1 = scan.nextInt();
		System.out.print("정수2을 입력하세요 : ");
		int num2 = scan.nextInt();
		System.out.print("산술 연산자를 입력하세요 : ");
		char op = scan.next().charAt(0);
		//정수 + 정수 => 정수
		//+는 유니코드표에서 십진수 43에 해당
		//문자열 + 정수 => 문자열
		System.out.println(""+num1 + op + num2);
		
		//방법2
		System.out.print("정수와 산술연산자를 입력하세요(예: 1 + 2) : ");
		int num3 = scan.nextInt();
		char op1 = scan.next().charAt(0);
		int num4 = scan.nextInt();
		System.out.println(""+num3 + op1 + num4);
		scan.close();
	}

}

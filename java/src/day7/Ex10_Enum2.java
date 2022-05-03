package day7;

import java.util.Scanner;

public class Ex10_Enum2 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산을 위한 문자열을 입력했을 때 산술 연산 결과를 출력하는 예제 */
		Scanner scan = new Scanner(System.in);
		System.out.print("두 정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		System.out.println("ADD : 더하기 ");
		System.out.println("SUB : 빼기 ");
		System.out.println("MUL : 곱하기 ");
		System.out.println("DIV : 나누기 ");
		System.out.println("MOD : 나머지 ");
		System.out.println("산술 연산자를 입력하세요 (예: ADD) : ");
		String op = scan.next();
		Operator operator = Operator.valueOf(op);
		switch(operator) {
		case ADD:
			System.out.println(num1 + " + " + num2 + " = " + (num1 + num2) );
			break;
		case SUB:
			System.out.println(num1 + " - " + num2 + " = " + (num1 - num2) );
			break;
		case MUL:
			System.out.println(num1 + " * " + num2 + " = " + (num1 * num2) );
			break;
		case DIV:
			System.out.println(num1 + " / " + num2 + " = " + (num1 / (double)num2) );
			break;
		case MOD:
			System.out.println(num1 + " % " + num2 + " = " + (num1 % num2) );
			break;
		}
	}
}
enum Operator{
	ADD, SUB, MUL, DIV, MOD
}
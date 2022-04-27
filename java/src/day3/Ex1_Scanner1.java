package day3;

import java.util.Scanner;

public class Ex1_Scanner1 {

	public static void main(String[] args) {
		/* 한 학생의 수학, 영어, 국어 성적을 입력받고, 총점과 평균을 구하세요.
		 * 단, 성적은 정수로 입력받고 0~100사이의 정수를 입력해야 합니다.
		 * 테스트 성적 : 90 90 91
		 * 
		 * 수학을 입력하세요 (0~100): 90
		 * 영어를 입력하세요 (0~100): 90
		 * 국어를 입력하세요 (0~100): 91
		 * 세 과목의 총점은 271점입니다.
		 * 세 과목의 평균은 90.333333점입니다.
		 * */
		Scanner scan = new Scanner(System.in);
		
		System.out.print("수학을 입력하세요 (0~100): ");
		int num1 = scan.nextInt();
		System.out.print("영어를 입력하세요 (0~100): ");
		int num2 = scan.nextInt();
		System.out.print("국어를 입력하세요 (0~100): ");
		int num3 = scan.nextInt();
		
		int sum = num1 + num2 + num3;
		System.out.println("세 과목의 총점은 "+ sum +"점입니다.");
		
		double avg = sum / 3.0;
		System.out.println("세 과목의 평균은 "+ avg +"점입니다.");
		scan.close();
	}

}

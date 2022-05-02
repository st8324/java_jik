package day6;

import java.util.Scanner;

public class Ex7_Array5_Score2 {

	public static void main(String[] args) {
		/* 최대 10명 학생의 성적을 저장하기 위한 배열을 선언하고,
		 * 입력할 학생수를 입력을 받아 입력받은 학생수만큼 성적을 입력받고 총점과 평균을 출력하는 코드를 작성하세요
		 * 예1>
		 * 학생수를 입력하세요 : 3
		 * 1번학생 : 90
		 * 2번학생 : 80
		 * 3번학생 : 70
		 * 총점 : 240점, 평균 : 80점
		 * 
		 * 예2>
		 * 학생수를 입력하세요 : 11
		 * 최대 10명까지입니다.
		 * 
		 * 예3>
		 * 학생수를 입력하세요. : 0
		 * 최소 1명부터입니다.
		 * */
		//scan 선언
		Scanner scan = new Scanner(System.in);
		//배열 선언 10개짜리
		int max = 10;
		int score[] = new int[max];
		//학생수 입력
		System.out.print("학생수를 입력하세요. : ");
		int count = scan.nextInt();
		//입력받은 학생수가 10보다 크면 최대 10명까지입니다.라고 출력
		if(count > 10) {
			System.out.println("최대 10명까지입니다.");
		}
		//(입력받은 학생수가 10보다 크지 않고) 0보다 작거나 같으면 최소 1명부터입니다.라고 출력
		else if(count <= 0) {
			System.out.println("최소 1명부터입니다.");
		}
		//(입력받은 학생수가 10보다 크지 않고 0보다 작거나 같지 않으면) 입력받은 학생수만큼 성적 입력 후 총점 계산
		else {
			int sum = 0;
			double avg = 0.0;
			for(int i = 0; i<count; i++) {
				System.out.print(i+1+"번 학생 : ");
				score[i] = scan.nextInt();
				sum += score[i];
			}
			//평균 계산
			avg = (double)sum / count;
			//총점과 평균 출력
			System.out.println("총점 : "+sum+"점, 평균 : "+avg+"점");
		}
		
	}

}

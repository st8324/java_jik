package day9;

import java.util.Scanner;

public class Ex1_Method1_Baseball {

	public static void main(String[] args) {
		/* 1~4사이의 중복되지 않은 3개의 수를 생성하여 배열에 저장하고 출력하는 코드를 작성하세요.
		 * contains와 printArray를 이용*/
		//3개짜리 배열을 생성
		int com[] = new int [3];
		int min = 1, max = 6;
		
		//저장된 갯수가 3개가 될때까지 : count가 3가 아니면 동작(count가 3보다 작으면 동작)
		for(int count = 0; count < 3; ) {
			//1~4사이의 랜덤한 수 생성
			int r = (int)(Math.random() * (max - min + 1) + min);
			
			//배열에 count개만큼 랜덤한 수와 비교하여 있는지 없는지 확인해서 없으면 배열 count번지에 랜덤한수 저장하고, 
			//count를 1증가
			if(!contains(com, count, r)) {
				com[count] = r;
				count++;
			}
		}
		//배열값 출력
		printArray(com);
		int user[] = new int[3];
		int strike = 0, ball = 0;
		Scanner scan = new Scanner(System.in);
		do {
			strike = 0;
			ball = 0;
			//사용자가 1~9사이의 정수 3개를 입력
			System.out.print("입력 : ");
			for(int i = 0; i<user.length; i++) {
				user[i] = scan.nextInt();
			}
			//스트라이트 갯수 확인
			strike = getStrike(com, user);
			//볼의 갯수 확인
			ball = getBall(com, user);
			//결과 출력
			printResult(strike, ball);
		}while(strike < 3);
		scan.close();
	}
	/* 기능 : 정수형 배열에서 처음부터 n개중에서 정수 num가 있는지 없는지 알려주는 메소드
	 * 매개변수 : 정수형 배열, 확인할 개수 n, 정수 num => int arr[], int n, int num
	 * 리턴타입 : 있는지 없는지 => boolean
	 * 메소드명 : contains
	 * */
	public static boolean contains(int arr[], int n, int num) {
		//배열이 잘못되거나 비교 갯수가 잘못되서 비교할 필요가 없는 경우
		if(arr==null || arr.length == 0 || n <= 0) {
			return false;
		}
		if(arr.length < n) {
			n = arr.length;
		}
		for(int i = 0; i<n; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	/* 기능 : 정수형 배열이 주어졌을 때, 주어진 배열의 값을 콘솔에 출력하는 메소드
	 * 매개변수 : 정수형 배열 => int num[]
	 * 리턴타입 : 없음 => void 
	 * 메소드명 : printArray
	 * */
	public static void printArray(int num[]) {
		if(num == null || num.length == 0) {
			System.out.println("출력할 배열이 없습니다.");
			return ;
		}
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}

	/* 기능 : 정수형 배열 2개가 주어지면 스트라이크 갯수(같은 자리에서 일치하는 숫자의 개수)를 알려주는 메소드
	 * 매개변수 : 정수형 배열 2개 => int arr1[], int arr2[]
	 * 리턴타입 : 스트라이크 갯수 => 정수 => int
	 * 메소드명 : getStrike */
	public static int getStrike(int arr1[], int arr2[]) {
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		int strike = 0;
		int count = arr1.length > arr2.length ? arr2.length : arr1.length;
		for(int i = 0; i<count; i++) {
			if(arr1[i] == arr2[i]) {
				strike++;
			}
		}
		return strike;
	}
	/* 기능 : 정수형 배열 2개가 주어지면 볼 갯수(다른 자리에서 일치하는 숫자의 개수)를 알려주는 메소드
	 * 매개변수 : 정수형 배열 2개 => int arr1[], int arr2[]
	 * 리턴타입 : 볼 갯수 => 정수 => int
	 * 메소드명 : getBall */
	public static int getBall(int arr1[], int arr2[]) {
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		int ball = 0;
		//전체 일차히는 갯수 = 볼 + 스트라이크의 갯수
		for(int tmp : arr1) {
			if(contains(arr2, arr2.length, tmp)) {
				ball++;
			}
		}
		//볼의 갯수 : 전체일치하는갯수 - 스트라이크 갯수
		return ball - getStrike(arr1, arr2);
	}

	/* 기능 : 스트라이크와 볼의 갯수가 주어지면 결과를 콘솔에 출력하는 메소드
	 * 1S1B, O, 1S, 2B
	 * 매개변수 : 스트라이크와 볼의 갯수 => int strike, int ball
	 * 리턴타입 : 없음 =>void
	 * 메소드명 : printResult */
	public static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.print(strike+"S");
		}
		if(ball != 0) {
			System.out.print(ball+"B");
		}
		if(strike == 0 && ball == 0) {
			System.out.print("O");
		}
		System.out.println();
	}
}






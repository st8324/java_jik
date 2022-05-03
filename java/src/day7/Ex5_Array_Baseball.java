package day7;

import java.util.Scanner;

public class Ex5_Array_Baseball {

	public static void main(String[] args) {
		/* 정수 3개짜리 배열 com을 생성 한 후 랜덤으로 1~9사이의 세 정수를 만들어 
		 * 배열에 저장하는 코드를 작성하세요. (중복 가능)*/
		
		int min = 1, max = 9;
		int com[] = new int[3];
		int user[] = new int[3];
		Scanner scan = new Scanner(System.in);
		/* 랜덤으로 생성한 수와 배열에 저장된 수들을 비교하여 중복된 수가 없으면 배열에 저장, 있으면 건너뜀
		 * [0, 0, 0] : 0
		 * 1 => [1, 0, 0] : 1
		 * 1
		 * 5 => [1, 5, 0] : 2
		 * 5 
		 * 2 => [1, 5, 2] : 3
		*/
		int count = 0;
		for( ; count < 3 ; ) {
			//랜덤한 수 생성
			int r = (int)(Math.random() * (max-min+1) + min);
			//랜덤한 수와 저장된 배열값들을 비교하여 중복이 안되면 저장
			int i=0;
			for(; i < count; i++) {
				if(r == com[i]) {
					break;
				}
			}
			//반복문 종료 후 i가 count와 같다는 의미는 중복된 수가 없다는 의미
			if(i == count) {
				com[count] = r;
				System.out.print(com[count] + " ");
				count++;
			}
		}
		
		System.out.println();
		/* 사용자가 정수 3개를 입력하여 3S가 될때까지 게임을 진행하도록 코드를 작성하세요.
		 * 단, 사용자가 입력한 정수도 배열에 저장. 
		 * */
		int s, b;
		do {
			s = 0;
			b = 0;
			//정수 3개를 입력 받음
			System.out.print("1~9사이의 정수를 중복되지 않게 입력하세요(예:1 2 3) : ");
			for(int i = 0; i<user.length; i++) {
				user[i] = scan.nextInt();
			}

			//스트라이크 갯수 확인
			for(int i = 0; i < com.length; i++) {
				if(com[i] == user[i]) {
					s++;
				}
			}
			//볼 갯수 확인
			for(int i = 0; i<com.length; i++) {
				for(int j = 0; j<user.length; j++) {
					if(i == j) {
						continue;
					}
					if(com[i] == user[j]) {
						b++;
					}
				}
			}
			s = 0;
			b = 0;
			//스트라이크와 볼 갯수를 같이 확인
			for(int i = 0; i<com.length; i++) {
				for(int j = 0; j<user.length; j++) {
					//같은 숫자가 있으면
					if(com[i] == user[j]) {
						//같은 자리이면 스트라이크, 다른 자리면 볼
						if(i == j) {
							s++;
						}else {
							b++;
						}
					}
				}
			}
			//s가 0이 아니면 s의 개수와 S를 출력
			if( s!= 0 ) {
				System.out.print(s + "S");
			}
			//b가 0이 아니면 b의 개수와 B를 출력
			if( b != 0 ) {
				System.out.print(b + "B");
			}
			//s가 0이고 b가 0이면 O를 출력
			if(s == 00 && b == 0) {
				System.out.print("O");
			}
			System.out.println();
		}while(s < 3);
		scan.close();
	}

}

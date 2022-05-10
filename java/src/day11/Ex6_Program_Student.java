package day11;

import java.util.Scanner;

public class Ex6_Program_Student {
	/* 학생 정보(이름, 학년, 반, 번호, 국어, 영어, 수학 성적)를 관리하는 프로그램을 작성하세요. 
	 * 1. 기능을 정리=>주석
	 *  - 학생정보 입력
	 *    - 학년, 반, 번호, 이름, 국어, 영어, 수학 성적을 한번에 입력받음
	 *    - 입력한 학생정보를 저장
	 *  - 학생정보 출력
	 *    - 전체 학생의 학년, 반, 번호, 이름, 국어, 영어, 수학 성적을 출력
	 *  - 학생정보 수정
	 *    - 학년, 반, 번호를 입력받음
	 *    - 입력받은 정보와 일치하는 학생이 있으면, 이름, 국어, 영어, 수학 성적을 전부 수정
	 *  - 학생 정보 삭제
	 *    - 학년, 반, 번호를 입력받음
	 *    - 입력받은 정보와 일치하는 학생이 있으면, 삭제
	 *  - 프로그램 종료
	 * 2. 필요한 클래스가 있는지 확인하고, 있으면 만듬
	 *  - 학생 클래스 : 이름, 학년, 반, 번호, 국어, 영어, 수학 성적
	 *  - 기능 : 
	 *    - 학생 정보를 출력하는 기능
	 *    - 학년, 반, 번호가 주어졌을 때 일치하는지 확인하는 기능
	 *    - 주어진 이름, 국어, 영어, 수학점수로 수정하는 기능 
	 *  - 생성자 : 이름, 학년, 반, 번호, 국어, 영어, 수학 성적이 주어졌을 때 초기화하는 생성자
	 * 3. 기능을 구현 
	 *  - 클래스 정의 및 구현
	 *  - 반복문을 이용하여 메뉴 출력 및 메뉴 선택
	 *  - 선택한 메뉴에 따른 조건문 생성
	 *  */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int menu = -1;
		final int max = 30;
		Ex6_Student std[] = new Ex6_Student[max];
		int index = 0;//여기서 index는 현재 저장된 학생의 수
		
		for( ; menu != 5 ; ) {
			//메뉴를 출력하고, 메뉴를 선택
			menu = selectMenu(scan);
			int grade, classNum, num;
			double kor, eng, math;
			String name;
			switch(menu) {
			case 1:
				//학년, 반, 번호, 이름, 국어, 영어, 수학 점수를 입력
				System.out.print("학생 정보를 입력하세요(학년, 반, 번호, 이름순) : ");
				grade = scan.nextInt();
				classNum = scan.nextInt();
				num = scan.nextInt();
				name = scan.next();
				System.out.print("학생 성적을 입력하세요(국어, 영어, 수학순) : ");
				kor = scan.nextDouble();
				eng = scan.nextDouble();
				math = scan.nextDouble();
				
				//Ex6_Student의 생성자를 이용하여 객체를 생성한 후 학생 배열 std에서
				//index 번지에 저장
				std[index] = new Ex6_Student(name, grade, classNum, num, kor, eng, math);
				//index를 1증가
				index++;
				break;
			case 2:
				//반복문을 이용하여 0번지부터 index명만큼 학생 정보를 출력
				for(int i = 0; i < index; i++) {
					std[i].print();
				}
				break;
			case 3: 
				//학년, 반, 번호를 입력
				System.out.print("수정할 학생 정보를 입력하세요(학년, 반, 번호) : ");
				grade = scan.nextInt();
				classNum = scan.nextInt();
				num = scan.nextInt();
				//반복문을 통해 0번지부터 index명만큼 학생 정보를 하나씩 가져와서 
				for(int i = 0; i<index; i++) {
					//입력받은 학년, 반, 번호와 일치하는 학생이 있는지 확인해서 있으면 
					if(std[i].equal(grade, classNum, num)) {
						//이름, 국어, 영어, 수학 성적을 입력 받은 후
						System.out.print("수정할 학생 이름과 성적을 입력하세요(이름, 국어, 영어, 수학순) : ");
						name = scan.next();
						kor = scan.nextDouble();
						eng = scan.nextDouble();
						math= scan.nextDouble();
						//학생 정보를 수정하고, 반복문을 종료
						std[i].modify(name, kor, eng, math);
						break;
					}
					//등록된 학생 전체를 확인해서 일치하는 학생이 없으면 등록된 학생이 아닙니다라고 출력
					if(i+1 == index) {
						System.out.println("등록된 학생이 아닙니다.");
					}
				}
				break;
			case 4:
				//학년, 반, 번호를 입력
				System.out.print("삭제할 학생 정보를 입력하세요(학년, 반, 번호) : ");
				grade = scan.nextInt();
				classNum = scan.nextInt();
				num = scan.nextInt();
				int delIndex = -1; //삭제할 학생 정보의 번지
				//삭제할 위치를 찾음
				//반복문을 이용하여 0번지부터 index명의 학생을 비교하여 
				for(int i = 0 ; i<index; i++) {
					//일치하는 학생 정보가 있으면 delIndex번지이지 기억하고 반복문을 종료
					if(std[i].equal(grade, classNum, num)) {
						delIndex = i;
						break;
					}
				}
				//delIndex가 0이상이면 => 일치하는 학생이 있으면 
				if(delIndex >= 0) {
					//삭제하는 부분
					//반복문을 이용하여 delIndex번지부터 index-2번지까지 다음번지에 있는 정보를 현재 번지에 저장
					for(int i = delIndex; i < index-1; i++) {
						std[i] = std[i+1];
					}
					//index를 1 감소
					index--;
				}
				//delIndex가 0 미만이면 등록된 학생이 아닙니다를 출력
				else {
					System.out.println("등록된 학생이 아닙니다.");
				}
				break;
			case 5:
				System.out.println("프로그램을 종료합니다..........");
				break;
			default:
				System.out.println("메뉴를 잘못 선택했습니다.!!!!!!!!!");
			}
		}
	}
	/* 기능 : 메뉴를 출력하고 메뉴를 입력하면 입력한 메뉴를 돌려주는 메소드
	 * 매개변수 : 입력받기 위한 Scanner => Scanner scan
	 * 리턴타입 : 입력한 메뉴 => 정수 => int
	 * 메소드명 : selectMenu */
	public static int selectMenu(Scanner scan) {
		System.out.println("----------메뉴--------");
		System.out.println("1. 학생정보 입력");
		System.out.println("2. 학생정보 출력");
		System.out.println("3. 학생정보 수정");
		System.out.println("4. 학생정보 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴를 선택하세요 : ");
		int menu = scan.nextInt();
		System.out.println("---------------------");
		return menu;
	}
}











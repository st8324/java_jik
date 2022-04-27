package day3;

public class Ex8_Switch2 {

	public static void main(String[] args) {
		/* 월이 주어졌을 때 주어진 월의 마지막일을 출력하는 코드를 작성하세요.(switch문)
		 * 31 : 1 3 5 7 8 10 12
		 * 30 : 4 6 9 11
		 * 28 : 2
		 * */
		int month = 8;
		switch(month) {
		case 1,3,5,7,8,10,12:
			System.out.println(month + "월은 31일까지 있습니다.");//이 실행문은 누구의 실행문일까요? case 12
			break;
		case 2:
			System.out.println(month + "월은 28일까지 있습니다.");
			break;
		case 4,6,9,11:
			System.out.println(month + "월은 30일까지 있습니다.");
			break;
		default:
			System.out.println(month + "월은 없는 달입니다.");
		}
	}

}

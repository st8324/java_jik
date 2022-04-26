package day2;

public class Ex15_Test3 {

	public static void main(String[] args) {
		/* month가 주어질 때 해당 달의 마지막 일을 출력하는 코드를 if문으로 작성하세요.
		 * 31 : 1 3 5 7 8 10 12
		 * 30 : 4 6 9 11
		 * 28 : 2
		 * 그 외의 달은 잘못된 월입니다라고 출력
		 * month가 1이거나 month가 3이거나 month가 5이거나 month가 7이거나 month가 8이거나 month가 10이거나
		 * month가 12이면 31일이라고 출력하고
		 * month가 4이거나 month가 6이거나 month가 9이거나 month가 11이면 30일이라고 출력하고
		 * month가 2이면 28일이라고 출력하고
		 * 아니면 잘못된 월입니다라고 출력
		 * */
		int month = 13;
		if(month < 1 || month > 12) {
			System.out.println(month + "월은 잘못된 월입니다.");
		}else if(month == 2) {
			System.out.println(month + "월은 28일까지 있습니다.");
		}else if(month == 4 || month == 6 || month == 9 || month == 11 ) {
			System.out.println(month + "월은 30일까지 있습니다.");
		}else {
			System.out.println(month + "월은 31일까지 있습니다.");
		}
	}

}

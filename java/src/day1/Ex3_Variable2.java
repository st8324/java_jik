package day1;

public class Ex3_Variable2 {

	public static void main(String[] args) {
		/* 변수는 읽기를 하려면 초기화가 되어있어야 함.
		 * 초기화 되지 않은 변수를 읽어오려고 하면 에러 발생
		 * */
		int num;
		
		//System.out.println(num);//변수가 초기화 되지 않아 에러 발생
		num = 10;
		System.out.println(num);

	}
}

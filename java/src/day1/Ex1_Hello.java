package day1;

public class Ex1_Hello {
	// 콘솔 응용 프로그램이 실행되기 위해서 main이라는 얘(메소드)가 필요하다
	public static void main(String[] args) {
		/* 여러줄 주석
		 * 주석1
		 * 주석2
		 * */
		// 한줄 주석은 아무 위치에서 사용가능하지만 중간은 안됨
		/* println(문자열) : 문자열을 콘솔에 출력한 후 줄바꿈을 함(엔터효과)
		 * print(문자열) : 문자열을 콘솔에 출력  
		 * */
		System.out.print("Hello world!!");
		System.out.println("Hello world!!"); // 한줄 주석은, 주석기호가 나온 시점부터 해당 라인 끝까지 주석처리
		System.out.print("Hello world!!");
	}
}

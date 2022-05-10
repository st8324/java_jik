package day11;

import day11_1.*;

public class Ex5_AccessModifier {

	public static void main(String[] args) {
		Ex5_A t1 = new Ex5_A();
		//public은 모두 사용 가능 
		System.out.println(t1.num1);
		//default는 같은 패키지내에서 사용 가능
		System.out.println(t1.num2);
		//private은 내 클래스에서만 사용 가능
		//System.out.println(t1.num3);//에러 발생
		
		Ex5_B t2 = new Ex5_B();
		//public은 모두 사용 가능 
		System.out.println(t2.num1);
		//default는 같은 패키지내에서 사용 가능
		//System.out.println(t2.num2);//에러 발생. 다른 패키지에 있는 클래스이기 때문
		//private은 내 클래스에서만 사용 가능
		//System.out.println(t2.num3);//에러 발생
		//public int num = 2;//지역 변수에 접근제한자를 붙일 수 없다
	}
	public int num = 1;

}

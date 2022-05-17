package day16;

import java.util.Comparator;
import java.util.Objects;

public class Ex01_Objects_Compare {

	public static void main(String[] args) {
		Integer num1 = 10, num2 = 20;
		/* Objects.compare()에서 세번째 매개변수는 Comparator인터페이스의 객체가 필요 
		 * => Comparator 인터페이스의 구현 클래스가 필요
		 * => 구현 클래스 대신 익명 객체를 이용
		 * => Objects.compare()의 리턴값
		 * 	  => 0 : 같다
		 * 	  => 음수 : 앞에 수가 작다
		 * 	  => 양수 : 앞에 수가 크다
		 * */
		System.out.println(Objects.compare(num1, num2, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		}));
		System.out.println(Objects.compare(num1, num2, new Ex1_A()));
	}

}
class Ex1_A implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1 - o2;
	}
	
}

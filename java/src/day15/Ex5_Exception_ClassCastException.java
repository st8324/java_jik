package day15;

public class Ex5_Exception_ClassCastException {

	public static void main(String[] args) {
		/* 강제 클래스 타입 변환시 발생할 수 있음. 
		 * 부모 객체를 자식 객체로 강제 타입 변환할 때 안되는 경우 발생 */
		//Ex5_C c = (Ex5_C)new Ex5_P();
		//c.print();
		/* 메소드의 매개변수를 다형성을 이용하려고 Object로 한 경우 발생할 수 있다
		 * */
		String str = "abc";
		test(str);
	}
	public static void test(Object obj) {
		Ex5_C c = (Ex5_C)obj;
		c.print();
	}
}

class Ex5_P{}

class Ex5_C extends Ex5_P{
	void print() {}
}

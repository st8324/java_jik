package day15;

public class Ex2_Anonymous {

	public static void main(String[] args) {
		//구현 클래스 생성 후 객체를 생성
		Test test = new TestA();
		test.test();
		//구현 클래스 생성 없이 이름 없는 클래스를 바로 만들어서 객체를 생성
		Test test2 = new Test() {
			
			@Override
			public void test() {
				System.out.println("테스트2");
			}
		};
		test2.test();
	}

}

interface Test{
	void test();
}

class TestA implements Test{

	@Override
	public void test() {
		System.out.println("테스트");
	}
	
}
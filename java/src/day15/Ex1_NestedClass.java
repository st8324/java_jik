package day15;

public class Ex1_NestedClass {

	public static void main(String[] args) {
		//A.num = 10;//x 인스턴스 변수이어서 클래스를 통해 호출할 수 없다
		A a = new A();//A생성자 호출
		A.B b = a.new B();//B생성자 호출
		
		A.num2 = 10;
		A.C c = new A.C();//C생성자 호출. A객체 생성 없이 호출 가능. static
		
		a.method(1);
	}

}

class A{
	public int num=1;
	public static int num2;
	
	B b1 = new B();
	C c1 = new C();
	//static B b2 = new B();
	static C c2 = new C();
	
	//인스턴스(객체) 멤버 클래스
	class B{
		int num=2;
		public B() {	
			System.out.println("B생성자");
			System.out.println(this.num);//B객체의 num를 호출
			System.out.println(A.this.num);//바깥 클래스 A 객체의 num를 호출
		}
	}
	//정적(클래스) 멤버 클래스
	static class C{
		public C() {	System.out.println("C생성자");	}
	}
	public void method(int num) {
		char ch='a';
		//로컬 클래스
		//로컬 클래스에서 메소드의 매개변수와 지역변수를 사용할 수 있는데
		//이때 자동으로 final이 붙는다(처음부터 붙는게 아니라 로컬에서 호출할 때 
		//final이 붙음). 그래서 매개변수와 지역변수를 로컬클래스에서
		//수정할 수 없다
		class D{
			public D() {	
				System.out.println("D생성자"); 	
				//ch = 'b';	//X
				//num = 2;	//X
			}
		}
		D d = new D();
		ch = 'c';
	}
	
	public A() {	System.out.println("A생성자");	}
}




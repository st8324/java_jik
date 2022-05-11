package day12;

public class Ex6_Abstract {

	public static void main(String[] args) {
		//추상 클래스를 이용하여 객체를 만들 수 없다.
		//Ex6_Animal animal = new Ex6_Animal();
		Ex6_Dog dog = new Ex6_Dog();
		dog.bark();
		Ex6_Animal animal = new Ex6_Dog();
		animal.bark();
	}
}

/* 추상 클래스는 추상 메소드와 일반 메소드 모두 존재할 수 있다. 
 * 추상 메소드에는 필드가 있을 수 있다.*/
abstract class Ex6_Animal{
	public String type;//목
	public abstract void bark();
	public void print() {
		System.out.println("동물입니다.");
	}
}
/* 추상 클래스를 상속 받은 일만 클래스는 반드시 추상메소드를 오버라이딩해야한다. */
class Ex6_Dog extends Ex6_Animal{

	@Override
	public void bark() {
		System.out.println("멍멍");
	}
	
}
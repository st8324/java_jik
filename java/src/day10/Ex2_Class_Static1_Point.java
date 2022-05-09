package day10;

public class Ex2_Class_Static1_Point {

	public static void main(String[] args) {
		//에러 발생 : print()메소드는 객체 메소드이기 때문에 클래스 이름으로 호출할 수 없다
		//Point1.print();
		//print()메소드는 객체 메소드이기 때문에 객체를 생성 후 호출해야 한다.
		Point1 p1 = new Point1(10,20);
		p1.print();
		//printDimensional() 메소드는 클래스 메소드이기 때문에 클래스 이름으로 호출할 수 있다.
		Point1.printDimensional();
		//클래스 메소드는 객체를 이용하여 호출할 수 있지만 경고가 뜬다.
		p1.printDimensional();
		
	}

}

class Point1{
	static String dimensional="이차원";//클래스 변수
	int x, y;//객체변수
	
	public Point1(int x, int y) {
		//내 필드 x,y에 매개변수 x,y의 값을 저장
		this.x = x;
		this.y = y;
	}
	public Point1() {
		this(0,0);
	}
	public void print() {
		System.out.println("차원 : " + dimensional);
		System.out.println("좌표 : " + x + "," + y);
	}
	public void move(int x, int y) {
		this.x = x; 
		this.y = y;
	}
	public static void printDimensional() {
		System.out.println("차원 : " + dimensional);
	}
}

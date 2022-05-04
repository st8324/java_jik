package day8;

public class Ex6_Class2 {

	public static void main(String[] args) {
		
		Point2 p1 = new Point2();
		p1.print();
		p1.setX(20);
		p1.print();
		System.out.println(p1.getX());
	}

}

class Point2{
	private int x,y;
	
	public void print() {
		System.out.println(x + ", " + y);
	}
	/* 기능 : 내 x좌표의 값을 주어진 x1으로 수정하는 메소드
	 * 매개변수 : 수정할 좌표 x1 => int x1
	 * 리턴타입 : 없음 => void 
	 * 메소드명 : setX*/
	public void setX(int x1) {
		x = x1;
	}
	public void setY(int y1) {
		x = y1;
	}
	/* 기능 : 내 x좌표의 값을 알려주는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 내 x좌표 => 정수 => int
	 * 메소드명 : getX*/
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
class Point3{
	private int x,y;
	
	public void print() {
		System.out.println(x + ", " + y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}




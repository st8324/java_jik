package day8;

public class Ex5_Class1 {

	public static void main(String[] args) {
		Point1 p1 = new Point1();
		p1.print();
		p1.x1 = 20;
		//p1.x2 = 20;//에러 발생. 접근제한자가 private이기 때문에
		p1.x = 20;
		p1.print();
	}
}

/* class 앞에 public은 클래스이름과 파일이름이 같은 경우에만 붙일 수 있다. */
/* 좌표평면(2차원 화면)에서 두 점을 나타내는 클래스 : Point*/
class Point1{
	//멤버변수 => 좌표평면에서 점을 나타내기 위해 필요한 정보 => 클래스내 메소드에서 사용
	//멤버 변수는 초기화를 하지 않아도 각 타입의 기본값으로 초기화가 자동으로 됨
	//x좌표, y좌표
	int x, y;
	public int x1, y1;
	private int x2, y2;
	//메소드 => 기능
	/* 기능 : 현재 좌표를 출력하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : print
	 * */
	public void print() {
		System.out.println(x + ", " + y);
		x1 = 20;
		x2 = 20;
	}
}
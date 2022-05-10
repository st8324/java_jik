package day11;

public class Ex3_Singleton {

	public static void main(String[] args) {
		Test3 t1 = Test3.getInstance();
		Test3 t2 = Test3.getInstance();
		if(t1 == t2) {
			System.out.println("같은 객체");
		}else {
			System.out.println("다른 객체");
		}
	}

}

class Test3{
	//자신의 클래스를 이용하여 정적(클래스) 멤버를 선언하고 객체를 생성
	private static Test3 t = new Test3(5);
	private int num;
	//외부에서 생성자를 호출하지 못하도록 접근제한자를 private으로 설정
	private Test3(int num) {
		this.num = num;
	}
	//생성된 객체를 외부에서 사용할 수 있도록 getInstance를 구현
	public static Test3 getInstance() {
		return t;
	}
}
package day13;

public interface Controller {
	int MIN = 1;//public static final이 앞에 자동으로 붙는다.
	void run();	//public abstract 앞에 자동으로 붙는다.
	void stop();
	void print();
	default void test() {
		System.out.println("테스트입니다.");
	}
}

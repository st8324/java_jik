package day20;

public class Ex02_Thread1 {

	public static void main(String[] args) {
		//
		//Test1 t1 = new Test1();
		//Thread th1 = new Thread(t1);
		Thread th1 = new Thread(new Test1());
		th1.setPriority(Thread.MAX_PRIORITY);
		th1.start();
		
		Thread th2 = new Test2();
		th2.setPriority(Thread.MIN_PRIORITY);
		th2.start();
		
		Thread th3 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i =0; i<10000; i++) {
					System.out.println("@");
				}
			}
		});
		
		th3.start();
		for(int i =0; i<10000; i++) {
			System.out.println("|");
		}
		

	}

}
//Runnable 인터페이스를 구현한 구현 클래스를 이용
class Test1 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i<10000; i++) {
			System.out.println("-");
		}
	}
	
}
//Thread 클래스를 상속 받은 자식 클래스를 이용
class Test2 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i<10000; i++) {
			System.out.println("*");
		}
	}
}




package day20;

import java.awt.Toolkit;

public class Ex03_Thread2_2 {

	public static void main(String[] args) {
		Thread th = Thread.currentThread();
		Thread th1 = new Thread1();
		Thread th2 = new Thread2();
		th1.setName("쓰레드1");
		th2.setName("쓰레드2");
		th1.start();
		th2.start();
		System.out.println("main 쓰레드 이름 : " + th.getName());
		System.out.println("Thread1 이름 : " + th1.getName());
		System.out.println("Thread2 이름 : " + th2.getName());
	}
}

class Thread1 extends Thread{
	@Override
	public void run() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		for(int i = 0 ; i<5; i++) {
			tk.beep();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}
class Thread2 extends Thread{
	@Override
	public void run() {
		for(int i = 0 ; i<5; i++) {
			System.out.println("띵");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}








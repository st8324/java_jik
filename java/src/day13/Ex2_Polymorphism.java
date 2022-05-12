package day13;

public class Ex2_Polymorphism {
	
	public static void main(String[] args) {
		Controller controller[] = new Controller[3];
		controller[0] = new RadioController();
		controller[1] = new TvController();
		controller[2] = new TvController();

		controller[1].run();
		for(int i = 0; i<900; i++) {
			if(controller[1] instanceof RadioController) {
				RadioController tmp = (RadioController)controller[1];
				tmp.frequencyUp();
			}
			if(controller[1] instanceof TvController) {
				TvController tmp = (TvController)controller[1];
				tmp.channelUp();
			}
		}
		System.out.println("-------------");
		for(Controller tmp : controller) {
			printController(tmp);
			System.out.println("-------------");
		}
	}
	//매개변수가 인터페이스이면 호추할 때 인터페이스를 구현한 구현 객체가 와야 함
	public static void printController(Controller con) {
		con.print();
	}
	/*
	public static void printController(TvController con) {
		con.print();
	}
	public static void printController(RadioController con) {
		con.print();
	}*/
}

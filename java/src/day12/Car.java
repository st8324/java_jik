package day12;

public class Car {
	private Tire tire[];

	public Car(Tire[] tire) {
		this.tire = tire;
	}
	public void print() {
		if(tire == null) {
			return;
		}
		for(Tire tmp : tire) {
			System.out.println(tmp.getPosition() + ", 압력 : " + tmp.getPressure() + ", 상태 : " + tmp.getState());
		}
	}
}

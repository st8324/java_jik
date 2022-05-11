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
			if(tmp instanceof HankookTire) {
				System.out.print(HankookTire.COMPANY + " : ");
			}else if(tmp instanceof KumhoTire) {
				System.out.print(KumhoTire.COMPANY + " : ");
			}
			System.out.println(tmp.getPosition() + ", 압력 : " + tmp.getPressure() + ", 상태 : " + tmp.getState());
		}
	}
	public void repare(int index, Tire tire) {
		if(this.tire == null || this.tire.length <= index) {
			return;
		}
		this.tire[index] = tire;
	}
	public void repare(int index, HankookTire tire) {
		if(this.tire == null || this.tire.length <= index) {
			return;
		}
		this.tire[index] = tire;
	}
	public void repare(int index, KumhoTire tire) {
		if(this.tire == null || this.tire.length <= index) {
			return;
		}
		this.tire[index] = tire;
	}
}

package day13;

public class RadioController implements Controller{
	private double frequency;
	private int volumn;
	private boolean power;
	
	@Override
	public void run() {
		power = true;
		System.out.println("라디오 전원이 켜집니다.");
	}

	@Override
	public void stop() {
		power = false;
		System.out.println("라디오 전원이 꺼집니다.");
	}

	@Override
	public void print() {
		System.out.println("전원 : " + (power?"켜짐":"꺼짐"));
		System.out.println("주파수: " + frequency);
		System.out.println("음량 : " + volumn);
	}
	public void frequencyUp(){
		frequency = power ? frequency+0.1 : frequency;
	}
	public void frequencyDown() {
		frequency = power ? frequency-0.1 : frequency;
	}
	public void volumnUp() {
		volumn = power ? volumn + 1 : volumn;
	}
	public void volumnDown() {
		volumn = power ? volumn - 1 : volumn;
	}
}

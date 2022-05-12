package day13;

public class TvController implements Controller {
	private int channel;
	private int volumn;
	private boolean power;
	
	@Override
	public void run() {
		power = true;
		System.out.println("TV 전원이 켜집니다.");
	}

	@Override
	public void stop() {
		power = false;
		System.out.println("TV 전원이 꺼집니다.");
	}

	@Override
	public void print() {
		System.out.println("전원 : " + (power?"켜짐":"꺼짐"));
		System.out.println("채널 : " + channel);
		System.out.println("음량 : " + volumn);
	}
	public void channelUp(){
		channel = power ? channel+1 : channel;
	}
	public void channelDown() {
		channel = power ? channel-1 : channel;
	}
	public void volumnUp() {
		volumn = power ? volumn + 1 : volumn;
	}
	public void volumnDown() {
		volumn = power ? volumn - 1 : volumn;
	}
}

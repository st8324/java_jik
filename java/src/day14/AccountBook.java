package day14;
//가계부
public class AccountBook {
	//내역의 최대 개수
	public static final int MAX = 100;
	//가계부에서 내역이 최대 100개 기록할 수 있다
	private Item items[] = new Item[MAX];
	private int count;//현재 기록된 내역의 개수
	
	/* 기능 : 현재까지 기록된 내역을 확인하는 메소드 
	 *		 items에 있는 내역들을 count개 출력하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : readItems
	 * */
	public void readItems() {
		for(int i = 0; i<count; i++) {
			System.out.println(items[i]);//여기에서 itmes[i]는 items[i].toString()로 호출
		}
	}
	/* 기능 : 가계부에 새 내역을 추가하는 메소드
	 * 
	 * 매개변수 : 
	 * 리턴타입 : 
	 * 메소드명 : insertItem 
	 * */
	
}

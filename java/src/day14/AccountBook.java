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
		if(count == 0) {
			System.out.println("입력된 내역이 없습니다.");
			return;
		}
		for(int i = 0; i<count; i++) {
			System.out.println(i+1+". "+items[i]);//여기에서 itmes[i]는 items[i].toString()로 호출
		}
	}
	/* 기능 : 가계부에 새 내역을 추가하여 추가됐는지를 알려주는 메소드
	 * 		 새 내역(Item)이 주어지면 items에 추가하여 추가 됐는지를 알려주는 메소드
	 * 매개변수 : 새 내역 => Item item
	 * 리턴타입 : 추가 여부 => 성공/실패 => boolean
	 * 메소드명 : insertItem 
	 * */
	public boolean insertItem(Item item) {
		//가계부에 쓸 공간이 없는 경우
		if(count == MAX) {
			return false;
		}
		//추가해야하는 내역이 비었을 때
		if(item == null) {
			return false;
		}
		items[count++] = item;
		return true;
	}
	/* 기능 : 가계부에 기존 내역을 삭제하여 삭제한 내역을 알려주는 메소드
	 * 		 삭제할 번지가 주어지면 주어진 내역을 삭제하고 알려주는 메소드
	 * 매개변수 : 삭제할 번지 => int delIndex
	 * 리턴타입 : 삭제한 내역 => Item
	 * 메소드명 : deleteItem
	 * */
	public Item deleteItem(int delIndex) {
		//잘못된 번지인 경우
		if(delIndex >= count || delIndex < 0) {
			return null;
		}
		//삭제할 내역을 임시저장(나중에 알려줘야 하기 때문에)
		Item delItem = items[delIndex];
		//삭제한 위치부터 하나씩 밀어줌
		for(int i=delIndex; i<count-1; i++) {
			items[i] = items[i+1];
		}
		//삭제후 저장된 개수를 줄임
		count--;
		//삭제한 내역을 알려줌
		return delItem;
	}
	/* 기능 : 가계부에 기존 내역을 수정하여 수정 여부를 알려주는 메소드
	 * 
	 * 매개변수 : 수정할 번지, 수정할 내용들 => int modIndex, String date, boolean income, String payment, String content, int price
	 * 리턴타입 : 수정 여부 => boolean
	 * 메소드명 : modifyItem
	 * */
	public boolean modifyItem(int modIndex, String date, boolean income, String payment, String content, int price) {
		//잘못된 번지인 경우
		if(modIndex >= count || modIndex < 0) {
			return false;
		}
		items[modIndex].modify(date, income, payment, content, price);
		return true;
	}
	public Item getItem(int index) {
		if(index < 0 || index >= count) {
			return null;
		}
		return items[index].clone();
	}
	public void readItems(String type, String date) {
		switch(type) {
		case "date":
			for(int i = 0; i<count; i++) {
				if(items[i].getDate().equals(date)) {
					System.out.println(i+1+". " + items[i]);
				}
			}
			break;
		}
	}
}






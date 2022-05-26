package day23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01_UpDownGame {

	public static void main(String[] args) {
		/* - 1~100사이의 랜덤한 수를 맞추는 Up Down 게임 프로그램을 작성하세요.
		 * - 기록을 저장하는 기능을 추가
		 * - 기록은 최대 5등까지
		 * - 5등이내의 기록은 이름을 기록하여 저장
		 * - 한 사람이 여러 기록을 가질 수 있다
		 * - 같은 기록이 경우 기록된순서대로
		 * - 잘못된 정수를 입력해도 시도한걸로 인정
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * */
		Scanner scan = new Scanner(System.in);
		int menu;
		int min = 1, max = 100;
		List<Record> list = new ArrayList<Record>();
		list.add(new Record(1, "일길동"));
		list.add(new Record(7, "이길동"));
		list.add(new Record(8, "삼길동"));
		//list.add(new Record(9, "사길동"));
		//list.add(new Record(10, "일길동"));
		do {
			System.out.println("1.플레이");
			System.out.println("2.기록확인");
			System.out.println("3.종료");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:
				//게임플레이
				//랜덤한 수 생성
				int r = (int)(Math.random()*(max-min+1)+min);
				System.out.println(r);
				int count = 0;//시도 횟수
				//맞출때까지 게임을 반복
				while(true) {
					//숫자를 입력받아서 비교
					System.out.print("정수 입력(1~100) : ");
					int num = scan.nextInt();
					count++;
					if(num > r) 
						System.out.println("DOWN");
					else if(num < r)
						System.out.println("UP");
					else 
						break;
				}
				System.out.println("정답입니다.");
				//내 기록 확인
				//새 기록이면(5등이내이면)
				//이름 입력하고 저장
				int i;
				for(i = 0; i<list.size(); i++) {
					if(list.get(i).getCount() > count) {
						break;
					}
				}
				//list.size() < 5 : 저장된 기록이 5개 미만
				//i < list.size() : 저장된 기록이 5개 이상 중에 지금 플레이한 횟수가
				//					등수에 포함될 때
				//					위에서 break가 동작하면 i는 list.size()보다 작고
				//					break가 동작 안하면 i는 list.size()
				if(list.size() < 5 || i < list.size() ) {
					System.out.println("새로운 기록이 달성됐습니다. 기록을 저장하세요.");
					System.out.print("이름 : ");
					
					list.add(i, new Record(count, scan.next()));
					list = list.subList(0, list.size() > 5 ? 5 : list.size());
				}
				break;
			case 2:
				for(int j = 0; j<list.size(); j++) {
					System.out.println(j+1+". " + list.get(j));
				}
				break;
			case 3: 
				//프로그램 종료
				System.out.println("프로그램 종료");
				break;
			default:
			}
			
		}while(menu != 3);
		
		scan.close();
	}
}
class Record{
	private int count;
	private String name;

	public Record(int count, String name) {
		this.count = count;
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "[ " + name + " : " + count + "]";
	}
	
}




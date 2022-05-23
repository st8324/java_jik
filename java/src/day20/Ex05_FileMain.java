package day20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex05_FileMain {

	public static void main(String[] args) {
		//파일들을 관리할 리스트
		List<String> list = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		int menu;
		do {
			System.out.println("메뉴");
			System.out.println("1. 파일 저장");
			System.out.println("2. 파일 확인");
			System.out.println("3. 파일 검색");
			System.out.println("4. 프로그램 종료");
			System.out.print("메뉴를 선택하세요 : ");
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				System.out.print("파일명 : ");
				String inpuString = scan.next();
				list.add(inpuString);
				System.out.println("파일 저장이 완료되었습니다.");
				break;
			case 2:
				for(String tmp:list) {
					System.out.println(tmp);
				}
				break;
			case 3:
				System.out.print("검색어 : ");
				String search = scan.next();
				for(String tmp : list) {
					//indexOf 이용
					int index = tmp.indexOf(search);
					if(index >=0 ) {
						System.out.println(tmp);
					}
					//contains 이용
					if(tmp.contains(search)) {
						System.out.println(tmp);
					}
				}
				break;
			case 4:
				System.out.println("프로그램을 종료합니다. ");
				break;
			}
		}while(menu != 4);
		
		scan.close();
	}

}

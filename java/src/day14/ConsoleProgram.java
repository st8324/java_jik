package day14;

import java.util.Scanner;

public interface ConsoleProgram {
	//메뉴출력 후 메뉴를 선택하는 기능
	int selectMenu(Scanner scan);
	
	//선택한 기능에 맞게 동작하는 메소드
	void excute(int menu);
	
	//프로그램 실행
	void run();
}

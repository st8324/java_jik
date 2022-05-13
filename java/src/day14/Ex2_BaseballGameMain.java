package day14;

import java.util.Scanner;

public class Ex2_BaseballGameMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BaseballGame game = new BaseballGame(scan);
		game.run();
		scan.close();
	}

}

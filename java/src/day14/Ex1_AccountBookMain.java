package day14;

import java.util.Scanner;

public class Ex1_AccountBookMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AccountBookManager accountBookManager = new AccountBookManager(scan);
		accountBookManager.run();
		scan.close();
	}

}

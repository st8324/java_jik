package day18;

import java.util.Scanner;

public class Ex03_StudentMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StudentManager sm = new StudentManager(scan);
		sm.run();
	}
}

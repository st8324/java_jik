package day22;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import day14.ConsoleProgram;

public class ScoreManager implements ConsoleProgram {

	private Scanner scan;
	private int exitMenu = 4;
	private List<Score> list = new ArrayList<Score>();
	
	public ScoreManager(Scanner scan) {
		if(scan == null)
			scan = new Scanner(System.in);
		this.scan = scan;
	}

	@Override
	public int selectMenu(Scanner scan) {
		System.out.println("-----------------------");
		System.out.println("1. 성적 추가");
		System.out.println("2. 성적 확인");
		System.out.println("3. 성적 수정");
		System.out.println("4. 프로그램 종료");
		System.out.println("-----------------------");
		System.out.print("메뉴 선택 : ");
		return scan.nextInt();
	}

	@Override
	public void excute(int menu) {
		switch(menu) {
		case 1:
			if(addScore()) 
				printMessage("성적을 추가했습니다.");
			else
				printMessage("이미 등록된 과목 성적입니다.");
			break;
		case 2:
			printScore();
			break;
		case 3:
			break;
		case 4:
			break;
		default:
		}
	}

	private void printScore() {
		System.out.println("-----------------------");
		System.out.println("성적 확인 메뉴");
		System.out.println("1. 모든 성적 확인");
		System.out.println("2. 학기 성적 확인");
		System.out.println("3. 과목 성적 확인");
		System.out.println("-----------------------");
		System.out.print("메뉴 선택 : ");
		int menu = scan.nextInt();
		switch(menu) {
		case 1:
			printScoreList(s->true);
			break;
		case 2:
			System.out.print("학년 : ");
			int grade = scan.nextInt();
			System.out.print("학기 : ");
			int term = scan.nextInt();
			printScoreList(s->s.getGrade() == grade && s.getTerm() == term);
			break;
		case 3:
			System.out.print("과목 : ");
			String name = scan.next();
			printScoreList(s->s.getName().equals(name));
			break;
		default:
			printMessage("잘못된 메뉴를 선택했습니다.");
		}
	}
	private void printScoreList(Predicate<Score> p) {
		List<Score> tmpList = new ArrayList<Score>();
		
		for(Score tmp : list) {
			if(p.test(tmp)) {
				tmpList.add(tmp);
			}
		}
		
		if(tmpList.size() == 0) {
			printMessage("출력할 성적이 없습니다.");
		}else {
			System.out.println("-----------------------");
			for(Score tmp : tmpList) {
				System.out.println(tmp);
			}
			System.out.println("-----------------------");
		}
	}

	private boolean addScore() {
		System.out.println("-----------------------");
		System.out.println("추가할 학생 정보를 입력하세요.");
		//학년, 학기, 과목을 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학기 : ");
		int term = scan.nextInt();
		System.out.print("과목 : ");
		String name = scan.next();
		
		//학년, 학기, 과목이 같은 성적이 성적 리스트에 있으면 있다고 알림
		Score tmp = new Score(grade, term, name);
		if(list.contains(tmp)) {
			System.out.println("-----------------------");
			return false;
		}
		//중간,기말,수행평가을 입력
		System.out.print("중간 : ");
		int midterm = scan.nextInt();
		System.out.print("기말 : ");
		int finals = scan.nextInt();
		System.out.print("수행 : ");
		int pa = scan.nextInt();
		
		//성적 정보를 성적 리스트에 추가
		tmp = new Score(grade, term, name, midterm, finals, pa);
		list.add(tmp);
		return true;
	}

	@Override
	public void run() {
		//샘플 데이터를 추가
		list.add(new Score(1, 1, "국어", 100, 100, 90));
		list.add(new Score(1, 2, "국어", 90, 100, 90));
		list.add(new Score(1, 1, "영어", 100, 80, 90));
		list.add(new Score(1, 1, "수학", 70, 100, 90));
		
		int menu = -1;
		do {
			try {
				menu = selectMenu(scan);
				excute(menu);
			}catch(InputMismatchException e) {
				printMessage("올바른 값을 입력하세요.");
				scan.nextLine();
			}catch(RuntimeException e) {
				printMessage(e.getMessage());
			}catch(Exception e) {
				printMessage("예외 발생 : " + e.getMessage());
			}
		}while(menu != exitMenu);
	}
	private void printMessage(String str) {
		System.out.println("-----------------------");
		System.out.println(str);
		System.out.println("-----------------------");
	}
}

package day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex02_BoardMain {

	public static void main(String[] args) {
		/* - 게시글 등록 
		 *   - 사용자가 게시글을 등록한다.
		 *   - 게시글 타입에는 공지와 일반이 있다.
		 *   - 게시글 정보는 게시글 타입, 제목, 내용, 작성자를 입력하여 등록한다
		 *   - 게시글 타입, 작성자는 공백이 없는 단어를 입력을 하고, 제목, 내용은 공백이 포함된 문자열을 입력한다.
		 * - 게시글 확인
		 *   - 등록된 전체 게시글을 게시글 번호, 타입, 제목, 작성자, 작성일, 조회수순으로 보여준다.
		 *   - 출력된 전체 게시글중 보고 싶은 게시글 번호를 선택해서 상세 게시글을 확인한다.
		 *   - 게시글 상세를 확인하지 않고 나가려면 -1을 선택하도록 한다
		 *   - 게시글 번호를 선택하면 게시글 제목, 작성자, 작성일, 조회수, 내용 순으로 상세 내용을 출력한다.
		 *   - 게시글 번호를 선택해서 게시글을 조회하면 해당 게시글 조회수가 1  증가한다.
		 * - 게시글 수정
		 *	 - 전체 게시글을 출력한 후, 수정할 게시글을 선택한다.
		 *   - 게시글이 선택되면 제목, 내용을 수정한다
		 * */
		/*
		
		반복 : 종료 메뉴를 선택할 때까지

			콘솔창에 메뉴 출력
			
			실행할 메뉴를 콘솔에서 입력 받음
			
			입력받은 메뉴에 맞는 기능을 실행
				
				1번 메뉴를 선택 : 게시글 등록 기능을 실행
					타입 입력
					제목 입력
					내용 입력
					작성자 입력
					게시글 생성 후 저장(리스트에 생성한 게시글을 추가)
					
				
				2번 메뉴를 선택 : 게시글 확인 기능을 실행
					전체 게시글 확인
					게시글 선택
					게시글 상세 확인
				
				3번 메뉴를 선택 : 게시글 수정 기능을 실행
					전체 게시글 확인
					게시글 선택
					게시글 제목 입력
					게시글 내용 입력
					게시글 수정
				
				4번 메뉴를 선택 : 프로그램을 종료
				
				그외 메뉴를 선택 : 콘솔에 알림창 출력

		 */
		//게시글 리스트 : 게시글들을 담을 공간
		List<Board> list = new ArrayList<Board>();
		//콘솔에서 입력받기 위한 스캐너
		Scanner scan = new Scanner(System.in);
		//프로그램 종료 번호
		int exitMenu = 4;
		//종료 메뉴를 선택할 때까지  
		int menu;
		
		//테스트 데이터
		list.add(new Board("일반", "일반 제목", "내용1", "홍길동"));
		list.add(new Board("일반", "제목2", "내용2", "홍길동"));
		list.add(new Board("공지", "공지 제목3", "내용3", "홍길동"));
		
		//게시글 등록, 확인, 수정시에 임시로 사용할 변수/참조변수
		String title, content, writer, type;
		int num, view;
		do {
			//콘솔창에 메뉴 출력
			System.out.println("메뉴");
			System.out.println("1. 게시글 등록");
			System.out.println("2. 게시글 확인");
			System.out.println("3. 게시글 수정");
			System.out.println("4. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			
			//실행할 메뉴를 콘솔에서 입력 받음
			menu = scan.nextInt();
			
			//입력받은 메뉴에 맞는 기능을 실행
			switch(menu) {
			//1번 메뉴를 선택 : 게시글 등록 기능을 실행
			case 1:	
				System.out.println("게시글 정보를 입력하세요.");
				//타입 입력
				System.out.print("타입[일반, 공지] : ");
				type = scan.next();
				scan.nextLine();
				
				//제목 입력
				System.out.print("제목 : ");
				title = scan.nextLine();
				
				//내용 입력
				System.out.print("내용 : ");
				content = scan.nextLine();
				
				//작성자 입력
				System.out.print("작성자: ");
				writer = scan.next();
				//게시글 생성 후 저장(리스트에 생성한 게시글을 추가)
				list.add(new Board(type, title, content, writer));
				
				break;
			//2번 메뉴를 선택 : 게시글 확인 기능을 실행
			case 2:
				//전체 게시글 확인
				System.out.println("번호\t타입 제목 \t 작성자 \t 작성일 \t\t 조회수");
				for(Board tmp : list) {
					System.out.println(tmp);
				}
				//게시글 선택
				System.out.print("게시글 선택[나가기 : -1] : ");
				num = scan.nextInt();
				//게시글 상세 확인
				if(num >= 0) {
					//list에서 게시글을 가져옴(num-1번지)
					Board tmp = list.get(num-1);
					//조회수 증가
					tmp.updateView();
					//가져온 게시글의 상세 내용을 확인 : detailPrint()를 호출
					tmp.detailPrint();
				}
				break;
			//3번 메뉴를 선택 : 게시글 수정 기능을 실행
			case 3:
				//전체 게시글 확인
				System.out.println("번호\t타입 제목 \t 작성자 \t 작성일 \t\t 조회수");
				for(Board tmp : list) {
					System.out.println(tmp);
				}
				//게시글 선택
				System.out.print("게시글 선택 : ");
				num = scan.nextInt();
				scan.nextLine();
				//게시글 제목 입력
				System.out.print("제목 : ");
				title = scan.nextLine();
				//게시글 내용 입력
				System.out.print("내용 : ");
				content = scan.nextLine();
				//게시글 수정
				//선택한 게시글을 가져옴
				Board tmp = list.get(num-1);
				//가져온 게시글을 수정 : modify를 호출
				tmp.modify(title, content);
				//list.set(num-1, tmp);
				/* List의 set을 이용 안한 이유 : 안해도 가능하기 때문에 
				 * List의 get을 이용하여 객체를 가져왔을 때, 가져온 객체는 원본의 주소 */
				break;
			case 4:
				break;
			default:
			}
			
			
		}while(menu != exitMenu);
		
		
		scan.close();
	}

}











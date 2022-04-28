package day4;

public class Ex8_InfiniteLoop {

	public static void main(String[] args) {
		//1부터 int 최대 정수까지 반복함 => 많이 실행할 뿐 무한루프틑 아님. 무한루프인 경우 반복문 아래 코드가 에러가 발생함
		for(int i = 1 ; i > 0 ; i++ ) {
			//System.out.println(i);
		}
		System.out.println("안녕하세요.");
	}

}

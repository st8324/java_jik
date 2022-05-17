package day16;

public class Ex06_String_Search2 {

	public static void main(String[] args) {
		/* 주어진 str에 search가 몇번 있는지 출력하는 코드를 작성하여 확인하세요. */
		String str = "abcdabcdabababc";
		String search = "abcdabcde";
		int index = 0;
		int count = 0;
		do {
			index = str.indexOf(search, index);
			if(index >= 0) {
				count++;
				index = index + search.length();
			}
		}while(index >= 0);
		System.out.println(str+"에는 " + search+"가 " +count +"개 있습니다.");
	}

}

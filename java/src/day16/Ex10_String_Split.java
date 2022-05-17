package day16;

public class Ex10_String_Split {

	public static void main(String[] args) {
		/*  - 문자열.split(정규표현식) : 문자열에 정규표현식과 일치하는 것들이 있으면 잘라서 배열로
		 * 	  만듬
		 *  - String arr[] = "abc,def,fgh".split(",")를 하면 
		 *    String arr[] = {"abc", "def", "fgh"};가 저장된거와 같다.
		 * */
		String hobby = "독서,음악 감상-영화 보기-운동";
		String hobbies[] = hobby.split("[,-]");
		System.out.print("취미 : ");
		if(hobbies != null) {
			for(String tmp : hobbies) {
				System.out.print(tmp + " ");
			}
			System.out.println();
		}else {
			System.out.println("없음");
		}

	}

}

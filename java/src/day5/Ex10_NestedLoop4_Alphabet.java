package day5;

public class Ex10_NestedLoop4_Alphabet {

	public static void main(String[] args) {
		/* a				'a'부터 'a'까지
		 * ab				'a'부터 'b'까지
		 * abc				
		 * ...				
		 * abcdfg...xyz		'a'부터 'z'까지
		 * 
		 * 반복횟수 : end는 'a'부터 'z'까지 1씩 증가
		 * 규칙성 : ch는 'a'부터 end까지 1씩 증가하며 ch를 출력 
		 * */
		for(char end = 'a'; end <='z'; end++) {
			/* ch는 'a'부터 end까지 1씩 증가하며 ch를 출력 
			 * 
			 * 반복횟수 : ch는 'a'부터 end까지 1씩 증가
			 * 규칙성 : ch를 출력
			 * */
			for(char ch ='a'; ch <= end; ch++) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
	
}

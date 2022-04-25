package day1;

public class Ex6_Char {

	public static void main(String[] args) {
		/* 문자 ''안에 들어가는 한글자
		 * 예외 : p.34
		 * */
		char ch1 = '\t'; //Tab키 만큼 공백		
		char ch2 = '\n'; //엔터
		char ch3 = '\r'; //커서를 앞으로 이동
		char ch4 = '\"'; //"문자
		char ch5 = '\''; //'문자
		char ch6 = '\\'; //\문자
		char ch7 = '\u0000'; //유니코드 0에 해당하는 문자
		char ch8 = 'A';
		
		int num = 65;
		char ch9 = (char)num;
		System.out.println(ch9);
		ch9 = (char)(num+1);
		System.out.println(ch9);
	}

}

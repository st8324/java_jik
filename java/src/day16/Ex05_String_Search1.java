package day16;

public class Ex05_String_Search1 {

	public static void main(String[] args) {
		String str ="Hello wolrd wolrd";
		String search = "wo";
		/* - 문자열.indexOf(검색어)
		 *   - 일치하는 문자열이 없으면 -1, 있으면 시작번지
		 *   - 여러개 있어서도 처음 시작하는 번지를 찾음
		 * - 문자열.(검색어, 시작번지)
		 *   - 문자열에서 시작번지부터 검색어를 찾아 있으면 시작번지, 없으면 -1
		 * */
		int index = str.indexOf(search);
		if(index >= 0) {
			System.out.println(str+" 문자열에 "+ search+" 문자열은 " + index + "번지에 있습니다.");
			index = str.indexOf(search, index+search.length());
			if(index >= 0) {
				System.out.println(str+" 문자열에 "+ search+" 문자열은 " + index + "번지에 2개 있습니다.");
			}else {
				System.out.println(str+" 문자열에 "+ search+" 문자열은 1개 있습니다.");
			}
		}else {
			System.out.println(str+" 문자열에 "+ search+" 문자열은 " + "없습니다.");
		}
		System.out.println(str.lastIndexOf(search));
		System.out.println(str.contains(search));
	}

}

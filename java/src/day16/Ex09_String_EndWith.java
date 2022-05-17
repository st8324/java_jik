package day16;

public class Ex09_String_EndWith {

	public static void main(String[] args) {
		/* 다음과 같이 파일이름이 주어졌을 때 파일 이미지인지 아닌지 구별하는 코드를 작성하세요.
		 * 파일 확장자가 .jpg, .png, .bmp인 경우 이미지로 구별
		 * */
		String fileName = "test.jpg.txt";
		//끝에서부터 .을 찾아서 
		int index = fileName.lastIndexOf(".");
		//switch문을 이용하여 이미지 찾기
		if(index != -1) {
			//.뒤에있는 문자열을 가져옴
			String endwith = fileName.substring(index+1);
			//가져온 문자열이 jpg, png, bmp를 체크
			//셋중에 같은게 있으면 이미지, 없으면 이미지 아님
			switch(endwith) {
			case "jpg",  "bmp", "png":
				System.out.println(fileName +"은 이미지입니다.");
				break;
			default:
				System.out.println(fileName +"은 이미지가 아닙니다.");
			}
		}else {
			System.out.println(fileName +"은 이미지가 아닙니다.");
		}
		
		//반복문을 이용하여 이미지 찾기
		String img[] = {"jpg", "bmp", "png"};
		
		if(index != -1) {
			//.뒤에있는 문자열을 가져옴
			String endwith = fileName.substring(index+1);
			//가져온 문자열이 jpg, png, bmp를 체크
			//셋중에 같은게 있으면 이미지, 없으면 이미지 아님
			int i;
			for(i = 0; i<img.length; i++) {
				if(img[i].equals(endwith)) {
					break;
				}
			}
			if(i < img.length) {
				System.out.println(fileName +"은 이미지입니다.");
			}else {
				System.out.println(fileName +"은 이미지가 아닙니다.");
			}
		}else {
			System.out.println(fileName +"은 이미지가 아닙니다.");
		}
		//endWith를 이용하여 이미지 찾기
		String img2[] = {".jpg", ".bmp", ".png"};
		int i;
		/* 문자열1.endWith(문자열2) : 문자열1이 문자열2로 끝나는지 알려줌(참/거짓)*/
		for(i=0; i<img2.length; i++) {
			if(fileName.endsWith(img2[i])) {
				break;
			}
		}
		if(i < img2.length) {
			System.out.println(fileName +"은 이미지입니다.");
		}else {
			System.out.println(fileName +"은 이미지가 아닙니다.");
		}
		//substring을 이용하지 않고 이미지 찾기
		int length = fileName.length();
		
		for(i = 0; i < img2.length; i++) {
			index = fileName.lastIndexOf(img2[i]);
			if(index == length - img2[i].length()) {
				break;
			}
		}
		if(i < img2.length) {
			System.out.println(fileName +"은 이미지입니다.");
		}else {
			System.out.println(fileName +"은 이미지가 아닙니다.");
		}
	}

}

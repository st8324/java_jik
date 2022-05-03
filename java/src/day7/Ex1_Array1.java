package day7;

public class Ex1_Array1 {

	public static void main(String[] args) {
		/* 5개짜리 배열을 만들고, 0번지에 1, 1번지에 2, ... 4번지에 5를 저장하고, 출력하는 코드를 작성하세요.
		 * 0번지 0*/
		int arr[] = new int [5];
		
		for(int i = 0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.println(arr[i]);
		}
	}
}

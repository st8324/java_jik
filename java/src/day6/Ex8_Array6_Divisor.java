package day6;

public class Ex8_Array6_Divisor {

	public static void main(String[] args) {
		/* 정수 num의 약수를 배열에 저장 한 후, 출력하는 코드를 작성하세요.
		 * 약수는 최대 10개만 저장 
		 * num = 10 */
		int num = 12;
		int max = 10;
		int div[] = new int[max];
		int index = 0;
		for(int i = 1; i<=num; i++) {
			if(num % i == 0) {
				//System.out.print(i + " ");
				//?번지가 10보다 작은지 확인하여 10보다 작으면 배열 ?번지에 i를 저장 
				if(index < max) {
					div[index] = i;
					//?을 1증가
					index++;
				}
			}
		}
		//출력
		for(int i = 0; i<index; i++) {
			System.out.print(div[i] + " ");
		}
	}

}

package day16;

public class Ex02_System_CurrentTimeMillis {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long sum = 0;
		for(int i = 1; i<= 10000; i++) {
			sum += i;
			System.out.print(sum + " ");
		}
		System.out.println();
		long end = System.currentTimeMillis();
		
		System.out.println("1부터 10000까지 합 : " + sum);
		System.out.println("소요 시간 : " + (end - start)/1000.0 + "초");
	}

}

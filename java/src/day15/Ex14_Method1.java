package day15;

public class Ex14_Method1 {

	public static void main(String[] args) {
		/* 메소드의 매개변수가 가변일 때 사용하는 방법
		 * 타입 ... 배열명으로 사용 */
		System.out.println(sum(1,2));
		System.out.println(sum(4,5,6,7,8));
		System.out.println(sum());
	}
	/* 기능 : 여러개의 정수의 합을 알려주는 메소드
	 * 매개변수 : 여러개의 정수 => int ... nums
	 * 리턴타입 : 합 => int
	 * 메소드명 : sum */
	public static int sum(int ...nums) {
		//nums는 메소드에서 배열처럼 사용
		if(nums.length == 0) {
			return 0;
		}
		int sum = 0;
		for(int tmp: nums) {
			sum += tmp;
		}
		return sum;
	}
}

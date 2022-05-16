package day15;

public class Ex15_Method2 {

	public static void main(String[] args) {
		System.out.println(sum1(5));
		System.out.println(sum1(5,1,2,3));
		System.out.println(sum1(5,1,2,3,4,5));
		System.out.println(sum1(5,1,2,3,4,5,6));

	}
	public static int sum1(int max, int ... nums) {
		if(nums.length == 0 || max == 0) {
			return 0;
		}
		if(max > nums.length) {
			max = nums.length;
		}
		int sum = 0;
		for(int i = 0; i<max; i++) {
			sum += nums[i];
		}
		return sum;
	}
	//가변인자는 제일 뒤에 와야 함. 아래 코드는 가변인자가 앞에 있기 때문에 에러 발생
	/*public static int sum2(int ... nums, int max) {
		if(nums.length == 0 || max == 0) {
			return 0;
		}
		if(max > nums.length) {
			max = nums.length;
		}
		int sum = 0;
		for(int i = 0; i<max; i++) {
			sum += nums[i];
		}
		return sum;
	}*/
}

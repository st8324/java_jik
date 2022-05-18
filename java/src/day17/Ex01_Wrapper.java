package day17;

public class Ex01_Wrapper {

	public static void main(String[] args) {
		/* - 제네릭 클래스에서 기본 타입으로 된 제네릭을 만들고 싶지만
		 * 	 제네릭은 기본타입이 올 수 없고 클래스가 필요하다. 
		 *   그래서 기본 타입으로 만든 Wrapper 클래스를 이용해야 한다. 
		 * - Wrapper클래스와 기본 타입의 차이
		 *   - Wrapper 클래스의 객체는 기본타입값과 null을 가짐
		 *     => 언박싱할 때 조심해야함. null일수도 있기 때문
		 *   - 기본타입은 기본타입값만 가질 수 있다
		 * - 두 기본타입 변수는 ==로 비교 가능
		 * - 기본 타입변수와 Wrapper클래스 객체를 ==로 비교할 수 있다
		 *   => Wrapper클래스 객체가 자동 언박싱이 되어서 ==로 비교
		 * - 두 Wrapper클래스 객체는 ==로 비교하면 안됨 */
		//List<Integer> list = new ArrayList<Integer>();

		Integer num1 = 1;//자동 박싱
		int num2 = num1;//자동 언박싱
		Integer num3 = null;
		//int num4 = num3;//예외 발생. null을 기본타입으로 바꿀수 없음
		
		int num5 = 1, num6 = 1;
		System.out.print("두 기본타입변수 ==로 비교         : ");
		if(num5 == num6) {
			System.out.println(num5+"와 " + num6 +"은 같다");
		}else {
			System.out.println(num5+"와 " + num6 +"은 다르다");
		}
		
		Integer num7 = 1, num8 = new Integer(1);
		System.out.print("두 Wrapper 객체 ==로 비교       : ");
		if(num7 == num8) {
			System.out.println(num7+"와 " + num8 +"은 같다");
		}else {
			System.out.println(num7+"와 " + num8 +"은 다르다");
		}
		
		System.out.print("Wrapper 객체와 기본타입 ==로 비교 : ");
		if(num7 == (int)num8) {
			System.out.println(num7+"와 " + num8 +"은 같다");
		}else {
			System.out.println(num7+"와 " + num8 +"은 다르다");
		}
		
		String str1 = "1000";
		int num9 = Integer.parseInt(str1);
		System.out.println("문자열: " + str1 +", 정수 : " +num9);
		String str2 = "1.23";
		double num10 = Double.parseDouble(str2);
		System.out.println("문자열: " + str2 +", 실수 : " +num10);
	}
}




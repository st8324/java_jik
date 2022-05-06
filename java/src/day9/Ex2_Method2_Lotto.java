package day9;

import java.util.Scanner;

public class Ex2_Method2_Lotto {

	public static void main(String[] args) {
		/* 앞 예제에서 사용한 메소드들을 필요하면 복사붙여넣기 해서 로또 프로그램을 작성하세요.
		 * 필요한 기능은 메소드로 추가해도 됩니다. */
		Scanner scan = new Scanner(System.in);
		int n = 6;
		int min =1, max = 45;
		
		//로또 구매 : 로또번호 입력(6자리, 1~45)
		System.out.print("로또 번호 입력("+n+"개) : ");
		int user[] = inputCreateArray(scan, n);
		
		//로또 당첨번호 생성(랜덤. 1~45. 중복x, 6자리)
		int lotto[] = createRandomArray(min, max, n);
		
		//로또 보너스 번호 생성
		int bonus;
		for( ; ; ) {
			bonus = (int)(Math.random()*(max - min + 1) + min);
			if(!contains(lotto, lotto.length, bonus)) {
				break;
			}
		}
		System.out.print("당첨번호 : ");
		printArray(lotto);
		System.out.println("보너스 번호 : " +bonus);
				
		//당첨 갯수 확인
		int count = getCount(user, lotto);
		//당첨 등수 출력
		printResult(count, contains(user, user.length, bonus));
		
	}
	/* 기능 : 주어진 Scanner를 이용하여 콘솔에서 정수를 n개 입력받아 배열로 반환하는 메소드
	 * 매개변수 : Scanner, 입력받을 정수의 개수 => Scanner scan, int n
	 * 리턴타입 : 정수 배열 => int []
	 * 메소드명 : inputCreateArray 
	 * */
	public static int[] inputCreateArray(Scanner scan, int n) {
		if( n <= 0) {
			return null;
		}
		int arr[] = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = scan.nextInt();
		}
		return arr;
	}
	
	/* 기능 : 정수형 배열에서 처음부터 n개중에서 정수 num가 있는지 없는지 알려주는 메소드
	 * 매개변수 : 정수형 배열, 확인할 개수 n, 정수 num => int arr[], int n, int num
	 * 리턴타입 : 있는지 없는지 => boolean
	 * 메소드명 : contains
	 * */
	public static boolean contains(int arr[], int n, int num) {
		//배열이 잘못되거나 비교 갯수가 잘못되서 비교할 필요가 없는 경우
		if(arr==null || arr.length == 0 || n <= 0) {
			return false;
		}
		if(arr.length < n) {
			n = arr.length;
		}
		for(int i = 0; i<n; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	/* 기능 : 정수형 배열이 주어졌을 때, 주어진 배열의 값을 콘솔에 출력하는 메소드
	 * 매개변수 : 정수형 배열 => int num[]
	 * 리턴타입 : 없음 => void 
	 * 메소드명 : printArray
	 * */
	public static void printArray(int num[]) {
		if(num == null || num.length == 0) {
			System.out.println("출력할 배열이 없습니다.");
			return ;
		}
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}

	/* 기능 : min에서 max사이의 중복되지 않은 n개의 정수를 만들어서 배열로 반환하는 메소드 
	 * 매개변수 : 최소값, 최대값, 개수 => int min, int max, int n
	 * 리턴타입 : 중복되지않은 수를 저장한 배열 => int []
	 * 메소드명 : createRandomArray */
	public static int[] createRandomArray(int min, int max, int n) {
		if(n <= 0) {
			return null;
		}
		//min = 45, max = 1
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		//min=1, max=5, n=6
		if(max - min + 1 < n) {
			return null;
		}
		int arr[] = new int [n];
		for(int count = 0; count < n; ) {
			int r = (int)(Math.random()*(max-min+1) + min);
			if(!contains(arr, count, r)) {
				arr[count] = r;
				count++;
			}
		}
		return arr;
	}
	
	/* 기능 : 두 정수 배열에서 같은 숫자의 개수를 알려주는 메소드
	 * 매개변수 : 두 정수 배열 => int arr1[], int arr2[]
	 * 리턴타입 : 같은 숫자의 개수 => int
	 * 메소드명 : getCount*/
	public static int getCount(int arr1[], int arr2[]) {
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		int count = 0;
		for(int tmp: arr1) {
			if(contains(arr2, arr2.length, tmp)) {
				count++;
			}
		}
		return count;
	}
	/* 기능 : 일치하는 개수와 보너스가 있는지 없는지 알려주면 당첨 등수를 출력하는 메소드
	 * 매개변수 : 일치하는 개수, 보너스 일치 여부 => int count , boolean bonusOk
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printResult */
	public static void printResult(int count, boolean bonusOk) {
		if(count < 0 || count > 6) {
			System.out.println("등수를 확인할 수 없습니다.");
			return ;
		}
		switch(count) {
		case 6:
			System.out.println("1등!"); break;
		case 5:
			System.out.println(bonusOk?"2등!":"3등!");	break;
		case 4:
			System.out.println("4등!");	break;
		case 3:
			System.out.println("5등!");	break;
		default:
			System.out.println("꽝!");
		}
	}
}







package day12;

import java.util.Scanner;

public class Ex7_Mart {

	/* 음료수/박스과자를 관리하는 마트(종류는 최대 30개 - 음료수+박스과자종류)
	 * 1. 제품등록(신규제품)
	 * 2. 제품입고
	 * 3. 제품 선택
	 * 4. 제품 구매
	 * 5. 프로그램 종료
	 * */
	public static void main(String[] args) {
		//제품을 관리하기 위한 배열. 마트에서 판매하는 제품 목록(음료수+박스과자)
		Product list[] = new Product[30];
		//저장된 판매 제품 갯수
		int listCount = 0;
		//장바구니에 담긴 제품 갯수
		int basketCount = 0;
		int menu;
		int subMenu, price, amount, capacity, count;
		String name;
		Scanner scan = new Scanner(System.in);
		//바구니 생성. 종류는 최대 30개
		Product basket[] = new Product[30];
		do {
			menu = selectMenu(scan);
			switch(menu) {
			case 1:
				/* 음료수인지 박스과지인지를 선택
				 * 제품명, 가격, 수량, 박스과자면 1박스당 개수를 음료수면 용량을 입력
				 * 입력받은 정보를 이용하여 객체로 만든 후 판매 목록에 추가
				 * */
				subMenu = selectSubMenu(scan);
				
				switch(subMenu) {
				case 1: case 2:
					list[listCount] = createProduct(subMenu, scan);
					listCount++;
					break;
				default:
					System.out.println("선택할 수 없는 종류입니다.");
				}
				break;
			case 2:
				printProductList(list, listCount);
				if(addAmountProductList(scan, list, listCount)) {
					System.out.println("입고가 완료되었습니다.");
				}else {
					System.out.println("입고에 실패했습니다.");
				}
				break;
			case 3:
				printProductList(list, listCount);
				/* 제품을 선택
				 * 수량을 입력
				 * 바구니에 담아야 함
				 * 제품 제고량에서 수량만큼 뺌
				 * 현재 바구니에 담긴 목록을 출력
				 * */
				Product selectProduct = selectProduct(scan, list, listCount);
				if(selectProduct != null) {
					basket[basketCount] = selectProduct;
					basketCount++;
					printProductList(basket, basketCount);
				}else {
					System.out.println("선택된 제품이 없습니다.");
				}
				break;
			case 4:
				/* 현재 바구니에 담긴 목록을 출력하고
				 * 최종 합계를 출력
				 * 결재 금액을 입력 
				 * 결재를 진행
				 *   금액이 부족하면 결재를 취소할건지 물어봄
				 *     취소하면 장바구니를 비움
				 *     결재를 취소하지 않으면 장바구니를 보관 
				 *   결재가 정상적으로 완료되면 
				 *     거스름돈을 출력하고
				 *     바구니를 비움*/
				printProductList(basket, basketCount);
				//최종합계 출력
				int sum = sumProductList(basket, basketCount);
				System.out.println("구매 총 금액 : " + sum);

				//결재 금액을 입력
				System.out.print("금액을 입력하세요 : ");
				int buyPrice = scan.nextInt();
				//결재를 진행취소
				//금액이 부족하면 결재를 취소할건지 물어봄
				if(sum > buyPrice) {
					System.out.print("결재를 취소하겠습니까?(취소시 장바구니는 비워집니다. y/n) : ");
					char cancel = scan.next().charAt(0);
					//취소하면
					if(cancel == 'Y' || cancel == 'y') {
						//장바구니에 담긴 제품들을 마트에 돌려줘야함
						returnProductList(list, listCount, basket, basketCount);
						//장바구니를 비움
						basketCount = 0;
					}
				}
				//결재가 정상적으로 완료되면
				else {
					//거스름돈을 출력하고
					System.out.println("거스름돈 : " + (buyPrice - sum) + "원");
					//바구니를 비움
					basketCount = 0;
				}
				break;
			case 5:
				break;
			default:
			}
		}while(menu != 5);
		scan.close();
	}
	/* 기능 : 메뉴를 출력하고, 메뉴를 Scanner를 통해 입력받아 입력받은 메뉴를 알려주는 메소드
	 * 매개변수 : Scanner => Scanner scan
	 * 리턴타입 : 입력받은 메뉴 => 정수 => int
	 * 메소드명 : selectMenu 
	 * */
	public static int selectMenu(Scanner scan) {
		System.out.println("====메뉴====");
		System.out.println("1. 제품 등록(관리자)");
		System.out.println("2. 제품 입고(관리자)");
		System.out.println("3. 제품 선택(고객)");
		System.out.println("4. 제품 구매(고객)");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		int menu = scan.nextInt();
		System.out.println("===========");
		return menu;
	}
	/* 기능 : 제품등록에 대한 서브 메뉴를 출력하고, Scanner를 통해 서브 메뉴를 입력받아 서브메뉴를 알려주는 메소드
	 * 매개변수 : Scanner => Scanner scan
	 * 리턴타입 : 입력받은 메뉴 => 정수 => int
	 * 메소드명 : selectSubMenu
	 */
	public static int selectSubMenu(Scanner scan) {
		System.out.println("1. 음료수 등록");
		System.out.println("2. 박스과자 등록");
		System.out.print("종류 선택 : ");
		return scan.nextInt();
	}
	/* 기능 : 선택한 subMenu에 맞는 제품 정보를 Scanner를 통해 입력받아 제품 객체를 생성한 후 생성한 
	 * 		 제품을 알려주는 메소드
	 * 매개변수 : 선택한 서브메뉴, 스캐너 => int subMenu, Scanner scan
	 * 리턴타입 : 생성한 제품 => Product
	 * 메소드명 : createProduct
	 * */
	public static Product createProduct(int subMenu, Scanner scan) {
		System.out.print("제품명 : ");
		String name = scan.next();
		System.out.print("가격 : ");
		int price = scan.nextInt();
		System.out.print("수량 : ");
		int amount = scan.nextInt();

		switch(subMenu) {
		case 1:
			System.out.print("음료수 용량 : ");
			int capacity = scan.nextInt();
			return new Drink(name, price, amount, capacity);
		case 2:
			System.out.print("박스당 개수 : ");
			int count = scan.nextInt();
			return new SnackBox(name, price, amount, count);
		default:
			return null;
		}
	}
	/* 기능 : 제품목록을 출력하는 메소드
	 * 매개변수 : 제품목록 => Product productList[], int listCount
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printProductList */
	public static void printProductList(Product productList[], int listCount) {
		if(productList == null || listCount == 0) {
			System.out.println("등록된 제품이 없습니다.");
			return;
		}
		for(int i = 0; i<listCount; i++) {
			System.out.print(i+1+".");
			productList[i].print();
		}
	}
	/* 기능 : Scanner를 이용하여 제품 목록에서 제품과 수량을 입력하여 수량을 추가하는 메소드
	 * 매개변수 : Scanner, 제품 목록 => Scanner scan, Product list[], int listCount
	 * 리턴타입 : 입고 여부 => boolean
	 * 메소드명 : addAmountProductList
	 * */
	public static boolean addAmountProductList(Scanner scan, Product list[], int listCount) {
		if(list == null || listCount == 0) {
			return false;
		}
		System.out.print("입고할 제품을 선택하세요 : ");
		int num = scan.nextInt();
		System.out.print("입고할 제품의 수량을 입력하세요 : ");
		//입고된 수량
		int amount = scan.nextInt();
		//제품선택을 잘못했거나 수량을 잘못 선택한 경우
		if(num < 1 || num > listCount || amount <= 0) {
			return false;
		}
		//해당 제품의 수량을 변경
		//입고되기전 수량
		list[num-1].sumAmount(amount);
		return true;
	}
	/* 기능 : 스캐너를 이용하여 제품과 수량을 선택하면 
	 * 		 제품리스트에서 해당 제품을 수량에 맞게 꺼내서 제품을 돌려주는 메소드
	 * 매개변수 : 스캐너, 제품리스트(마트) => Scanner scan, Product list[], int listCount
	 * 리턴타입 : 선택된 제품(입력한 수량으로) => Product
	 * 메소드명 : selectProduct 
	 * */
	public static Product selectProduct(Scanner scan, Product list[], int listCount) {
		System.out.print("구매할 제품을 선택하세요 : ");
		int num = scan.nextInt();
		if(num > listCount) {
			return null;
		}
		System.out.print("구매할 제품의 수량을 입력하세요 : ");
		//입고된 수량
		int amount = scan.nextInt();
		
		Product buyProduct = list[num-1];
		Product selectProduct = null;
		if(buyProduct instanceof SnackBox) {
			selectProduct = new SnackBox((SnackBox)buyProduct);
		}else if(buyProduct instanceof Drink) {
			selectProduct =  new Drink((Drink)buyProduct);
		}else {
			return null;
		}
		//제고량보다 많은 수량을 입력한 경우
		if(buyProduct.getAmount() < amount) {
			//수량을 제고량으로 수정
			amount = buyProduct.getAmount();
		}
		selectProduct.setAmount(amount);
		buyProduct.sumAmount(-amount);
		return selectProduct;
	}
	/* 기능 : 제품 리스트가 주어지면 해당 제품 리스트의 합계를 구하여 알려주는 메소드
	 * 매개변수 : 제품 리스트 => Product list[], int listCount
	 * 리턴타입 : 합계 => int
	 * 메소드명 : sumProductList */
	public static int sumProductList(Product list[], int listCount) {
		int sum = 0;
		for(int i = 0; i<listCount; i++) {
			sum += list[i].getPrice() * list[i].getAmount();
		}
		return sum;
	}
	/* 기능 : 장바구니에 담은 제품들을 마켓에 돌려주는 메소드
	 * 매개변수 : 마켓제품리스트, 장바구니리스트 
	 * 			=> Product list[], int listCount, Product basket[], int basketCount
	 * 리턴타입 : 없음 => void
	 * 메소드명 : returnProductList
	 */
	public static void returnProductList(Product list[], int listCount, Product basket[], int basketCount) {
		if(list == null || basket == null) {
			return;
		}
		for(int i = 0; i<listCount; i++) {
			for(int j = 0; j<basketCount; j++) {
				Product pi = list[i];
				Product pj = basket[j];
				if(pi.getName().equals(pj.getName())) {
					//pi.amount : 제고량, pj.amount : 구매하려고 선택했던 수량
					pi.sumAmount(pj.getAmount());
				}
			}
		}
	}
}



















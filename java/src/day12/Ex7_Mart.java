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
		Scanner scan = new Scanner(System.in);

		//제품을 관리하기 위한 배열. 마트에서 판매하는 제품 목록(음료수+박스과자)
		Product list[] = new Product[30];
		//바구니 생성. 종류는 최대 30개
		Product basket[] = new Product[30];
		
		//저장된 판매 제품 갯수
		int listCount = 0;
		//장바구니에 담긴 제품 갯수
		int basketCount = 0;
		
		int menu, subMenu;
		
		do {
			//메뉴 출력 후 메뉴를 선택
			menu = selectMenu(scan);
			switch(menu) {
			//선택한 메뉴가 1이면(제품 등록)
			case 1:
				//서브 메뉴 출력 후 서브 메뉴를 선택
				subMenu = selectSubMenu(scan);
				
				switch(subMenu) {
				//올바른 서브메뉴를 선택하면
				case 1: case 2:
					//제품 정보를 입력받아서 판매제품리스트에 추가
					list[listCount] = createProduct(subMenu, scan);
					//판매 제품 갯수 증가
					listCount++;
					break;
				//잘못된 서브메뉴를 선택하면
				default:
					System.out.println("선택할 수 없는 종류입니다.");
				}
				break;
			//선택한 메뉴가 2이면(제품 입고)
			case 2:
				//입고 가능한 제품들을 출력
				printProductList(list, listCount);
				//제품을 선택하고 입고할 수량을 선택해서 판매제품리스트에 제품이 입고가 되면
				if(addAmountProductList(scan, list, listCount)) {
					System.out.println("입고가 완료되었습니다.");
				}else {
					System.out.println("입고에 실패했습니다.");
				}
				break;
			case 3:
				//구매하기 위해 판매제품리스트를 출력
				printProductList(list, listCount);
				//제품을 선택하고 수량을 선택함
				Product selectProduct = selectProduct(scan, list, listCount);
				//선택된 제품이 있으면
				if(selectProduct != null) {
					//장바구니에 선택된 제품을 담고
					basket[basketCount] = selectProduct;
					//장바구니에 담긴 개수를 하나 증가
					basketCount++;
					//장바구니에 있는 목록을 출력
					printProductList(basket, basketCount);
				}else {
					System.out.println("선택된 제품이 없습니다.");
				}
				break;
			case 4:
				//장바구니에 있는 목록을 출력
				printProductList(basket, basketCount);
				//장바구니에 있는 목록의 최종합계 출력
				int sum = sumProductList(basket, basketCount);
				System.out.println("구매 총 금액 : " + sum);

				//결재 금액을 입력
				System.out.print("금액을 입력하세요 : ");
				int buyPrice = scan.nextInt();
				
				
				//금액이 부족하면 
				if(sum > buyPrice) {
					//결재를 취소할건지 물어봄
					System.out.print("결재를 취소하겠습니까?(취소시 장바구니는 비워집니다. y/n) : ");
					char cancel = scan.next().charAt(0);
					//취소하면
					if(cancel == 'Y' || cancel == 'y') {
						//장바구니에 담긴 제품들을 마트에 돌려줌
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
				System.out.println("프로그램을 종료합니다.");
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
		//등록하기 위한 공통된 제품 정보를 입력
		System.out.print("제품명 : ");
		String name = scan.next();
		System.out.print("가격 : ");
		int price = scan.nextInt();
		System.out.print("수량 : ");
		int amount = scan.nextInt();

		//선택한 종류에 따른 추가 정보를 입력
		switch(subMenu) {
		case 1:
			System.out.print("음료수 용량 : ");
			int capacity = scan.nextInt();
			//입력된 정보를 이용하여 음료수를 생성하여 돌려줌
			return new Drink(name, price, amount, capacity);
		case 2:
			System.out.print("박스당 개수 : ");
			int count = scan.nextInt();
			//입력된 정보를 이용하여 박스과자를 생성하여 돌려줌
			return new SnackBox(name, price, amount, count);
		//잘못된 정보를 선택하면 없다라고 알려줌
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
		//입고할 제품을 선택
		System.out.print("입고할 제품을 선택하세요 : ");
		int num = scan.nextInt();
		//입고할 제품 수량을 선택
		System.out.print("입고할 제품의 수량을 입력하세요 : ");
		int amount = scan.nextInt();
		//제품선택을 잘못했거나 수량을 잘못 선택한 경우 입고 실패했다고 알려줌
		if(num < 1 || num > listCount || amount <= 0) {
			return false;
		}
		//선택된 제품에 입고된 수량을 추가
		list[num-1].sumAmount(amount);
		//입고가 완료됐다고 알려줌
		return true;
	}
	/* 기능 : 스캐너를 이용하여 제품과 수량을 선택하면 
	 * 		 제품리스트에서 해당 제품을 수량에 맞게 꺼내서 제품을 돌려주는 메소드
	 * 매개변수 : 스캐너, 제품리스트(마트) => Scanner scan, Product list[], int listCount
	 * 리턴타입 : 선택된 제품(입력한 수량으로) => Product
	 * 메소드명 : selectProduct 
	 * */
	public static Product selectProduct(Scanner scan, Product list[], int listCount) {
		//구매할 제품을 선택
		System.out.print("구매할 제품을 선택하세요 : ");
		int num = scan.nextInt();
		//잘못된 제품을 선택하면 제품이 없다고 알려줌
		if(num > listCount) {
			return null;
		}
		//제품이 있으면 구매할 수량을 선택
		System.out.print("구매할 제품의 수량을 입력하세요 : ");
		int amount = scan.nextInt();
		
		//구매한 제품을 선택해서 가져옴
		Product buyProduct = list[num-1];
		Product selectProduct = null;
		//선택된 제품을 복사해서 가져옴
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
		//선택한 제품 정보에 선택한 수량으로 변경
		selectProduct.setAmount(amount);
		//판매제품 리스트에서 선택한 수량을 빼줌
		buyProduct.sumAmount(-amount);
		//선택한 제품을 알려줌
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
		//판매 제품 목록과 장바구니 목록을 하나씩 비교하여 제자리에 가져다 놓음
		for(int i = 0; i<listCount; i++) {
			for(int j = 0; j<basketCount; j++) {
				Product pi = list[i];//판매 제품
				Product pj = basket[j];//장바구니 제품
				//판매제품 이름과 장바구니 제품 이름이 같으면
				if(pi.getName().equals(pj.getName())) {
					//pi.amount : 제고량, pj.amount : 구매하려고 선택했던 수량
					//장바구니에 있는 제품을 제자리에 돌려놓음 : 판매제품 수량에 장바구니 제품을 수량을 추가
					pi.sumAmount(pj.getAmount());
				}
			}
		}
	}
}



















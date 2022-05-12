package day12;

public abstract class Product {
	//제품명
	private String name;
	//가격
	private int price;
	//수량
	private int amount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/* 기능 : 수량이 주어지면 기존 수량에 누적하는 메소드
	 * */
	public void sumAmount(int amount) {
		this.amount += amount;
	}
	
	public Product(String name) {
		this(name, 0, 0);
	}
	public Product(String name, int price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	public abstract void print();
}

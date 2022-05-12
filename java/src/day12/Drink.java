package day12;

public class Drink extends Product {

	private int capacity;//용량 ml
	
	public Drink(String name, int price, int amount, int capacity) {
		super(name, price, amount);
		this.capacity = capacity;
	}
	public Drink(Drink product) {
		this(product.getName(), product.getPrice(), 
				product.getAmount(), product.getCapacity());
	}
	@Override
	public void print() {
		if(capacity<1000) {
			System.out.println(getName()+"[" + capacity +"ml] : "+getPrice()+"원 - " 
					+ getAmount());
		}
		else {
			System.out.println(getName()+"[" + capacity/1000.0 +"l] : " +getPrice()+"원 - " 
					+ getAmount());
		}
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	
}

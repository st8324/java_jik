package day12;

public class SnackBox extends Product {

	private int count;
	
	public SnackBox(String name, int price, int amount, int count) {
		super(name, price, amount);
		this.count = count;
	}

	public SnackBox(SnackBox product) {
		this(product.getName(), product.getPrice(), 
				product.getAmount(), product.getCount());
	}
	@Override
	public void print() {
		System.out.println(getName() + "[박스당 "+count+"개] : "+getPrice()+"원 - " 
			+ getAmount());
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}

package day14;

//내역
public class Item {
	//날짜,구분(수입/지출), 구분(결재방식), 상세항목, 금액
	private String date;
	private boolean income;//구분(수입/지출)
	private String payment;//결재방식
	private String content;//항목
	private int price;//금액

	//수정 기능
	public void modify(String date, boolean income, String payment, String content, int price) {
		if(date != null) {
			this.date = date;
		}
		if(payment != null) {
			this.payment = payment;
		}
		if(content != null) {
			this.content = content;
		}
		if(price >= 0) {
			this.price = price;
		}
		this.income = income;
	}
	
	
	
	@Override
	public String toString() {
		return "내역 [" + date + " | " + (income?"수입":"지출") 
				+ " | " + payment + " | " + content
				+ " | " + price + "원]";
	}



	public Item(String date, boolean income, String payment, String content, int price) {
		this.date = date;
		this.income = income;
		this.payment = payment;
		this.content = content;
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isIncome() {
		return income;
	}

	public void setIncome(boolean income) {
		this.income = income;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}

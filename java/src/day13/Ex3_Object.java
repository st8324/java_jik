package day13;

public class Ex3_Object {

	public static void main(String[] args) {
		A a1 = new A(1,2);
		A a2 = new A(1,2);
		
		if(a1 == a2) {
			System.out.println("공유 중입니다.");
		}else {
			System.out.println("공유하고 있지 않습니다.");
		}
		if(a1.equals(a2)) {
			System.out.println("같은 필드를 가진 객체입니다.");
		}else {
			System.out.println("다른 객체입니다.");
		}
		System.out.println(a1.toString());
		
		//=을 통해 객체를 저장하면 공유. a1과 a3이 같은 객체를 공유
		A a3 = a1;
		//a3의 num1의 값을 변경 => a1의 num1의 값도 같이 변경
		a3.setNum1(3);
		System.out.println("-----------");
		System.out.println(a3.toString());
		System.out.println(a1.toString());
		
		//clone을 통해 객체를 복사하면 새로운 객체를 생성한 후 필드를 복사하여 객체를 반환
		a3 = (A)a1.clone();
		//a3의 num1의 값을 변경 => a1의 num1의 값이 변경되지 않음
		a3.setNum1(5);
		System.out.println("-----------");
		System.out.println(a3.toString());
		System.out.println(a1.toString());
	}
}

class A implements Cloneable{
	private int num1;
	private int num2;
	
	public A(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	/*
	@Override
	public boolean equals(Object obj) {
		//두 객체에 저장된 주소가 같은지 확인 => 두 객체가 같은 객체를 공유하는지 확인
		if(this == obj) {
			return true; 
		}
		//상대 객체가 없으면 비교 불가능
		if(obj == null) {
			return false;
		}
		//obj가 A로 타입변환이 불가능하면 비교할수 없다
		if(!(obj instanceof A)) {
			return false;
		}
		A object = (A)obj;
		if(num1 != object.num1) {
			return false;
		}
		if(num2 != object.num2) {
			return false;
		}
		
		return true;
	}
	*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num1;
		result = prime * result + num2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		A other = (A) obj;
		if (num1 != other.num1)
			return false;
		if (num2 != other.num2)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "A [num1=" + num1 + ", num2=" + num2 + "]";
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	//일반적인 clone은 얕은 복제. 깊은 복제를 하려면 따로 구현해야함.
	@Override
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
}





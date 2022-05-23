package day20;

import java.util.ArrayList;
import java.util.List;

public class Ex01_List {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		Point pt = new Point();
		list.add(pt);
		list.add(new Point());
		list.add("123");
		list.indexOf(pt);//참조변수를 직접 넣어줬기 때문에 리스트에 있는 객체와 pt가 같은 객체를 공유. 그래서 equals를 오버라이딩 안해도 가능
		for(Object tmp : list) {
			if(tmp instanceof Point) {
				Point p = (Point)tmp;
				System.out.println(p.x + ", " + p.y);
			}else {
				System.out.println(tmp);
			}
		}
		/*  - indexOf, contains, containsAll, remove 등을 이용할 때 (오버라이딩이) 필요한 메소드 : 
		 *    Point클래스의 equals
		 *  - equals를 오버라이딩을 안하면 Object의 equals가 호출이 됨. 이 때, equals는 주소를 비교함
		 *    (같은 객체를 두 참조변수가 공유하는지를 확인) 
		 * */

	}

}

class Point{
	int x,y;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}
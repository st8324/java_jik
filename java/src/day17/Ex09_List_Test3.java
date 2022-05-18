package day17;

import java.util.ArrayList;
import java.util.List;

public class Ex09_List_Test3 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		Student std = new Student(1, 1, 1, "홍길동");
		list.add(new Student(std));
		System.out.println(list);
		/*  - 학생 객체 std를 생성하여 리스트에 추가한 후, 학생 객체를 수정했을 때 문제가 생길 수 있다.
		 * 	  => 복사 생성자를 이용하여 객체를 복사해서 리스트에 추가해야 한다.
		 * 	  => 또는 학생 클래스에 clone()를 오버라이딩해서 복제해서 리스트에 추가하면 된다.*/
		std.setName("임꺽정");
		System.out.println(list);
	}
}

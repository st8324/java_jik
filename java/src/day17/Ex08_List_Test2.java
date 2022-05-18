package day17;

import java.util.*;


public class Ex08_List_Test2 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		//list.add(new Student(1,1,1, "홍길동"));
		Student std = new Student(1,1,1, "홍길동");
		list.add(std);
		/* - Student 클래스에 equals를 오버라이딩 하지 않으면 indexOf, contains, remove메소드가 원하는대로 동작하지 않음 */
		System.out.println(list);
		int index = list.indexOf(new Student(1,1,1, "홍길동"));
		System.out.println("list에서 학생 정보가 있습니까? " + index + "번지");
		System.out.println("list에서 학생 정보가 있습니까? " + list.contains(new Student(1,1,1, "홍길동")));
		System.out.println("list에서 학생 정보를 삭제했습니까? "+list.remove(new Student(1,1,1, "임꺽정")));
		//list.remove(std);
		System.out.println(list);
		
	}

}

class Student{
	private int grade, clazz, num;
	private String name;
	
	public Student(int grade, int clazz, int num, String name) {
		this.grade = grade;
		this.clazz = clazz;
		this.num = num;
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClazz() {
		return clazz;
	}

	public void setClazz(int clazz) {
		this.clazz = clazz;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [grade=" + grade + ", clazz=" + clazz + ", num=" + num + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clazz;
		result = prime * result + grade;
		result = prime * result + num;
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
		Student other = (Student) obj;
		if (clazz != other.clazz)
			return false;
		if (grade != other.grade)
			return false;
		if (num != other.num)
			return false;
		return true;
	}

	public Student(Student std) {
		this.num = std.num;
		this.clazz = std.clazz;
		this.grade = std.grade;
		this.name = new String(std.name);
	}
	
	
}
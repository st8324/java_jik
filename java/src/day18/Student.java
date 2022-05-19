package day18;

public class Student implements Cloneable {
	private int grade, classNum, num;
	private String name;
	private int kor, eng, math;
	
	public void modify(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public Student(int grade, int classNum, int num, String name, int kor, int eng, int math) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		modify(name, kor, eng, math);
	}
	public Student() {}
	
	@Override
	public String toString() {
		return "[" + grade + "학년 " + classNum + "반 " + num + "번 " + name + "] 국어 : " + kor
				+ ", 영어 : " + eng + ",수학 : " + math;
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
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	
	@Override
	public Student clone() {
		try {
			Student std = (Student)super.clone();
			std.name = new String(name);
			return std;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}

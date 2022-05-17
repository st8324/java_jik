package day16;

public class Ex07_String_Replace {

	public static void main(String[] args) {
		String str = "I love C";
		System.out.println(str);
		str = str.replace("C", "JAVA");
		System.out.println(str);
		str = str + ". JAVA is programing languge";
		System.out.println(str);
		str = str.replace("JAVA", "C");
		System.out.println(str);
	}

}

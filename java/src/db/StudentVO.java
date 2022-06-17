package db;

public class StudentVO {
	private String st_num;
	private String st_name;
	private String st_pr_num;
	//getter와 setter
	public String getSt_num() {
		return st_num;
	}
	public void setSt_num(String st_num) {
		this.st_num = st_num;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String getSt_pr_num() {
		return st_pr_num;
	}
	public void setSt_pr_num(String st_pr_num) {
		this.st_pr_num = st_pr_num;
	}
	//toString
	@Override
	public String toString() {
		return "Student [st_num=" + st_num + ", st_name=" + st_name + ", st_pr_num=" + st_pr_num + "]";
	}
	//Constructor
	public StudentVO(String st_num, String st_name, String st_pr_num) {
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_pr_num = st_pr_num;
	}
	
	
}

package day22;

public class Score {
	//과목명, 중간, 기말, 수행평가, 학년, 학기
	private String name;
	private int midterm, finals, performanceAssessment, grade, term;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMidterm() {
		return midterm;
	}
	public void setMidterm(int midterm) {
		if(midterm < 0 || midterm > 100)
			throw new RuntimeException("중간고사는 0~100사이의 정수를 입력하세요.");
		this.midterm = midterm;
	}
	public int getFinals() {
		return finals;
	}
	public void setFinals(int finals) {
		if(finals < 0 || finals > 100)
			throw new RuntimeException("기말고사는 0~100사이의 정수를 입력하세요.");
		this.finals = finals;
	}
	public int getPerformanceAssessment() {
		return performanceAssessment;
	}
	public void setPerformanceAssessment(int performanceAssessment) {
		if(performanceAssessment < 0 || performanceAssessment > 100)
			throw new RuntimeException("수행평가는 0~100사이의 정수를 입력하세요.");
		this.performanceAssessment = performanceAssessment;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		if(grade < 1 || grade > 3)
			throw new RuntimeException("학년은 1~3사이의 정수를 입력하세요.");
		this.grade = grade;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		if(grade < 1 || grade > 2)
			throw new RuntimeException("학기은 1~2사이의 정수를 입력하세요.");
		this.term = term;
	}
	public Score(int grade, int term, String name, int midterm, int finals, int performanceAssessment) {
		this(grade, term, name);
		setMidterm(midterm);
		setFinals(finals);
		setPerformanceAssessment(performanceAssessment);
		
	}
	public Score(int grade, int term, String name) {
		setGrade(grade);
		setTerm(term);
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + grade;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + term;
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
		Score other = (Score) obj;
		if (grade != other.grade)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (term != other.term)
			return false;
		return true;
	}
	@Override
	public String toString() {
		double total = midterm * 0.4 + finals * 0.5 + performanceAssessment * 0.1;
		return grade +"학년 " + term +"학기 " + name + " [중간 : "+ midterm +", 기말 : " + finals +", 수행 : " 
				+ performanceAssessment + ", 총점 : " + total +"]";
	}
		
}

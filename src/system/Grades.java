package system;

public class Grades {
	
	public String name;
	
	public String ID;
	
	public int lab1;
	
	public int lab2;

	public int lab3;

	public int midTerm;

	public int finalExam;
	
	public int totalGrade;


	public void calculateTotalGrade(float []weight) {
		
		this.totalGrade = Math.round(this.lab1*weight[0] + this.lab2*weight[1] + this.lab3*weight[2]
				
				+this.midTerm*weight[3] + this.finalExam*weight[4]);
		
		
	}

	public Grades(String ID, String name, int lab1, int lab2, int lab3, int midTerm, int finalExam) {
		
		this.name = name;
		this.ID = ID;
		this.lab1 = lab1;
		this.lab2 = lab2;
		this.lab3 = lab3;
		this.midTerm = midTerm;
		this.finalExam = finalExam;
		
		
	}

}

package com.gradeslate.gradeslate;
import java.util.ArrayList;

public class Grades {
	private ArrayList<Evaluation> grades = new ArrayList<Evaluation>();
	private int avgGrd, curGrd, gpa;
	private char letGrd;
	
	Grades(){}
	
	public void average(){
		int sum = 0;
		int num = 0;
		
		for(Evaluation grade:grades){
			num++;
			sum += grade.getGrade();
		}
		
		avgGrd = sum/num;
		
	}
	
	public void letter(){
		average();
		
		if((avgGrd >= 80)&&(avgGrd <= 100)){
			letGrd = 'A';
		}
		
		else if((avgGrd >= 65)&&(avgGrd <= 79)){
			letGrd = 'B';
		}
		
		else if((avgGrd >= 55)&&(avgGrd <= 64)){
			letGrd = 'C';
		}
		
		else if((avgGrd >= 50)&&(avgGrd <= 54)){
			letGrd = 'D';
		}
		
		else{
			letGrd = 'F';
		}
		
	}
	
	public void curGrd(){
		for(Evaluation grade:grades)
			curGrd += grade.totalGrdPer();
	}
	
	
	public int getAvgGrds(){
		return avgGrd;
	}
	
	public int getCurGrd(){
		return curGrd;
	}
	
	public char getLetGrd(){
		return letGrd;
	}
	
	public void addEval(Evaluations type, int worth){
		Evaluation next = new Evaluation(type, worth);
		grades.add(next);
	}
	
	
}

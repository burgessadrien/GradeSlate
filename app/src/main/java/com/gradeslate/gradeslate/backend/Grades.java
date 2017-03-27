package com.gradeslate.gradeslate.backend;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Grades implements Serializable {
	private ArrayList<Evaluation> grades = new ArrayList<Evaluation>();
	private float avgGrd, curGrd, gpa;
	private char letGrd;
	
	Grades(){}
	
	public void average(){
		float sum = 0;
		float num = 0;
		
		for(Evaluation grade:grades){
			num++;
			sum += grade.getGrade();
		}
		
		avgGrd = sum/num;
		
	}

	public ArrayList<Evaluation> getGrades() {
		return grades;
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

	public float getAvgGrds(){
		average();
		return avgGrd;
	}
	
	public float getCurGrd(){
		return curGrd;
	}
	
	public char getLetGrd(){
		return letGrd;
	}
	
	public void addEval(String type, float worth){
		Evaluation next = new Evaluation(type, worth);
		grades.add(next);
	}

	public ArrayList<Evaluation> getEvaluations(){
		return grades;
	}


	
	
}

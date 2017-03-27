package com.gradeslate.gradeslate.backend;

import java.io.Serializable;

public class Course implements Serializable {
	
	private Bookbag knapsack= new Bookbag();
	private Grades grades = new Grades();
	private Professor prof;
	private String title;
	private int credHour = 0;

	/********************
	 * 
	 * adding times for labs, tests, assignments and other
	 */

	public Course(String title, int credHour){
		this.title = title;
		this.credHour = credHour;
		prof = new Professor();
	}
	
	public Professor getProf(){
		return prof;
	}
	
	public Grades getGrades(){
		return grades;
	}
	
	public Bookbag getBag(){
		return knapsack;
	}
	
	public String getTitle(){
		return title;
	}


	/****************************
	 *
	 * The following method is used for calculating the desired average
	 *
	 */

	public float desGrd(float des){
		float sumGrd = 0;
		int numEntGrd = 0;
		int numGrd = 0;
		for(Evaluation eval: grades.getEvaluations()){
			if(eval.entered() == true){
				numEntGrd ++;
				sumGrd += eval.getGrade();
			}
			numGrd++;
		}

		float max = des*numGrd;
		float answer = (max - sumGrd)/(numGrd - numEntGrd);
		return answer;
	}
	
	public char letGrd(){
		return grades.getLetGrd();
	}
	
	public int getCredHour(){
		return credHour;
	}
	

}

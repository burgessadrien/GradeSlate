package com.gradeslate.gradeslate.Backend;

public class Course {
	
	private Bookbag knapsack= new Bookbag();
	private Grades grades = new Grades();
	private Professor prof;
	private String title;
	private int credHour = 0;
	private String description;
	
	/********************
	 * 
	 * adding times for labs, tests, assignments and other
	 */
	
	Course(String title, int time, int credHour){
		this.title = title;
		this.credHour = credHour;
	}
	
	public void setProf(String name){
		prof = new Professor(name);
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

	
	public void inDes(String des){
		this.description = des;
	}
	
	public String getDes(){
		return description;
	}
	
	public char letGrd(){
		return grades.getLetGrd();
	}
	
	public int getCredHour(){
		return credHour;
	}
	

}

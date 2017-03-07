package com.gradeslate.gradeslate.backend;

public class Evaluation {
	private String evalType;
	private int grade;
	private int worth;
	private Team team;
	/*******
	 * 
	 * add tasks when ready
	 */
	
	Evaluation(String type, int worth){
		this.evalType = type;
		this.worth = worth;
		team = new Team();
	}
	
	public void setEval(String type){
		evalType = type;
		
	}
	
	public Team getTeam(){
		return team;
	}
	
	public String getType(){
		return evalType;
	}
	
	public void addMember(String name){
		team.addMem(name);
	}
	
	public void setGrade(int grade){
		this.grade = grade;
	}
	
	public int getGrade(){
		return grade;
	}
	
	public int totalGrdPer(){
		int per = grade/100;
		int total = per*worth;
		return total;
	}
	
}

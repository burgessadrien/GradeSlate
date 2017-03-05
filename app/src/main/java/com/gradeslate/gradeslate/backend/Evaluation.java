package com.gradeslate.gradeslate.backend;

public class Evaluation {
	private Evaluations evalType;
	private int grade;
	private int worth;
	private Team team;
	/*******
	 * 
	 * add tasks when ready
	 */
	
	Evaluation(Evaluations type, int worth){
		this.evalType = type;
		this.worth = worth;
		team = new Team();
	}
	
	public void setEval(Evaluations type){
		evalType = type;
		
	}
	
	public Team getTeam(){
		return team;
	}
	
	public Evaluations getType(){
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
